#include <stdio.h>

int main(){
    int n, num[10][10];
    // int max[10], min[10];
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            scanf("%d", &num[i][j]);
        }
    }
    
    for(int i=0; i<n; i++){
    	int max = -0x7ffffff, maxx, maxy;
        int x = i;
        for(int j=0; j<n; j++){
            if(num[i][j] > max){
                max = num[i][j];
                maxx = i;
                maxy = j;
            }
        }
        for(int y=0; y<n; y++){
            if(num[x][y] == max){
                maxx = x;
                maxy = y;
//                printf("%d %d\n", x, y);
                int min = 0x7fffffff, minx, miny;
                for(int xx=0; xx<n; xx++){
                    if(num[xx][y] <= min){
                        min = num[xx][y];
                        minx = xx;
                        miny = y;
                    }
                }
//                printf("max = %d  min = %d\n", max, min);
                if(min == max){
                    printf("%d %d", x, y);
                    return 0;
                }
            }
        }
    }
    printf("NONE");
    return 0;
}