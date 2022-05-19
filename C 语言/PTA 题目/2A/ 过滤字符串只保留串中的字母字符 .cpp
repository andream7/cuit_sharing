#include <stdio.h>
int fun(char *ptr);
int main() {
    char str[80];
    int s;
    gets(str);
    s = fun(str);
    printf("The new string is :");
    puts(str);
    printf("There are %d char in the new string.", s);
    return 0;
}

/* 请在这里填写答案 */
int fun(char *ptr) {
    int cnt = 0;
    char *p = ptr;
    while (*p) {
        if (*p >= 'a' && *p <= 'z' || *p >= 'A' && *p <= 'Z') {
            *(ptr + cnt) = *p;
            cnt++;
        }
        p++;
    }
    *(ptr + cnt) = '\0';
    return cnt;
}