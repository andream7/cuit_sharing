#include "stdio.h"
void fun(int a[3][3],int b[3]);
int main()
{int a[3][3]={1,2,3,9,8,4,6,2,1},i,j,b[3];
 fun(a,b);
  for(i=0;i<3;i++)
   {for(j=0;j<3;j++)
      printf("%4d",a[i][j]);
    printf("%4d\n",b[i]);
    }
  return 0;
   }


/* 请在这里填写答案 */
void fun(int a[3][3],int b[3]) {
    for(int (*i)[3]=a; i-a<3; i++) {
//    	printf("%3d", *i);
    	b[i-a] = 0;
      for(int j=0; j<3; j++) {
//      	printf("%3d", *(*i+j));
        b[i-a] += *(*i+j);
      }
//      printf("\n");
    }
}