#include <stdio.h>

int main(){
    int n, t, num[1000+5], max = 0, con, maxnum;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", num+i);
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<n-i-1; j++){
            if(num[j] > num[j+1]){
                t = num[j];
                num[j] = num[j+1];
                num[j+1] = t;
            }
        }
    }
    t = num[0], con = 1, max = 1, maxnum = num[0];
    for(int i=1; i<n; i++){
        if(num[i] == t){
            con++;
        }else{     
            t = num[i];
            con = 1;
        }
        con > max ? max = con, maxnum = t : 0;
    }
    printf("%d %d", maxnum, max);
    return 0;
}
//10 3 2 -1 5 3 4 3 0 3 2