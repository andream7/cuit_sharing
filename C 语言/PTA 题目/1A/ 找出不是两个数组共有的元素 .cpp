#include <stdio.h>

int main(){
    int a[30], b[30], n, m, cnt = 0;
    scanf("%d", &n);
    for(int i=0; i<n; i++)
        scanf("%d", &a[i]);
    scanf("%d", &m);
    for(int i=0; i<m; i++)
        scanf("%d", &b[i]);
    for(int i=0; i<n; i++){
        int flag = 0;
        for(int j=0; j<m; j++){
            if(a[i] == b[j]){
                flag = 1;
                break;
            }
        }
		for(int k=0; k<i; k++){
            if(a[i] == a[k]){
            	flag = 1;
                break;
			}        
        }
        if(!flag)   cnt++ == 0 ? printf("%d", a[i]) : printf(" %d", a[i]);
    }
    for(int i=0; i<m; i++){
        int flag = 0;
        for(int j=0; j<n; j++){
            if(b[i] == a[j]){
                flag = 1;    
                break;
            }
        }
         for(int k=0; k<i; k++){
            if(b[i] == b[k]){
            	flag = 1;
            	break;
			}              
        }
        if(!flag)   cnt++ == 0 ? printf("%d", b[i]) : printf(" %d", b[i]);
    }
    return 0;
}