#include <iostream>
/* 请在这里填写答案 */
/*int Fun(int n);*/

int Fun(int n) {
    // 使用一个变量来计算阶乘
    int fact = 1; 

    // 从 2! 开始计算，直到 n!
    for (int i = 2; i <= n; ++i) {
        fact *= i;  // 逐步计算阶乘
        std::cout << fact << std::endl;  // 输出当前阶乘结果
    }

    return 0;  // 返回 0 表示函数执行结束
}
int main()
{
  int n;
std::cin >> n;
  Fun(n);
  return 0;
}

