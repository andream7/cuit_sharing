1. 权限赋值：表
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
create user 'cuit'@'localhost' identified by '123456';
grant select,insert on books to 'cuit'@'localhost';
grant select,insert on booktype to 'cuit'@'localhost';
########## End ##########  

2. 权限收回：表
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
create user 'cuit'@'localhost' identified by '123456';
grant all on books to 'cuit'@'localhost';
revoke insert on books from 'cuit'@'localhost';
########## End ##########  

3. 权限赋予：属性
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
create user 'cuit'@'localhost' identified by '123456';
grant select on books to 'cuit'@'localhost';
grant select(cTypeID),select(vTypeName),update(vTypeName) on booktype to 'cuit'@'localhost';
########## End ##########  

4. 权限收回：属性
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
grant select(cBookID),update(cBookID),select(mSalePrice),update(mSalePrice) 
on books to 'cuit'@'localhost';
revoke update(cTypeID) on books from 'cuit'@'localhost';
########## End ##########  

5. 级联权限赋予
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
create user 'cuit'@'localhost' identified by '123456';
create user 'cuit2'@'localhost' identified by '123456';
grant select,update,insert 
on books to 'cuit'@'localhost' with grant option;
########## End ##########  

6. 视图权限
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
create user 'cuit'@'localhost' identified by '123456';
create view Book_Price(cBookID,vBookName,mSalePrice,cTypeID)
as select cBookID,vBookName,mSalePrice,cTypeID from books;
grant select,update(mSalePrice) 
on Book_Price to 'cuit'@'localhost';
########## End ##########  