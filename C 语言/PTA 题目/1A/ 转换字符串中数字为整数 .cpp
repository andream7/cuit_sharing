#include<stdio.h>
#include<string.h>
int conv(char arr[]);
int main()
{
    int x=0;
    char c[81];
    gets(c);
    x=conv(c);
    printf("%d",x);
    return 0;
}

/* 请在这里填写答案 */
int conv(char arr[]){
    int num = 0;
    for(int i=0; arr[i] != '\0'; i++){
        if(arr[i]>='0' && arr[i]<='9')
            num = num*10 + arr[i] - '0';
    }
    return num;
}