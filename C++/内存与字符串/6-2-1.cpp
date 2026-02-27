//在这里给出函数被调用进行测试的例子。例如：
#include <iostream>
/* 请在下方填写答案*/
///*void Fun(/*函数指针1*/ /*函数指针2*/, int a, int b);
/*int add(int a, int b);
int sub(int a, int b);*/
typedef int (*FuncPtr)(int, int);

// 加法函数
int add(int a, int b) {
    return a + b;
}

// 减法函数
int sub(int a, int b) {
    return a - b;
}

// Fun 函数，接受两个函数指针和两个 int 数据
void Fun(FuncPtr func1, FuncPtr func2, int a, int b) {
    std::cout << func1(a, b) << std::endl; // 调用加法函数并打印结果
    std::cout << func2(a, b) << std::endl; // 调用减法函数并打印结果
}
int main()
{
int a,b;
std::cin >> a>> b;
///*函数指针1类型，题干隐藏*/ funptr1 =add;
///*函数指针2类型，题干隐藏*/ funptr2 = sub;
//  Fun(funptr1, funptr2, a, b);
  return 0;
}
