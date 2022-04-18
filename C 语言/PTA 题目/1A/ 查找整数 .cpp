#include <stdio.h>

int main(){
	int n, x, num, sign;
	scanf("%d%d", &n, &x);
	for(int i=0; i<n; i++){
		scanf("%d", &num);
		if(num == x){
			printf("%d", i);
			return 0;
		}
	}
	printf("Not Found");
	return 0;
} 
