#include <stdio.h>
#include <math.h>

int prime(int m){
	for(int i=2; i<=sqrt(m); i++){
		if(m%i == 0)
			return 0;
	}
	return 1;
}

int main(){
	int n, k, cnt = 0, sum = 0;
	scanf("%d%d", &n, &k);
	for(int i=n; i>=2 && cnt<k; i--){
		prime(i) ? sum += i, cnt++ == 0 ? printf("%d", i) : printf("+%d", i) : 0;
//		if(prime(i)){
//			sum += i;
//			cnt++;
//			if(cnt == 0){
//				printf("%d", i); 
//			}else{
//				printf("+%d", i); 
//			} 
//		} 
	}	
	printf("=%d", sum);
	
	return 0;
} 
