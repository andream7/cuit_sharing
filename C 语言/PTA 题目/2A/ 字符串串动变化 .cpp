#include<stdio.h>
void fun(char *p);
int main()
{ char str[80];
  gets(str);
  fun(str);
  printf("The string after moving:");puts(str);
  return 0;
  }


/* 请在这里填写答案 */
void fun(char *p) {
    char *pos = p, *str = p;
    while(*str) {
        if(*pos < *str) {
            pos = str;
        }
        str++;
    }
    str = pos;
    while(*str) {
        *str = *(str - 1);
        str--;
    }
    *p = *pos;
}