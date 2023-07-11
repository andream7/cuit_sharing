#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include<string.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
long int Eular_79(long int n_79) {
	int res = n_79;
	for (int i = 2; i <= sqrt(n_79); i++) { //判断n是否为质数
		if (n_79 % i == 0) {
			res = res / i * (i - 1);//res=res*(1-1/i)先进行除法防止溢出
		}
		while ( n_79 % i == 0 ) {
			n_79 /= i;
		}
	}
	if (n_79 > 1) {
		res = res / n_79 * (n_79 - 1);
	}
	return res;
}

int key_generate_79(int etemp_79, int* temp_79) {
	int i = 0;
	while (1) {
		if (etemp_79 == 0) {
			break;
		}
		*(temp_79 + i) = etemp_79 % 2;
		etemp_79 = etemp_79 / 2;
		i++;
	}
	return i;
}

//平方乘
long int LRFun_79(long int a_79, long int n_79, int key_79[], int klen_79) {
	printf("平方乘\n");
	int s = 1;
	for (int i = klen_79 - 1; i >= 0; i--) {
		s = (s * s) % n_79;
		if (key_79[i] == 1) {
			s = (s * a_79) % n_79;
		}
		printf("i=%d, %d\n", i, s);
	}
	return s;
}

//模重复平方法
long int RLFun_79(long int a_79, long int n_79, int key_79[], int klen_79) {

	printf("模重复平方 \n");
	long int s = 1;
	for (int i = 0; i < klen_79; i++) {
		if (key_79[i] == 1) {
			s = (s * a_79) % n_79;
		}
		a_79 = (a_79 * a_79) % n_79;
		printf("i=%d, %ld\n", i, s);
	}
	return s;
}


//扩展欧几里得
long int Exgcd_79(long int a, long int b, long int &x, long int &y) {
	if (b == 0) {
		x = 1;
		y = 0;
		return a;
	}
	long int r = Exgcd_79(b, a % b, x, y); //ax1+by1=bx2+[a-(a/b)b]y2=ay2+bx2-b(a/b)y2
	int temp = x; //由于a和b相同，所以有x1=y2 y1=x2-(a/b)y2
	x = y;
	y = temp - a / b * y;
	return r;
}


//求a的逆元x
long int mod_reverse_79(long int a_79, long n_79) {
	long int r, x, y;
	r = Exgcd_79(a_79, n_79, x, y);
	if (r == 1)
		return (x % n_79 + n_79) % n_79; //输出正数
	else
		return -1;
}

//转换为模数n进制
int MessageProcess_79(long int num, long int array[], int n) {
	long int temp = num;
	int i;

	for (i = 0; temp > 0; i++) {
		array[i] = temp % n;
		temp = temp / n;
	}
	return i;
}

int main() {
	long int e_79, p_79, q_79, n_79, d_79 = 1;
	int msg_79, mimsg_79, klen_79;
	int temp[32] = {0};
	int temp1[32] = {0};
	long int array_79[30] = {0};
	long int mi_array_79[30] = {0};
	
	printf("请顺序输入公钥，两素数：e p q:");
	scanf("%ld %ld %ld", &e_79, &p_79, &q_79);
	n_79 = p_79 * q_79;
	printf("输出模数n：%ld\n", n_79);
	printf("输出模数n的欧拉函数：%ld\n", Eular_79(n_79));
	d_79 = mod_reverse_79(e_79, Eular_79(n_79));

	printf("输出模数私钥d：%ld\n", d_79);
	printf("请输入要加密的明文m：");
	char str[30] = {0};
	scanf("%s", str);
//	scanf("%d", &msg_79);

	for(int k = 0; k < (int)strlen(str); k++){
		printf("对第%d个字符进行加密", k);
		msg_79 = str[k];
		printf("RSA加密模幂运算底数 指数 模数：%d %ld %ld\n", msg_79, e_79, n_79);
			
		int array_len = MessageProcess_79(msg_79, array_79, n_79);
		int msg_final_79 = 0;
		int i, j;
		
		for(i = 0; i < array_len; i++){
			printf("RSA第%d组 底数 指数 模数：%ld %ld %ld\n", i, array_79[i], e_79, n_79);
				
			klen_79 = key_generate_79(e_79, temp);
			mimsg_79 = LRFun_79(array_79[i], n_79, temp, klen_79);
			printf("加密后的密文为：%d", mimsg_79);
			mi_array_79[i] = mimsg_79;
		
			printf("\nRSA解密模幂运算底数 指数 模数：%d %ld %ld\n", mimsg_79, d_79, n_79);
			klen_79 = key_generate_79(d_79, temp1);
			msg_79 = RLFun_79(mimsg_79, n_79, temp1, klen_79);
			printf("解密后的明文为：%d\n\n", msg_79);
			
			array_79[i] = msg_79;
		}
		for(j = 0; j < array_len; j++){
				if(j == 0){
					msg_final_79 += array_79[j];
					continue;
				}
				msg_final_79 += array_79[j] * n_79;
			}
			
		printf("最终加密后的密文为："); 
		for(i=0;i<array_len;i++){
			printf("%ld", mi_array_79[i]);
		}
		printf("\n最终解密后的明文为：%c\n\n\n", msg_final_79);
	}
	return 0;
}
