#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int data;
    struct ListNode *next;
};

struct ListNode *readlist();
struct ListNode *deletem(struct ListNode *L, int m);
void printlist(struct ListNode *L) {
    struct ListNode *p = L;
    while (p) {
        printf("%d ", p->data);
        p = p->next;
    }
    printf("\n");
}

int main() {
    int m;
    struct ListNode *L = readlist();
    scanf("%d", &m);
    L = deletem(L, m);
    printlist(L);

    return 0;
}

/* 你的代码将被嵌在这里 */
struct ListNode *readlist() {
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
struct ListNode *deletem(struct ListNode *L, int m) {
    struct ListNode *tmp = L, *pre = L;
    while (tmp != NULL) {
        if (tmp->data == m) {
            if (tmp == L) {
                L = L->next;
                tmp = L;
                pre = L;
            } else {
                pre->next = tmp->next;
                tmp = tmp->next;
            }
        } else {
            pre = tmp;
            tmp = tmp->next;
        }
    }
    return L;
}