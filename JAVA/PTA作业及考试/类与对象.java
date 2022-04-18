/*
计算长方体的表面积和体积
请完成相关代码，实现长方体的表面积和体积的计算
*/
class Cuboid
{
    double l,w,h;
    public Cuboid(double l,double w,double h)
    {
        this.l=l;
        this.w=w;
        this.h=h;
    }
    public double getArea()
    {
        return (l*w+l*h+w*h)*2;
    }
    public double getVolume()
    {
        return l*w*h;
    }
}
/*
数组工具
按照题目要求，实现int数组工具，打印，排序，求和，使得程序正常运行。
*/
class MyArrays
{
    static void printArray(int a[])
    {
        for(int i=0;i<a.length;++i)
            System.out.print(a[i]+",");
        System.out.println();
    }
    static void sortArray(int a[])
    {
        Arrays.sort(a);
    }
    static int sumOfArray(int a[])
    {
        int sum=0;
        for(int i:a)
            sum+=i;
        return sum;
    }
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
*/
class BMI
{
    String name;
    int age;
    double weight;
    double height;
    double BMI;
    public BMI(String name,int age,double weight,double height)
    {
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.height=height;
        this.BMI=(weight*0.45359237)/(height*0.0254*height*0.0254);
        this.BMI=Math.round(BMI*100)/100.0;
    }
    public String getName()
    {
        return name;
    }
    public double getBMI()
    {
        return BMI;
    }
    public String getStatus()
    {
        double sta=getBMI();
        if(sta<18.5)
            return "Underweight";
        else if(sta<25.0)
            return "Normal";
        else if (sta<30.0)
            return "Overweight";
        else
            return "Obese";
    }
}