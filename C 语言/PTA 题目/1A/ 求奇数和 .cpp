#include <stdio.h>

int main(){
	int n, sum = 0;
	while(~scanf("%d", &n), n > 0){
		if(n%2 == 1)
			sum += n;
	}
	printf("%d", sum);
	
}
