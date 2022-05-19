#include <stdio.h>

int read(){
    char ch; int k = 1, t = 0;
    do{
        ch = getchar();
        if(ch == '-')   k = -1;
    }while(ch<'0' || ch>'9');
    do{
        t = (t<<1) + (t<<3) + (ch^48);
        ch = getchar();
    }while(ch != ' ' && ch != '\n');
    return k*t;
}

int main(){
    int a[10], b[10], sum = 0;
    for(int i=0; i<5; i++)
        a[i] = read();
    for(int j=0; j<5; j++)
        b[j] = read();
    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            sum += a[i]*b[j];
        }
    }
    printf("sum=%d", sum);
    return 0;
}