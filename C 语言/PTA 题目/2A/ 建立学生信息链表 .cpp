#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct stud_node {
    int num;
    char name[20];
    int score;
    struct stud_node *next;
};
struct stud_node *head, *tail;

void input();

int main() {
    struct stud_node *p;

    head = tail = NULL;
    input();
    for (p = head; p != NULL; p = p->next)
        printf("%d %s %d\n", p->num, p->name, p->score);

    return 0;
}

/* 你的代码将被嵌在这里 */
void input() {
    struct stud_node *node = (struct stud_node *)malloc(sizeof(struct stud_node));
    node->next = NULL;
    while (scanf("%d", &node->num) && node->num != 0) {
        scanf("%s%d", node->name, &node->score);
        if (head == NULL) {
            head = node;
            tail = head;
        } else {
            tail->next = node;
            tail = node;
        }
        node = (struct stud_node *)malloc(sizeof(struct stud_node));
    }
}