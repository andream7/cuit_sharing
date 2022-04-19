#include <stdio.h>
void sort(int a[],int n);
int main()
{
  int  a[3][4],i,j;
  for(i=0;i<3;i++)
     for(j=0;j<4;j++)
         scanf("%d",&a[i][j]);
   for(i=0;i<3;i++) sort(a[i],4);
   for(i=0;i<3;i++)
   {  for(j=0;j<4;j++)  printf("%5d",a[i][j]);
         printf("\n");
        }

  return 0;
 }


/* 请在这里填写答案 */
void sort(int a[],int n) {
	int *p = a;
//	printf("%x\n", a);

	
//	printf("\n");
//	p = a;
	for(int *i = a; i < a+4; i++) {
		for(int *j = a; (j - a) < (a + 3 - a) ; j++) {
//			printf("%3d", *j);
			if(*j > *(j+1)) {
//				printf("%3d and %3d",  )
				int t = *j;
				*j = *(j+1);
				*(j+1) = t;
			}
		}
//		printf("%3d", *i);
	}
//	printf("\n");
}