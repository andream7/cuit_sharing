
#include<stdio.h>

#define M 10
#define N 4

void Input(float a[][N],int m);
float Sum(float a[][N],int m);


int main(void)
{
        float num[M][N],sum;

        int m;
        scanf("%d", &m);
        Input(num,m); 

        sum = Sum(num,m);
        printf("sum = %.2f\n", sum);
        return 0;
}

/* 请在这里填写答案 */
void Input(float a[][N],int m){
    for(int i=0; i<m; i++)
        for(int j=0; j<4; j++)
            scanf("%f", &a[i][j]);

}
float Sum(float a[][N],int m){
    float sum = 0;
    for(int i=1; i<m-1; i++){
        for(int j=1; j<3; j++){
            sum += a[i][j];
        }
    }
    return sum;
}
