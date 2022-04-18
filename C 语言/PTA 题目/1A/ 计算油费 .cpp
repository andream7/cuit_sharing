#include <stdio.h>

int main(){
    int a, b;
    char c; 
    double price = 0;
    scanf("%d%d %c", &a, &b, &c);
    switch(b){
        case 90:{
            price = (double)a*6.95;
            break;
        }
        case 93:{
            price = (double)a*7.44;
            break;
        }
        case 97:{
            price = (double)a*7.93;
            break;
        }
    }
    if(c == 'm')
        price *= 0.95;
    else
        price *= 0.97;
    printf("%.2lf", price);
    return 0;    
}