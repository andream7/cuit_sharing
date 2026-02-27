#include <iostream>
using namespace std; 
class Point {
 private:
 int x; int y;
public:
Point(int a, int b);
~Point();
void setX(int a){x = a;}
void setY(int b){y=b;}
int getX(){return x;}
int getY(){return y;}
//继续补全Point类中的operator<<输出运算符重载函数的声明，并以};结束。然后在类外定义operator<<输出运算符重载函数以及剩下的类成员函数实现。
/* 请在这里填写答案 */
friend ostream& operator<<(ostream& out, const Point& p);
};
ostream& operator<<(ostream& out, const Point& p) {
	out << "Point(" << p.x << "," << p.y << ")";
	return out;
}

Point::Point(int a, int b) : x(a), y(b) {}
Point::~Point() {}

int main()
{
Point pt(10, 20);
cout << pt.getX() << endl;
pt.setX(30);
pt.setY(40);
cout << pt ;
return 0;
}