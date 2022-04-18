#include <stdio.h>

int main(){
    int max = -0x7fffffff, maxx, maxy;
    int num[21][21];
    int m;
    scanf("%d", &m);
    for(int i=0; i<m; i++){
        for(int j=0; j<m; j++){
            scanf("%d", &num[i][j]);
            if(num[i][j] > max){
                max = num[i][j];
                maxx = i;
                maxy = j;
            }
        }
    }

    printf("max=%d,i=%d,j=%d", max, maxx, maxy);

    return 0;
}