/*
求圆锥体积（泛型）
请用泛型完成该题目，输入为底面圆的半径和圆锥的高（两个整型），输出为该圆锥的体积（保留小数点后两位）。注：在涉及园的计算中请用Math.PI。
在这里给出函数被调用进行测试的例子。例如：
import java.util.Scanner;

public class Main {
       public static void main(String args[]) {
          int i,j;
        Scanner sc=new Scanner(System.in);
          i=sc.nextInt();
          j=sc.nextInt();
          sc.close();
        Circle circle=new Circle(i);
          Cone<Circle> coneOne=new Cone<Circle>(circle);//创建一个（圆）锥对象  
          coneOne.setHeight(j);
          System.out.printf("%.2f\n",coneOne.computerVolume());
          
      }
    }
/* 请在这里填写答案 *
*/
class Circle{
 double r;
 public Circle(double r) {
  super();
  this.r = r;
 }
    double getArea(){
        return Math.PI*r*r;
    }
}
class Cone<T>{
 T circle;
 double h; 
 public Cone(T circle) {
  this.circle = circle;
    }
 public void setHeight(int h){
  this.h = h;
 } 
 public double computerVolume() {  
  return ((Circle)circle).getArea() * h/3;
 }
}
/*
约瑟夫环（集合）
约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。
例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3，1。
由于在Java语言中，使用链表来实现非常简单。请完成代码，实现相应输出。
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        sc.close();
        LinkedList<Integer> list = new LinkedList<Integer>();
        /* 请在这里填写答案 *
        System.out.println(list.getFirst());
      }
}
*/
for(int i=1;i<=a;++i)
    list.add(i);
int order=1;
while(list.size()>1)
{
    if(order==b)
    {
        order=1;
        System.out.print(list.removeFirst()+" ");
    }
    else
    {
        list.add(list.removeFirst());
        ++order;
    }
}
/*
根据已有类Worker，使用LinkedList编写一个WorkerList类，实现计算所有工人总工资的功能
Main类：在main方法中，调用constructWorkerList方法构建一个Worker对象链表，调用computeTotalSalary方法计算总工资并输出到屏幕。

根据要求，编写WorkerList类的构造方法和方法。编程要求如下：

数据使用Scanner对象从键盘读入；
constructWorkerList方法：从键盘读入工人数量workerNum，调用readInWorker方法读入workerNum个工人，将每个工人对象添加到链表中，最后返回链表。
readInWorker方法：使用scanner从键盘读入一个工人的姓名、年龄和工资，构建一个Worker对象并返回
computeTotalSalary方法：计算链表中所有工人的工资总和并返回。
提示：
Scanner对象读入字符串的方法：

next()方法读入一个字符串，读到空白符结束；(本题中使用next()方法读入字符串)

nextLine()也是读入一个字符串，但读取到回车(也就是"\r")结束。

import java.util.*;

public class Main {
    public static void main(String[] args) {        
        WorkerList app=new WorkerList();                        
        List<Worker> list=app.constructWorkerList();        
        System.out.println(app.computeTotalSalary(list));    
    }
}

/* 请在这里填写答案：将WorkerList类补充在这里 *


class Worker {    
    private String name;
    private double salary;
    
    public Worker() { }
    
    public Worker(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }

    public String toString() {
        return name + " "+salary;
    }    
}
*/
class WorkerList
{
    Worker readInWorker()
    {
        Scanner input = new Scanner(System.in);
        Worker a = new Worker();
        String name = input.next();
        double salary = input.nextDouble();
        a.setName(name);
        a.setSalary(salary);
        input.close();
        return a;
    }
    List<Worker> constructWorkerList()
    {
        Scanner input = new Scanner(System.in);
        List<Worker> list = new LinkedList<Worker>();
        int n=input.nextInt();
        String name;
        double salary;
        for(int i=0;i<n;++i)
        {
            Worker w=new Worker();
            name=input.next();
            salary=input.nextDouble();
            w.setName(name);
            w.setSalary(salary);
            list.add(w);
        }
        input.close();
        return list;
    }
    double computeTotalSalary(List<Worker> l)
    {
        double sum=0;
        for(int i=0;i<l.size();++i)
            sum+=l.get(i).getSalary();
        return sum;
    }
}
/*
编写Student类，使用泛型和集合框架编写StudentList类，实现计算班级平均分的功能
Main类：在main方法中，调用constructStudentList方法构建一个Worker对象链表，调用computeAverageScore方法计算一个班级的平均分并输出到屏幕。
根据要求，编写Student类和StudentList类。

Student类的编程要求如下：

成员变量包括：学生姓名(String name)、班级编码(String classCode)、分数(int score)
根据程序需求编写构造方法。
根据程序需求编写set和get方法。
StudentList类的编程要求如下：

根据程序需求编写构造方法。
constructStudentList方法：调用readInStudent方法读入多个学生信息，将Student对象添加到链表中，构建一个Student对象链表，最后返回链表。
readInStudent方法：使用scanner从键盘读入一个学生的姓名、班级和分数，构建一个Student对象并返回。
computeAverageScore(List list)方法：遍历链表，累加链表中所有学生人数和总分数，计算出某个班级平均分并返回。
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentList sl=new StudentList();        
        List<Student> list=sl.constructStudentList();        
        System.out.println(sl.computeAverageScore(list));    
    }
}

/* 请在这里填写答案 *
/*请在这里补充Student类*
    
    
/*请在这里补充StudentList类*
*/
class Student
{
    String name;
    String classCode;
    int score;
    public void setName(String s){
        name=s;
    }
    String getName(){
        return name;
    }
    public void setClassCode(String s){
        classCode=s;
    }
    String getClassCode(){
        return classCode;
    }
    public void setScore(int s){
        score=s;
    }
    int getScore(){
        return score;
    }
}
class StudentList
{
    String t;
    List<Student> constructStudentList()
    {
        Scanner input=new Scanner(System.in);
        t=input.nextLine();
        List<Student> l=new ArrayList<>();
        String name;
        String code;
        int score;
        while(true)
        {
            Student s=new Student();
            int i=0;
            String c=input.nextLine();
            String[] a=c.split(" ");
            name=a[i];++i;
            code=a[i];++i;
            score=Integer.parseInt(a[i]);++i;
            s.setName(name);
            s.setClassCode(code);
            s.setScore(score);
            l.add(s);
            if(a.length>3)
                break;
        }
        input.close();
        return l;
    }
    Student readInStudent(){
        Student a=new Student();
        return a;
    }
    double computeAverageScore(List<Student> l)
    {
        double sum=0,num=0;
        for(int i=0;i<l.size();++i)
        {
            if(t.equals(l.get(i).getClassCode()))
            {
                sum+=l.get(i).getScore();
                ++num;
            }
        }
        sum/=num;
        return sum;
    }
}
