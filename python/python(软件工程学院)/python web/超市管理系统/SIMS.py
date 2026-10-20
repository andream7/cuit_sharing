from flask import Flask, url_for, render_template, request, redirect, session, flash, g
from flask_bootstrap import Bootstrap
import sqlite3
import random
import decimal
import json
import time

# 初始化
app = Flask(__name__)
app.secret_key = 'A0Zr98j/3yX R~XHH!jmN]LWX/,?RT'
bootstrap = Bootstrap(app)
DATABASE = './SIMS.db'
ADMIN_NAME = 'admin'
ADMIN_PWD = '123456'


# 连接数据库
def conn_db():
    try:
        return sqlite3.connect(DATABASE)
    except Exception as e:
        print(e)


@app.before_request
def before_request():
    g.db = conn_db()


# 关闭连接
@app.teardown_request
def teardown_request(exception):
    if hasattr(g, 'db'):
        g.db.close()


# 数据查询
def query_db(query, args=(), one=False):
    cur = g.db.execute(query, args)
    rv = [dict((cur.description[idx][0], value)
               for idx, value in enumerate(row)) for row in cur.fetchall()]
    return (rv[0] if rv else None) if one else rv


# 用户是否在登陆状态
def user_online():
    if 'user_id' in session:
        return True
    else:
        return False


@app.route('/')
def index(name=None):
    return render_template('index.html', name=name)


@app.route('/admin/login', methods=['GET', 'POST'])
def admin_login():
    error = None
    if request.method == 'POST':
        if request.form['username'] == ADMIN_NAME and request.form['password'] == ADMIN_PWD:
            flash('登陆成功')
            return redirect(url_for('admin'))
        if request.form['username'] != ADMIN_NAME:
            error = 'Invalid username'
        elif request.form['password'] != ADMIN_PWD:
            error = 'Invalid password'
    return render_template('admin_login.html', error=error)


@app.route('/admin/query_all', methods=['GET', 'POST'])
def admin_goods():
    error = None
    conn = conn_db()
    cur = conn.cursor()
    goods = cur.execute('''SELECT bar_code, good_name, price, type, description FROM goods''')

    if request.method == "POST":
        id = request.values.getlist("radio")

        if request.form.get('add', None) == '添加':
            return redirect(url_for('admin_add_good'))
        if not id:
            flash('未选定')
            return redirect(url_for('admin_goods'))
        if request.form.get('modify',None) == '修改':
            return redirect(url_for('admin_modify_good', id = id[0]))
        elif request.form.get('delete', None) == '删除':
            cur.execute('''DELETE FROM goods WHERE bar_code = ?''', [id[0]])
            conn.commit()
            return redirect(url_for('admin_goods'))
        else:
            return redirect(url_for('admin_goods'))
    return render_template('admin_queryall.html', error=error, goods=goods)


@app.route('/admin/orders', methods=['GET', 'POST'])
def admin_orders():
    error = None

    sum_list = []
    order_ids = []
    user_id = []
    orders = query_db('''SELECT * from history''', [], False)[::-1]
    ids = query_db('''SELECT order_id from history''', [], False)

    for i in ids:
        if not i['order_id'] in order_ids:
            order_ids.append(i['order_id'])
    order_ids = order_ids[::-1]

    for i in order_ids:
        sum = 0
        for record in orders:
            if record['order_id']== i:
                sum += round(record['price'] * record['number'],2)
        sum_list.append(sum)
        user_id.append(query_db('''select use_id from history WHERE order_id = ?''',[i], True)['use_id'])

    return render_template('admin_orders.html', error=error, order_ids=order_ids,
                           orders=orders, sum_list=sum_list[::-1], user_id= user_id)


@app.route('/admin/add_good', methods=['GET', 'POST'])
def admin_add_good():
    error = None
    if request.method == 'POST':
        if request.form['bar_code'] == '':
            error = 'You must input the good id'
        elif request.form['good_name'] == '':
            error = 'You must input the good name'
        elif request.form['price'] == '':
            error = 'You must input the good price'
        elif request.form['type'] == '':
            error = 'You must input the good type'
        elif query_db('''select * from goods WHERE bar_code=?''', [request.form['bar_code']], True) is not None:
            error = 'The bar_code is already taken'
        elif query_db('''select * from goods WHERE good_name=?''', [request.form['good_name']], True) is not None:
            error = 'The good name is already taken'
        else:
            db = conn_db()
            cur = db.cursor()
            cur.execute("INSERT INTO goods (bar_code, good_name, price, type, description) VALUES (?,?,?,?,?)",
                        [request.form['bar_code'], request.form['good_name'], request.form['price'],
                         request.form['type'], request.form['description']])
            db.commit()
            return redirect(url_for('admin_goods'))
    return render_template('admin_add_good.html', error=error)


