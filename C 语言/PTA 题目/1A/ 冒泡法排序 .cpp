#include <stdio.h>

int main(){
	int n, k, num[200], t;
	scanf("%d%d", &n, &k);
	for(int i=0; i<n; i++)
		scanf("%d", &num[i]);
	for(int i=0; i<k; i++){
		for(int j=0; j<n-i-1; j++){
			if(num[j] > num[j+1])
				t = num[j], num[j] = num[j+1], num[j+1] = t;
		}
	}
	for(int i=0; i<n; i++)
		i==0 ? printf("%d", num[i]) : printf(" %d", num[i]);
	return 0;
}
