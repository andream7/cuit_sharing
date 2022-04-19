#include <stdio.h>
#include <string.h>

int main(){
    char s1[100], s2[100];
    
    gets(s1);
    gets(s2);
    while(1){
    	int flag = 0;
	    for(int i=0; s1[i] != '\0'; i++){
	    	char t1[100] = {'\0'}, t2[100] = {'\0'}, a[100] = {'\0'};
	        if(s1[i] == s2[0]){
	            strncpy(a, s1+i, strlen(s2));
	//            printf("len: %d\n", strlen(a)); 
	//            puts(a);
	            if(strcmp(a, s2) == 0){
	            	flag = 1;
	//				printf("i = %d\n", i);
	                strncpy(t1, s1, i);
	//                puts(t1);
	                strncpy(t2, s1+i+strlen(s2), strlen(s1)-i);
	//                puts(t2);
	                strcpy(s1, strcat(t1, t2)); 
	            }
	        }
	        
	    }
		if(!flag)	break;    	
	}

    puts(s1);
    return 0;
}

