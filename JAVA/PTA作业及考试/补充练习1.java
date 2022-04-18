/*
在运行字节码文件时，使用java命令，一定要给出字节码文件的扩展名.class。
F
浮点型数据的默认类型为float类型。
F
调用默认构造方法创建类的对象时，对象成员变量将获取默认值。
T
非静态方法中不能引用静态变量。
F
Java数据的隐含转换由系统自动进行，在计算机中占内存位（bit）数少的类型向占位数多的类型转换。
T
编写一个Java Application程序，其中类声明为public class StringDemo{…}, 那么该程序一个以什么文件名保存？( )
StringDemo.java
下列哪个选项是合法的标识符？（ ）
_name
以下选项中变量均已正确定义，合法的赋值语句是（ ）
++ i
设a, f, x, y, z 均为int型的变量，并已赋值，下列表达式的结果不是逻辑值的是（ ）
y + x * x++
下列关于Java常量的描述中，错误的是( )。
定义符号常量使用关键字const
为AB类的一个无形式参数、无返回值的方法method书写方法头，使得使用类名AB作为前缀就可以调用它，该方法头的形式为( )。
static void method( )
在Java语言中，对于构造方法，下列叙述正确的是( )。
如果类中定义了构造方法，系统就不再提供默认构造方法
System．out．print(12 + 3 + “4”)的在屏幕上的输出结果是( ) 。
154
*/
/*
使用二维数组实现Matrix(矩阵)
1. 定义Matrix(矩阵)类，要求如下：   
   a) 变量：matrix(int型二维数组)，row(行数)，column(列数)；   
   b) 方法：实现两个矩阵的乘法，所有方法将返回操作后的结果矩阵。(两个矩阵的乘法：一个m×n的矩阵a（m,n)乘一个n×p的矩阵b（n,p)，会得到一个m×p的矩阵c（m,p)。矩阵的行数和列数自定。）   
   c) 定义构造方法。     
     
2. 编写主类，测试Matrix类。包括：构建对象，测试每一个方法，并将测试结果输出到屏幕上。
*/
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int [][]m1=new int[r][c];
        for(int i=0;i<r;++i)
        {
            for (int j = 0; j < c; ++j)
                m1[i][j] = sc.nextInt();
        }
        Matrix mat1=new Matrix(m1,r,c);
        r=sc.nextInt();
        c=sc.nextInt();
        int [][]m2=new int[r][c];
        for(int i=0;i<r;++i)
        {
            for (int j = 0; j < c; ++j)
                m2[i][j] = sc.nextInt();
        }
        Matrix mat2=new Matrix(m2,r,c);
        Matrix.multiplication(mat1,mat2);
    }
    public static class Matrix
    {
        int row;
        int column;
        int[][] m;
        public Matrix(int [][] m,int r,int c)
        {
            this.row=r;
            this.column=c;
            this.m=m;
        }
        public static void multiplication(Matrix m1,Matrix m2)
        {
            Matrix m3=new Matrix(new int[m1.row][m2.column],m1.row,m2.column);
            for(int i=0;i<m1.row;++i)
            {
                for(int j=0;j<m2.column;++j)
                {
                    for(int k=0;k<m1.column;++k)
                        m3.m[i][j]+=m1.m[i][k]*m2.m[k][j];
                }
            }
            for(int i=0;i<m3.row;++i)
            {
                for(int j=0;j<m3.column;++j)
                    System.out.print(m3.m[i][j]+" ");
                System.out.println();
            }
        }
    }
}