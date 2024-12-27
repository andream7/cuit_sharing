//在这里给出函数被调用进行测试的例子。例如：
#include <iostream>
/* 请在这里填写答案 */
/*class Counter{};*/
class Counter{
    public:
    static int count;

    Counter() { count++;}

    ~Counter() { count--;}

    static int getCount() {
        return count;
    }
};
// 静态成员变量的初始化
int Counter::count = 0;
int main()
{
  Counter c1;
Counter c2;
std::cout << Counter::count << std::endl;
{
Counter c3;
std::cout << Counter::count << std::endl;
}
std::cout << Counter::count << std::endl;
  return 0;
}
