#include <stdio.h>
#include <string>
#include <string.h>
#include <iostream>
#include <stdlib.h>
#include <algorithm>
using namespace std;

int main(){
    int n;
    scanf("%d", &n);
    getchar();
    for(int i=0; i<n; i++){
    	string str;
    	int cnt = 0, first = 0;
    	char ch;
//    	getline(cin, str);
    	while(~scanf("%c", &ch) && ch != '\n'){
    		if(!first && ch == ' ')
    			continue;
    		if(first == 0){
    			first = 1;
//    			str[cnt++] = ' ';
//    			str.push_back(' ');
			}
    		
    		if(ch == ' ' && str[cnt-1] == ' ')
    			continue;
    		if(ch>='A'&&ch<='Z'&&ch!='I')
                ch += 32;
    		if((ch<'a'||ch>'z')&&ch!='I'&&str[str.length()-1] == ' '&&(ch<'0'||ch>'9')){
//    			str[cnt-1] = ch;
//				str.pop_back();
//				str.push_back(ch);
				str[str.length()-1] = ch;
				continue;
			}
//    		str[cnt++] = ch;
			str.push_back(ch);
		}
//		str.push_back(' ');
//		cout << str << endl;
//    	cout << str.find("can you") << endl << str.npos;
        while(str.find("?") != str.npos)	
			str.replace(str.find("?"), 1, "!");
		while(str.find(" me") != str.npos)	
			str.replace(str.find(" me"), 3, " you");
		while(str.find(" I ") != str.npos)	
			str.replace(str.find(" I "), 3, " you");    
        while(str.find("can you") != str.npos)
			str.replace(str.find("can you"), 7, "I can");
		while(str.find("could you") != str.npos)	
			str.replace(str.find("could you"), 9, "I could");
		cout << "AI: " << str << endl;
	}

    return 0;
}