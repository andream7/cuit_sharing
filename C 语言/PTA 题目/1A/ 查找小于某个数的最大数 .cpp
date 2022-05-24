
#include <stdio.h>

void Input(int a[],int m);
int Max(int a[],int m, int num); 
#define N 100
int main(void)
{
        int arrA[N], n,num, maxA;

        scanf("%d", &n);

        Input(arrA,n);

        scanf("%d", &num);

        maxA = Max(arrA,n,num) ;
        if (maxA == -1)
                printf("not Find!\n");
        else
                printf("%d\n", maxA);

        return 0;
}
/* 请在这里填写答案 */
void Input(int a[],int m){
    for(int i=0; i<m; i++)
        scanf("%d", &a[i]);
}
int Max(int a[],int m, int num){
    int max = -0x7fffffff, flag = 0;
    for(int i=0; i<m; i++){
        if(a[i]<num && a[i]>max)
            max = a[i], flag = 1;
    }
    return flag == 0 ? -1 : max;
}