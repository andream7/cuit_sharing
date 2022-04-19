#include <stdio.h>
#include <string.h>
#include <math.h>

int main (){
	int a=0,i,j,s=0,s2=0,cnt=0,n,m,max,x,y;
	scanf("%d%d",&m,&n);
	if(m>n){
		a=m,m=n,n=a;
	}
	if(m==1)	m++;
	for(i=m;i<=n;i++){
		a=i,cnt=0;
		for(j=2;j<=i/2;j++){
			if(a%j==0){
				cnt++;
				break;
			}
		}
		if(cnt==0){
			s++;
			s2+=i;
		}
	}
	printf("%d %d",s,s2);
	
	
	
	
	return 0;
}