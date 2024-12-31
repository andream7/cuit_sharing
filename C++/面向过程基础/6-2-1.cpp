#include <iostream>
#include <string>
/* 请在这里填写答案 */
/*void Foo();*/
    void Foo(){
        int num;
        std::cin >> num;
        if(num >=0 &&num<=3){
            std::cout<< "baby" <<std::endl;
        }else if(num >=4 &&num<=17){
            std::cout<< "teen" <<std::endl;
        }else if(num>= 18){
            std::cout<< "adult" <<std::endl;
    
        }else{
            std::cout<< "error" <<std::endl;
        }
    }

int main()
{
  Foo();
  return 0;
}

