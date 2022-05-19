#include <stdio.h>
#include <string.h>

#define MAXS 10

void Shift( char s[] );

void GetString( char s[] ); /* 实现细节在此不表 */

int main()
{
    char s[MAXS];

    GetString(s);
    Shift(s);
    printf("%s\n", s);

    return 0; 
}
/* 你的代码将被嵌在这里 */
void Shift( char s[] ) {
	int len = strlen(s);
    for(int i=0; i<3; i++) {
        s[len+i] = s[i];
    }
    for(int i=3; i<len+3; i++) {
    	s[i-3] = s[i];
	}
    s[len] = '\0';
}
