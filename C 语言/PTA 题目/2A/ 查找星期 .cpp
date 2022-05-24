#include <stdio.h>
#include <string.h>

#define MAXS 80

int getindex( char *s );

int main()
{
    int n;
    char s[MAXS];

    scanf("%s", s);
    n = getindex(s);
    if ( n==-1 ) printf("wrong input!\n");
    else printf("%d\n", n);

    return 0;
}

/* 你的代码将被嵌在这里 */
int getindex( char *s ) {
    if(!strcmp(s, "Sunday")) return 0;
    else if(!strcmp(s, "Monday"))    return 1;
    else if(!strcmp(s, "Tuesday"))   return 2;
    else if(!strcmp(s, "Wednesday")) return 3;
    else if(!strcmp(s, "Thursday"))  return 4;
    else if(!strcmp(s, "Friday"))    return 5;
    else if(!strcmp(s, "Saturday"))  return 6;
    return -1;
}