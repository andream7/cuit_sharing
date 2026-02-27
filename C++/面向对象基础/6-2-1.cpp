//在这里给出函数被调用进行测试的例子。例如：
#include <iostream>
/* 请在这里填写答案 */
/*class Point;
class Line;*/
class Point {
private:
    int x;
    int y;

public:
    // 默认构造函数
    Point() : x(0), y(0) {}

    // 带参数的构造函数
    Point(int x, int y) : x(x), y(y) {}

    // 获取和设置成员变量的函数
    int getX() const { return x; }
    void setX(int x) { this->x = x; }

    int getY() const { return y; }
    void setY(int y) { this->y = y; }
};

// Line 类定义
class Line {
private:
    Point point1;
    Point point2;

public:
    // 默认构造函数
    Line() : point1(0, 0), point2(0, 0) {}

    // 带参数的构造函数
    Line(int x1, int y1, int x2, int y2) : point1(x1, y1), point2(x2, y2) {}

    // 获取和设置成员变量的函数
    Point getPoint1() const { return point1; }
    void setPoint1(int x, int y) { point1.setX(x); point1.setY(y); }

    Point getPoint2() const { return point2; }
    void setPoint2(int x, int y) { point2.setX(x); point2.setY(y); }
};
int main()
{
int x1,x2,y1,y2;
std::cin >> x1>> y1 >> x2>> y2;

Line line1(x1,y1,x2,y2);
std::cout << line1.getPoint1().getX() << std::endl;
std::cout << line1.getPoint2().getY() << std::endl;

Line line2;
line2.setPoint1(x1,y1);
line2.setPoint2(x2,y2);
std::cout << line2.getPoint1().getX() << std::endl;
std::cout << line2.getPoint2().getY() << std::endl;
  
  return 0;
}

