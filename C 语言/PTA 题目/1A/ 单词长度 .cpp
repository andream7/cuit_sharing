#include <stdio.h>

int main(){
    char str[10000], ch;
    int start, end, len[1000], cnt = 0, flag = 0;
    for(int i=1; ; i++){
    	scanf("%c", &ch);
    	str[i] = ch;
    	if(ch == '.'){
    		str[i] = ' ';
    		break;
		}
    		
	}
	str[0] = ' ';
    for(int i=0; str[i] != '\0'; i++){
        if(str[i] != ' ' && str[i-1] == ' ')
            start = i, flag = 1;
        if(str[i] == ' ' && str[i-1] != ' ' && flag == 1)
            end = i, len[cnt++] = end - start, flag = 0;
    }
    for(int i=0; i<cnt; i++)
        i == 0 ? printf("%d", len[i]) : printf(" %d", len[i]);
    return 0;
}