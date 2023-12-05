1. 存储过程
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(inout qty decimal)
Begin
select count(*) into qty from books where siQuantity<qty;
End$$
delimiter ;
########## End ##########  

2. 函数
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter //
create function MYFUNC(saleprice decimal)
returns decimal
Begin
return (select count(*) from books where mSalePrice<saleprice);
End//
delimiter ;
########## End ##########  

3. 游标
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter //
create procedure MYPROC(in saleprice decimal, out totalQty smallint)
Begin
    declare a int default 0;
    declare c cursor for select sum(siQuantity) from books where mSalePrice<saleprice;
    declare continue handler for not found set a=1;
    open c;
    fetch c into totalQty;
    close c;
End//
delimiter ;
########## End ##########  

4. 触发器
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter //
create trigger check_update before update on books 
for each row 
Begin
    if new.mSalePrice<old.mPrice then 
    set new.mPrice=new.mSalePrice-10;
    end if;
End//
delimiter ;
########## End ##########  