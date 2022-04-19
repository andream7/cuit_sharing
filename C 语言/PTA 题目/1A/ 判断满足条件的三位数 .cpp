#include <stdio.h>
#include <math.h>

int search( int n );

int main()
{
    int number;

    scanf("%d",&number);
    printf("count=%d\n",search(number));

    return 0;
}


/* ?????????? */
int search( int n ){
	int i, cnt = 0;
	for(i=101; i<=n; i++){
		int m = i, num[10] = {0};
		if((int)sqrt(i)*(int)sqrt(i) == i)
			while(m){
//				num[m%10]++;
				if(++num[m%10]>=2){
					cnt++;
					break;
				}
	//			printf("%d\n", num[m%10]);
				m /= 10;		
			}
	}
	return cnt;
	
}
