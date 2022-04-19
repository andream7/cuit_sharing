#include <stdio.h>

int main(){
    int num[10], cnt = 0;
    for(int i=0; cnt<10; i++){
    	scanf("%d", &num[cnt]);
    	if(num[cnt] <= num[cnt-1] && cnt != 0)
    		continue;
    	cnt++;
	}
    int x;
    scanf("%d", &x);
    for(int i=0; i<10; i++)
        if(num[i] == x){
            printf("%d", i+1);
            return 0;
        }
    printf("Not Find!");
    return 0;
}