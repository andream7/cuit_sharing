1. insert
USE purchase_book;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
insert into customer values
('b665a29c-136e-11ec-b124-7567d484c929','张彦','13589112389','zhangyan@163.com',
'Cuit ','张彦','男','2003-10-1','四川','成都',99,'四川省成都市双流航空港成都信息工程大学'),
('b665a29c-136e-11ec-b124-7897d484c920','心田','13578912389','xintian@163.com',
'Cuit ','张田田','男','2003-10-1','四川','成都',100,'四川省成都市双流航空港成都信息工程大学');
########## End ##########   
select * from customer;

2. delete
USE purchase_book;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
delete from customer where cCustomerID='b665a29c-136e-11ec-b124-7567d484c929';
########## End ##########   
select * from customer;

3. delete
USE purchase_book;
set sql_safe_updates=0;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
delete from books where cSaleStatus=0 and cBookID not in(
    select cBookID from orderdetail
);
########## End ##########   
select * from books; 

4. delete多表
USE purchase_book;
set foreign_key_checks=0;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
set foreign_key_checks=0;
delete from orders where cOrderNo='21091300010';
delete from orderlog where cOrderNo='21091300010';
########## End ########## 
set foreign_key_checks=1;
select o.cOrderNo from orders o left JOIN orderdetail od on o.cOrderNo=od.cOrderNo  
where o.cOrderNo='21091300010';

5. UPDATE
USE purchase_book;
set sql_safe_updates=0;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
update books set mSalePrice=mSalePrice*1.1 
where cTypeID in 
(select cTypeID from booktype where vTypeName like '%外语%') and
mSalePrice*1.1<=mPrice;  
########## End ##########   
select * from books where cTypeID=(select cTypeID from booktype where vTypeName like '%外语%');  

6. 查询记录集插入新表
USE purchase_book;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
create table soldbook
as (SELECT vBookName,count(*) 已售数量 from orderdetail join books 
on books.cBookID=orderdetail.cBookID 
group by vBookName
);
########## End ##########   
select * from soldbook;  

7. 视图
USE purchase_book;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
create view IS_customer as
select cCustomerID,cBookID,dPayTime 
from orders join orderdetail on 
orders.cOrderNo=orderdetail.cOrderNo;
select cCustomerID,cBookID,dPayTime 
from IS_customer a 
where cBookID in(select cBookID from IS_customer b
where a.dPayTime!=b.dPayTime and a.cCustomerID=b.cCustomerID);
########## End ##########   

8. 视图，关联子查询
USE purchase_book;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
create view IS_customer as
select cCustomerID,cBookID,mSalePrice 
from orders join orderdetail on 
orders.cOrderNo=orderdetail.cOrderNo;

select cCustomerID,cBookID 
from IS_customer a 
where mSalePrice>any(
    select avg(mSalePrice) from IS_customer b 
    group by cCustomerID 
    having a.cCustomerID=b.cCustomerID
);
########## End ##########   

9. 视图,cast
USE purchase_book;
#请在此处添加实现代码,注意用;作为每条语句的结束符号
########## Begin ##########
create view IS_books
as
select books.cBookID, sum(mBookCost) 'vvv'
from books join orderdetail on books.cBookID = orderdetail.cBookID
group by cBookID;
create view IS_sum
as
select sum(vvv) 'abc'
from IS_books;
select IS_books.cBookID, cast(100 * (IS_books.vvv / IS_sum.abc) as decimal (32,2)) '占比'
from IS_books,IS_sum
group by cBookID;
########## End ##########    