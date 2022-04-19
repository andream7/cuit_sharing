#include <stdio.h>

int main(){
    int max=-0x7fffffff;
    char ch;
    for(int i=0; i<5; i++){
        ch = getchar();
        max = ch > max ? ch : max;
    }
    printf("%c %d", max, max);
    return 0;
}