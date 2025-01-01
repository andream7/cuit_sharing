#include <iostream>
#include <string>
#include <sstream>
void Fun(const std::string& str) {
    std::stringstream ss(str);
    std::string segment;

    while (std::getline(ss, segment, ',')) {
        std::cout << segment << std::endl;
    }
}
int main()
{
std::string str;
std::cin >> str;
Fun(str);
return 0;
}
