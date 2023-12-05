1. 模糊匹配
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select * from Student where Sname like '%勇%' and Sdept='CS';
########## End ########## 

2. 函数
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select max(Sno)-min(Sno)+1 as '学号差值',count(Sno) as '学生人数' from Student;
########## End ########## 

3. group by, having,cast
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Cno,round(avg(Grade),2) as '平均成绩' from SC group by Cno having avg(Grade)>75;
########## End ########## 

4. 排序和limit
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select sno,Grade from SC where Cno=1 order by Grade asc limit 2;
########## End ########## 

5. case when
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select sno,cno,
case 
when grade between 90 and 100 then 'A' 
when grade between 76 and 89 then 'B'
when grade between 60 and 75 then 'C'
when grade between 0  and 60 then 'D'
End as '成绩等级'
from SC;
########## End ########## 