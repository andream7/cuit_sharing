
#include <stdio.h>
struct student {                 /*学生信息结构定义*/
    int num;                     /* 学号 */
    char name[10];               /* 姓名 */
    int math, english, computer; /* 三门课程成绩 */
};
int update_score(struct student *p, int n, int num, int course, int score); /*函数声明*/

int main(void) {
    int i, pos, n, num, course, score;
    struct student students[50]; /* 定义结构数组 */
    scanf("%d", &n);
    for (i = 0; i < n; i++) {
        scanf("%d", &students[i].num);
        scanf("%s", students[i].name);
        scanf("%d", &students[i].math);
        scanf("%d", &students[i].english);
        scanf("%d", &students[i].computer);
    }

    /* 输入待修改学生信息 */
    scanf("%d", &num);
    scanf("%d", &course);
    scanf("%d", &score);

    /*调用函数，修改学生成绩*/
    pos = update_score(students, n, num, course, score);

    /*输出修改后的学生信息*/
    if (pos == -1)
        printf("Not found!\n");
    else {
        printf("%d,%d,%d,%d\n", students[pos].num, students[pos].math, students[pos].english, students[pos].computer);
    }

    return 0;
}

/* 请在这里填写答案 */
int update_score(struct student *p, int n, int num, int course, int score) {
    for (int i = 0; i < n; i++) {
        if (p[i].num == num) {
            switch (course) {
                case 1: {
                    p[i].math = score;
                    break;
                }
                case 2: {
                    p[i].english = score;
                    break;
                }
                case 3: {
                    p[i].computer = score;
                    break;
                }
            }
            return i;
        }
    }
    return -1;
}