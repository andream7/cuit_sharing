#include <stdio.h>
#include <math.h>

struct complex {
    double a, b;
};

struct complex add(struct complex x, struct complex y) {
    return {x.a + y.a, x.b + y.b};
}

struct complex sub(struct complex x, struct complex y) {
    return {x.a - y.a, x.b - y.b};
}

struct complex mul(struct complex x, struct complex y) {
    return {x.a * y.a - x.b * y.b, x.b * y.a + x.a * y.b};
}

struct complex div(struct complex x, struct complex y) {
    return {(x.a * y.a + x.b * y.b) / (y.a * y.a + y.b * y.b), (x.b * y.a - x.a * y.b) / (y.a * y.a + y.b * y.b)};
}

void printSingle(struct complex x, bool f) {
    if (fabs(x.a) < 0.05 && fabs(x.b) < 0.05 && !f) {
        printf("0.0");
        return;
    }
    bool flag = false;
    if (fabs(x.a) >= 0.05 || f) {
        printf("%.1lf", x.a);
        flag = true;
    }
    if (fabs(x.b) >= 0.05 || f) {
        if (x.b >= 0 && (flag || f)) {
            printf("+%.1lfi", x.b);
        } else {
            printf("%.1lfi", x.b);
        }
    }
}

void printTotal(char ch, struct complex x, struct complex y, struct complex z) {
    printf("(");
    printSingle(x, 1);
    printf(") %c (", ch);
    printSingle(y, 1);
    printf(") = ");
    printSingle(z, 0);
    printf("\n");
}

int main() {
    struct complex x, y, z;
    scanf("%lf%lf%lf%lf", &x.a, &x.b, &y.a, &y.b);
    z = add(x, y);
    printTotal('+', x, y, z);
    z = sub(x, y);
    printTotal('-', x, y, z);
    z = mul(x, y);
    printTotal('*', x, y, z);
    z = div(x, y);
    printTotal('/', x, y, z);
    return 0;
}