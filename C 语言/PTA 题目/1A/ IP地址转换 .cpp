#include <stdio.h>
#include <math.h>

int main(){
    char str[40];
    int ip = 0, cnt = 7;
    gets(str);
    for(int i=0; str[i]!='\0'; i++){

        ip += (str[i]-'0')*pow(2, cnt--);
        if((i+1)%8 == 0){
            printf("%d", ip);
            if(i != 31)
                printf(".");
            ip = 0;
            cnt = 7;
        }        
    }

    return 0;
}