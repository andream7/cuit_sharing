#include <stdio.h>
#include <string.h>

void Conv( char *p );
int main()
{
        char str[64];  

        gets(str);
        Conv(str);
        printf("After changing:   %s\n", str);
        return 0;
}


/* 请在这里填写答案 */
void Conv( char *p ) {
    for(char *a = p; a < p + strlen(p); a++) {
        if((a == p || *(a-1) == ' ') && *a <= 'z' && *a >= 'a') {
            *a = *a - 32;
        }
    }

}