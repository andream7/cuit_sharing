#include <stdio.h>
#include <string.h>

int main(){
    char str[200];
    gets(str);
    int num[10] = {0}, flag = 0;
    for(int i=0; i<strlen(str); i++){
        if(str[i]>='0' && str[i]<='9')
            num[str[i]-'0'] ++;
    }
    for(int i=0; i<10; i++){
        if(num[i]){
        	flag = 1;
            printf("%d-%d\n", i, num[i]);
        }
    }
    if(!flag)	printf("None!\n");
    return 0;
}