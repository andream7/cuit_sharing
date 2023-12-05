1. 投影
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Cno,Cpno from Course;
########## End ########## 

2. in
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Sno,Sage from Student where Sdept in('CS','MA','IS');
########## End ########## 

3. 条件选择
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Sno,Grade from SC where Cno=1 and Grade>80;
########## End ########## 

4. 去重
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Sno from SC where Grade>80 group by Sno;
########## End ##########

5. 模糊匹配
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Sno,Sname,Ssex,Sage,Sdept from Student where Sname like "李%";
########## End ########## 

6. 模糊匹配
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Cno,Cname from Course where Cname like "数据%";
########## End ########## 

7. is null
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Cname from Course where Cpno is null;
########## End ########## 

8. 多项选择条件
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Sno,Cno,Grade from SC where Cno=1 and(
    Grade>90 or Grade<60
);
########## End ########## 

9. 最大值和最小值函数，别名
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Sdept,max(Sage) '最大年龄',min(Sage) '最小年龄' from Student 
group by Sdept;
########## End ########## 

10. 排序
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Sno,Grade from SC 
where Cno=1 
order by Grade asc,Sno desc;
########## End ########## 

11. group by having
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Cno,count(*) '选课人数' from SC 
group by Cno 
having count(*)>2;
########## End ########## 

12. group by avg
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Cno,avg(Grade) '平均成绩' from SC 
group by Cno 
having avg(Grade)>70.0;
########## End ########## 