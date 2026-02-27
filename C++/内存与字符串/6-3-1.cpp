#include <iostream>
/* 请在下方填写答案*/
/*class Array;*/
class Array{

    public:
    int* ptr;  // 指向数组的指针
    int sz;    // 数组长度

    // 默认构造函数
    Array() : ptr(nullptr), sz(0) {}

    // 带参数的构造函数
    Array(int value, int size) : sz(size) {
        ptr = new int[size];
        for (int i = 0; i < size; ++i) {
            ptr[i] = value;
        }
    }

    // 析构函数
    ~Array() {
        delete[] ptr;
        std::cout << "destruct array" << std::endl;
    }

    // 设置数组大小
    void setSize(int size) {
        if (ptr != nullptr) {
            delete[] ptr;
        }
        sz = size;
        ptr = new int[size];
    }

    // 设置数组元素的值
    void setValue(int index, int value) {
        if (index >= 0 && index < sz) {
            ptr[index] = value;
        }
    }
};
int main()
{
int val,sz;
std::cin >> val>> sz;
Array arr1(val, sz);
std::cout << arr1.ptr[sz-1] << std::endl;
Array arr2;
arr2.setSize(sz+1);
arr2.setValue(sz,5);
std::cout << arr2.ptr[sz] << std::endl;
  return 0;
}
