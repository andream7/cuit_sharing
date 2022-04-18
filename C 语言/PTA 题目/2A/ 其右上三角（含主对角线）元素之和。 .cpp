#include <stdio.h>

int fun(int a[3][3]);

int main()
{   int i,j,s,x[3][3];;
   for(i=0;i<3;i++)
      for(j=0;j<3;j++)
        scanf("%d",&x[i][j]);
   s=fun(x);
   printf("sum=%d\n",s);
   return 0;
}
/* 您的答案将被嵌入在这里 */
int fun(int a[3][3]) {
    int sum = 0;
    sum += a[0][0] + a[1][1] + a[2][2] + a[0][1] + a[0][2] + a[1][2];
    return sum;
}