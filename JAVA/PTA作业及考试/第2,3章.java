/*
冒泡算法
冒泡排序是最简单的排序之一，通过与相邻元素的比较和交换来把小的数交换到最前面。请完成实现swap方法，来完成冒泡算法
*/
public static void swap(int[] arr,int pre,int next){
    int temp=arr[pre];
    arr[pre]=arr[next];
    arr[next]=temp;
}
/*
计算π的值
在数学中，我们可以通过π=4╳(1-1/3+1/5-1/7+1/9-......1/(2╳n+1)) 来计算，n越大，计算值越靠近。输入正整数n来计算π。
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int x=reader.nextInt();
        double ans=0;
        for(int i=0;i<x;++i)
        {
            if(i%2==1)
                ans-=1.0/(2*i+1);
            else
                ans+=1.0/(2*i+1);
        }
        System.out.println(4.0f*ans);
    }
}
/*
求圆柱的面积和体积
输入圆柱的底面半径r和高l（double类型），输出圆柱的底面积和体积（double类型）。注意：计算中的π来自于Math。
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        double r=reader.nextDouble();
        double l=reader.nextDouble();
        System.out.println("The area is "+r*r*Math.PI);
        System.out.println("The volume is "+r*r*Math.PI*l);
    }
}
/*
判断奇偶
输入一个整数，判断其奇偶性
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int x=reader.nextInt();
        if(x%2==1)
            System.out.println(x+" is odd.");
        else
            System.out.println(x+" is even.");
    }
}
/*
华氏度转摄氏度
本题要求编写程序，计算华氏温度对应的摄氏温度。计算公式：C=5×(F−32)/9，式中：C表示摄氏温度，F表示华氏温度，输出数据要求为取整（舍去小数部分）后整型。
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int x=reader.nextInt();
        System.out.println(5*(x-32)/9);
    }
}
/*
华氏度转摄氏度（四舍五入）
本题要求编写程序，计算华氏温度对应的摄氏温度。计算公式：C=5×(F−32)/9，式中：C表示摄氏温度，F表示华氏温度，输出数据要求为四舍五入取整后整型。
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        double x=reader.nextDouble();
        System.out.println(Math.round(5*(x-32)/9));
    }
}
/*
中国生肖年
输入一个年份，输出该年的生肖属相。注：十二生肖为鼠、牛、虎、兔、龙、蛇、马、羊、猴、鸡、狗、猪。
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int x=reader.nextInt();
        x=x%12;
        char sx[]={'鼠','牛','虎','兔','龙','蛇','马','羊','猴','鸡','狗','猪'};
        System.out.println(sx[(x+8)%12]);
    }
}
/*
打印乘法表
输出10以内的乘法表，输入为1-20的整数，输出请参照输出样例。打印的时候，一个数占4位。
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int x=reader.nextInt();
        for(int i=1;i<=x;++i)
        {
            for(int j=1;j<=x;++j)
                System.out.printf("%4d",i*j);
            System.out.println("");
        }
    }
}