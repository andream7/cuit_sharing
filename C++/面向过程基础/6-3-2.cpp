#include <iostream>
/* 请在这里填写答案 */
/*void Foo();*/

void Foo() {
    char c;
    std::cin >> c;  // 输入字符
    c = std::tolower(c);  // 将字符转换为小写

    // 使用switch语句来判断字符
    switch(c) {
        case 'a':
            std::cout << "great" << std::endl;
            break;
        case 'b':
            std::cout << "good" << std::endl;
            break;
        case 'c':
            std::cout << "pass" << std::endl;
            break;
        case 'd':
            std::cout << "fail" << std::endl;
            break;
        default:
            // 如果输入的字符不是 'a'、'b'、'c'、'd'，不输出任何内容
            break;
    }
}

int main()
{
  Foo();
  return 0;
}