@app.route('/admin/modify_good/<id>', methods=['GET', 'POST'])
def admin_modify_good(id=0):
    error = None
    good = query_db('''SELECT * from goods WHERE bar_code=?''', [id], True)

    if request.method == 'POST':
        db = conn_db()
        cur = db.cursor()
        cur.execute('''UPDATE goods set bar_code=?, good_name=?, price=?, type=?, description=? WHERE bar_code=?''',
                    [request.form['bar_code'], request.form['good_name'], request.form['price'], request.form['type'],
                    request.form['description'], id])
        db.commit()
        flash('商品信息更新成功！')
        return redirect(url_for('admin'))
    return render_template('admin_modify_good.html', error = error, good = good)


@app.route('/admin/query_good', methods=['GET', 'POST'])
def admin_query_good():
    error = None
    if request.method == 'POST':
        good = query_db('''select * from goods WHERE good_name=?''', [request.form['good_name']], True)
        if good:
            return redirect(url_for('admin_modify_good', id=good['bar_code']))
        else:
            error = 'Sorry, there is no commodity to match'
    return render_template('admin_query_good.html', error = error)


@app.route('/admin/users', methods=['GET', 'POST'])
def admin_users():
    error=None
    users = query_db('''SElECT * From users''',[], False)
    return render_template('admin_users.html', error = error, users=users)


@app.route('/admin', methods=['GET','POST'])
def admin():
    return render_template('admin.html')


@app.route('/user/login', methods=['GET', 'POST'])
def user_login():
    error = None
    if request.method == 'POST':
        user = query_db('''select * from users WHERE user_name=?''', [request.form['username']], True)
        if user:
            if user['passwd'] != request.form['password']:
                error = 'Invalid password'
            else:
                session['user_id'] = user['user_id']
                flash('登陆成功')
                return redirect(url_for('user'))
        else:
            error = 'Invalid username'
    return render_template('user_login.html', error=error)


@app.route('/logout')
def logout():
    session.pop('user_id', None)
    return redirect(url_for('index'))


@app.route('/user/register', methods=['GET', 'POST'])
def user_register():
    error = None
    if request.method == 'POST':
        if request.form['username'] == '':
            error = 'You must input your username'
        elif request.form['password'] == '':
            error = 'You must input the password'
        elif request.form['password'] != request.form['password1']:
            error = 'The twice passwords are not the same'
        elif query_db('''select * from users WHERE user_name=?''', [request.form['username']], True) is not None:
            error = 'The username is already taken'
        else:
            # 生成用户ID
            user_id = random.randint(1000, 9999)
            db = conn_db()
            cur = db.cursor()
            cur.execute("INSERT INTO users (user_id, user_name, passwd, phone, addr, members) VALUES (?,?,?,?,?,?)",
                        [user_id, request.form['username'], request.form['password'], request.form['phone'],
                         request.form['address'], "否"])
            db.commit()
            return redirect(url_for('user_login'))
    return render_template('user_register.html', error=error)


@app.route('/user/info', methods=['GET', 'POST'])
def user_info():
    if not user_online():
        return redirect(url_for('user_login'))
    user = query_db('''select * from users WHERE  user_id = ?''', [session['user_id']], one=True)
    return render_template('user_info.html', user=user)


@app.route('/user/modify', methods=['GET', 'POST'])
def user_modify():
    if not user_online():
        return redirect(url_for('user_login'))
    error = None
    user = query_db("select * from users WHERE user_id=?", [session['user_id']], True)
    if request.method == 'POST':
        if request.form['password'] != request.form['password1']:
            error = 'Twice passwords are not the same'
        if request.form['username'] != '':
            user['user_name'] = request.form['username']
        if request.form['password'] != '':
            user['passwd'] = request.form['password']
        if request.form['phone'] != '':
            user['phone'] = request.form['phone']
        if request.form['address'] != '':
            user['addr'] = request.form['address']

        db = conn_db()
        cur = db.cursor()
        cur.execute('''UPDATE users SET user_name=?, passwd=?, phone=?, 
                      addr=? WHERE user_id =?''',
                    [user['user_name'], user['passwd'], user['phone'], user['addr'], user['user_id']])
        db.commit()
        flash('相关信息已修改！')
        return redirect(url_for('user'))
    return render_template('user_modify.html', error=error)


@app.route('/user/good/<id>', methods=['GET', 'POST'])
def user_good(id=0):
    if not user_online():
        return redirect(url_for('user_login'))
    error = None
    good = query_db('''select * from goods where bar_code= ?''',
                    [id], True)

    if request.method == 'POST':
        db = conn_db()
        cur = db.cursor()
        if query_db('''select bar_code from "order" WHERE bar_code=?''', [id], True) is not None:
            num = query_db('''SELECT number FROM "order" WHERE bar_code = ?''', [id], True)
            cur.execute('''UPDATE "order" SET number=? WHERE bar_code=?''', [num['number'] + 1, id])
        else:
            cur.execute('''INSERT INTO "order"(bar_code, good_name, price, number) VALUES (?, ?, ?, 1)''',
                        [id, good['good_name'], good['price']])
        db.commit()
        flash("商品：" + good['good_name'] + "已加入购物车中")
        return redirect(url_for('user'))

    return render_template('user_good.html', good=good, error=error)


