#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//    这两个函数由系统提供
char *dstr_readword();
char *dstr_create(const char *s);

char *dstr_add(char *s, char c);
char *dstr_concat(char *this, const char *that);

int main() {
    char *s = dstr_create("hello");
    s = dstr_add(s, '!');
    printf("%lu-%s\n", strlen(s), s);
    char *t = dstr_readword();
    s = dstr_concat(s, t);
    free(t);
    printf("%lu-%s\n", strlen(s), s);
    free(s);
}

/* 请在这里填写答案 */
char *dstr_add(char *s, char c) {
    char *t = s;
    while (*t++)
        ;
    *t++ = c;
    *t = '\0';
    return s;
}
char *dstr_concat(char *this, const char *that) {
    char *t = this;
    int n = 0;
    while (*this ++)
        ;
    while (that[n]) {
        *this ++ = that[n++];
    }
    *this = '\0';
    return t;
}