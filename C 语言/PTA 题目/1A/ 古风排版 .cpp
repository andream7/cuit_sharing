#include <stdio.h>
#include <string.h>

int main(){
    int n;
    scanf("%d", &n);
    getchar();
    int cnt = 0, first = 1;
    char str[2000];
    while(scanf("%c", &str[cnt])){
    	if(first == 1 && str[cnt] == ' ')
    		continue;
    	if(str[cnt] == '\n'){
    		str[cnt] = '\0';
    		break;
		}
    	first = 0;
    	cnt++;
	}
    /*int flag = 0;
    for(int i=strlen(str)-1; i>=0; i--){
    	if(str[i] != ' '){
    		break;
		}else{
			str[i] = '\0';
			while(i--){
				if(str[i] != ' '){
					flag = 1;
					break;
				}					
				str[i] = '\0';
			}
			if(flag)	break;
		}
	}*/
    char ans[2000] = {'\0'};
    for(int i=0; i<n; i++){      
        cnt = 0;
        for(int j=i; j<strlen(str); j+=n){
            ans[cnt++] = str[j];
        }
//        printf("1");
//		printf("%d  %d\n", cnt, strlen(str)/n);
        if(strlen(str)%n != 0 && cnt <= strlen(str)/n)
        	printf(" ");		
        for(int j=cnt-1; j>=0; j--)
        	printf("%c", ans[j]);
//        printf("1");	
        printf("\n");
    }
    return 0;
}
// T  h  i  s     i  s     a     t   e   s   t       c   a   s   e
// 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18
//4
//This is a test case123456