#include <stdio.h>

#define MAXS 10

char *match(char *s, char ch1, char ch2);

int main() {
    char str[MAXS], ch_start, ch_end, *p;

    scanf("%s\n", str);
    scanf("%c %c", &ch_start, &ch_end);
    p = match(str, ch_start, ch_end);
    printf("%s\n", p);

    return 0;
}

/* ?????????? */
char *match(char *s, char ch1, char ch2) {
    char *p = NULL;
    for (; *s; s++) {
        if (p == NULL && *s == ch1) {
            p = s;
            for (; *s != ch2 && *s; s++) {
                putchar(*s);
            }
            if (*s)
                putchar(*s);
            printf("\n");
        }
    }
    if (p == NULL)
        printf("\n");
    return p;
}