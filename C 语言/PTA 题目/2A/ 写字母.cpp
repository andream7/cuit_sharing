#include <stdio.h>
#include <stdlib.h>

void WriteLetter(FILE *f, int n);

int main() {
    FILE *f;
    int n;
    f = fopen("Letter.txt", "w");
    if (!f) {
        puts("文件无法打开!");
        exit(1);
    }

    scanf("%d", &n);
    WriteLetter(f, n);

    if (fclose(f)) {
        puts("文件无法关闭!");
        exit(1);
    }
    puts("文件保存成功!");
    return 0;
}

/* 你提交的代码将被嵌在这里 */
void WriteLetter(FILE *f, int n) {
    char ch;
    for (ch = 'A'; ch <= 'Z' && n; ch++) {
        fputc(ch, f);
        n--;
    }
}