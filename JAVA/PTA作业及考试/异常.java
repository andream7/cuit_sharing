/*
异常：圆半径不能为负数 
计算圆的面积，其中PAI取3.14，圆半径为负数时应抛出异常，输出相应提示。
在这里给出函数被调用进行测试的例子。例如：
import java.util.Scanner;
public class Main {
       public static void main(String args[ ]) {
           double s=0;
           Scanner sr=new Scanner(System.in);
           double r=sr.nextDouble();
           sr.close();
           try{
               Circle c1=new Circle(r);       
               s = c1.area();
               System.out.printf("%.1f",s);
           }
           catch (NumRangeException e){
               e.print();
           }
        }
    }

/* 请在这里填写答案 *
*/
class Circle
{
    double r;
    public Circle(double r)
    {
        this.r=r;
    }
    public double area()throws NumRangeException
    {
        if(r<0)
        {
            throw new NumRangeException(r);
        }
        return r*r*3.14;
    }
}
class NumRangeException extends Exception
{
    double r;
    public NumRangeException(double r)
    {
        this.r=r;
    }
    public void print()
    {
        System.out.println("错误:圆半径"+r+"为负数");
    }
}
/*
异常：物品安全检查
车站检查危险品的设备，如果发现危险品会发出警告。编程模拟设备发现危险品的情况。编程要求如下：

通过继承Exception类，编写一个DangerException类。
a) 该异常类有构造方法，该构造方法使用super调用父类构造方法，使用字符串：“属于危险品！”，对父类变量detailMessage进行初始化。
编写商品类：Goods，该类包含以下成员：
a) 私有的name属性(String类型)，表示商品名称。
b) 私有的isDanger属性(boolean型)，表示商品是否为危险品，如果为危险品，则值为true，否则为fales。
c) 分别为两个私有变量编写set和get方法
编写一个Machine类，该类的方法checkBag(Goods goods)。当发现参数goods是危险品时，即：goods的isDanger属性为true时，该方法抛出DangerException异常的对象。
编写主类Check，在其main方法中创建创建商品对象，并使用Machine对象检查商品。
public class Main {
       public static void main(String args[]) {          
          String[] name ={"苹果","炸药","西服","硫酸","手表","硫磺"};                  
          Goods[] goods = new Goods[name.length];                  
          for(int i= 0;i<name.length;i++) {
             goods[i] = new Goods();
             if(i%2==0) {
                goods[i].setDanger(false);
                goods[i].setName(name[i]);
             }
             else {
                goods[i].setDanger(true);
                goods[i].setName(name[i]);
             } 
          }          
          Machine machine = new Machine();
          for(int i= 0;i<goods.length;i++) {
              System.out.print(goods[i].getName());
              try { 
                  machine.checkBag(goods[i]);
                  System.out.println("，检查通过\n");
              }catch(DangerException e) {
                  System.out.println(e.getMessage());
                  System.out.println(goods[i].getName()+"，被禁止!\n"); 
              }
          }     
       } 
}

/* 请在这里填写答案 *
*/
class DangerException extends Exception
{
    DangerException()
    {
        super("属于危险品!");
    }
}
class Goods
{
    private String name;
    private boolean isDanger;
    void setName(String name)
    {
        this.name=name;
    }
    void setDanger(boolean isDanger)
    {
        this.isDanger=isDanger;
    }
    boolean getDanger()
    {
        return isDanger;
    }
    String getName()
    {
        return name;
    }
}
class Machine
{
    void checkBag(Goods goods)throws DangerException
    {
        if(goods.getDanger()==true)
            throw new DangerException();
    }
}