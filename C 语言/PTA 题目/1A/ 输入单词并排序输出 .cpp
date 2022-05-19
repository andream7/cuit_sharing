#include<stdio.h>
#include<string.h>
int input(char ar2[][21]);
void paixu(char ar2[][21], int n);
void printArr(char ar2[][21], int n);
int main(void)
{
    char arr[10][21]={0};
    int n;
    n=input(arr);    
    paixu(arr,n);
    printArr(arr,n);

    return 0;
}
/* 请在这里填写答案 */
int input(char ar2[][21]){
    char str[30];
    int cnt = 0;
    while(~scanf("%s", str)){
        if(strcmp(str, "*END*") == 0 || cnt == 10)
            break;
        strcpy(ar2[cnt++], str);
    }
    return cnt;
}
// 其中函数的返回值等于输入的有效单词的数目。
void paixu(char ar2[][21], int n){
    for(int i=0; i<n; i++){
        for(int j=0; j<n-i-1; j++){
            if(strcmp(ar2[j], ar2[j+1]) > 0){
                char str[30];
                strcpy(str, ar2[j]);
                strcpy(ar2[j], ar2[j+1]);
                strcpy(ar2[j+1], str);
            }
        }
    }
}
// 其中函数完成对ar2数组中的n个字符串进行排序。
void printArr(char ar2[][21], int n){
    if(n == 0){
        printf("NO WORD");
        return ;
    }
    printf("After sorted:\n");
    for(int i=0; i<n; i++){
        i == 0 ? printf("%s", ar2[i]) : printf(" %s", ar2[i]);
    }
}
// 其中函数完成对ar2数组中的n个字符串进行输出。