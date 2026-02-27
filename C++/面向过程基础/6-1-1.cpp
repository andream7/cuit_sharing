#include <iostream>
#include <string>
/* 请在这里填写答案 */
/*std::string GetString();*/
    std::string GetString() {
        std::string input;
        std::getline(std::cin, input); // 读取一整行带空格的字符串
        return input;
    }
int main()
{
  std::string str;
str = GetString();
std::cout << str<< std::endl;
str = GetString();
std::cout << str<< std::endl;

  return 0;

}

