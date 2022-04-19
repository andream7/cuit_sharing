#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct ListNode {
    char code[8];
    struct ListNode *next;
};

struct ListNode *createlist(); /*裁判实现，细节不表*/
int countcs(struct ListNode *head);

int main() {
    struct ListNode *head;

    head = createlist();
    printf("%d\n", countcs(head));

    return 0;
}

/* 你的代码将被嵌在这里 */
int countcs(struct ListNode *head) {
    int cnt = 0;
    while (head != NULL) {
        if (head->code[1] == '0' && head->code[2] == '2')
            cnt++;
        head = head->next;
    }
    return cnt;
}