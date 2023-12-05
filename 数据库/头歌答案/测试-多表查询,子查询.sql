1. 不相关子查询
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select sno from Student where sno in
(select sno from SC where cno=1) and sno in
(select sno from SC where cno=2)
########## End ########## 

2. 相关子查询
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select a.sno,a.cno from SC a where grade>(
    select avg(b.grade) from SC b group by b.cno having a.cno=b.cno
);
########## End ########## 

3. 等值连接 group by
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select SC.Sno,count(Cno) as '选课数' from SC join Student on SC.Sno=Student.Sno 
where Student.Sdept='CS' group by SC.sno;
########## End ############

4. 外连接
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select cname from Course where Cno not in(
    select Cno from SC group by Cno
);
########## End ############

5. 子查询,等值连接综合题
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select sno from Student where Sdept='CS' and sno not in(
    select SC.sno from SC join Course on SC.cno=Course.cno 
    where Cname='操作系统'
);
########## End ############