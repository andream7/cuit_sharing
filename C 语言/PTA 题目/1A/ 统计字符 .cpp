#include <stdio.h>

int main(){
    char str[1000];
    gets(str);
    int l, n, b, o;
    l = n = b = o = 0;
    for(int i=0; str[i] != '\0'; i++){
        if(str[i]>='a'&&str[i]<='z' || str[i]>='A'&&str[i]<='Z')
            l++;
        else    if(str[i]>='0' && str[i]<='9')
            n++;
        else    if(str[i] == ' ')
            b++;
        else
            o++;
    }
    printf("字母:%d,数字:%d,空格:%d,其他:%d", l, n, b, o);
    return 0;
}