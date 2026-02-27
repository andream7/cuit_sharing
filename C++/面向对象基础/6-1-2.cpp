//在这里给出函数被调用进行测试的例子。例如：
#include <iostream>
/* 请在这里填写答案 */
/*class Car;*/
class Car{
private:
    std::string name;
    int id;
    int price;
    int maxSpeed;
    std::string city;

public:
    // 默认构造函数
    Car() : name(""), id(0), price(0), maxSpeed(100), city("chengdu") {}

    // 带参数的构造函数
    Car(const std::string& name, int id, int price, const std::string& city)
        : name(name), id(id), price(price), maxSpeed(100), city(city) {}

    // 析构函数
    ~Car() {
        std::cout << "destruct car" << std::endl;
    }

    // 获取和设置成员变量的函数
    std::string getName() const { return name; }
    void setName(const std::string& name) { this->name = name; }

    int getID() const { return id; }
    void setID(int id) { this->id = id; }

    int getPrice() const { return price; }
    void setPrice(int price) { this->price = price; }

    int getMaxSpeed() const { return maxSpeed; }
    void setMaxSpeed(int maxSpeed) { this->maxSpeed = maxSpeed; }

    std::string getCity() const { return city; }
    void setCity(const std::string& city) { this->city = city; }
};
int main()
{
   std::string name;
int id;
int price;
int maxSpeed;
std::string city;
std::cin >> name >> id >> price >> city;
{
  Car c1(name,id, price, city);
std::cout << c1.getName() << " " << c1.getID()<<" " << c1.getPrice()<<" " << c1.getCity() <<" " << c1.getMaxSpeed() << std::endl;
  Car c2;
   c2.setName("dazhong");
    c2.setPrice(20);
c2.setMaxSpeed(200);
std::cout << c2.getName() <<" " <<c2.getID()<<" " << c2.getPrice()<<" " << c2.getCity() <<" " << c2.getMaxSpeed() << std::endl;
c2.setCity("beijing");
std::cout << c2.getName() <<" " << c2.getID()<<" " << c2.getPrice()<<" " << c2.getCity() <<" " << c2.getMaxSpeed() << std::endl;
}
  return 0;
}

