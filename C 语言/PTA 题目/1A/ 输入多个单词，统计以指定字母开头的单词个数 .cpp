#include<stdio.h>
int getWordNum(char ar1[],char ch) ;
int main()
{ 
    char string[81],c,n; 
    gets(string);                           
    c=getchar();
    n=getWordNum(string,c);
    printf("%d",n); 
    return 0;
}

/* 请在这里填写答案 */
int getWordNum(char ar1[], char ch) {
    int cnt = 0;
    ch = ch > 'Z' ? ch-32 : ch;
    for(int i=0; ar1[i] != '\0'; i++){
        if((ar1[i]==ch || ar1[i]==ch+32) && (ar1[i-1] == ' ' || i == 0))
            cnt++;
    }
    return cnt;
}