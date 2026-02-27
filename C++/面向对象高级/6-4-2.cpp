#include <iostream>
#include <memory>
/* 请在下方填写答案*/
/*class Oct;*/
class Vec {
public:
    int* ptr; // 一维数组指针
    int sz;   // 数组长度

    // 构造函数
    Vec(int size) : sz(size), ptr(new int[size]) {
        for (int i = 0; i < sz; ++i) {
            ptr[i] = i + 1; // 设置默认值为 1, 2, 3, ...
        }
    }

    // 禁止拷贝构造函数和赋值运算符，防止复制智能指针
    Vec(const Vec&) = delete;
    Vec& operator=(const Vec&) = delete;

    // 允许移动构造函数和赋值运算符，以支持移动语义
    Vec(Vec&& other) : ptr(std::move(other.ptr)), sz(other.sz) {
        other.sz = 0;
        other.ptr = nullptr;
    }
    Vec& operator=(Vec&& other) {
        if (this != &other) {
            delete[] ptr; // 释放当前资源
            ptr = std::move(other.ptr);
            sz = other.sz;
            other.sz = 0;
            other.ptr = nullptr;
        }
        return *this;
    }

    // 析构函数
    ~Vec() {
        delete[] ptr; // 释放动态分配的内存
    }

    // 友元函数，重载输出运算符
    friend std::ostream& operator<<(std::ostream& os, const Vec& v) {
        for (int i = 0; i < v.sz; ++i) {
            os << v.ptr[i];
            if (i < v.sz - 1) os << " ";
        }
        return os;
    }
};
int main()
{
int sz;
std::cin >> sz;
Vec v(sz);
std::cout << v;
  return 0;
}
