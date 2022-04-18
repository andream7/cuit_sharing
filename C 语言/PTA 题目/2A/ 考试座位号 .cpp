#include <stdio.h>

struct stu {
    long long uid, pos_pre, pos_crt;
} p[1010];

int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%lld%lld%lld", &p[i].uid, &p[i].pos_pre, &p[i].pos_crt);
    }
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (p[j].pos_pre > p[j + 1].pos_pre) {
                struct stu t = p[j];
                p[j] = p[j + 1];
                p[j + 1] = t;
            }
        }
    }
    int m, tmp;
    scanf("%d", &m);
    for (int i = 0; i < m; i++) {
        scanf("%d", &tmp);
        printf("%lld %lld\n", p[tmp - 1].uid, p[tmp - 1].pos_crt);
    }
    return 0;
}