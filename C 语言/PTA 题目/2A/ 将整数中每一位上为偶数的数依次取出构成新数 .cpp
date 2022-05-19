#include <stdio.h> 

void fun (long s, long *t);

int main()
{ 
    long s, t;
    scanf("%ld", &s);
    fun(s, &t);
    printf("The result is: %ld\n", t);
    return 0;
}


/* 请在这里填写答案 */
void fun (long s, long *t) {
    int tmp, tt=1;
    *t = 0;
    while(s) {
        tmp = s%10;
        if(tmp % 2 == 0) {
            *t = (*t) + tmp*tt;
            tt *= 10;
        }
        s /= 10;
        
    }
}