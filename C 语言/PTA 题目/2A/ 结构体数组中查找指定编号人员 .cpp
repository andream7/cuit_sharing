#include <stdio.h>
#include <string.h>
#define N 8
struct student {
    char num[10];
    int year, month, day;
};
struct student fun(struct student *std, char *num);
int main() {
    struct student std[N] = {{"111111", 1984, 2, 15}, {"222222", 1983, 9, 21}, {"333333", 1984, 9, 1}, {"444444", 1983, 7, 15}, {"555555", 1984, 9, 28}, {"666666", 1983, 11, 15}, {"777777", 1983, 6, 22}, {"888888", 1984, 8, 19}};
    struct student p;
    char n[10] = "666666";
    p = fun(std, n);
    if (p.num[0] == 0)
        printf("Not found !\n");
    else {
        printf("Succeed !\n  ");
        printf("%s   %d-%d-%d\n", p.num, p.year, p.month, p.day);
    }
    return 0;
}

/* 请在这里填写答案 */
struct student fun(struct student *std, char *num) {
    for (int i = 0; i < N; i++) {
        if (strcmp(std[i].num, num) == 0) {
            return std[i];
        }
    }
    return (struct student){"", 0, 0, 0};
}