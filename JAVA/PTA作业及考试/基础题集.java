/*
java.io包中的File类提供了获得文件基本信息及文件操作的方法。
T
RandomAccessFile类可以对文件进行随机读写操作。
T
InputStream所有与输入相关的方法声明抛出异常类IOException。
T
File类的对象可以对文件进行读取或写入。
F
Java中所有的I/O都是通过流来实现的。
T
Java语句：File f = new File(“d:\src\hello.txt”) ，编译没有语法错误。。
F
FileReader类提供了读取一行的方法。
F
Java程序结束的时候会自动关闭所有打开的流。
T
如果按字节来读取一个文件的内容，应该使用FileInputStream而不是FileReader。
T
BufferedReader流可以直接指向一个文件对象。
F
Java系统的标准输入对象是System.in，标准输出对象有两个，分别是System.out和System.err。
T
InputStream类和OutputStream类是所有二进制I/O的根类。
T
建立数据库连接时应捕获IOException异常。
F
不同数据库厂家提供了针对自己产品的不同JDBC驱动。
T
JDBC(Java DataBase Connection) ，是Java应用程序访问数据库的接口(API)规范，可以为多种关系数据库提供统一访问，它由一组用java语言编写的类和接口组成。
T
JDBC-ODBC桥接器是目前主流的数据库连接方式。
F
可以通过JDBC提供的API，在查询前知道数据库中表的字段个数和名字。
T
数据库查询的结果存放在一个ResultList类声明的对象中。
F
数据库查询的结果存放在一个PreparedStatement类声明的对象中。
F
当数据库连接关系后，ResultSet中的数据已经下载到本机，可以继续访问。
F
Java的回收机制会自动关闭数据库连接，所以程序员不用主动断开数据库。
F
JDBC中连接数据库的三要素是URL，用户名，密码。
T
可以通过一个可滚动的结果集来实现数据库的随机查询。
T
如果你被要求写一段代码读取一个文本文件，那么一般使用哪种Stream？
FileReader
为8位byte字节流提供读和写操作支持的类分别是（ ）。
InputStream类和OutputStream类
在java.io包中，只有实现了一个标记接口的类的对象才可以被串行化，这个接口是( )。
Serializable
这是在Java中，( )类提供定位本地文件系统，对文件或目录及其属性进行基本操作。
File
Character流与Byte流的区别是（ ）。
前者是字符读写，后者是字节读写
File类是IO包中唯一表示磁盘文件信息的对象，它定义了一些与平台无关的方法来操纵文件。
通过调用File类提供的各种方法，我们能够创建、删除文件、重命名文件、判断文件的读写权限及是否存在，设置和查询文件的最近修改时间等。
下面的代码片段实现的是什么功能？
File file = new File("C:\test.dat");
if (file.exists()) {
file.delete();
}
删除C:\test.dat。
如果需要从文件中读取数据，则可以在程序中创建哪一个类的对象（）。
FileInputStream
Java中，JDBC是指( )
Java程序与数据库连接的一种机制
在JDBC中，Statement对象调用（ ）方法来实现数据库的增、删、改。
executeUpdate()
下列哪个参数不是连接数据库所需要的参数：（ ）
主机名
下列哪个不是JDBC的基本功能?
创建数据库
下列哪个步骤不是JDBC访问数据库的必要步骤?
回滚事务操作
以下负责建立与数据库连接的是( )
DriverManager
在Java中，JDBC API定义了一组用于与数据库进行通信的接口和类，它们包括在( )包中。
java.sql
*/
/*
本题目要求计算1!+2!+3!+...+15!的值。
public class Main{
    public static void main( String args[] ) { 
        int  i,j,temp;
        int sum=0;
        for(i=1;i<=15;i++) { 
            /*-------------*
            for(j=1;j<=i;j++) {
            /*----------------*
            }
            /*-----------------*
        }
        System.out.println(sum);
    }
}
*/
temp=1;
temp*=j;
sum+=temp;
/*
水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身
（例如：1^3 + 5^3+ 3^3 = 153）。
完成本题，求出所有的三位数水仙花数。
public class Main {
    public static void main(String[] args) {
        for(int i=100; i<1000; i++){
            if(ComputingSXH.sxhNum(i) )
                System.out.print(i+" ");
        }
    }
}
class ComputingSXH{
    static int a, b, c; 
    public static boolean sxhNum(int m){
        a =/*----------*
        b =/*----------*
        c =/*----------*
        return        (a*a*a+b*b*b+c*c*c==m);
    }
}
*/
m%10;
m/10%10;
m/100;
/*
本题需要用递归实现N的阶乘，请完成程序，实现该功能。
public class Main {
    public static void main(String[] args) {
        int n = 20;
        System.out.print(Factorial(n));
    }
/*-----------------*
    {
        if(n == 0)
/*-----------*
        else
/*------------*
    }
}
*/
public int Factorial(int n)
return 1;
return n*Factorial(n-1);
/*
这是程序填空题。请在空格处填上代码，实现如下输出：
构造方法一被调用了
构造方法二被调用了
构造方法三被调用了
public class Main {
    public Main(){
        System.out.println("构造方法一被调用了");
    }
    public Main(int x){
        this();
        System.out.println("构造方法二被调用了");
    }
    public Main(boolean b){
        this(1);
        System.out.println("构造方法三被调用了");
    }
    public static void main(String[] args) {
        /*----------------*
    }
}
*/
Main a=new Main(true);
/*
冒泡算法
冒泡排序是最简单的排序之一，通过与相邻元素的比较和交换来把小的数交换到最前面。
请完成实现swap方法，来完成冒泡算法。
public class Main{
    public static void main(String[] args) {
     int a[] = {17,15,9,10,1};
     BubbleSort.bubbleSort(a);
     for(int i=0; i<a.length; i++)
     {
         System.out.print(a[i]+" ");
    }
}
}
class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=arr.length-1; j>i; j--) {
                if(arr[j]<arr[j-1]) {
                    swap(arr, j-1, j);
                }
            }
        }
    }
 /* 请在这里填写答案 *
}
*/
static void swap(int[] a,int l,int r)
{
    int temp=a[l];
    a[l]=a[r];
    a[r]=temp;
}
/*
分数计算
该题目实现了分数的表示，分数的加法和乘法。
该题目的输入不需要考虑输入分母为“0”。
注意，例如当输入是分子是4，分母是8的时候，分数应该是1/2，而不是4/8.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).print();
        in.close();
    }
}
/* 请在这里填写答案 *
*/
class Fraction
{
    int a,b;
    Fraction(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    void print()
    {
        int temp=gcd(a,b);
        System.out.print(a/temp+"/"+b/temp+" ");
    }
    int gcd(int m,int n)
    {
        return n>0?gcd(n,m%n):m;
    }
    Fraction plus(Fraction n)
    {
        Fraction temp=new Fraction(0,0);
        temp.a=this.a*n.b+this.b*n.a;
        temp.b=this.b*n.b;
        return temp;
    }
    Fraction multiply(Fraction n)
    {
        Fraction temp=new Fraction(0,0);
        temp.a=this.a*n.a;
        temp.b=this.b*n.b;
        return temp;
    }
}
/*
简单创建对象
本题要求实现一个Student类，
其包含两个变量（姓名和学号，分别为String和int类型），
其他应该完成的方法参见main函数中的调用。
public class Main {
    public static void main(String[] args) {
        Student chen=new Student();
        Student zhang=new Student("Zhang",2018123456);
        chen.setName("Chen");
        chen.setID(2018012345);
        System.out.println(chen.toString());
        System.out.println(zhang.toString());
    }
}
/* 请在这里填写答案 *
*/
class Student
{
    String name;
    int ID;
    Student(String name,int ID)
    {
        this.name=name;
        this.ID=ID;
    }
    Student()
    {
        
    }
    void setName(String name)
    {
        this.name=name;
    }
    void setID(int ID)
    {
        this.ID=ID;
    }
    public String toString()
    {
        return name+" "+ID;
    }
}
/*
计算长方体的表面积和体积
请完成相关代码，实现长方体的表面积和体积的计算
import java.util.Scanner;
/* 你的代码将被嵌入到这里 *
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double l = input.nextDouble();
    double w = input.nextDouble();
    double h = input.nextDouble();
    Cuboid myCuboid = new Cuboid(l, w, h);
   System.out.printf("%.4f",myCuboid.getArea());
    System.out.println();
    System.out.printf("%.4f",myCuboid.getVolume());
    input.close();
  }
}
*/
class Cuboid
{
    double l,w,h;
    Cuboid(double l,double w,double h)
    {
        this.l=l;
        this.w=w;
        this.h=h;
    }
    double getArea()
    {
        return (l*w+l*h+w*h)*2;
    }
    double getVolume()
    {
        return l*w*h;
    }
}
/*
十六进制转十进制 
完成方法，实现：输入为一个十六进制的数（可以是多位），输出其十进制的值。
在这里给出函数被调用进行测试的例子。例如：
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String hex = input.nextLine();
        System.out.println(hexToDecimal(hex.toUpperCase()));
        input.close();
    }
/* 请在这里填写答案 *
}
*/
static int hexToDecimal(String hex)
{
    int a=0,b,len=hex.length();
    char c;
    for(int i=0;i<len;++i)
    {
        c=hex.charAt(i);
        if(c>='A' && c<='F')
            b=c-'A'+10;
        else
            b=c-'0';
        a=a*16+b;
    }
    return a;
}
/*
设计一个栈类
栈（Stack）是一种以“后进先出”的方式存放数据的数据结构。
设计实现一个简单的栈来存放整型，完成如下功能：
方法	功能
StackOfIntegers()	构建一个默认容量为16的空栈
StackOfIntegers(capacity: int)	构建一个指定容量的空栈
empty(): boolean	如果栈为空则返回true
peek(): int	返回栈顶的整数而不从栈中删除该数
push(value: int): void	将一个整数存储到栈顶
pop(): int	删除栈顶整数并返回它
getSize(): int	返回栈中元素的个数
在这里给出函数被调用进行测试的例子。例如：
import java.util.Scanner;
public class Main {
    public static void main(String[
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        int first = input.nextInt();
        input.close();
        StackOfIntegers stack1 = new StackOfIntegers();
        StackOfIntegers stack = new StackOfIntegers(l);
        stack1.push(first);
        System.out.println(stack1.getsize() + " " + stack1.peek());
        for( int i = 0; i < l; i++)
            stack.push(i);
        while(!stack.empty())
            System.out.print(stack.pop() + " ");
    }
}
/* 请在这里填写答案 *
*/
class StackOfIntegers
{
    int[] a;
    int head;
    int capacity;
    StackOfIntegers()
    {
        a=new int[16];
        capacity=16;
        head=0;
    }
    StackOfIntegers(int number)
    {
        a=new int[number];
        capacity=number;
        head=0;
    }
    boolean empty()
    {
        return head==0;
    }
    int peek()
    {
        return a[head-1];
    }
    void push(int v)
    {
        a[head++]=v;
    }
    int pop()
    {
        return a[--head];
    }
    int getsize()
    {
        return capacity;
    }
}
/*
链表和迭代器
import java.util.*;
public class Main{
    public static void main(String args[]){
        LinkedList<String> mylist=new LinkedList<String>();
        mylist.add("Hello");                 //链表中的第一个节点
        mylist.add("PTA");                 //链表中的第二个节点
        mylist.add("I");
        /* 请在这里填写答案 *
        while(iter.hasNext()) {
          String te=(String)iter.next();  //必须强制转换取出的数据
          System.out.print(te+" ");
        }
   }
}
*/
mylist.pop();
mylist.pop();
mylist.pop();
mylist.add("I love java");
ListIterator iter=mylist.listIterator();
/*
约瑟夫环（集合）
约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。
例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3，1。由于在Java语言中，使用链表来实现非常简单。
请完成代码，实现相应输出。
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
    list.addLast(i);
while(list.size()>1)
{
    for(int i=1;i<b;++i) {
        list.addLast(list.getFirst());
        list.pollFirst();
    }
    System.out.print(list.getFirst()+" ");
    list.pollFirst();
}
/*
筛选数字
用户输入一个数字序列，然后显示该序列中的不同数字。该序列以“0”为结束标记，0以后的数字不计入统计，而且0也不计入统计。
在这里给出部分代码，请完善代码，实现功能。
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        /* 请在这里填写答案 *
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}
*/
Scanner in=new Scanner(System.in);
int c,flag,sz;
while(true)
{
    c=in.nextInt();
    if(c==0)
        break;
    flag=1;
    sz= list.size();
    for(int i=0;i<sz;++i) {
        if (list.get(i) == c) {
            flag = 0;
            break;
        }
    }
    if(flag==1)
        list.add(c);
}
/*
求圆锥体积（泛型）
请用泛型完成该题目，输入为底面圆的半径和圆锥的高（两个整型），输出为该圆锥的体积（保留小数点后两位）。
注：在涉及园的计算中请用Math.PI。
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
class Circle
{
    double r;
    Circle(double r)
    {
        this.r=r;
    }
    double getArea()
    {
        return Math.PI*r*r;
    }
}
class Cone<T>
{
    T circle;
    double h;
    Cone(T circle)
    {
        this.circle=circle;
    }
    void setHeight(int h)
    {
        this.h=h;
    }
    double computerVolume()
    {
        return ((Circle)circle).getArea()*h/3;
    }
}
/*
完成学生及教师的设计（包括集合）
已知Main类、Person类的设计，完成Student类，Teacher类、MyTool类的设计。
import java.util.*;
public class Main {
    public static void main(String[] args) {
     List persons=getPersons();  //得到一个所有人的线性表
        List teachers=new ArrayList();
        List students=new ArrayList();
        MyTool.separateStu_T( persons,teachers,students); //将persons线性表中的 teacher，student分别放到teachers,students两个线性表中
        Collections.sort(teachers);  //对教师线性表排序
        Collections.sort(students);  //对学生线性表排序
        showResult(teachers);  //显示教师线性表排序以后的结果
        showResult(students);  //显示学生线性表排序以后的结果
    }
    public static List getPersons()
    {
        List persons=new ArrayList();
        Scanner in=new Scanner(System.in);
        Person person=null;
        int num=Integer.parseInt(in.nextLine());
        for(int i=0;i<num;i++)
        {    String str=in.nextLine();
            String []data=str.split(",");
            if(data[0].equalsIgnoreCase("student"))
                 person=new Student(Integer.parseInt(data[1]),data[2],data[3],Integer.parseInt(data[4]),data[5]);
            else if (data[0].equalsIgnoreCase("teacher"))
                  person=new Teacher(Integer.parseInt(data[1]),data[2],data[3],Integer.parseInt(data[4]),data[5]);
            else person=null;
                 persons.add(person);
        }
        return persons;
    }
    public static void showResult(List persons)
    {
        for(int i=0;i<persons.size();i++)
        {
            Person per=(Person)persons.get(i);
            System.out.println(per.getName()+","+per.getGender()+","+per.getAge());
        }
    }
}    
abstract class Person  implements Comparable
{    private String name;
     private String gender;
     private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Person(String name, String gender, int age) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
/* 请在这里填写答案 *
*/
class Student extends Person
{
    int sno;
    String major;
    Student(int sno,String name,String gender,int age,String major)
    {
        super(name,gender,age);
        this.sno=sno;
        this.major=major;
    }
    void setSno(int sno)
    {
        this.sno=sno;
    }
    void setMajor(String major)
    {
        this.major=major;
    }
    int getSno()
    {
        return sno;
    }
    String getMajor()
    {
        return major;
    }
    public int compareTo(Object a)
    {
        return ((Student)a).getSno()-this.sno;
    }
}
class Teacher extends Person
{
    int tno;
    String subject;
    Teacher(int tno,String name,String gender,int age,String subject)
    {
        super(name,gender,age);
        this.tno=tno;
        this.subject=subject;
    }
    public void setTno(int tno)
    {
        this.tno = tno;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public int getTno() {
        return tno;
    }

    public String getSubject() {
        return subject;
    }
    public int compareTo(Object a)
    {
        return this.getAge()-((Teacher)a).getAge();
    }
}
class MyTool
{
    public static void separateStu_T(List persons,List teachers,List students)
    {
        Iterator<Person> it=persons.iterator();
        Person p;
        while (it.hasNext())
        {
            p=it.next();
            if(p instanceof Teacher)
                teachers.add((Teacher)p);
            else
                students.add((Student)p);
        }
    }
}
/*
多线程打印（继承）
通过继承实现多线程，在主方法中输入N，然后通过线程输出从0到N的整数。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThreadTest mythread;
        mythread = new ThreadTest(sc.nextInt());
        mythread.start();
        sc.close();
    }
}
/* 请在这里填写答案 *
*/
class ThreadTest extends Thread
{
    int n;
    ThreadTest(int n)
    {
        this.n=n;
    }
    public void run()
    {
        for(int i=1;i<=n;++i)
            System.out.print(i+" ");
    }
}
/*
多线程打印（接口）
通过接口方式实现多线程，在主方法中输入N，然后通过线程输出从0到N的整数。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyThread mythread=new MyThread(sc.nextInt());
        Thread threadone;
        threadone = new Thread(mythread);
        threadone.start();
        sc.close();
    }
}
/* 请在这里填写答案 *
*/
class MyThread implements Runnable
{
    int n;
    MyThread(int n)
    {
        this.n=n;
    }
    public void run()
    {
        for(int i=1;i<=n;++i)
            System.out.print(i+" ");
    }
}
/*
多线程累加
启动10个线程，第一个线程从1加到10，第二个线程从11加到20.....第十个线程从91加到100，最后再把10个线程结果相加。
线程类的已经完成，请完成Main类，实现输出。
class Thread_test extends Thread
{
    int number;
    public static int sum;
    public Thread_test(int n) //构造函数
    {
        number=n;
    }
    public static synchronized void add(int num){  //同步方法
        sum += num;
        }
    public void run()
    {
        int count=0;
        for(int i=0;i<10;i++)
        {
            count+=number+i;
        }
        System.out.println("The "+((int)number/10+1)+" time: "+count);
        add(count);
    }
}
/* 请在这里填写答案 *
*/
class Main
{
    public static void main(String[] args) throws Exception
    {
        Thread_test a[]=new Thread_test[10];
        for(int i=0;i<10;++i)
        {
            a[i]=new Thread_test(i*10+1);
            a[i].start();
            Thread_test.sleep(10);
        }
        System.out.println("Total is "+a[0].sum);
    }
}
/*
年龄输入异常
从键盘输入年龄，如果年龄大于120则年龄太大，
如果是负数，则是非法输入。
需要用自定义异常来实现。当输入正常年龄的时候，则把年龄打印出来；
如果输入是大于120的正数，则输出“too old”；
如果输入是负数，则输出“illegal input”。
import java.util.Scanner;
public class Main {
   public static void main(String args[]) {
      People wang=new People();
      int n;
      Scanner input=new Scanner(System.in);
      n=input.nextInt();
      input.close();
      try{  wang.setAge(n);
            System.out.println(wang.getAge());
      }
      catch(IntegerException e) {
            System.out.println(e.toString());
      }
    }
}
class People {
    private int age=1;
    public void setAge(int age) throws IntegerException {
/* 请在这里填写答案 *
*/
        if(age>120)
            throw new IntegerException("too old");
        else if(age<0)
            throw new IntegerException("illegal input");
        else
            this.age=age;
    }
    People()
    {

    }
    public int getAge() {
        return age;
    }
}
class IntegerException extends Exception
{
    IntegerException(String message)
    {
        super(message);
    }
    public String toString()
    {
        return getMessage();
    }
}
/*
自定义异常
public class Main {
   public static void main(String args[ ]) {
      try{  throw new DefaultException("Default Exception");
      }
      catch(Exception e) {
            System.out.println(e);
      }
    }
}
/* 请在这里填写答案 *
*/
class DefaultException extends Exception
{
    DefaultException(String message)
    {
        super(message);
    }
}
/*
父子年龄比较
该题目要求实现一个Age类，包括year，month，day三个变量，并有相应的构造方法和set方法，父亲的出生日期已经确定为1980年2月18日，然后输入儿子的出生日期，得到岁数的差异值，
如果儿子和父亲的年龄差小于20岁抛出异常“too young”，大于70岁也抛出异常“too old”。
注：1、年龄差取整。
2、不用考虑年份，月份，日期输入的异常，只需要考虑都是合理值即可。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int y,m,d;
        y=sc.nextInt();
        m=sc.nextInt();
        d=sc.nextInt();
        sc.close();
        Age father=new Age(1980);
        father.setMonth(2);
        father.setDay(18);
        Age son=new Age(y,m,d);
        try{System.out.print(father.Compare(son));
        }
        catch(AgeException e){
            System.out.println(e.toString());
        }
    }
}
/* 请在这里填写答案 *
*/
class Age
{
    int year,month,day;
    Age(int year)
    {
        this.year=year;
    }
    Age(int y,int m,int d)
    {
        year=y;
        month=m;
        day=d;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    int Compare(Age f) throws AgeException
    {
        int difference=Math.abs(year-f.year);
        if(month!=f.month)
        {
            if(month>f.month)
                difference--;
        }
        else
        {
            if(day>f.day)
                --difference;
        }
        if(difference<20)
            throw new AgeException("too young");
        else if(difference>70)
            throw new AgeException("too old");
        else
            return difference;
    }
}
class AgeException extends Exception
{
    AgeException(String message)
    {
        super(message);
    }
    public String toString()
    {
        return getMessage();
    }
}
/*
多种异常的捕获
如果try块中的代码有可能抛出多种异常，且这些异常之间可能存在继承关系，那么在捕获异常的时候需要注意捕获顺序。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String choice = sc.next();
            try {
                if (choice.equals("number"))
                    throw new NumberFormatException();
                else if (choice.equals("illegal")) {
                    throw new IllegalArgumentException();
                } else if (choice.equals("except")) {
                    throw new Exception();
                } else
                break;
            }
            /*这里放置你的答案*
        }//end while
        sc.close();
    }
}
*/
catch (NumberFormatException e){
    System.out.println("number format exception");
    System.out.println(e);
}catch (IllegalArgumentException e){
    System.out.println("illegal argument exception");
    System.out.println(e);
}catch (Exception e){
    System.out.println("other exception");
    System.out.println(e);
}
/*
父子年龄比较-2 
儿子的出生日期为2000年1月1日，然后在键盘输入父亲的出生日期，得到岁数的差异值，如果儿子和父亲的年龄差小于20岁抛出异常“too young”，大于70岁也抛出异常“too old”。
注：1、年龄差取整。2、不用考虑年份，月份，日期输入的异常，只需要考虑都是合理值即可。该题目要求实现一个Age类，包括year，month，day三个变量，并有相应的构造方法和set方法。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int y,m,d;
        y=sc.nextInt();
        m=sc.nextInt();
        d=sc.nextInt();
        sc.close();
        Age sonage=new Age(2000);
        sonage.setMonth(1);
        sonage.setDay(1);
        Age fatherage=new Age(y,m,d);
        try{System.out.print(sonage.Compare(fatherage));
        }
        catch(AgeException e){
            System.out.println(e.toString());
        }
    }
}
/* 请在这里填写答案 *
*/
class Age
{
    int year,month,day;
    Age(int year)
    {
        this.year=year;
    }
    Age(int y,int m,int d)
    {
        year=y;
        month=m;
        day=d;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    int Compare(Age f) throws AgeException
    {
        int difference=year-f.year;
        if(month!=f.month)
        {
            if(month<f.month)
                difference--;
        }
        else
        {
            if(day<f.day)
                --difference;
        }
        if(difference<20)
            throw new AgeException("too young");
        else if(difference>70)
            throw new AgeException("too old");
        else
            return difference;
    }
}
class AgeException extends Exception
{
    AgeException(String message)
    {
        super(message);
    }
    public String toString()
    {
        return getMessage();
    }
}
/*
数组工具
按照题目要求，实现int数组工具，打印，排序，求和，使得程序正常运行。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]= new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
        }
        MyArrays.printArray(array);//显示数组的内容
        MyArrays.sortArray(array);    //对数组元素排序
        MyArrays.printArray(array);//显示排序后的结果
        int sum=MyArrays.sumOfArray(array);//数组元素求和
        System.out.println(sum);//显示数组元素的和
        sc.close();
    }
}
/* 请在这里填写答案 *
*/
class MyArrays
{
    static void printArray(int[] a)
    {
        int len=a.length;
        for(int t:a)
            System.out.print(t+",");
        System.out.println();
    }
    static void sortArray(int[] a)
    {
        Arrays.sort(a);
    }
    static int sumOfArray(int[] a)
    {
        int sum=0;
        for(int t:a)
            sum+=t;
        return  sum;
    }
}
/*
二维向量定义及加法运算
裁判测试程序样例中展示的是一段二维向量类TDVector的定义以及二维向量求和的Java代码，其中缺失了部分代码，请补充完整，以保证测试程序正常运行
import java.util.Scanner;
class TDVector {
    private double x;
    private double y;
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
    /** 你所提交的代码将被嵌在这里（替换此行） *
}
public class Main {
    public static void main(String[] args) {
        TDVector a = new TDVector();  * 无参构造，向量的x和y默认为0 *
        Scanner sc = new Scanner(System.in);
        double x,y,z;
        x = sc.nextDouble();
        y = sc.nextDouble();
        z = sc.nextDouble();        
        TDVector b = new TDVector(x, y);  * 按照参数构造向量的x和y *
        TDVector c = new TDVector(b);  * 按照向量b构造向量 *
        a.setY(z);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        c.setX(z);
        a = b.add(c);
        System.out.println(a);
        System.out.println("b.x="+b.getX()+" b.y="+b.getY());
        sc.close();
    }
}
*/
TDVector()
{
    x=0.0;
    y=0.0;
}
TDVector(double x,double y)
{
    this.x=x;
    this.y=y;
}
TDVector(TDVector p)
{
    x=p.x;
    y=p.y;
}
void setX(double x)
{
    this.x=x;
}
void setY(double y)
{
    this.y=y;
}
double getX()
{
    return x;
}
double getY()
{
    return y;
}
TDVector add(TDVector p)
{
    TDVector a=new TDVector(x+p.x,y+p.y);
    return a;
}
/*
BMI计算（类与对象）
身体质量指数（BMI）是基于体重和身高计算的健康测量。可以通过以千克为单位的体重除以以米为单位的身高的平方，得到BMI的值。
输入体重（磅）和身高（英寸），求身体BMI的指标。1磅=0.45359237，1英寸=0.0254米。
BMI	说明
BMI<18.5	Underweight
18.5<=BMI<25.0	Normal
25.0<=BMI<30.0	Overweight
30.0<=BMI	Obese
请设计一个BMI类，包含有姓名，年龄，体重（磅），身高（英寸）等信息。主程序如下所示，请完成设计，使程序按要求输出。
在这里给出类被调用进行测试的例子。例如：
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int age = input.nextInt();
        double weight = input.nextDouble();
        double height = input.nextDouble();
        BMI bmi1 = new BMI(name, age, weight, height);
        System.out.println("The BMI for " + bmi1.getName() + " is " + bmi1.getBMI() + " " + bmi1.getStatus());
    }
}
/* 请在这里填写答案 *
*/
class BMI
{
    String name;
    int age;
    double weight,height;
    double bmi;
    BMI(String name,int age,double weight,double height)
    {
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.height=height;
        bmi=weight*0.45359237/(height*0.0254*0.0254*height);
    }
    String getName()
    {
        return name;
    }
    double getBMI()
    {
        return Double.parseDouble(String.format("%.2f",bmi));
    }
    String getStatus()
    {
        if(bmi<18.5)
            return "Underweight";
        else if(bmi<25.0)
            return "Normal";
        else if(bmi<30.0)
            return "Overweight";
        else
            return "Obese";
    }
}
/*
设计MyInteger类
设计一个MyInteger的类。这个类包括：
一个名为value的int类型数据域，存储这个对象表示的int值。
一个为指定的int值创建MyInteger对象的构造方法。
一个为缺省值创建MyInteger对象的构造方法，value缺省值为0.
如果对象中的值分别是偶数、奇数或者素数，那么isEven()、isOdd()和isPrime()方法会返回true。
两个equals()方法，如果该对象的值与指定的值相等，那么equals(int)和equals(MyInteger)返回true。
测试程序如下
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        MyInteger A = new MyInteger(x);
        MyInteger B = new MyInteger(y);
        MyInteger C = new MyInteger();
        System.out.println(A.isEven());
        System.out.println(A.isOdd());
        System.out.println(A.isPrime());
        System.out.println(A.equals(z));
        System.out.println(A.equals(B));
    }
}
/* 请在这里填写答案 *
*/
class MyInteger
{
    int x;
    MyInteger()
    {

    }
    MyInteger(int x)
    {
        this.x=x;
    }
    String isEven()
    {
        return x%2==0?"true":"false";
    }
    String isOdd()
    {
        return x%2==1?"true":"false";
    }
    String isPrime()
    {
        int sq=(int)Math.sqrt(x);
        for(int i=2;i<=sq;++i)
        {
            if(x%i==0)
                return "false";
        }
        return "true";
    }
    String equals(int x)
    {
        return this.x==x?"true":"false";
    }
    String equals(MyInteger a)
    {
        return x==a.x?"true":"false";
    }
}
/*
设计MyPoint类
设计一个MyPoint类，代表一个以x坐标和y坐标的点。该类包括：
一个创建(0,0)的无参构造方法。
以指定坐标构建点的构造方法。
一个名为distance的方法，返回该点到MyPoint类型的指定点之间的距离。
一个名为distance的方法，返回该点到指定x和y坐标的距离。
一个名为distance的静态方法，返回两个MyPoint对象之间的距离。
测试方法如下所示：
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double y = input.nextDouble();
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        MyPoint P1 = new MyPoint();
        MyPoint P2 = new MyPoint(x,y);
        MyPoint P3 = new MyPoint(x1,y1);
        System.out.printf("%.4f", P1.distance(P2));
        System.out.print("\n");
        System.out.printf("%.4f", MyPoint.distance(P2,P3));
    }
}
/* 请在这里填写答案 *
*/
class MyPoint
{
    double x,y;
    MyPoint()
    {
        x=0;
        y=0;
    }
    MyPoint(double a,double b)
    {
        x=a;
        y=b;
    }
    public double distance(MyPoint t)
    {
        return Math.sqrt((x-t.x)*(x-t.x)+(y-t.y)*(y-t.y));
    }
    public double distance(double a,double b)
    {
        return Math.sqrt((x-a)*(x-a)+(y-b)*(y-b));
    }
    public static double distance(MyPoint a,MyPoint b)
    {
        return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }
}
/*
JAVA成绩比较 
本题要求实现Student类，该类实现Comparable接口，用于计算两个同学的JAVA成绩差，
其中一个同学的数据已经输入，只需要从键盘输入第二个同学的信息（只有姓名和JAVA成绩两项），最终返回成绩差（可能有负数）。
在这里给出该类被调用进行测试的例子。例如：
import java.util.Scanner;
interface Comparable {                            
    int compareTo(Student  student);
}
public class Main {
    public static void main(String[] args) {                
        Scanner input = new Scanner(System.in);
        Student p1=new Student("张三", 88);
        String name = input.next();
        int score = input.nextInt();
        Student p2 = new Student(name,score);
        System.out.println(p1.compareTo(p2));
        input.close();
    }
}
/* 请在这里填写答案 
*/
class Student
{
    String name;
    int score;
    Student(String name,int score)
    {
        this.name=name;
        this.score=score;
    }
    public int compareTo(Student p)
    {
        return score-p.score;
    }
}
/*
请完成父类
裁判测试程序样例中展示的是一段定义基类People、派生类Student以及测试两个类的相关Java代码，
其中缺失了部分代码，请补充完整，以保证测试程序正常运行。
class People{
    protected String id;
    protected String name;
    /** 你提交的代码将被嵌在这里（替换此行） **
}
class Student extends People{
    protected String sid;
    protected int score;
    public Student() {
        name = "CUIT Student";
    }
    public Student(String id, String name, String sid, int score) {
        super(id, name);
        this.sid = sid;
        this.score = score;
    }
    public void say() {
        System.out.println("I'm a student. My name is " + this.name + ".");
    }
}
public class Main {
    public static void main(String[] args) {
        Student zs = new Student();
        zs.setId("4700X");
        zs.setName("Zhang San");
        zs.say();
        System.out.println(zs.getId() + " , " + zs.getName());
        Student ls = new Student("330106","Li Si","2018000007",98);
        ls.say();
        System.out.println(ls.getId() + " : " + ls.getName());
        People ww = new Student();
        ww.setName("Wang Wu");
        ww.say();
        People zl = new People("370202", "Zhao Liu");
        zl.say();
    }
}
*/
People()
{
    
}
People(String id,String name)
{
    this.id=id;
    this.name=name;
}
public void setId(String id)
{
    this.id=id;
}
public void setName(String name)
{
    this.name=name;
}
public String getId()
{
    return id;
}
public String getName()
{
    return name;
}
public void say()
{
    System.out.println("I'm a person. My name is "+name+".");
}
/*
请按照要求实现接口
创建一个直角三角形类Triangle类，实现下列接口Ishape。两条直角边长作为Triangle类的私有成员，类中包含参数为直角边的构造方法。
import java.text.DecimalFormat;
interface Ishape {
    public abstract double getArea();
    public abstract double getPerimeter();
}
/*你写的代码将嵌入到这里*
public class Main {
    public static void main(String[] args) {
        DecimalFormat d = new DecimalFormat("#.####");
        Ishape r = new Triangle(3.1, 4.2);
        System.out.println(d.format(r.getArea()));
        System.out.println(d.format(r.getPerimeter()));
    }
}
*/
class Triangle implements Ishape
{
    private double a,b;
    Triangle(double a,double b)
    {
        this.a=a;
        this.b=b;
    }
    public double getArea()
    {
        return a*b/2;
    }
    public double getPerimeter()
    {
        return a+b+Math.sqrt(a*a+b*b);
    }
}
/*
根据父类完成子类
裁判测试程序样例中展示的是一段定义基类People、派生类Student以及测试两个类的相关Java代码，其中缺失了部分代码，请补充完整，以保证测试程序正常运行。
class People{
    private String id;
    private String name;
    public People(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
class Student extends People{
    private String sid;
    private int score;
    public Student(String id, String name, String sid, int score) {
    /** 你提交的代码将被嵌在这里（替换此行） *
    }
    public String toString(){
        return ("(Name:" + this.getName() 
                + "; id:" + this.getId() 
                + "; sid:" + this.sid
                + "; score:" + this.score 
                + ")");
    }
}
public class Main {
    public static void main(String[] args) {
        Student zs = new Student("370202X", "Zhang San", "1052102", 96);
        System.out.println(zs);
    }
}
*/
super(id,name);
this.sid=sid;
this.score=score;
/*
抽象类的继承
该题是抽象类的继承，请仔细阅读主方法和基类，完成代码，使得程序输出正常
public class Main {
    public static void main(String[] args) {
        Shape s1=new Circle(3.0);
        Shape s2=new Rec(4.5,7.6);
        System.out.printf("%.3f\n",s1.getArea());
        System.out.printf("%.3f",s2.getArea());
    }
}
abstract class Shape{
    abstract double getArea();
}
/* 请在这里填写答案 *
*/
class Circle extends Shape
{
    double r;
    Circle(double r)
    {
        super();
        this.r=r;
    }
    public double getArea()
    {
        return Math.PI*r*r;
    }
}
class Rec extends Shape
{
    double a,b;
    Rec(double a,double b)
    {
        super();
        this.a=a;
        this.b=b;
    }
    public double getArea()
    {
        return a*b;
    }
}
/*
打印大小写字母
仔细阅读接口和主程序的调用，完成程序，使得程序可以正常打印26个大小写字母。
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int N,n;
        Scanner input=new Scanner(System.in);
        N=input.nextInt();
        n=input.nextInt();
        input.close();
        InterfaceA a =new Print();
        a.setN(N);
        a.printCapitalLetter();
        InterfaceB b=new Print();
        b.printLowercaseLetter(n);
    }
}
interface InterfaceA {
    void setN(int n);
    void printCapitalLetter();
}
interface InterfaceB {
    void printLowercaseLetter(int n);
}
/* 请在这里填写答案 *
*/
class Print implements InterfaceA,InterfaceB
{
    int n;
    Print()
    {
        super();
        n=0;
    }
    public void setN(int n)
    {
        if(n>26)
            n%=26;
        this.n=n;
    }
    public void printCapitalLetter()
    {
        for(int i=0;i<n;++i)
            System.out.printf("%c",'A'+i);
        System.out.println();
    }
    public void printLowercaseLetter(int n)
    {
        if(n>26)
            n%=26;
        for(int i=0;i<n;++i)
            System.out.printf("%c",'a'+i);
        System.out.println();
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
    public List<Worker> constructWorkerList()
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        List<Worker> l=new LinkedList<Worker>();
        for(int i=0;i<n;++i)
        {
            Worker w=new Worker(in.next(),in.nextDouble());
            l.add(w);
        }
        in.close();
        return l;
    }
    public double computeTotalSalary(List<Worker> a)
    {
        double sum=0;
        for(Worker w:a)
            sum+=w.getSalary();
        return sum;
    }
}
/*
分解质因数
将一个正整数分解质因数。不用考虑输入为0，1或者负数。
*/
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        int temp= (int) Math.sqrt(a);
        int flag=0;
        System.out.print(a+"=");
        for(int i=2;i<=temp;++i)
        {
            if(a%i==0)
            {
                if(flag==0)
                {
                    System.out.print(i);
                    a/=i;
                    flag=1;
                }
                while(a%i==0)
                {
                    System.out.print("*"+i);
                    a/=i;
                }
            }
        }
        if(a!=1)
            System.out.print(a);
    }
}
/*
求s=a+aa+aaa+aaaa+aa...a的值
题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a,b;
        a=input.nextInt();
        b=input.nextInt();
        long c=a,sum=0;
        for(int i=0;i<b;++i)
        {
            sum+=c;
            c=c*10+a;
        }
        System.out.println(sum);
    }
}
/*
鸡兔同笼
有若干只鸡兔同在一个笼子里，从上面数，有m个头，从下面数，有n只脚。问笼中各有多少只鸡和兔？
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n,m;
        n=input.nextInt();
        m=input.nextInt();
        if(m<2*n)
            System.out.println("No Answer");
        else
        {
            if((m-2*n)%2>0)
                System.out.println("No Answer");
            else
                System.out.printf("%d %d",n-(m-2*n)/2,(m-2*n)/2);
        }
    }
}
/*
统计字母和数字的个数
该题读入键盘输入字符串，然后统计字母和数字的出现个数。注：中间不得出现空格；使用String str = sc.nextLine();来读入字符串。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a=0,b=0,d=0,len=0;
        String s;
        char c;
        s=input.nextLine();
        len=s.length();
        for(int i=0;i<len;++i)
        {
            c=s.charAt(i);
            if(c>='0' && c<='9')
                ++a;
            else if(c>='a' && c<='z' || c>='A' && c<='Z')
                ++b;
            else if(c==' ')
                ++d;
        }
        System.out.printf("%d %d",b,a);
    }
}
/*
超市奖票兑换
某家超市有一种促销手段，购买金额超过一定金额就给一张随机编号奖票。编号是一个1到100之间的数字。当收集到连续编号的三张贴花时，就可以换一个小礼物。兑换完礼物后，该奖票就作废。

小明经常去某家超市购物，积攒了不少奖票，你帮他看看，能换多少小礼物。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int c,ans=0;
        int[] a=new int[105];
        for(int i=0;i<n;++i)
        {
            c = input.nextInt();
            ++a[c];
        }
        for(int i=3;i<=100;++i)
        {
            while(a[i]>0 && a[i-1]>0 && a[i-2]>0)
            {
                ++ans;
                --a[i];
                --a[i-1];
                --a[i-2];
            }
        }
        System.out.println(ans);
    }
}
/*
删除序列的最大和最小值
学者在进行数据统计的时候，为了避免极值的影响，通常会忽略掉最大值和最小值，然后对剩余元素进行统计，请编写程序完成去除极值的工作。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[1005];
        for(int i=0;i<n;++i)
            a[i] = input.nextInt();
        Arrays.sort(a,0,n);
        --n;
        System.out.printf("%d",a[1]);
        for(int i=2;i<n;++i)
            System.out.printf(" %d",a[i]);
    }
}
/*
打印等腰直角三角形
等腰直角三角形是指一个角是直角，且两条直角边相等的三角形。这里我们输出直角边长为n的等腰直角三角形。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<=i;++j)
                System.out.printf("*");
            System.out.println();
        }
    }
}
/*
报数分队
班级第一次列队，通常老师会让同学按身高排成一列，然后1、2报数，喊到1的同学向前一步，就这样，队伍就变成两列了。假设现在一个班级有n个同学，并且他们已经按身高排成了一列，同学按身高从1到n编号，你能告诉我最后哪些编号的同学站在了第一列么?
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[105];
        for(int i=0;i<n;++i)
        {
            a[i]=input.nextInt();
        }
        System.out.print(a[0]);
        for(int i=2;i<n;i+=2)
            System.out.printf(" %d",a[i]);
        System.out.println();
        if(n>1)
            System.out.print(a[1]);
        for(int i=3;i<n;i+=2)
            System.out.printf(" %d",a[i]);
    }
}
/*
N个6的加法
sn=6+66+666+...+66..66(n个6)。 求sn？
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int c=0,sum=0;
        for(int i=0;i<n;++i)
        {
            c=c*10+6;
            sum+=c;
        }
        System.out.println(sum);
    }
}
/*
结伴出行
可以去秋游啦！同学们别提多高兴了！老师说，单独行动有点危险，那么我们还是结伴同行吧。结伴的规则是这样的：排在最前的一个人和排在最后的那个人结成同伴，排在第2个的与排在倒数第2个的结成同伴......依次类推，2个一组成同伴。好，请马上排出来吧！老师语音一落，同学们“唰唰唰”很快结伴好了，准备出发喽！
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[55];
        for(int i=0;i<n;++i)
        {
            a[i]=input.nextInt();
        }
        for(int i=0;i<n/2;++i)
        {
            System.out.printf("%d %d\n",a[i],a[n-1-i]);
        }
    }
}
/*
读数字（switch练习）
输入一个整数，输出每个数字对应的拼音。只处理正数。十个数字对应的拼音如下：

0: ling
1: yi
2: er
3: san
4: si
5: wu
6: liu
7: qi
8: ba
9: jiu
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int flag=0;
        int a;
        for(int i=0;i<n;++i)
        {
            a=input.nextInt();
            if(flag>0)
                System.out.print(" ");
            else
                flag=1;
            if(a==0)
                System.out.print("ling");
            else if(a==1)
                System.out.print("yi");
            else if(a==2)
                System.out.print("er");
            else if(a==3)
                System.out.print("san");
            else if(a==4)
                System.out.print("si");
            else if(a==5)
                System.out.print("wu");
            else if(a==6)
                System.out.print("liu");
            else if(a==7)
                System.out.print("qi");
            else if(a==8)
                System.out.print("ba");
            else if(a==9)
                System.out.print("jiu");
        }
    }
}
/*
求素数
输入一个整数，求该整数范围内的所有素数。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int MAX=100000;
        int[] p=new int[MAX];
        int[] v=new int[MAX];
        int cnt=0;
        for(int i=2;i<MAX;++i)
        {
            if(v[i]==0)
            {
                p[++cnt]=i;
            }
            for(int j=1;j<=cnt && p[j]*i<MAX;++j)
            {
                v[p[j]*i]=1;
                if(i%p[j]==0)
                    break;
            }
        }
        for(int i=1;p[i]<=n;++i)
        {
            System.out.printf("%d",p[i]);
            if(i%5==0)
                System.out.println();
            else
                System.out.printf("\t");
        }
    }
}
/*
毕业聚会
毕业在即，三位小伙伴马上要分别。为了在未来的某个日子可以见面，三位小伙伴有了一个约定，假设在未来的某一年，三位小伙伴的年龄的末尾正好出现3、6、9三个数，那么他们会再次相聚。

现在问题来了，假设今年三位小伙伴的年龄分别是x，y，z，那么，他们三人最早几年后可以相聚呢?
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] a=new int[5];
        for(int i=0;i<3;++i)
            a[i] = input.nextInt();
        Arrays.sort(a,0,3);
        int ans=0,flag=0;
        for(int i=0;i<100;++i)
        {
            for(int j=0;j<3;++j)
                a[j] = (a[j] + 1) % 10;
            ++ans;
            if(a[0]==3 && a[1]==6 && a[2]==9)
            {
                System.out.println(ans);
                flag = 1;
                break;
            }
        }
        if(flag==0)
            System.out.println("so sad!");
    }
}
/*
冒泡算法（打出中间过程）
冒泡排序是一种简单的排序算法。
它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
请完成8个整数的冒泡排序，并打印出中间过程。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] a=new int[10];
        int temp;
        for(int i=0;i<8;++i)
            a[i]=input.nextInt();
        for(int i=0;i<7;++i)
        {
            for(int j=0;j<7-i;++j)
            {
                if(a[j]>a[j+1])
                {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            System.out.print(a[0]);
            for(int j=1;j<8;j++)
                    System.out.print(" "+a[j]);
            System.out.println();
        }
    }
}
/*
选择排序
选择排序(Selection-sort)是一种简单直观的排序算法。
它的工作原理：首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
以此类推，直到所有元素均排序完毕。
请完成8个整数的选择排序，并打印出中间过程。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] a=new int[10];
        int temp,mx;
        for(int i=0;i<8;++i)
            a[i]=input.nextInt();
        for(int i=0;i<8;++i)
        {
            mx=i;
            for(int j=i+1;j<8;++j)
            {
                if(a[j]<a[mx])
                    mx=j;
            }
            temp=a[mx];
            a[mx]=a[i];
            a[i]=temp;
            for(int j=0;j<7;j++)
                    System.out.print(a[j]+" ");
            System.out.println(a[7]);
        }
    }
}
/*
输入单词倒置
通过键盘输入几个单词，每个单词以空格分开。然后从最后一个单词开始，挨个输出每个单词。输出时每个单词之间有一个空格，最后一个单词后面没有空格。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String a=input.nextLine();
        String[] b=a.split(" ");
        int cnt=b.length;
        System.out.print(b[cnt-1]);
        for(cnt-=2;cnt>=0;--cnt)
            System.out.print(" "+b[cnt]);
    }
}
/*
大数相加
在Java语言中，整数相加受到了位数的限制，请实现两个超大整数的加法。
*/
import java.util.*;
import java.math.BigInteger;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String a=input.nextLine();
        String b=input.nextLine();
        String c=new BigInteger(a).add(new BigInteger(b)).toString();
        System.out.print(a+"+"+b+"="+c);
    }
}
/*
消费税计算
营业税为消费额的6%，用户输入消费金额，程序计算出营业税，计算结果四舍五入保留小数点两位。当输入金额为负数是，系统输出“Invalid input”。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double a=input.nextDouble();
        if(a>0)
            System.out.printf("%.2f",a*0.06);
        else
            System.out.println("Invalid input");
    }
}
/*
整除判断
输入一个整数，判断是否被2,3整除。如果能被2和3同时整除，则输出“n is divisible by 2 and 3”（n是输入的整数）。如果只能被2或3整除，则输出“n is divisible by 2 or 3, but not both”，如果都不能被2和3同时整除，则输出“n is not divisible by 2 and 3”
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        if(a%6==0)
            System.out.println(a+" is divisible by 2 and 3");
        else if(a%2==0 || a%3==0)
            System.out.println(a+" is divisible by 2 or 3, but not both");
        else
            System.out.println(a+" is not divisible by 2 and 3");
    }
}
/*
求最大公约数
输入两个正整数，输出这两个整数的最大公约数
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        System.out.println(GCD(a,b));
    }
    public static int GCD(int m, int n) {
        return n>0?GCD(n,m%n):m;
    }
}
/*
BMI计算
身体质量指数（BMI）是基于体重和身高计算的健康测量。可以通过以千克为单位的体重除以以米为单位的身高的平方，得到BMI的值。
输入体重（磅）和身高（英寸），求身体BMI的指标。1磅=0.45359237，1英寸=0.0254米。

BMI	说明
BMI<18.5	Underweight
18.5<=BMI<25.0	Normal
25.0<=BMI<30.0	Overweight
30.0<=BMI	Obese
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double w=input.nextDouble();
        double h=input.nextDouble();
        w*=0.45359237;
        h*=0.0254;
        double bmi=w/(h*h);
        if(bmi<18.5)
            System.out.println("Underweight");
        else if(bmi<25.0)
            System.out.println("Normal");
        else if(bmi<30.0)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }
}
/*
计算π的值
在数学中，我们可以通过π=4╳(1-1/3+1/5-1/7+1/9-......1/(2╳n+1)) 来计算，n越大，计算值越靠近。输入正整数n来计算π。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int flag=-1;
        double pi=1.0;
        --n;
        for(int i=1;i<=n;++i)
        {
            pi+=1.0/(2*i+1)*flag;
            flag*=-1;
        }
        System.out.println(pi*4);
    }
}
/*
计算器
实现一个简单的四则运算器，用户依次输入第一个运算数，运算符，和第二个运算数，程序给出相应答案。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        String op=input.next();
        int b=input.nextInt();
        int c;
        char opration=op.charAt(0);
        System.out.print(a+" "+opration+" "+b+" = ");
        if(opration=='+')
            System.out.print(a+b);
        else if(opration=='-')
            System.out.print(a-b);
        else if(opration=='*')
            System.out.print(a*b);
        else if(opration=='/')
            System.out.print(a/b);
    }
}
/*
求圆柱的面积和体积
输入圆柱的底面半径r和高l（double类型），输出圆柱的底面积和体积（double类型）。注意：计算中的π来自于Math。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double r=input.nextDouble();
        double l=input.nextDouble();
        double s=Math.PI*r*r;
        System.out.println("The area is "+s);
        System.out.println("The volume is "+s*l);
    }
}
/*
一位的十六进制转换为十进制
十六进制记数系统有16个数字：0到9，A到F。之母A、B、C、D、E和F分别对应十进制的数字10、11、12、13、14和15。现在完成程序，输入为十六进制的数字（一位），显示它对应的十进制数。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s=input.next();
        char c=s.charAt(0);
        if(c>='0' && c<='9')
            System.out.printf("%d",c-'0');
        else
            System.out.printf("%d",c-'A'+10);
    }
}
/*
十进制转十六进制
输入为一个十进制的数（可以是多位），输出是其十六进制的值。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        char[] s=new char[1000];
        int cnt=0,temp;
        if(n==0)
            System.out.println(0);
        while(n>0)
        {
            temp=n%16;
            if(temp<10)
                s[cnt++]=(char)(temp+'0');
            else
                s[cnt++]=(char)(temp-10+'A');
            n/=16;
        }
        for(--cnt;cnt>=0;--cnt)
            System.out.print(s[cnt]);
    }
}
/*
判断奇偶
输入一个整数，判断其奇偶性
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        if(n%2>0)
            System.out.println(n+" is odd.");
        else
            System.out.println(n+" is even.");
    }
}
/*
华氏度转摄氏度
本题要求编写程序，计算华氏温度对应的摄氏温度。计算公式：C=5×(F−32)/9，式中：C表示摄氏温度，F表示华氏温度，输出数据要求为取整（舍去小数部分）后整型。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        System.out.printf("%d",5*(n-32)/9);
    }
}
/*
华氏度转摄氏度（四舍五入）
本题要求编写程序，计算华氏温度对应的摄氏温度。计算公式：C=5×(F−32)/9，式中：C表示摄氏温度，F表示华氏温度，输出数据要求为四舍五入取整后整型。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double n=input.nextDouble();
        System.out.printf("%d",Math.round(5*(n-32)/9));
    }
}
/*
中国生肖年
输入一个年份，输出该年的生肖属相。注：十二生肖为鼠、牛、虎、兔、龙、蛇、马、羊、猴、鸡、狗、猪。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        char[] s={'鼠','牛','虎','兔','龙','蛇','马','羊','猴','鸡','狗','猪'};
        int n=input.nextInt();
        System.out.println(s[(n+8)%12]);
    }
}
/*
打印乘法表
输出10以内的乘法表，输入为1-20的整数，输出请参照输出样例。打印的时候，一个数占4位。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        for(int i=1;i<=n;++i)
        {
            for(int j=1;j<=n;++j)
                System.out.printf("%4d",i*j);
            System.out.println();
        }
    }
}
/*
三个整数排序
输入三个整数 ，然后从小到大的打印出来
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] a=new int[5];
        for(int i=0;i<3;++i)
            a[i]=input.nextInt();
        Arrays.sort(a,0,3);
        System.out.print(a[0]);
        for(int i=1;i<3;++i)
            System.out.print(" "+a[i]);
    }
}
/*
会文判断 
回文是指正读反读均相同的字符序列，如“abba”和“abdba”均是回文，但“good”不是回文。编写一个程序，判定给定的字符序列是否为回文。

*注：如果输入的不是字母或者数字，请过滤。

可以考虑使用StringBuilder来存储字符串，这样便于后续的处理。*
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s=input.nextLine();
        char c;
        int ans=1;
        for(int l=0,r=s.length()-1;l<r;)
        {
            c=s.charAt(l);
            while(l<r && !(c>='0' && c<='9' || c>='a' && c<='z' || c>='A' && c<='Z'))
            {
                ++l;
                c=s.charAt(l);
            }
            c=s.charAt(r);
            while(l<r && !(c>='0' && c<='9' || c>='a' && c<='z' || c>='A' && c<='Z'))
            {
                --r;
                c=s.charAt(r);
            }
            if(s.charAt(l)!=s.charAt(r))
            {
                ans=0;
                break;
            }
            ++l;
            --r;
        }
        if(ans>0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
/*
计算园面积
本题目要求园半径（整型），然后输出园面积s（保留小数点后两位）。圆周率请使用Java自己提供的Math.PI。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int r=input.nextInt();
        System.out.printf("%.2f",Math.PI*r*r);
    }
}
/*
闰年判断
本题目要求读入1个整数年份，范围在0到3000内，然后判断是否是否闰年。如果是闰年输出为“Yes”，否则为“No”
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        if(n%400==0 || n%100!=0 && n%4==0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
/*
数组元素的操作
本题目要求对一个20位长的数组进行操作，当输入一个0-19的整数时，把该位上的数据删除，然后依次把后面的数组中的数据依次前移，把最后一位填0。
*/
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        System.out.print("[");
        for(int i=0;i<20;++i)
        {
            if(i==n)
                continue;
            System.out.print(i+", ");
        }
        System.out.println("0]");
    }
}