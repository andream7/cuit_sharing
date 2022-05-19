#include <stdio.h>
#include <stdlib.h>

void ReadArticle(FILE *f);

int main() {
    FILE *f;
    f = fopen("Article.txt", "r");
    if (!f) {
        puts("文件无法打开!");
        exit(1);
    }

    ReadArticle(f);

    if (fclose(f)) {
        puts("文件无法关闭!");
        exit(1);
    }
    return 0;
}

/* 你提交的代码将被嵌在这里 */
void ReadArticle(FILE *f) {
    char str[1024];
    while (fgets(str, 100, f) != NULL) {
        //        puts(str);
        printf("%s", str);
    }
}