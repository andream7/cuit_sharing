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

/* 请在这里填写答案 *
*/
class Student implements Comparable
{
    String name;
    int score;
    public Student(String name,int score)
    {
        this.name=name;
        this.score=score;
    }
    public int compareTo(Student student)
    {
        return this.score- student.score;
    }
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
    public Triangle(double a,double b)
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
        return (a+b+Math.sqrt(a*a+b*b));
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
    public void setN(int n)
    {
        this.n=n;
    }
    public void printCapitalLetter()
    {
        if(n!=0)
        {
            n%=26;
            if(n==0)
                n=26;
        }
        for(int i=0;i<n;++i)
            System.out.print((char)('A'+i));
        System.out.println();
    }
    public void printLowercaseLetter(int n)
    {
        if(n!=0)
        {
            n%=26;
            if(n==0)
                n=26;
        }
        for(int i=0;i<n;++i)
            System.out.print((char)('a'+i));
        System.out.println();
    }
}
/*
会文判断
回文是指正读反读均相同的字符序列，如“abba”和“abdba”均是回文，但“good”不是回文。编写一个程序，判定给定的字符序列是否为回文。

*注：如果输入的不是字母或者数字，请过滤。

可以考虑使用StringBuilder来存储字符串，这样便于后续的处理。*
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
                Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int ans=1,l=0,r=s.length()-1;
        while(!(s.charAt(l)>='a' && s.charAt(l)<='z' || s.charAt(l)>='A' && s.charAt(l)<='Z' || s.charAt(l)>='0' && s.charAt(l)<='9'))
            ++l;
        while(!(s.charAt(r)>='a' && s.charAt(r)<='z' || s.charAt(r)>='A' && s.charAt(r)<='Z' || s.charAt(r)>='0' && s.charAt(r)<='9'))
            --r;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
            {
                ans=0;
                break;
            }
            ++l;
            while(!(s.charAt(l)>='a' && s.charAt(l)<='z' || s.charAt(l)>='A' && s.charAt(l)<='Z' || s.charAt(l)>='0' && s.charAt(l)<='9') && l<r)
                ++l;
            --r;
            while(!(s.charAt(r)>='a' && s.charAt(r)<='z' || s.charAt(r)>='A' && s.charAt(r)<='Z' || s.charAt(r)>='0' && s.charAt(r)<='9') && l<r)
                --r;
        }
        if(ans>0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}