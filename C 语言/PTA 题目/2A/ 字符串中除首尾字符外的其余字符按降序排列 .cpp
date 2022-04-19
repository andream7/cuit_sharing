#include <stdio.h>
int fun(char *s,int num);
int main()
{
    char s[10];
    gets(s);
    fun(s,7);
    printf("%s",s);
    return 0;
 }

/* 请在这里填写答案 */
int fun(char *s,int num) {
    char ch;
    for(int i=1; *(s+i+1)!='\0'; i++) {
        for(int j=i+1; *(s+j+1)!='\0'; j++) {
            if(s[i] < s[j]) {
                ch = s[i];
                s[i] = s[j];
                s[j] = ch;
            }
        }
    }

}