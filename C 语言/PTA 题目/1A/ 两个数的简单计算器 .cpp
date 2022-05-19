#include <stdio.h>

int main(){
    int a, b, ans = 0;
    char opt;
    scanf("%d %c %d", &a, &opt, &b);
    switch(opt){
        case '*':   ans = a*b; break;
        case '/':   ans = a/b; break;
        case '+':   ans = a+b; break;
        case '-':   ans = a-b; break;
        case '%':   ans = a%b; break;
        default:    printf("ERROR");
        return 0; 
    }
    printf("%d", ans);
    return 0;
}