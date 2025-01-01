//在这里给出函数被调用进行测试的例子。例如：
#include <iostream>
class Vec{
private:
int x,y;
public:
/* 请在这里填写答案，注意上述类定义部分已经放在后台，所以只需要继续编写完这个类的public部分 */

/*Vec Add(Vec& arg1, Vec& arg2){*/
/* 注意上上述声明没有放在后台，学生需要自行声明该函数，请在这里填写答案 */
// 默认构造函数
    Vec() : x(0), y(0) {}

    // 带参数的构造函数
    Vec(int x, int y) : x(x), y(y) {}

    // 获取成员变量的函数
    int getX() const { return x; }
    int getY() const { return y; }

    // 友元函数声明
    friend Vec Add(const Vec& arg1, const Vec& arg2);
};

// 友元函数定义
Vec Add(const Vec& arg1, const Vec& arg2) {
    return Vec(arg1.x + arg2.x, arg1.y + arg2.y);
}



int main()
{
int x1, x2,y1,y2;
std::cin >> x1>> y1 >> x2>>y2;
  Vec v1(x1,y1);
 Vec v2(x2,y2);
Vec v3 = Add(v1,v2);
std::cout << v3.getX() << std::endl;
std::cout << v3.getY() << std::endl;
  return 0;
}
