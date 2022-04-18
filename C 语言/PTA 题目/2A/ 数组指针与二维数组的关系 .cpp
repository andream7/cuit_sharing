#include <stdio.h>
void reOut(int (*p)[3]);
int main()
{
    void reOut(int (*p)[3]);
    int i, j, a[2][3], (*p)[3];
    for (i = 0; i < 2; i++)
        for (j = 0; j < 3; j++)
        scanf("%d", &a[i][j]);
    p= a;
    reOut(p); 
}


/* 请在这里填写答案 */
void reOut(int (*p)[3]) {
    for(int i=0; i<2; i++) {
        for(int j=0; j<3; j++)
            printf("%3d", *(*(p+i)+j));
    }
    for(int i=0; i<3; i++) {
        for(int j=0; j<2; j++)
            printf("%3d", *(*(p+j)+i));
    }
}