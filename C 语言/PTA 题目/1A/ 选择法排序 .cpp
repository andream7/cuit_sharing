#include <stdio.h>

int main()
{  
    int num[10], n;
    scanf("%d", &n); 
    for(int i=0; i<n; i++){
        scanf("%d", &num[i]);
    }
    for(int i=0; i<n; i++){
    	int max = num[i], maxnum = i, temp;
        for(int j=i; j<n; j++){
            max < num[j] ? max = num[j], maxnum = j : 0;
        }
        temp = num[i], num[i] = max, num[maxnum] = temp;
    }
    for(int i=0; i<n; i++){
        i == n-1 ? printf("%d", num[i]) : printf("%d ", num[i]);
    }
    return 0;
}