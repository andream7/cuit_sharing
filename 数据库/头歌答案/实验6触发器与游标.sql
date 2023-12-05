1. INSERT型触发器
use purchase_book;
#在创建购物车记录时，系统需要保证书籍(books)库存（siQuantiy）的一致性。
#因此在向购物车(shoppingcart)表格添加记录时，
#需先将书籍（books）库存（siQuantity）自减去购物车对应图书的数量(siQty)。
DELIMITER $$
#TODO
create trigger a
before insert on shoppingcart 
for each row
begin 
    update books set siQuantity=siQuantity-new.siQty 
    where books.cBookID=new.cBookID;
end
$$

2. UPDATE型触发器
use purchase_book;
#在更新购物车记录时，系统需要保证书籍(books)库存（siQuantiy）的一致性。
#因此在更新购物车(shoppingcart)表格记录时，
#需根据购物车对应图书的数量(siQty)变化情况对书籍（books）库存（siQuantity）进行对应更新。
DELIMITER $$
#TODO
create trigger a
before update on shoppingcart 
for each row
begin 
    update books set siQuantity=siQuantity-new.siQty+old.siQty
    where books.cBookID=new.cBookID;
end
$$

3. DELETE型触发器
use purchase_book;
#在删除购物车记录时，系统需要保证书籍(books)库存（siQuantiy）的一致性。
#因此在删除购物车(shoppingcart)表格记录时，
#需将购物车中对应书籍的数量添加到书籍（books）库存（siQuantity）。
DELIMITER $$
#TODO
create trigger a
after delete on shoppingcart 
for each row
begin 
    update books set siQuantity=siQuantity+old.siQty
    where books.cBookID=old.cBookID;
end
$$

4. 单循环游标
use purchase_book;
#编写一个单循环游标的存储过程，并调用它，
#打印books中的书籍名(vBookName)和库存(siQuantity)两个字段的信息。
drop procedure if exists proc_cursor;
delimiter $$
create procedure proc_cursor()
begin
  declare bookname longtext;
  declare quantity smallint;
  declare result longtext default ''; #将打印内容存入result中 
  declare done int default 0;
  declare cur cursor for select vBookName,siQuantity from books;
  declare continue handler for not found set done=1;
  #实现触发器 
  #TODO  
  open cur;
  REPEAT
  fetch cur into bookname,quantity;
  if done!=1 then
  set result=concat(result,"书籍名:");
  set result=concat(result,bookname);
  set result=concat(result,"库存:");
  set result=concat(result,quantity);
  end if;
  UNTIL DONE END REPEAT;
  close cur;
  select result;
end
$$
call proc_cursor();

5. 游标的嵌套
use purchase_book;
#创建两层的嵌套游标。
#依次遍历书籍(books)并按照书籍的ID(cBookID)去查询购物车(shoppingcart)表格记录并统计打印出该书籍的代售总数。
#统计结果存在一字符串内，结果格式为不同书籍的信息无缝连接。
#其中每种书籍信息内容为：
#cBookID:代售总数
#比如ID为“001“的书籍在购物车中有3条记录,siQty分别为3,4,5。
#该书籍的信息则为：
#001:12
drop procedure if exists proc_cursor;
delimiter $$
create procedure proc_cursor()
begin
	declare result varchar(4000) default '';  #将结果保存在本变量中
    declare bookid char(10);
    declare salesum smallint;
    declare sale smallint;
    declare done int default 0;
    declare a cursor for select cBookID from books;
    declare b cursor for select siQty from shoppingcart where cBookID=bookid;
    declare continue handler for not found set done=1;
    #TODO
	open a;
		l1:loop
			fetch next from a into bookid;
			if done=1 then
				leave l1;
			end if;
			set salesum=0;
			open b;
				l2:loop
					fetch next from b into sale;
					if done=1 then
						leave l2;
					end if;
					set salesum=salesum+sale;
				end loop l2;
			close b;
				set result=concat(result,bookid,":",salesum);
				set done=0;
		end loop l1;
    close a;
    select result;
end
$$
call proc_cursor();

6. 存储过程和游标的组合
use purchase_book;
#创建两层的嵌套游标。
#依次遍历书籍(books)并按照书籍的ID(cBookID)去查询购物车(shoppingcart)表格记录并统计打印出该书籍的代售总数。
#统计结果存在一字符串内，结果格式为不同书籍的信息无缝连接。
#其中每种书籍信息内容为：
#cBookID:代售总数
#比如ID为“001”的书籍在购物车中有3条记录,siQty分别为3,4,5。
#该书籍的信息则为：
#001:12
drop procedure if exists proc_cursor;
delimiter $$
create procedure proc_cursor()
begin
	declare result decimal(10,2) default 0.00;
    declare temp decimal(10,2) default 0.00;
    declare done int default 0;
    declare a cursor for select cast(siQuantity as decimal(10,2))*mSalePrice from books group by cBookID;
    declare continue handler for not found set done=1;
	open a;
		l1:loop
			fetch next from a into temp;
			if done=1 then
				leave l1;
			end if;
			set result=result+temp;
		end loop l1;
    close a;
    select cast(result as decimal(10,1)) 'total_price';
end
$$
call proc_cursor();