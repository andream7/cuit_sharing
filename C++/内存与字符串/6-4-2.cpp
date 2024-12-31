#include <iostream>
#include <memory>

/* 请在下方填写答案*/
/*class A;
class B;*/
class B;

class A {
public:
    std::weak_ptr<B> spB;  // 弱智能指针，引用 B 对象

    void print() const {
        std::cout << "It is A" << std::endl;
    }

    ~A() {
        std::cout << "destruct A" << std::endl;
    }
};

class B {
public:
    std::weak_ptr<A> spA;  // 弱智能指针，引用 A 对象

    void print() const {
        std::cout << "It is B" << std::endl;
    }

    ~B() {
        std::cout << "destruct B" << std::endl;
    }
};
void Fun(std::shared_ptr<A> pA, std::shared_ptr<B> pB)
{
    pA->spB = pB;
    pB->spA = pA;
}

void Fun(std::shared_ptr<A> pA, std::shared_ptr<B> pB)
{
    pA->spB = pB;
    pB->spA = pA;
}

int main()
{
std::shared_ptr<A> pA = std::shared_ptr<A>(new A);
std::shared_ptr<B> pB = std::shared_ptr<B>(new B);
Fun(pA, pB);
pA->spB.lock()->print();
pB->spA.lock()->print();
return 0;
}
