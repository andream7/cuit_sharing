1. 输入
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(in baseQty decimal,in cut decimal(10,2))
Begin
    update books set mSalePrice=mSalePrice*cut
    where siQuantity<baseQty;
end $$
delimiter ;
########## End ##########  

2. 输出
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(out price decimal)
Begin
    update books set mSalePrice=mSalePrice*0.9
    where siQuantity between 0 and 99;
    update books set mSalePrice=mSalePrice*1.1
    where siQuantity between 100 and 499;
    update books set mSalePrice=mSalePrice*1.2
    where siQuantity >499;
    select avg(mSalePrice) into price from books;
end $$
delimiter ;
########## End ##########  

3. 输入输出
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(in paytype varchar(20),out totalCost int,out maxCost int)
Begin
    select sum(mTotalCost),max(mTotalCost) into totalCost,maxCost
    from orders
    where vPayType=paytype;
end $$
delimiter ;
########## End ##########  

4. 输入输出2
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(inout tmpName varchar(100), out totalCost decimal)
Begin
    declare orderNo char(11);
    declare bookID char(10);
    select cOrderNo into orderNo from orders where vRecipientName=tmpName
    order by mTotalCost desc limit 1;
    select vBookName,mBookCost into tmpName,totalCost
    from orderdetail
    join books on books.cBookID=orderdetail.cBookID
    where cOrderNo=orderNo
    order by mBookCost desc limit 1;
end $$
delimiter ;
########## End ##########