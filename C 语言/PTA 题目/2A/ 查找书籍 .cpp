#include <stdio.h>

struct node {
    char name[40];
    float price;
} books[20];

int main() {
    int n;
    int maxbook = 0, minbook = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%s", books[i].name);
        scanf("%f", &books[i].price);
        maxbook = books[maxbook].price < books[i].price ? i : maxbook;
        minbook = books[minbook].price > books[i].price ? i : minbook;
    }
    printf("%.2f,%s\n", books[maxbook].price, books[maxbook].name);
    printf("%.2f,%s\n", books[minbook].price, books[minbook].name);

    return 0;
}