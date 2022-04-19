#include <stdio.h>

struct node {
    char id[100];
    char name[256];
    int s[3], sum;
} p[100];

int main() {
    int n, pos = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%s%s%d%d%d", p[i].id, p[i].name, &p[i].s[0], &p[i].s[1], &p[i].s[2]);
        p[i].sum = p[i].s[0] + p[i].s[1] + p[i].s[2];
        if (p[i].sum > p[pos].sum)
            pos = i;
    }
    printf("%s %s %d", p[pos].name, p[pos].id, p[pos].sum);
    return 0;
}
