#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define BUFFER_SIZE 10

int buffer[BUFFER_SIZE];
int in = 0;
int out = 0;

sem_t empty;
sem_t full;
sem_t mutex;

void *producer(void *arg) {
	int item;
	while (1) {
		item = rand() % 100; // 生产一个随机产品
		sem_wait(&empty); // 等待空闲位置
		sem_wait(&mutex); // 进入临界区
		buffer[in] = item;
		in = (in + 1) % BUFFER_SIZE;
		printf("Produced %d\n", item);
		sem_post(&mutex); // 离开临界区
		sem_post(&full); // 增加产品数
		sleep(1);
	}
}

void *consumer(void *arg) {
	int item;
	while (1) {
		sem_wait(&full); // 等待产品
		sem_wait(&mutex); // 进入临界区
		item = buffer[out];
		out = (out + 1) % BUFFER_SIZE;
		printf("Consumed %d\n", item);
		sem_post(&mutex); // 离开临界区
		sem_post(&empty); // 增加空闲位置数
		sleep(1);
	}
}

int main() {
	pthread_t prod, cons;
	
	sem_init(&empty, 0, BUFFER_SIZE); // 初始化empty信号量，初始值为BUFFER_SIZE
	sem_init(&full, 0, 0); // 初始化full信号量，初始值为0
	sem_init(&mutex, 0, 1); // 初始化互斥锁
	
	pthread_create(&prod, NULL, producer, NULL);
	pthread_create(&cons, NULL, consumer, NULL);
	
	pthread_join(prod, NULL);
	pthread_join(cons, NULL);
	
	sem_destroy(&empty);
	sem_destroy(&full);
	sem_destroy(&mutex);
	
	return 0;
}

