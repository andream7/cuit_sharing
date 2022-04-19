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

/* ???????? */
int fun(char *ptr) {
    char *p = ptr;
    int cnt = 0;
    while (*ptr) {
      if(*ptr>='a'&&*ptr<='z'||*ptr>='A'&&*ptr<='Z') {
          *p++ = *ptr;
          cnt++;
      }
      ptr++;
    }
    *p = '\0';
    return cnt;
}
