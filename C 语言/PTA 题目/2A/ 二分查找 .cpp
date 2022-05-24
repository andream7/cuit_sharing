#include<stdio.h>
#define N 20
int Search(int *pa, int n, int k,int *p);
int main()
{
     int a[N],n,cmp,*p=&cmp;
     int pos,num=0;
     int i,k;
     scanf("%d",&n);
     for(i=0;i<n;i++)
            scanf("%d",&a[i]);
     scanf("%d",&k);
     pos=Search(a,n,k,p);
       printf("%d\n%d\n",pos,cmp);
        return 0;
}

/* 请在这里填写答案 */
int Search(int *pa, int n, int k,int *p) {
    int l = 0, r = n-1, mid = (l+r)/2;
    *p = 0;
    while(1) {
    	if(l > r)  return -1;
        (*p)++;
        if(k == *(pa+mid))  return mid;
        if(k > *(pa+mid)) {
            l = mid + 1;
            mid = (l+r)/2;
            continue;
        }else {
            r = mid - 1;
            mid = (l+r)/2;
            continue;
        }
        
    }
    
}