#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int data;
    struct ListNode *next;
};

struct ListNode *createlist();

int main() {
    struct ListNode *p, *head = NULL;

    head = createlist();
    for (p = head; p != NULL; p = p->next)
        printf("%d ", p->data);
    printf("\n");

    return 0;
}

/* 你的代码将被嵌在这里 */
struct ListNode *createlist() {
    int n;
    struct ListNode *head = NULL;
    while (scanf("%d", &n) && n != -1) {
        struct ListNode *node = (struct ListNode *)malloc(sizeof(struct ListNode));
        node->data = n;
        node->next = head;
        head = node;
    }
    return head;
}