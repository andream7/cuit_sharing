1. 输入1
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(in init decimal,in len decimal,in number decimal)
Begin
  declare n int default 0;
  l1:loop
  update books set mSalePrice = n
  where mSalePrice in(
    select a.mSalePrice from(
      select mSalePrice from books where mSalePrice>=n and mSalePrice<n+len
    )a
  );
  if n>len*number then leave l1;
  end if;
  set n=n+len;
  end loop;
end $$
delimiter ;
########## End ##########  

2. 输入2
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(in bookType varchar(100),in flag int)
Begin
  if flag=0 then
  update books set mSalePrice=mSalePrice*0.5 where cBookID in(
    select a.cBookID from (
      select cBookID from books join booktype on books.cTypeID=booktype.cTypeID 
    where vTypeName=bookType
  ) a
);
elseif flag=1 then
  update books set mSalePrice=mSalePrice*0.5 where cBookID in(
    select a.cBookID from (
      select cBookID from books join booktype on books.cTypeID=booktype.cTypeID 
    where vTypeName!=bookType
  ) a
);
end if;
end $$
delimiter ;
########## End ##########

3. 输出1
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(out bookname  varchar(100), out eval int)
BEGIN
create view A as
select books.cBookID,vBookName ,count(*) 'sum'
from books join evaluation on evaluation.cBookID = books.cBookID
where comment like '非常好'
group by books.cBookID;
select vBookName,sum into bookname,eval
from A where cBookID=(
    select cBookID from A where sum=
        (select max(sum) from A)
);
end $$
delimiter ;
########## End ##########

4. 输入输出1
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(inout bookname  varchar(100), inout number int)
begin
declare n int default 0;
declare pos int;
set pos=number-1;
select count(*) into n from books a
where a.mSalePrice <(
select b.mSalePrice from books b where b.vBookName=bookname
);
if n<number then 
select "not existed", 1 into bookname, number;
else
select vBookName,siQuantity into bookname,number 
from books a
where a.mSalePrice <(
select b.mSalePrice from books b where b.vBookName=bookname
)
order by a.mSalePrice desc
limit pos,1;
end if;
end $$
delimiter ;
########## End ##########

5. 输入输出2
USE purchase_book;
#请在此处添加实现代码
########## Begin ##########
delimiter $$
create procedure MYPROC(inout price decimal, out bookname varchar(100))
begin
declare n int;
select cBookID into n
from books
order by abs(price-mSalePrice) asc
limit 1;
select vBookName,mSalePrice into bookname,price
from books
where cBookID=n;
end $$
delimiter ;
########## End ##########