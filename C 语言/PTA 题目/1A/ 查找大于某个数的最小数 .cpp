
#include <stdio.h>

void Input(int a[],int m);
int Min(int a[],int m, int num); 

int main(void)
{
    int arrA[10], num, minA;

    Input(arrA,10);

    scanf("%d", &num);

    minA = Min(arrA,10,num) ; // 调用函数查找在arrA中大于num的最小数 
    if (-1 == minA)
    {
        printf("not Find!\n");
    }
    else
    {
        printf("%d\n", minA);
    }

    return 0;
}

/* 请在这里填写答案 */
void Input(int a[],int m){
    for(int i=0; i<10; i++)
        scanf("%d", &a[i]);
}
int Min(int a[],int m, int num){
    int max = 0x7fffffff;
    for(int i=0; i<10; i++){
        if(a[i]>num && a[i]<max){
            max = a[i];
        }
    }
    return max == 0x7fffffff ? -1 : max;
}