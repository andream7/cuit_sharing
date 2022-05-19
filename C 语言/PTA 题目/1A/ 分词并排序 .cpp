
#include<stdio.h>
#include<string.h>
void MyGets(char ar1[],int n);  
void split_sort(char ar1[]); 

int main(void)
{
    char arr1[100]={0};

    MyGets(arr1,100);
    printf("Valid string:\n");
    puts(arr1);    

    printf("After Sorted :\n");
    split_sort(arr1);

    return 0;
}

/* ???????? */
void MyGets(char ar1[],int n){
    char ch;
    int cnt = 0;
    while((ch=getchar()) != '\n' && cnt < n){
        if(ch==' ' || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            ar1[cnt++] = ch;
        
    }
    ar1[cnt] = '\0';
//    puts(ar1);
}      //??????????????????ar1?,n???ar1???
void split_sort(char ar1[]){
    char str[1000][1000], cnt1 = 0, cnt2 = 0;
    for(int i=0; i<strlen(ar1); i++){
        if(ar1[i]==' '){
            if(ar1[i-1] == ' ' || i == 0) continue;
            cnt1++;
            cnt2 = 0;
            continue;
        }
        str[cnt1][cnt2++] = ar1[i];
    }
//    printf("%d\n", cnt1);

	for(int i=0; i<=cnt1; i++){
		for(int j=0; j<=cnt1-i-1; j++){
			if(strcmp(str[j], str[j+1]) > 0){
				char temp[1000];
				strcpy(temp, str[j]);
				strcpy(str[j], str[j+1]);
				strcpy(str[j+1], temp);
			}
		}
	}
	for(int i=0; i<=cnt1; i++){
		if(i == 0)
			printf("%s", str[i]);
		else if(strcmp(str[i], str[i-1]) == 0)
			continue;
		else printf("*%s", str[i]);
	}
}           //?????ar1????????????????