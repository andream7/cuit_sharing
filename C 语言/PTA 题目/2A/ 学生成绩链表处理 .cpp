#include <stdio.h>
#include <stdlib.h>

struct stud_node {
    int num;
    char name[20];
    int score;
    struct stud_node *next;
};

struct stud_node *createlist();
struct stud_node *deletelist(struct stud_node *head, int min_score);

int main() {
    int min_score;
    struct stud_node *p, *head = NULL;

    head = createlist();
    scanf("%d", &min_score);
    head = deletelist(head, min_score);
    for (p = head; p != NULL; p = p->next)
        printf("%d %s %d\n", p->num, p->name, p->score);

    return 0;
}

/* 你的代码将被嵌在这里 */
struct stud_node *createlist() {
    int id, score;
    char name[20];
    struct stud_node *head = NULL, *tail = NULL;
    while (scanf("%d", &id) && id != 0) {
        struct stud_node *node = (struct stud_node *)malloc(sizeof(struct stud_node));
        scanf("%s %d", node->name, &node->score);
        node->num = id;
        node->next = NULL;
        if (head == NULL) {
            head = node;
            tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }
    return head;
}
struct stud_node *deletelist(struct stud_node *head, int min_score) {
    struct stud_node *tmp = head, *pre = head;
    while (tmp != NULL) {
        if (tmp->score < min_score) {
            if (tmp == head) {
                head = head->next;
                tmp = head;
                pre = head;
            } else {
                tmp = tmp->next;
                pre->next = tmp;
            }
        } else {
            pre = tmp;
            tmp = tmp->next;
        }
    }
    return head;
}