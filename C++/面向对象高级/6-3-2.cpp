#include <iostream>
#include <memory>
/* 请在下方填写答案*/
/*class Vec;*/
class Vec {
public:
    int x, y;
    Vec(int x = 0, int y = 0) : x(x), y(y) {}
    Vec operator+(const Vec& other) const {
        return Vec(x + other.x, y + other.y);
    }
    int operator*(const Vec& other) const {
        return x * other.x + y * other.y;
    }
    int getX() const {
        return x;
    }
    int getY() const {
        return y;
    }
};
int main()
{
int x1, y1, x2,y2;
std::cin >> x1>> y1>>x2>>y2;
Vec v1(x1,y1);
Vec v2(x2,y2);
Vec v3 = v1+v2;
int res = v1*v2;
std::cout << v3.getX() << std::endl;
std::cout << res << std::endl;
  return 0;
}
