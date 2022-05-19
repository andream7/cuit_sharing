#include <stdio.h>

struct stu {
    char name[80];
    int birth;
    char tel[80];
    bool operator>(const stu a) {
        return a.birth < birth;
    }
} frd[20];

int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%s %d %s", frd[i].name, &frd[i].birth, frd[i].tel);
    }
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (frd[j] > frd[j + 1]) {
                struct stu t = frd[j];
                frd[j] = frd[j + 1];
                frd[j + 1] = t;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        printf("%s %d %s\n", frd[i].name, frd[i].birth, frd[i].tel);
    }
    return 0;
}