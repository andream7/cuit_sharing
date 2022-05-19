#include <stdio.h>

int main(){
	char ch, num[100];
	int cnt = 0;
	while(~scanf("%c", &ch)&&(ch != ' '&& ch != '\n')){
		num[cnt++] = ch;
	}
	for(int i=0; i<cnt; i++){
		printf("%c ", num[i]);
	}
	return 0;
}
