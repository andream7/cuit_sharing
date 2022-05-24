#include <stdio.h>
#include <stdlib.h>
#define NAME_LEN 100
#define SEX_LEN 6
typedef struct {
    int id;                        //身份证号码
    char lastname[NAME_LEN + 1];   //姓
    char firstname[NAME_LEN + 1];  //名
    char sex[SEX_LEN];             //性别
    double ability;
} TeamMember;

void showCaptain(TeamMember team[], int n);
int main() {
    TeamMember *team;
    int n;
    int i;

    scanf("%d", &n);
    team = (TeamMember *)malloc(n * sizeof(TeamMember));
    for (i = 0; i < n; i++) {
        scanf("%d %s %s %s %lf", &team[i].id, team[i].lastname, team[i].firstname, team[i].sex, &team[i].ability);
    }

    showCaptain(team, n);

    return 0;
}

/* 您提交的代码将放置在这里 */
void showCaptain(TeamMember team[], int n) {
    int capter = 0;
    for (int i = 1; i < n; i++) {
        capter = team[capter].ability < team[i].ability ? i : capter;
    }
    printf("%d %s %s %s %.2lf", team[capter].id, team[capter].lastname, team[capter].firstname, team[capter].sex, team[capter].ability);
}