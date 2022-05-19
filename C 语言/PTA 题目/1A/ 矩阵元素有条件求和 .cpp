#include <stdio.h>

int main(){
	int m, n, num[200][200] = {0};
	int x, y, sum = 0;
	scanf("%d%d", &m, &n);
	for(int i=1; i<=m; i++){
		for(int j=1; j<=n; j++){
			scanf("%d", &num[i][j]);
			if(num[i][j] == 0)
				x = i, y = j;
		}
	}
	for(int i=-1; i<=1; i++)
		for(int j=-1; j<=1; j++)
			num[x+i][y+j] = 0;
	for(int i=1; i<=m; i++)
		for(int j=1; j<=n; j++)
			sum += num[i][j];
	printf("%d", sum);
	return 0;
}
