//在这里给出函数被调用进行测试的例子。例如：
#include <iostream>
/* 请在下方填写答案*/
class A {
private:
    int data;

public:
    // 默认构造函数
    A() : data(0) {}

    // 带参数的构造函数
    A(int data) : data(data) {}

    // 获取成员变量的函数
    int getData() const { return data; }

    // 打印成员变量的函数
    void print() const {
        std::cout << data << std::endl;
    }
    void print() {
        std::cout<< "nonconst " << data << std::endl;
    }

    // 友元函数声明
    friend A Add(const A& a, const A& b);
};

// 求和函数定义
A Add(const A& a, const A& b) {
    return A(a.data + b.data);
}


int main()
{
int data1, data2;
std::cin >> data1 >> data2;
  const A a(data1);
a.print();
A b(data2);
A res = Add(a,b);
res.print();
  return 0;
}
