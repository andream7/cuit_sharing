#include <stdio.h>
char *fun(char *s, char *t);
int main() {
    char s[100], t[100], *p;
    scanf("%s", s);
    scanf("%s", t);
    p = fun(s, t);
    if (p)
        printf("The result is : %s\n", p);
    else
        printf("Not found !\n");
}

/* 请在这里填写答案 */
char *fun(char *s, char *t) {
}