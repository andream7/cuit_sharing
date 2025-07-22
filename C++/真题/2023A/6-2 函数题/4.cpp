#include <iostream>
#include <memory>
/* 请在下方填写答案*/
/*class Pet;
class Dog;
class Cat
*/
class Pet {
  protected:
      std::string name;
  public:
      Pet(const std::string& n) :name(n) {}
      virtual ~Pet() {}
      virtual void playWith(Pet* other) = 0;
      const std::string& getName() const { return name; }
  };
  
  class Dog :public Pet {
  public:
      Dog(const std::string& name) : Pet(name) {}
      void playWith(Pet* other) override {
          std::cout << "Dog " << name << " play with " << other->getName() << std::endl;
      }
  };
  
  class Cat :public Pet {
  public:
      Cat(const std::string& name) : Pet(name) {}
      void playWith(Pet* other) override {
          std::cout << "Cat " << name << " play with " << other->getName() << std::endl;
      }
  };
  
int main()
{
std::string name1, name2;
std::cin >> name1 >> name2;
Pet *cp = new Cat(name1);
Pet *dp = new Dog(name2);
cp->playWith(dp);
cp->playWith(cp);
dp->playWith(cp);
  return 0;
}