@app.route('/user/query', methods=['GET', 'POST'])
def user_query():
    if not user_online():
        return redirect(url_for('user_login'))
    error = None
    if request.method == 'POST':
        good = query_db('''select * from goods WHERE good_name=?''', [request.form['good_name']], True)
        if good:
            return redirect(url_for('user_good', id=good['bar_code']))
        else:
            error = 'Sorry, there is no commodity to match'
    return render_template('user_query.html', error=error)


@app.route('/user/query_all', methods=['GET', 'POST'])
def user_query_all():
    if not user_online():
        return redirect(url_for('user_login'))
    error = None
    conn = conn_db()
    cur = conn.cursor()
    goods = cur.execute('''SELECT bar_code, good_name, price, type, description FROM goods''')

    if request.method == 'POST':
        id_all = request.values.getlist("checkbox")
        for id in id_all:
            if query_db('''SELECT * FROM "order" WHERE bar_code=?''', [id], True) is not None:
                num = query_db('''SELECT number FROM "order" WHERE bar_code = ?''', [id], True)
                cur.execute('''UPDATE "order" SET number=? WHERE bar_code=?''', [num['number'] + 1, id])
            else:
                record = query_db('''SELECT * from goods WHERE bar_code = ?''', [id], True)
                cur.execute('''INSERT INTO "order" (bar_code, good_name, price, number) VALUES (?,?,?,1)''',
                            [id, record['good_name'], record['price']])
        conn.commit()
        flash('所有已选商品已加入购物车')
        return redirect(url_for('user'))
    return render_template('user_queryall.html', goods=goods, error=error)


@app.route('/user/order', methods=['GET', 'POST'])
def user_order():
    if not user_online():
        return redirect(url_for('user_login'))
    error = None
    sum = 0

    conn = conn_db()
    cur = conn.cursor()
    order = cur.execute('''SELECT * FROM "order"''')

    # 计算总金额
    for record in order:
        sum += round(record[2] * record[3],2)

    order = cur.execute('''SELECT * FROM "order"''')
    if request.method == 'POST':
        if request.form.get('all', None) == '全部购买':
            order_id = query_db('''SELECT max(order_id) FROM history''',[],True)['max(order_id)'] + 1
            print(order_id)
            cur.execute('''INSERT INTO history (order_id, use_id, good_id, good_name, number, price) \
                            SELECT ?,?,bar_code,good_name,number,price FROM "order"''',
                        [order_id, session['user_id']])
            cur.execute('''DELETE FROM "order"''')
            conn.commit()
            flash('全部商品购买成功！')
            return redirect(url_for('user'))
        elif request.form.get('confirm', None) == '确认购买':
            order_id = query_db('''SELECT max(order_id) FROM history''', [], True)['max(order_id)'] + 1
            id_all = request.values.getlist('checkbox')
            for id in id_all:
                cur.execute('''INSERT INTO history(order_id, use_id, good_id, good_name, number, price) \
                                SELECT ?,?,bar_code,good_name,number,price FROM "order" WHERE bar_code = ?''',
                            [order_id, session['user_id'], id])
                cur.execute('''DELETE FROM "order" WHERE bar_code = ?''', [id])

            conn.commit()
            flash('所选商品购买成功！')
            return redirect(url_for('user'))
        else:
            id_all = request.values.getlist('checkbox')
            for id in id_all:
                cur.execute('''DELETE FROM "order" WHERE bar_code = ?''', [id])
            conn.commit()
            flash('所选商品已从购物车中删除！')
            return redirect(url_for('user_order'))

    return render_template('user_order.html', error=error, order=order, sum=sum)


@app.route('/user/orders', methods=['GET', 'POST'])
def user_orders():
    if not user_online():
        return redirect(url_for('user_login'))
    error = None

    sum_list = []
    order_ids = []

    orders = query_db('''SELECT * from history WHERE use_id = ?''', [session['user_id']], False)
    orders = orders[::-1]
    ids = query_db('''SELECT order_id from history WHERE use_id = ?''', [session['user_id']], False)

    for i in ids:
        if not i['order_id'] in order_ids:
            order_ids.append(i['order_id'])
    order_ids = order_ids[::-1]

    for i in order_ids:
        sum = 0
        for record in orders:
            if record['order_id']== i:
                sum += round(record['price'] * record['number'],2)
        sum_list.append(sum)

    return render_template('user_orders.html', error=error, order_ids=order_ids, orders=orders, sum_list=sum_list[::-1])


@app.route('/user', methods=['GET', 'POST'])
def user():
    if not user_online():
        return redirect(url_for('user_login'))
    return render_template('user.html')


if __name__ == '__main__':
    app.run()
