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
class ThreadTest extends Thread{
    int n;
        ThreadTest(int n){
        this.n=n;
    }
    public void run(){
    for(int i=1;i<=n;i++){
        System.out.print(i+" ");
    }
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
class MyThread implements Runnable{
    int n;
    MyThread(int n){
        this.n=n;
    }
    public void run(){
                    for(int i=1;i<=n;i++){
                        System.out.print(i+" ");
                    }
    }
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