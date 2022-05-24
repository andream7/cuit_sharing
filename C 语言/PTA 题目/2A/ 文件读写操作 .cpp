#include <stdio.h>
void fileRW(FILE *fin, FILE *fout);
int main() {
    char fname[20];
    gets(fname);
    FILE *fpr = fopen(fname, "r");
    FILE *fpw = fopen("file2.txt", "w");
    fileRW(fpr, fpw);
    fclose(fpr);
    fclose(fpw);
    return 0;
}
/* 请在这里填写答案 */
void fileRW(FILE *fin, FILE *fout) {
    char s[100];
    int cnt = 1;
    while (fgets(s, 100, fin) != NULL) {
        char ps[100];
        char *a = ps, *p = s;
        while (*p == ' ' || *p == '\t')
            p++;
        while (*p) {
            *a++ = *p++;
        }
        *a = '\0';
        fprintf(fout, "%d:", cnt);
        fputs(ps, fout);
        cnt++;
    }
}