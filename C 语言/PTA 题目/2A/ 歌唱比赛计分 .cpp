#include <stdio.h>

struct node {
    double s;
    int id;
} singer[10];

int main() {
    for (int i = 0; i < 10; i++) {
        int maxx = 0, minn = 0x7fffffff, t;
        for (int j = 0; j < 6; j++) {
            scanf("%d", &t);
            maxx = maxx > t ? maxx : t;
            minn = minn < t ? minn : t;
            singer[i].s += t;
        }
        singer[i].s = (singer[i].s - maxx - minn) / 4.0;
        singer[i].id = i + 1;
    }
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9 - i; j++) {
            if (singer[j].s < singer[j + 1].s) {
                struct node t = singer[j];
                singer[j] = singer[j + 1];
                singer[j + 1] = t;
            }
        }
    }
    for (int i = 0; i < 10; i++) {
        printf("No.%-2d: %.2lf\n", singer[i].id, singer[i].s);
    }
    return 0;
}