#include <stdio.h>

int main(){
    char str[100];
    gets(str);
    for(int i=0; str[i] != '\0'; i++){
        if(str[i] >= 'A' && str[i] <= 'Z')
            str[i] = 'Z' - (str[i] - 'A');
    }
    puts(str);
    return 0;
}