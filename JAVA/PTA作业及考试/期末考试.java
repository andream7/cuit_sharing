/*
使用预处理语句不仅可以减轻了数据库压力，而且也提高了访问数据库的速度。
T
JDBC-ODBC桥接器是目前主流的数据库连接方式。
F
数据库查询的结果存放在一个PreparedStatement类声明的对象中。
F
Java的回收机制会自动关闭数据库连接，所以程序员不用主动断开数据库。
F
JDBC中连接数据库的三要素是URL，用户名，密码。
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
*/
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
        /*-------------*
    }
}
*/
Main a=new Main(true);
/*
使用递归实现阶乘的计算
public class Main {
    public static void main(String[] args) {
        int n = 20;
        System.out.print(Factorial(n));
    }
public static long Factorial(int n) 
    {
        if(n == 0)
/*--------------*
        else
/*-------------*
    }
}
*/
return 1;
return n*Factorial(n-1);
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
class Cuboid{
    double l,w,h;
    Cuboid(double l,double w,double h){
        this.l=l;
        this.w=w;
        this.h=h;
    }
    double getArea(){
        return (l*w+l*h+w*h)*2;
    }
    double getVolume(){
        return l*w*h;
    }
}
/*
请按照要求实现接口（直角三角形）
创建一个直角三角形类Triangle类，实现下列接口Ishape。两条直角边长作为Triangle类的私有成员，类中包含参数为直角边的构造方法。注意本题需要用到Math.sqrt（）方法。
import java.text.DecimalFormat;
import java.util.Scanner;
interface Ishape {
    public abstract double getArea();
    public abstract double getPerimeter();
}
/*你写的代码将嵌入到这里*
public class Main {
    public static void main(String[] args) {
        DecimalFormat d = new DecimalFormat("#.####");
        double x,y;
        Scanner input=new Scanner(System.in);
        x=input.nextDouble();
        y = input.nextDouble();
        Ishape r = new Triangle(x, y);
        System.out.println(d.format(r.getArea()));
        System.out.println(d.format(r.getPerimeter()));
    }
}
*/
class Triangle implements Ishape{
    double x,y;
    Triangle(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double getArea(){
        return x*y/2;
    }
    public double getPerimeter(){
        return x+y+Math.sqrt(x*x+y*y);
    }
}
/*
输入平时成绩异常
从键盘输入一名同学的期终平时成绩，按照学校规定，如果成绩高于100和低于60则视为异常（低于60分没有资格参加期末考试）。需要用自定义异常来实现。当输入正常成绩的时候，则把成绩打印出来；如果输入是大于100或者小于0的数，则输出“illegal input”；如果输入是大于等于0且小于60，则输出“not qualified”。
在这里给出函数被调用进行测试的例子。例如：
import java.util.Scanner;
public class Main {
   public static void main(String args[]) {
      Score wang=new Score();
      int n;
      Scanner input=new Scanner(System.in);
      n=input.nextInt();
      input.close();
      try{  wang.setFinalscore(n);
            System.out.println(wang.getFinalscore());
      }
      catch(IntegerException e) {
            System.out.println(e.toString());
      }
    }
}
class Score {
    private int finalscore;
    public void setFinalscore(int finalscore) throws IntegerException {
        if(finalscore>100||finalscore<60) {
            throw new IntegerException(finalscore); //方法抛出异常，导致方法结束
        }
        else {
            this.finalscore=finalscore;
        }
     }  
     public int getFinalscore() {
        return finalscore;
     }
 }
/* 请在这里填写答案 *
*/
class IntegerException extends Exception{
    int score;
    IntegerException(int score)
    {
       this.score=score;
    }
    public String toString()
    {
        String a="";
        if(score>100 || score<0)
            a="illegal input";
        else if(score>=0 && score<60)
            a="not qualified";
        return a;
    }
}
/*
约瑟夫环（集合）
约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3，1。由于在Java语言中，使用链表来实现非常简单。请完成代码，实现相应输出。
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
    list.push(i);
while(list.size()>1)
{
    for(int i=1;i<b;++i)
    {
        list.push(list.getLast());
        list.pollLast();
    }
    System.out.print(list.getLast()+" ");
    list.pollLast();
}
/*
多线程编程：使用多线程同步与通信，模拟实现售票系统的售票和退票过程
使用synchronized实现同步控制，并使用wait()和notify()实现线程之间的通信。
编程要求如下：
可售出票的数量为一个固定值(total)，从键盘读入。
当余票的数量足够出售时(余票数量大于客户购买票数)，则先售票；如果没有余票了(票数为0)或余票数量不够了(余票数量小于客户购买票数)，则需要等待退票。退票后，如果余票足够出售，则又开始售票。
退票规则：有票被售出，才能退票。如果退票数大于已售票总数，也只能退回已售出票的实际数量。比如：已售出3张票，第一次退回了2张票，第2次就只能退1张票了。
售票线程正在售票的时候不能退票，反之亦然。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        //System.out.println("请输入票数：");        
        int num=sc.nextInt();        //从键盘读入总票数          
         Ticket tickets = new Ticket(num);    //产生票
        new Thread(new sellTicketThread(tickets)).start();//sellTicketThread售票
        new Thread(new returnTicketThread(tickets)).start();//returnTicketThread退票
        Thread.sleep(50);    //休眠等待售票和退票执行完毕
        System.out.println(tickets.freeNum);
    }
}
class Ticket {
    int total;        //总票数
    int freeNum;    //多线程共享变量：余票数量    
    int soldNum;    //已售出票数
    boolean hasTicket;    //true表示有足够的票出售，false则表示票数不够    
    int count=3;    //线程售票退票次数
    int sellNum=3;    //单次售票数量
    int returnNum=2;    //单次退票数量    
    public Ticket(int number){            
        total = number;
        freeNum = total;    //售票前：总数与余票数相等
        soldNum=0;            //已售出票数
        hasTicket=(freeNum>=sellNum);    //余票足够
    }
//在下面补充Ticket类的synchronized售票方法
//在下面补充Ticket类的synchronized退票方法，并将Ticket类补充完整
 //在下面补充SellTicketThread类，通过实现Runnable实现SellTicketThread类
//在下面补充ReturnTicketThread类，通过实现Runnable实现ReturnTicketThread类
*/
    public synchronized  void sellTicket(int num)
    {
        if (!hasTicket){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        freeNum -= num;
        System.out.println("售出" + num + "余票" + freeNum);
        hasTicket = (freeNum>=sellNum);
        notify();
    }
    public synchronized void returnTicket(int num){
        if (hasTicket){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        freeNum += num;
        System.out.println("退回"  + num +"余票" + freeNum);
        hasTicket = (freeNum>=sellNum);
        notify();
    }
}
class sellTicketThread implements Runnable{
    Ticket ticket;

    public sellTicketThread(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            ticket.sellTicket(3);
        }
    }

}
class returnTicketThread implements Runnable{
    Ticket ticket;

    public returnTicketThread(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            ticket.returnTicket(2);
        }
    }
}
/*
三个整数排序
输入三个整数 ，然后从小到大的打印出来
*/
import java.*;
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int a,b,c,temp;
        a=in.nextInt();
        b=in.nextInt();
        c=in.nextInt();
        if(a>b)
        {
            temp=a;
            a=b;
            b=temp;
        }
        if(b>c)
        {
            temp=b;
            b=c;
            c=temp;
        }
        if(a>b)
        {
            temp=a;
            a=b;
            b=temp;
        }
        System.out.print(a+" "+b+" "+c);
          
    }
}