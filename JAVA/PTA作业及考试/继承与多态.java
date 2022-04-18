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
        /*------这里填空------*
    }
}
*/
Main a = new Main(true);
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
    
    /** 你提交的代码将被嵌在这里（替换此行） **
    
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
    double p;
    public Circle(double p) {
        this.p = p;
    }
    public double getArea(){
        return p*p*Math.PI;
    }
}
class Rec extends Shape{
    double a,b;
    public Rec(double c,double d)
    {
        a=c;
        b=d;
    }
    public double getArea(){
        return a*b;
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
class Cuboid{
    double l,w,h;
    public Cuboid(double l,double w,double h){
        this.l=l;
        this.w=w;
        this.h=h;
    }
    public double getArea(){
        return (l*w+w*h+l*h)*2;
    }
    public double getVolume(){
        return l*w*h;
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
class MyArrays{
    static void printArray(int a[]){
        for(int i=0;i<a.length;++i)
            System.out.print(a[i]+",");
        System.out.println();
    }
     static void sortArray(int a[]){
        Arrays.sort(a);
    }
    static int sumOfArray(int a[]){
        int sum=0;
        for(int i:a)
            sum+=i;
        return sum;
    }
}