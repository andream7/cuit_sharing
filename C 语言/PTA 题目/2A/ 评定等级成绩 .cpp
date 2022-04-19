#include <stdio.h>
struct Student {
    char name[50];  //姓名
    int sid;        //学号
    int C;          //C语言成绩
    int English;    //英语成绩
    int math;       //数学成绩
    int grade;      //总评等级成绩
};
int calScore(struct Student *stu);
int main() {
    int n;
    scanf("%d", &n);
    struct Student stu;
    int pass;
    for (int i = 0; i < n; i++) {
        scanf("%s%d%d%d%d", stu.name, &stu.sid, &stu.C,
              &stu.English, &stu.math);
        pass = calScore(&stu);
        printf("(%d, %s) : %d(%d)\n", stu.sid, stu.name, stu.grade, pass);
    }
    return 0;
}
/** 你所提交的代码将被嵌在这里  **/
int calScore(struct Student *stu) {
    if ((*stu).C < 60 || (*stu).English < 60 || (*stu).math < 60) {
        (*stu).grade = 1;
        return 0;
    }

    if (((*stu).C + (*stu).English + (*stu).math) / 3.0 > 90) {
        if ((*stu).C < 90) {
            (*stu).grade = 4;
            return 1;
        } else {
            (*stu).grade = 5;
            return 1;
        }
    }
    if (((*stu).C + (*stu).English + (*stu).math) / 3.0 > 80) {
        (*stu).grade = 4;
        return 1;
    }
    if (((*stu).C + (*stu).English + (*stu).math) / 3.0 > 70) {
        (*stu).grade = 3;
        return 1;
    }
    if (((*stu).C + (*stu).English + (*stu).math) / 3.0 > 60) {
        (*stu).grade = 2;
        return 1;
    }
    (*stu).grade = 1;
    return 0;
}