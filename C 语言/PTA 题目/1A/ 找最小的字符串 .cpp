#include <stdio.h>
#include <string.h>

int main(){
    char str[100] = {'\250'};
    puts(str);
    int n;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        char t[100];
        gets(t);
        strcpy(str, strcmp(t, str) < 0 ? t : str);
    }
    puts(str);
    return 0;
}