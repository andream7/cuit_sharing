#include <stdio.h>
#define MAXN 10

void sort( int a[], int n );

int main()
{
    int i, n;
    int a[MAXN];

    scanf("%d", &n);
    for( i=0; i<n; i++ )
        scanf("%d", &a[i]);

    sort(a, n);

    printf("After sorted the array is:");
    for( i = 0; i < n; i++ )
        printf(" %d", a[i]);
    printf("\n");

    return 0;
}

/* 你的代码将被嵌在这里 */
void sort( int a[], int n ){
    for(int i=0; i<n; i++){
        int max = 0;
        for(int j=0; j<n-i; j++){
            if(a[max] < a[j])
                max = j;
        }
        int t=a[max]; a[max]=a[n-i-1]; a[n-i-1]=t;
    }

}