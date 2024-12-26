#include <iostream>
#include <memory>
/* 请在下方填写答案*/
/*class Gun;
class Rifle;*/
class Gun {
public:
    int range;
    int att;

    Gun(int a, int r) : att(a), range(r) {}

    virtual bool fire(int hp, int dist) {
            std::cout << "Gun!" << std::endl;
            return false;
    }
};

class Rifle : public Gun {
public:
    Rifle(int a, int r) : Gun(a, r) {}

    bool fire(int hp, int dist) override {
        if (dist < range && att >= hp) {
            std::cout << "Rifle!" << std::endl;
            return true;
        }
        return false;
    }
};
bool Fire(Gun *g, int hp, int dist){
    return g->fire(hp, dist);
}
int main()
{
   int att1, range1, att2, range2, hp, dist;
std::cin >> att1>> range1>> att2 >> range2>>hp>>dist;
Gun *g = new Gun(att1, range1);
std::cout << Fire(g, hp, dist) << std::endl;
Gun *r = new Rifle(att2, range2);
std::cout << Fire(r, hp, dist) << std::endl;
  return 0;
}
