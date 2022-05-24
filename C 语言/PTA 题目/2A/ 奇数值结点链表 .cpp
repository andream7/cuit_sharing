#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int data;
    struct ListNode *next;
};

struct ListNode *readlist();
struct ListNode *getodd(struct ListNode **L);
void printlist(struct ListNode *L) {
    struct ListNode *p = L;
    while (p) {
        printf("%d ", p->data);
        p = p->next;
    }
    printf("\n");
}

int main() {
    struct ListNode *L, *Odd;
    L = readlist();
    Odd = getodd(&L);
    printlist(Odd);
    printlist(L);

    return 0;
}

/* 你的代码将被嵌在这里 */
struct ListNode *readlist() {
    struct ListNode *head = NULL, *tail = NULL;
    while (scanf("%d", &num) && num != -1) {
        struct ListNode *node = (struct ListNode *)malloc(sizeof(struct ListNode));
        node->data = num;
        node->next = NULL;
        if (head == NULL) {
            head = node;
            tail = node;
        } else {
            tail->next = node;
            tail = tail->next;
        }
    }
    return head;
}
struct ListNode *getodd(struct ListNode **L) {
    struct ListNode *nhead = NULL, *ntail = NULL, *opre = *L, *otail = *L, t;
    if (opre->data % 2 == 1) {
        nhead
    }
    while (otail) {
        if (otail->data % 2 == 0) {
            pre->next = otail;
            pre = otail;
        } else {
            if (nhead == NULL) {
                nhead = otail;
                ntail = otail;
            } else {
                ntail->next = otail;
                ntail = ntail->next;
            }
        }
    }
}