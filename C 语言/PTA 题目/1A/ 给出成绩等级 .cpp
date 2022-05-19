#include <stdio.h>

int main(){
    double s;
    do{
        scanf("%lf", &s);
    }while(s<0 || s>100);

    if(s >= 90) printf("score=%.1lf,grade=A", s);
    else if(s >= 80 && s<90) printf("score=%.1lf,grade=B", s);
    else if(s >= 70 && s<80) printf("score=%.1lf,grade=C", s);
    else if(s >= 60 && s<70) printf("score=%.1lf,grade=D", s);
    else if(s < 60) printf("score=%.1lf,grade=E", s);

    return 0;
}