#include <stdio.h>

static unsigned char Sbox[16 * 16] = {
// populate the Sbox matrix
	/* 0 1 2 3 4 5 6 7 8 9 a b c d e f */
	/*0*/ 0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76,
	/*1*/ 0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0,
	/*2*/ 0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15,
	/*3*/ 0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75,
	/*4*/ 0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84,
	/*5*/ 0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf,
	/*6*/ 0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8,
	/*7*/ 0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2,
	/*8*/ 0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73,
	/*9*/ 0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb,
	/*a*/ 0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79,
	/*b*/ 0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08,
	/*c*/ 0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a,
	/*d*/ 0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e,
	/*e*/ 0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf,
	/*f*/ 0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16
};
// 轮密钥加
void AddRoundKey_79(unsigned char input_79[4][4], unsigned char RoundKey_79[4][4]) {
	int i, j;
	for (j = 0; j < 4; j ++) {
		for (i = 0; i < 4; i ++)
			input_79[i][j] = input_79[i][j] ^ RoundKey_79[i][j];
	}
}

// 字节替换
void SubBytes_79(unsigned char input_79[4][4]) {
	int i, j;
	char high;
	char low;
	for (i = 0; i < 4; i ++) {
		for (j = 0; j < 4; j ++) {
			low = input_79[i][j] & 0x0F; //取低 4 位
			high = (input_79[i][j] >> 4) & 0x0f; //取高 4 位
			input_79[i][j] = Sbox[16 * high + low];
		}
	}
}

// 行移位 
void ShiftRows_79(unsigned char State[4][4]) {
    int i, j, k;
    int shiftnum = 0;
    char tmp;
    for (i = 0; i < 4; i ++) {
        for (j = 0; j < shiftnum; j ++) { //循环左移一次
            tmp = State[0][i];
            for (k = 0; k < 4 - 1; k ++) {
                State[k][i] = State[k + 1][i];
            }
            State[k][i] = tmp;
        }
        shiftnum ++; //移位次数+1
    }
}

// 列混合
 unsigned char gfmultby02(unsigned char value) {
     if ((value & 0x80) == 0) {
         return value << 1;
     } else {
         return (value << 1) ^ 0x1b;
     }
 }
 
 unsigned char gfmultby03(unsigned char value) {
     return gfmultby02(value) ^ value;
 }
 
void mixColumns_79(unsigned char state[4][4]) {
    unsigned char tmp[4][4];
    for (int i = 0; i < 4; i++) {
        tmp[i][0] = gfmultby02(state[i][0]) ^ gfmultby03(state[i][1]) ^ state[i][2] ^ state[i][3];
		tmp[i][1] = state[i][0] ^ gfmultby02(state[i][1]) ^ gfmultby03(state[i][2]) ^ state[i][3];
		tmp[i][2] = state[i][0] ^ state[i][1] ^ gfmultby02(state[i][2]) ^ gfmultby03(state[i][3]);
		tmp[i][3] = gfmultby03(state[i][0]) ^ state[i][1] ^ state[i][2] ^ gfmultby02(state[i][3]);
    }
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            state[i][j] = tmp[i][j];
        }
    }
}


unsigned char GenerateRoundKey_79(int num) {
	//默认密钥
	int key0[] = {43, 126, 21, 22, 40, 174, 210, 166, 171, 247, 21, 136, 9, 207, 79, 60};
	int i, j, m = 0, n = 0;
	int ri[] = {0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36};
	int k0[4], k1[4];
	int lun, r = 0;
	int cha[4][128];

	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			cha[j][i] = key0[m];
			m++;
		}
	}
	lun = num;
	n = 4;
	while (n < 4 * (lun + 1)) {

		if (n % 4 == 0) {
			k0[0] = cha[1][n - 1];
			k0[1] = cha[2][n - 1];
			k0[2] = cha[3][n - 1];
			k0[3] = cha[0][n - 1]; // 列移位
			for (i = 0; i < 4; i++) { //s盒替换
				k1[i] = Sbox[k0[i + (k0[i] % 16)]];
			}
			k1[0] = k1[0] ^ ri[r];
			for (i = 0; i < 4; i++) {
				cha[i][n] = cha[i][n - 4] ^ k1[i];
			}
			r++;
		} else {
			for (i = 0; i < 4; i++) {
				cha[i][n] = cha[i][n - 4] ^ cha[i][n - 1];
			}
		}
		n++;
	}

//output
	for (i = 0; i < 4; i++) {
		for (j = 4 * lun; j < 4 * (lun + 1); j++) {
			printf("%x ", cha[i][j]);
		}
		printf("\n");
	}
	return cha[4][4];
}

void Input(unsigned char input_79[4][4]) { //列项优先
	int i, j;
	for (i = 0; i < 4; i++) {
		for ( j = 0; j < 4; j++) {
			scanf("%hhX", &input_79[j][i]);
		}
	}
}

void Output(unsigned char input_79[4][4]) {
	int i, j;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (input_79[j][i] < 0x10)
				printf("0");
			printf("%X ", input_79[j][i]);
		}
		printf(("\n"));
	}
	printf("\n");
}

int main() {
	unsigned char Input_79[4][4];
	unsigned char PrimaryKey_79[4][4];
	printf("输入明文矩阵:\n");
	Input(Input_79);
	printf("\n输入初始密钥矩阵:\n");
	Input(PrimaryKey_79);

	printf("\nInitial state \n");
	Output(Input_79);
	printf("Round Key \n");
	Output(PrimaryKey_79);

	printf("Round 1\nAfterAddRoundKey\n");
	AddRoundKey_79(Input_79, PrimaryKey_79);
	Output(Input_79);

	printf("After SubBytes\n");
	SubBytes_79(Input_79);
	Output(Input_79);

	printf("After ShiftRows\n");
	ShiftRows_79(Input_79);
	Output(Input_79);

	printf("After MixColumns\n");
	mixColumns_79(Input_79);
	Output(Input_79);

	for (int i = 0; i < 10; i++) {
		//TODO
		printf("Round %d\n", i + 1);
		GenerateRoundKey_79(i);
		printf("\n");
		SubBytes_79(Input_79);
	}
	return 0;
}
