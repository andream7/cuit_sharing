#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int data;
    struct ListNode *next;
};

struct ListNode *createlist(); /*裁判实现，细节不表*/
struct ListNode *mergelists(struct ListNode *list1, struct ListNode *list2);
void printlist(struct ListNode *head) {
    struct ListNode *p = head;
    while (p) {
        printf("%d ", p->data);
        p = p->next;
    }
    printf("\n");
}

int main() {
    struct ListNode *list1, *list2;

    list1 = createlist();
    list2 = createlist();
    list1 = mergelists(list1, list2);
    printlist(list1);

    return 0;
}

/* 你的代码将被嵌在这里 */
struct ListNode *mergelists(struct ListNode *list1, struct ListNode *list2) {
    struct ListNode *head = NULL, *tail = NULL;
    while (list1 != NULL && list2 != NULL) {
        if (head == NULL) {
            if (list1->data < list2->data) {
                head = list1;
                tail = head;
                list1 = list1->next;
            } else {
                head = list2;
                tail = head;
                list2 = list2->next;
            }
        } else {
            if (list1->data < list2->data) {
                tail->next = list1;
                tail = tail->next;
                list1 = list1->next;
            } else {
                tail->next = list2;
                tail = tail->next;
                list2 = list2->next;
            }
        }
    }
    while (list1 != NULL) {
        tail->next = list1;
        tail = tail->next;
        list1 = list1->next;
    }
    while (list2 != NULL) {
        tail->next = list2;
        tail = tail->next;
        list2 = list2->next;
    }
    return head;
}