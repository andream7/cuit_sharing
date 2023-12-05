1. 多表连接
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select customer.vNickName,
orderdetail.cBookID,
orders.dOrderDate,
orders.dShippingDate,
orders.vRecipientName 
from orders join customer on orders.cCustomerID=customer.cCustomerID 
join orderdetail on orders.cOrderNo=orderdetail.cOrderNo 
where orders.vRecipientCity='成都' and orders.dShippingDate is not null;
########## End ##########  

2. 多表连接
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select customer.vNickName,
books.vBookName,
orders.dOrderDate,
orders.dShippingDate,
orders.vRecipientName 
from orders join customer on orders.cCustomerID=customer.cCustomerID 
join orderdetail on orders.cOrderNo=orderdetail.cOrderNo 
join books on books.cBookID=orderdetail.cBookID 
where orders.vRecipientCity='成都' and orders.dShippingDate is not null;
########## End ##########  

3. 连接或子查询
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select books.vBookName 
from evaluation join books on books.cBookID=evaluation.cBookID 
where evaluation.comment like '%好%' 
group by vBookName;
########## End ##########  

4. 多表连接
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select orders.cCustomerID,
books.vBookName 
from evaluation join books on books.cBookID=evaluation.cBookID 
join orders on orders.cOrderNo=evaluation.cOrderNo 
where evaluation.comment like '%好%';
########## End ##########  

5. 多表连接
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select vBookName 
from books 
where vPressHouse=(select vPressHouse from books
where cBookID=2109010001) and cBookID!=2109010001;
########## End ##########  

6. 外连接或子查询
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select vBookName 
from books 
where cBookID not in 
(select cBookID from orders join orderdetail on orders.cOrderNo=orderdetail.cOrderNo
where 1=1 
group by cBookID);
########## End ##########

7. Union
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
(
select vPressHouse,vBookName,iTotalNumber as '销售数量' 
from books join reportdetail
on reportdetail.cBookID=books.cBookID 
where books.vPressHouse='清华大学出版社' 
group by iTotalNumber desc 
limit 1 
)
union 
(
select vPressHouse,vBookName,iTotalNumber as '销售数量' 
from books join reportdetail
on reportdetail.cBookID=books.cBookID 
where books.vPressHouse='电子工业出版社' 
group by iTotalNumber desc 
limit 1 
);
########## End ##########

8. 嵌套子查询
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select vNickName 
from customer join orders on 
customer.cCustomerID=orders.cCustomerID 
join orderdetail on 
orderdetail.cOrderNo=orders.cOrderNo 
join books on 
books.cBookId=orderdetail.cBookId 
where vBookName like '%python%' 
group by vNickName;
########## End ##########

9. 嵌套子查询
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select books.cBookID from 
books join orderdetail on 
books.cBookId=orderdetail.cBookId 
join orders on 
orderdetail.cOrderNo=orders.cOrderNo 
join customer on 
customer.cCustomerID=orders.cCustomerID 
where customer.cCustomerID in
(
select customer.cCustomerID 
from customer join orders on 
customer.cCustomerID=orders.cCustomerID 
join orderdetail on 
orderdetail.cOrderNo=orders.cOrderNo 
join books on 
books.cBookId=orderdetail.cBookId 
where vBookName like '%python%' 
group by cCustomerID
) 
and books.vBookName not like '%python%' 
group by cBookID;
########## End ##########
;

10. 连接和子查询
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########

select customer.cCustomerID 
from customer join orders on 
customer.cCustomerID=orders.cCustomerID 
join orderdetail on 
orderdetail.cOrderNo=orders.cOrderNo 
join books on 
books.cBookId=orderdetail.cBookId 
where books.cBookID=2109010001 
and customer.cCustomerID in 
(
select customer.cCustomerID 
from customer join orders on 
customer.cCustomerID=orders.cCustomerID 
join orderdetail on 
orderdetail.cOrderNo=orders.cOrderNo 
join books on 
books.cBookId=orderdetail.cBookId 
where books.cBookID=2109010002 
group by customer.cCustomerID
);
########## End ##########

11. 相关子查询
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select a.cOrderNo from orders a
where a.mShippingCost/2>
(select avg(b.mShippingCost) from orders b 
where a.cCustomerID=b.cCustomerID 
group by cCustomerID 
);
########## End ##########

12. All
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select cBookID,vBookName,vPressHouse,mPrice from books 
where vPressHouse != '电子工业出版社' and 
mPrice<all(select mPrice from books where vPressHouse=
'电子工业出版社');
########## End ##########

13. exists
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
select cCustomerID from orders where exists(
        select cOrderNo from orderdetail where cBookID=2109010001 
        and orders.cOrderNo=orderdetail.cOrderNo
);
########## End ##########