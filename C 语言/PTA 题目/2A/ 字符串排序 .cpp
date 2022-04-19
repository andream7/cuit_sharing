#include<stdio.h>
#include<string.h>

#define N 5


void sort_Str(char **p);

int main(void)        
{
    int i;
    char *pstr[N], str[N][81];

    for (i=0; i<N; i++)
    {
        pstr[i] = str[i];
    }

    for (i=0; i<N; i++) 
    {
        gets(pstr[i]);
    }

    sort_Str(pstr);

    for (i=0; i<N; i++)
    {
        printf("%s\n", pstr[i]);
    }

    return 0;
}

/* 请在这里填写答案 */
void sort_Str(char **p) {
    for(int i=0; i<5; i++) {
        for(int j=0; j<4-i; j++) {
            if(strcmp(*(p+j), *(p+j+1)) > 0) {
                char t[80] = {'\0'};
                strcpy(t, *(p+j));
                strcpy(*(p+j), *(p+j+1));
                strcpy(*(p+j+1), t);
            }
        }
    }
}