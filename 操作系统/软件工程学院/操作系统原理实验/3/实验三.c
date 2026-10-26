#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define NUM_INSTRUCTIONS 320
#define PAGE_SIZE 10
#define MAX_PAGES (NUM_INSTRUCTIONS / PAGE_SIZE)

// 页面置换算法函数原型
void fifo(int pages[], int num_pages, int capacity);
void lru(int pages[], int num_pages, int capacity);
void opt(int pages[], int num_pages, int capacity);

int main() {
	int instructions[NUM_INSTRUCTIONS];
	int pages[NUM_INSTRUCTIONS];
	int i;
	
	// 设置随机种子
	srand((unsigned)time(NULL));
	
	// 生成随机指令序列
	for (i = 0; i < NUM_INSTRUCTIONS; i++) {
		instructions[i] = rand() % NUM_INSTRUCTIONS;
	}
	
	// 转换指令序列为页面序列
	for (i = 0; i < NUM_INSTRUCTIONS; i++) {
		pages[i] = instructions[i] / PAGE_SIZE;
	}
	
	// 运行不同的页面置换算法
	printf("FIFO Page Replacement Algorithm Results:\n");
	for (i = 4; i <= 32; i++) {
		fifo(pages, NUM_INSTRUCTIONS, i);
	}
	
	printf("\nLRU Page Replacement Algorithm Results:\n");
	for (i = 4; i <= 32; i++) {
		lru(pages, NUM_INSTRUCTIONS, i);
	}
	
	printf("\nOPT Page Replacement Algorithm Results:\n");
	for (i = 4; i <= 32; i++) {
		opt(pages, NUM_INSTRUCTIONS, i);
	}
	
	return 0;
}

// 先进先出页面置换算法
void fifo(int pages[], int num_pages, int capacity) {
	int frame[capacity];
	int i, j, k, flag, fault = 0;
	for (i = 0; i < capacity; i++) {
		frame[i] = -1;
	}
	
	for (i = 0; i < num_pages; i++) {
		flag = 0;
		for (j = 0; j < capacity; j++) {
			if (frame[j] == pages[i]) {
				flag = 1;
				break;
			}
		}
		if (!flag) {
			for (k = 0; k < capacity - 1; k++) {
				frame[k] = frame[k + 1];
			}
			frame[k] = pages[i];
			fault++;
		}
	}
	printf("Memory Capacity: %d, Page Faults: %d, Hit Rate: %.2f%%\n", capacity, fault, 100 * (1 - (float)fault / num_pages));
}

// 最近最少使用页面置换算法
void lru(int pages[], int num_pages, int capacity) {
	int frame[capacity];
	int time[capacity];
	int i, j, pos, fault = 0, least;
	for (i = 0; i < capacity; i++) {
		frame[i] = -1;
		time[i] = 0;
	}
	
	for (i = 0; i < num_pages; i++) {
		pos = -1;
		for (j = 0; j < capacity; j++) {
			if (frame[j] == pages[i]) {
				pos = j;
				break;
			}
		}
		
		if (pos == -1) {
			least = 0;
			for (j = 1; j < capacity; j++) {
				if (time[j] < time[least]) {
					least = j;
				}
			}
			frame[least] = pages[i];
			fault++;
		}
		
		for (j = 0; j < capacity; j++) {
			if (j == pos) {
				time[j] = i;
			} else if (frame[j] != -1) {
				time[j]++;
			}
		}
	}
	printf("Memory Capacity: %d, Page Faults: %d, Hit Rate: %.2f%%\n", capacity, fault, 100 * (1 - (float)fault / num_pages));
}

// 最优页面置换算法
void opt(int pages[], int num_pages, int capacity) {
	int frame[capacity];
	int i, j, k, pos, fault = 0, farthest, temp;
	for (i = 0; i < capacity; i++) {
		frame[i] = -1;
	}
	
	for (i = 0; i < num_pages; i++) {
		pos = -1;
		for (j = 0; j < capacity; j++) {
			if (frame[j] == pages[i]) {
				pos = j;
				break;
			}
		}
		
		if (pos == -1) {
			farthest = -1;
			for (j = 0; j < capacity; j++) {
				for (k = i + 1; k < num_pages; k++) {
					if (frame[j] == pages[k]) {
						if (k > farthest) {
							farthest = k;
							pos = j;
						}
						break;
					}
				}
				if (k == num_pages) {
					pos = j;
					break;
				}
			}
			frame[pos] = pages[i];
			fault++;
		}
	}
	printf("Memory Capacity: %d, Page Faults: %d, Hit Rate: %.2f%%\n", capacity, fault, 100 * (1 - (float)fault / num_pages));
}

