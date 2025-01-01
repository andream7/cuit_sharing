//在这里给出函数被调用进行测试的例子。例如：
#include <iostream>
/* 请在下方填写答案*/
/*class Mat3x4;*/
class Mat3x4{
    private:
int data[3][4];
    public:
    Mat3x4(int value) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 4; ++j) {
                data[i][j] = value;
            }
        }
    }
    Mat3x4() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 4; ++j) {
                data[i][j] = 0;
            }
        }
    }

    // 设置所有元素为指定的值
    void setValue(int value) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 4; ++j) {
                data[i][j] = value;
            }
        }
    }
    void setValue(int value,int i,int j) {
        data[i][j] = value;
    }
    int get(int i,int j){
        return data[i][j];
    }
    
};

int main()
{
int data1, data2;
std::cin >> data1 >> data2;
  Mat3x4 m1(data1); //全部初始化为data1数值
std::cout << m1.get(2,3) << std::endl;
Mat3x4 m2;
m2.setValue(data2);
m2.setValue(m2.get(2,3)+5, 2,3);//把（1,1）元素赋值
std::cout << m2.get(2,3) << std::endl;
  return 0;
}
