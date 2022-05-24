
#include <stdio.h>
void swap ( int *a,  int *b );

int main()
{
     int x, y;
     scanf("%d %d", &x, &y);
     swap(&x, &y);
     printf("%d %d", x,y);
     return 0;
}

/* 请在这里填写答案 */
void swap ( int *a,  int *b ) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}