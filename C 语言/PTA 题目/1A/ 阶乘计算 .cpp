#include <stdio.h>
double fac();
int main(void)
{
    int i, n;
    double Sum = 0;
    scanf("%d", &n);
    for (i=1; i<=n; i++)
    {
        Sum += 1 / fac();
    }

    printf("S=1/1!+1/2!+...+1/%d!=%.15f", n, Sum);
    return 0;
}

/* 请在这里填写答案 */
double fac(){
    static int cnt = 0;
    cnt ++;
    double ans = 1;
    for(int i=1; i<=cnt; i++){
        ans *= i;
    }
    return ans;
}