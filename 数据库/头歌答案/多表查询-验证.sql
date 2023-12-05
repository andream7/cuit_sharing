1. 外连接
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select Sname,Sage 
from student left join sc
on student.Sno=sc.Sno 
where Sdept='计算机系' and Cno is null;
########## End ##########  

2. 连接和库函数
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select max(Grade) as '最高分',min(Grade) as '最低分',avg(Grade) as '平均分' 
from sc left join course on course.Cno=sc.Cno where course.Cname='数据库';
########## End ##########  

3. 连接和统计count
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select count(*) as '选课人数' 
from course left join sc on course.cno=sc.cno where cname='数据库';
########## End ##########  

4. 多表连接
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select max(grade) as '最高分',min(grade) as '最低分',avg(grade) as '平均分' 
from sc join student on sc.sno=student.sno join 
course on sc.cno=course.cno 
where student.sdept='CS' and course.cname='数据库';
########## End ##########  

5. 多表连接和分组统计
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select sdept,max(grade) as '最高分',min(grade) as '最低分',avg(grade) as '平均分' 
from sc join student on sc.sno=student.sno join 
course on sc.cno=course.cno 
where course.cname='数据库' 
group by sdept;
########## End ##########  

6. 条件分支和分组统计
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select sno,
case when sum(ccredit)>10 then '好学生' 
     when sum(ccredit) between 6 and 10 then '一般学生' 
     else '不好学生' 
end 学生学分 
from sc join course on sc.cno=course.cno 
where grade>=60 
group by sno;
########## End ##########  

7. 条件分支和分组统计
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select sdept,sc.sno,count(*) '修课门数',avg(grade) '平均成绩',
case when count(*)>3 and avg(grade)>90.0 then '优秀'
     when count(*)>3 and avg(grade)>80.0 then '较好'
     when count(*)<=3 and avg(grade)>90.0 then '较好'
     when count(*)<=3 and avg(grade)>80.0 then '一般'
     else '应努力'
end 成绩 
from sc join student on sc.sno=student.sno 
group by sc.sno
order by avg(grade) desc;
########## End ##########  

8. 多表连接，排序
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select sname,cname,grade
from sc join student on sc.sno=student.sno 
join course on sc.cno=course.cno
where sdept='CS'
order by grade asc 
limit 2;
########## End ##########  

9. 外连接
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select student.sno,sname,sdept
from sc right join student on sc.sno=student.sno 
where cno is null;
########## End ##########  

10. 子查询
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select a.sname,a.sage
from student a
where a.sdept='CS' and a.sage>(
    select avg(b.sage) from student b where b.sdept='CS'
);
########## End ##########

11. 相关子查询
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select a.sno,a.sname
from student a join sc c on c.sno=a.sno
where a.sdept='CS' and c.grade<(
    select avg(d.grade) from student b join sc d on d.sno=b.sno 
);
########## End ##########

12. 子查询
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select a.sname,a.sdept
from student a
where a.ssex='男' and a.sage=(
    select max(b.sage) from student b where b.ssex='男'
);
########## End ##########

13. 子查询嵌套
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select a.sname,a.sdept
from student a
where a.sno in(
    select b.sno from sc b where b.cno in(
        select c.cno from course c where c.cname='数据库'
    )
);
########## End ##########

14. 子查询嵌套
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select a.sno,a.sname,a.sdept
from student a
where a.sno in(
    select b.sno from sc b where b.cno in(
        select c.cno from course c where c.cpno>2
    )
);
########## End ##########

15. 子查询嵌套
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select a.cname
from course a
where a.cno in(
    select b.cno from sc b where b.sno in(
        select c.sno from student c where c.ssex='男'
    )
);
########## End ##########

16. 子查询嵌套
USE Studb;
#请在此处添加实现代码
########## Begin ##########
select a.cname
from course a
where a.cno in(
    select b.cno from sc b where b.sno in(
        select c.sno from student c where c.sage=(
            select min(d.sage) from student d
        )
    )
);
########## End ##########