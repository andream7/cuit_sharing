#include <stdio.h>

int main(){
    
    int n;
    scanf("%d", &n);
    getchar();
    for(int t=0; t<n; t++){
    	char str[80];
    	gets(str);
		int num[120] = {0};
    	int cnt = 0;
        char ch;
        int temp = 0, start, end, flag = 0;
        while(str[cnt] != '\0'){
//            scanf("%c", &ch);
			ch = str[cnt++];
            if(ch == ' ')   continue;
            if(ch>='0' && ch<='9')
            	temp = temp*10 + ch-'0';
            
            if(ch == '-'){
                start = temp;
                temp = 0;
                flag = 1;
                continue;
            }
            
            if(ch == ','){
                if(flag){
                    end = temp;
                    for(int i=start; i<=end; i++)
                        num[i]++;
                    flag = start = end = temp = 0;
                }else{
                    num[temp]++;
                    temp = 0;
                }
                
            }
//			
//			if(ch == '\n'){
//                break;
//            }
        }
        if(flag){
                    end = temp;
                    for(int i=start; i<=end; i++)
                        num[i]++;
                    flag = start = end = temp = 0;
                }else{
                    num[temp]++;
                    temp = 0;
                }
        int first = 1;
        for(int i=0; i<100; i++){
            if(num[i])
                first == 1 ? printf("%d", i), first = 0 : printf(",%d", i);
        }
        printf("\n");
    }

    return 0;
}
