#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

void signal_handler(int sig) {
	printf("Bye, World!\n");
	exit(0);
}

int main() {
	pid_t pid = fork();
	if (pid == 0) {
		// 子进程
		signal(SIGTERM, signal_handler);
		while (1) {
			printf("I am Child Process, alive!\n");
			sleep(2);
		}
	} else if (pid > 0) {
		// 父进程
		char answer;
		do {
			printf("To terminate Child Process. Yes or No?\n");
			scanf(" %c", &answer);
			if (answer == 'Y' || answer == 'y') {
				kill(pid, SIGTERM);
				wait(NULL);  
				break;
			} else {
				sleep(2);
			}
		} while (answer != 'Y' && answer != 'y');
	} else {
		perror("fork");
		exit(1);
	}
	
	return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

void signal_handler(int sig) {
	printf("Bye, World!\n");
	exit(0);
}

int main() {
	pid_t pid = fork();
	
	if (pid == 0) {
		// 子进程
		signal(SIGTERM, signal_handler);
		while (1) {
			printf("I am Child Process, alive!\n");
			sleep(2);
		}
	} else if (pid > 0) {
		// 父进程
		char answer;
		do {
			printf("To terminate Child Process. Yes or No?\n");
			scanf(" %c", &answer);
			if (answer == 'Y' || answer == 'y') {
				kill(pid, SIGTERM);
				wait(NULL);  
				break;
			} else {
				sleep(2);
			}
		} while (answer != 'Y' && answer != 'y');
	} else {
		perror("fork");
		exit(1);
	}
	
	return 0;
}

