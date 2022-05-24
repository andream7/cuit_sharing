#include <stdio.h>

int main(){
	int n, cnt = 1;
	char ch;
	scanf("%d %c", &n, &ch);
	while(2*cnt*cnt-1 <= n){
		cnt ++;
	}
	cnt--;
	n = n - 2*cnt*cnt + 1;	
	for(int i=0, m=0; i<cnt; i++, m+=2){
		for(int j=0; j<i; j++)
			printf(" ");
		for(int j=cnt*2-1-m; j>0; j--)
			printf("%c", ch);
		printf("\n");
	}
	for(int i=cnt, m=cnt-1,c=3; i<cnt*2-1; i++, m--, c+=2){
		for(int j=1; j<m; j++)
			printf(" ");
		for(int j=1; j<=c; j++)
			printf("%c", ch); 
		printf("\n");
	}
	printf("%d", n); 
	return 0;
} 

