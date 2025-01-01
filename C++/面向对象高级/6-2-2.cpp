#include <iostream>
#include <string>
class Base {
public:
    Base(const std::string &n){name = n;}
    ~Base(){}
    std::string getFun1();
    void setFun1(const std::string&);
protected:
std::string getFun2();
    void setFun2(const std::string&);
private:
    std::string name;
};
class Derived :protected Base {
public:
    Derived(const std::string &n);
    ~Derived(){}
    std::string getName();
    void setName(const std::string&);
};
/* 请在下方填写答案*/
/*补全类成员函数*/
std::string Base::getFun1() {
    return name;
}

void Base::setFun1(const std::string& n) {
    name = n;
}

std::string Base::getFun2() {
    return name;
}

void Base::setFun2(const std::string& n) {
    name = n;
}
Derived::Derived(const std::string& n) : Base(n) {}

std::string Derived::getName() {
    return Base::getFun1();
}

void Derived::setName(const std::string& n) {
    Base::setFun1(n);
}
int main()
{
        std::string name;
    std::cin >> name ;
    Derived d(name);
        d.setName(name);
    std::cout << d.getName() << std::endl;
      
    return 0;
}
