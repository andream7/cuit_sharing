#include <stdio.h>
/* userCode(<80字符): 自定义函数之原型声明 */
void Input ( char *str );
int Split_Count ( char *str,char **pStr );

int main(void)
{
    char String[81]={0}, *pString[64];
    int i=0, count;

    Input(String);

    count = Split_Count(String,  pString);

    printf("%d Words: ", count);
    for (i=0; i<count-1; i++)
    {
         printf("%s-", pString[i]);
    }
    printf("%s", pString[count-1]);
    putchar('\n');
    return 0;
}
/* 请在这里填写答案 */
#include <stdlib.h>
void Input ( char *str ) {
    char ch; int cnt = 0, i = 0;
    bool flag = 0;
    while((cnt < 80) && (ch = getchar()) && ch != '\n') {
    	if((ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') || (ch == ' ')) cnt++;
        if((ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') || (ch == ' ' && (flag && *(str+i-1) != ' ')))
            *(str+i++) = ch, flag = 1;
    }
    if(*(str+i-1) == ' ')
    	*(str+i-1) = '\0';
    else
    	*(str+i) = '\0';
//    printf("%s\n", str);
}
//aa aaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa
int Split_Count ( char *str,char **pStr ) {
    int cnt = 0, pos = 0;
//     printf("1%s1\n", str);
	*(pStr) = (char *) malloc(1000);
    for(int i=0; *(str+i) != '\0'; i++) {
        if(str[i] == ' ') {        	
//        	printf("pos: %d\n", pos);
			*(*(pStr+cnt) + pos) = '\0';            
            *(pStr+cnt+1) = (char *) malloc(1000);
//			printf("pos: %d\n", pos);
            cnt++;
            pos = 0;
//            printf("pos: %d\n", pos);
            continue;
        }
//        printf("str[%d]: %c\n", i, str[i]);
//        printf("*(*(pStr+cnt) + pos): %c\n", *(*(pStr+cnt) + pos));
        *(*(pStr+cnt) + pos) = str[i];
        pos++;
//        printf("pos: %d\n", pos);
//        printf("%s\n", *(pStr+cnt));
    }
    *(*(pStr+cnt) + pos) = '\0'; 
    if(cnt == 0 && pos == 0)    return 0;
    return cnt+1;
}