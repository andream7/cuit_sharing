1. insert
USE Studb;
#请在此处添加实现代码,注意用;作为结束符号
########## Begin ##########
insert into Student value('200215128','张小勇','男',18,'CS');
insert into SC value('200215128',1,null);
########## End ########## 
select * from Student join SC on Student.sno=SC.sno where Sname='张小勇';

2. delete
USE Studb;
set sql_safe_updates=0;
#请在此处添加实现代码,注意用;作为结束符号
########## Begin ##########
delete from SC where sno in(
    select sno from Student where Sname='刘晨'
)and cno in(
    select cno from Course where Cname='数据库'
);
########## End ########## 
select * from SC;

3. update
USE Studb;
set sql_safe_updates=0;
#请在此处添加实现代码
########## Begin ##########
update SC b set Grade=grade*1.1 where b.sno=(
    select a.sno from Student a where Sname='张立'
)and cno='1';
########## End ########## 
select * from SC 
where cno='1' and sno=(select sno from Student where sname='张立');

4. delete
USE Studb;
set sql_safe_updates=0;
#请在此处添加实现代码
########## Begin ##########
delete from SC where SC.Sno in(
    select a.Sno from Student a where 
    a.Ssex='女' and a.Sdept in(
        select b.Sdept from Student b where
        a.Sdept=b.Sdept and b.Sname='李勇' 
    )
);
########## End ########## 
select * from SC  where sno in
(select sno from Student where Ssex= '女');

5. 视图
USE Studb;
set sql_safe_updates=0;
#请在此处添加实现代码
########## Begin ##########
create view ababa 
as select sdept,sum(Ccredit) 'asd'
from Course join  SC on SC.Cno=Course.Cno 
join Student on SC.Sno=Student.Sno 
group by Sdept;
create view az
as select sum(asd) 'sdf' from ababa;
select sdept,cast(100*(asd/sdf) as decimal(32,5)) '占比' 
from ababa,az group by Sdept;
########## End ########## 