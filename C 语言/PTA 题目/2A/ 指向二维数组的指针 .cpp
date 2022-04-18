#include <stdio.h>

void max_row(int (*arr)[20], int m, int n);

int main(void)
{
    int m, n;
    int hang, lie, juZhen[20][20];

    scanf("%d%d", &m, &n);

    for (hang = 0; hang < m; hang++)
    {
        for (lie = 0; lie < n; lie++)
        {
            scanf("%d", &juZhen[hang][lie]);
        }
    }
    max_row(juZhen, m, n);  
    return 0;
}

/* 请在这里填写答案 */
void max_row(int (*arr)[20], int m, int n) {
    for(int i=0; i<m; i++) {
        int maxnum = 0;
        for(int j=0; j<n; j++) {
            maxnum = max(maxnum, *(*(arr+i)+j));
        }
        printf("The max in line %d is:%d\n", i+1, maxnum);
    }

}