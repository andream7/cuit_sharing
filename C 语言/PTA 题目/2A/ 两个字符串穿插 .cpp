
#include <stdio.h>
#include <string.h>

#define N 32

void conj(char *s1, char *s2);

int main(void) {
    char str1[N * 2], str2[N];

    gets(str1);

    gets(str2);

    conj(str1, str2);

    printf("After conj string1:%s\n", str1);

    return 0;
}

/* 请在这里填写答案 */
void conj(char *s1, char *s2) {
    char *a = s1, *b = s2, news[2 * N + 5];
    char *p = news;
    while (*a && *b) {
        *p++ = *a++;
        *p++ = *b++;
    }
    while (*a) *p++ = *a++;
    while (*b) *p++ = *b++;
    *p = '\0';
    strcpy(s1, news);
}