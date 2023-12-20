1. 创建表
use TestDb; 
##### Create Table ####
Create Table t_emp(
    id int,
    name varchar(32),
    deptId int,
    salary float
);
#######
DESCRIBE t_emp;

2. 插入数据
USE Company;
#请在此处添加实现代码
########## Begin ##########
########## bundle insert the value ##########
insert
into tb_emp(Id,Name,DeptId,Salary)
value(1,'Nancy',301,2300),(2,'Tod',303,5600),(3,'Carly',301,3200);
########## End ##########
SELECT * FROM tb_emp;

3. 更新数据
USE Company;
#请在此处添加实现代码
########## Begin ##########
########## update the value ##########
update tb_emp
set Name='Tracy',DeptId=302,Salary=4300.00
where Id=3;
########## End ##########

SELECT * FROM tb_emp;

4. 删除数据
USE Company;
#请在此处添加实现代码
########## Begin ##########
########## delete the value ##########
delete from tb_emp
where Salary>3000;
########## End ##########
SELECT * FROM tb_emp;

5. 范围查询
USE Company;
#请在此处添加实现代码
########## Begin ##########
########## retrieving the Name and Salary with BETWEEN AND statement ##########
select Name,Salary from tb_emp where Salary BETWEEN 3000 and 5000;
########## End ##########

6. 查询空值与去除重复结果
USE Company;
######### Begin #########
select * from tb_emp where DeptId is null;
######### End #########
######### Begin #########
select distinct Name from tb_emp;
######### End #########

7. 对查询结果进行排序
USE School;
#请在此处添加实现代码
########## Begin ##########
########## 查询1班同学的所有信息以成绩降序的方式显示结果 ##########
select * from tb_score 
where class_id=1
order by score desc;
########## End ##########

8. 带比较运算符的子查询
USE Company;
#请在此处添加实现代码
########## Begin ##########
#查询大于所有平均年龄的员工姓名与年龄
select name,age from tb_emp 
where age>(select avg(age) from tb_emp);
########## End ##########

9. 内连接查询
USE School;
########## 查询数据表中学生姓名和对应的班级 ##########
#请在此处添加实现代码
########## Begin ##########
select tb_student.name as studentName,tb_class.name as className from tb_student,tb_class 
where tb_student.class_id=tb_class.id;
########## End ##########

10. 聚合查询:Count
USE School;
#请在此处添加实现代码
########## Begin ##########
########## 查询该表中一共有多少条数据 ##########
select count(*) from tb_class;
########## 查询此表中367班有多少位学生 ##########
select classid,count(*) from tb_class where classid=367;
########## End ##########

11. 分组查询
USE School;
#请在此处添加实现代码
########## Begin ##########
########## 对班级名称进行分组查询 ##########
select class_id,count(class_id) as number from tb_class 
group by class_id;
########## End ##########