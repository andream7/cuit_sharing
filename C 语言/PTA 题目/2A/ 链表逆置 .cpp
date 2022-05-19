#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int data;
    struct ListNode *next;
};

struct ListNode *createlist(); /*裁判实现，细节不表*/
struct ListNode *reverse(struct ListNode *head);
void printlist(struct ListNode *head) {
    struct ListNode *p = head;
    while (p) {
        printf("%d ", p->data);
        p = p->next;
    }
    printf("\n");
}

int main() {
    struct ListNode *head;

    head = createlist();
    head = reverse(head);
    printlist(head);

    return 0;
}

/* 你的代码将被嵌在这里 */
struct ListNode *createlist() {
    int n;
    struct ListNode *head = NULL, *tail;
    while (scanf("%d", &n) && n != -1) {
        struct ListNode *node = (struct ListNode *)malloc(sizeof(struct ListNode));
        node->next = NULL;
        node->data = n;
        if (head == NULL) {
            head = node;
            head->next = NULL;
            tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }
    return head;
}
struct ListNode *reverse(struct ListNode *head) {
    struct ListNode *tmp, *newHead, *oldHead;
    newHead = NULL;
    oldHead = head;
    while (oldHead) {
        tmp = oldHead;
        oldHead = oldHead->next;
        tmp->next = newHead;
        newHead = tmp;
    }
    return newHead;
}