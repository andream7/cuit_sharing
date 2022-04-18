#include <stdio.h>

int main(){
    int num[12] = {0}, t, cnt = 1;
    char str[80] = {'\0'};
    for(int i=0; i<10; i++){
        scanf("%d", &num[i]);
    }
    for(int i=1; ; i++){
        if(num[i]){
            str[0] = i+'0';
            num[i]--;
            break;
        }
    }
    for(int i=0; i<10; i++){
        while(num[i]){
            str[cnt++] = i+'0';
            num[i]--;
        }
    }
    puts(str);
    return 0;
}
//2 2 0 0 0 3 0 0 1 2 