#include <stdio.h>

int main(){
    char str[1000];
    for(int i=0; i<4; i++){
        gets(str);
        printf("%c%c", str[0], str[1]);
    }
    printf("\n");

    return 0;
}