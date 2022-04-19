#include<stdio.h>
int Input(int a[],int n);
int Search(int a[ ], int n, int num);

int main(void)
{
        int Arr[20],cnt=0, num, Pos;

         scanf("%d", &num);    
         cnt = Input(Arr,20);
         Pos = Search(Arr,cnt,num) ;  
        if (-1 == Pos)
        {
                printf("not Find!\n");
        }
        else
        {
                printf("%d\n", Pos);
        }

        return 0;
}
/* 请在这里填写答案 */

int Input(int a[],int n){
    int cnt = 0;
    while(~scanf("%d", &a[cnt])  && a[cnt++] != -9999 && cnt < 20);
    if(a[cnt-1] == -9999)	cnt--;
//    for(int i=0; i<cnt; i++){
//        printf("%d ", a[i]);
//    }
    return cnt;
}
int Search(int a[ ], int n, int num){
    for(int i=0; i<n; i++){
        if(a[i] == num){
            return i;
        }
    }
    return -1;
}