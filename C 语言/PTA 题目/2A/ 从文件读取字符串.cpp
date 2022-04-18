#include <stdio.h>
#include <string.h>

void FGetStr(char *str, int size, FILE *file);

int main() {
    FILE *f;
    char a[10], b[10];
    f = fopen("MyStr.txt", "r");
    if (f) {
        FGetStr(a, 10, f);
        FGetStr(b, 10, f);
        puts(a);
        puts(b);
        fclose(f);
    }
    return 0;
}

/* 你提交的代码将被嵌在这里 */
void FGetStr(char *str, int size, FILE *file) {
    char ch;
    int cnt = 0, f = 0;
    for (int i = 0; (ch = fgetc(file)) != EOF && i < size - 1; i++) {
        //    	putchar(ch);
        //    	printf("i: %d\n", i);
        if (ch != '\n') {
            *(str + cnt++) = ch;
        } else {
            f = 1;
            break;
        }
    }
    if (ch != '\n')
        ungetc(ch, file);
    *(str + cnt) = '\0';
}