#include <stdio.h>

int main(){
	int n;
	scanf("%d", &n);
	for(int i=1; i<=n; i++){
		int num[10];
		for(int j=1; j<=6; j++)
			scanf("%1d", &num[j]);
		if(num[1]+num[2]+num[3] == num[4]+num[5]+num[6])
			printf("You are lucky!\n");
		else
			printf("Wish you good luck.\n");
	}
	
	
	return 0;
}
