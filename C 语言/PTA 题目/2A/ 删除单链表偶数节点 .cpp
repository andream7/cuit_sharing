#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int data;
    struct ListNode *next;
};

struct ListNode *createlist();
struct ListNode *deleteeven(struct ListNode *head);
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
    head = deleteeven(head);
    printlist(head);

    return 0;
}

/* 你的代码将被嵌在这里 */
struct ListNode *createlist() {
    struct ListNode *head = NULL, *tail = NULL;
    struct ListNode *node = (struct ListNode *)malloc(sizeof(struct ListNode));
    node->next = NULL;
    while (scanf("%d", &node->data) && node->data != -1) {
        if (head == NULL) {
            head = tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
        node = (struct ListNode *)malloc(sizeof(struct ListNode));
        node->next = NULL;
    }
    return head;
}
struct ListNode *deleteeven(struct ListNode *head) {
    struct ListNode *pre, *tail;
    while (head && head->data % 2 == 0) {
        head = head->next;
    }
    if (head != NULL) {
        pre = head;
        tail = head->next;
        //    tail = head;
        while (tail) {
            if (tail->data % 2 == 0) {
                pre->next = tail->next;
            } else {
                pre = tail;
            }
            tail = tail->next;
        }
    } else {
        return NULL;
    }
    return head;
}