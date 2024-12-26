#include <iostream>
#include <algorithm>
#include <numeric>
/* 请在这里填写答案 */
/*void Fun(/* 自行填写*/

void Fun2(int n){
    std::cout << n/2 <<std::endl;
}
void Fun2(double n){
    std::cout << n/2 <<std::endl;
    
}
void Fun1(){
    std::string str;
    std::cin >> str;
    double d;
    int i;
    std::cin >> d;
    i = (int)d;
    if(str == "int")
    Fun2(i);
    else Fun2(d);
}
int main()
{
  Fun1();
  return 0;
}

