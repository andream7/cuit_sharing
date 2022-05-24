#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int CountWord(FILE *f);

int main() {
    FILE *f;
    int n;
    f = fopen("Story.txt", "r");
    if (!f) {
        puts("文件无法打开!");
        exit(1);
    }

    n = CountWord(f);

    if (fclose(f)) {
        puts("文件无法关闭!");
        exit(1);
    }

    printf("单词数: %d\n", n);
    return 0;
}

/* 你提交的代码将被嵌在这里 */
int CountWord(FILE *f) {
    char ch;
    int cnt = 0, start = 0;
    while ((ch = fgetc(f)) != EOF) {
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
            if (start == 0) {
                start = 1;
                cnt++;
            }

        } else if (start) {
            start = 0;
        }
    }
    return cnt;
}