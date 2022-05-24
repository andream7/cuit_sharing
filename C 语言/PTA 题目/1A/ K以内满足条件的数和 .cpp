#include <stdio.h>

int Count ( int num );

int main()
{

  int K,sum;

  scanf("%d", &K);

 sum = Count ( K );

  printf("%d", sum);

  return 0;

}

/* ???????? */
int Count ( int num ){
	int i, j, cnt = 0, sum = 0;
	for(i=num; i>0; i--){
		if((i%13==0 || i%17==0) && cnt<10)
			sum += i, cnt++;
	}
	
	return sum;
}
