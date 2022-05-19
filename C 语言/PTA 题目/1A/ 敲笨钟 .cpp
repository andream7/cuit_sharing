#include <stdio.h>
#include <string.h>
int main(){
    int n;
    scanf("%d", &n);
    getchar();
    char str[200];
    for(int i=0; i<n; i++){
        gets(str);
        int pos1 = strchr(str, ',') - str - 3;
        int pos2 = strchr(str, '.') - str - 3;
        char t1[200] = {'\0'}, t2[200] = {'\0'};
        strncpy(t1, str + pos1, 3);
        strncpy(t2, str + pos2, 3);
        if(strcmp(t1, t2) == 0 && strcmp(t1, "ong") == 0){
            int cnt = 0, pos3;
            for(int i=strlen(str)-1; ; i--){
                if(str[i] == ' '){
                    cnt ++;
                    if(cnt == 3){
                        pos3 = i;
                        break;
                    }
                }
            }
            char ans[200];
            strncpy(t1, str, pos3+1);
            strcat(t1, "qiao ben zhong.");
            puts(t1);
        }else{
            printf("Skipped\n");
        }
    }

    return 0;
}
/*
5
xun zhang zhai ju lao diao chong, xiao gua yu gong.
tian sheng wo cai bi you yong, qian jin san jin huan fu lai.
xue zhui rou zhi leng wei rong, an xiao chen jing shu wei long.
zuo ye xing chen zuo ye feng, hua lou xi pan gui tang dong.
ren xian gui hua luo, ye jing chun shan kong.
*/