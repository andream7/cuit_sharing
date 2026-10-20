#include "main.h"
// 从文件中加载玩家数据
int loadPlayers(player players[]) {
	FILE* fp = fopen("players.dat", "rb");  //二进制模式（"rb"）
	if (fp == NULL) {
		return 0;
	}

	int n = 0;
	while (fread(&players[n], sizeof(player), 1, fp) == 1) {
		n++;
	}
	//fread从文件中读取数据，sizeof是读取数据的大小，i是读取数据项的数量，fp是通过fopen函数打开的文件指针
	fclose(fp);
	return n;
}

// 将玩家数据保存到文件中
void savePlayers(player players[], int n) {
	FILE* fp = fopen("players.dat", "wb");//创建一个players文件，写入二进制数据
	if (fp == NULL) {
		printf("未能保存玩家.\n");
		return;
	}

	fwrite(players, sizeof(player), n, fp);
	fclose(fp);
}

// 注册新玩家
void registerPlayer(player players[], int n) {
	if (n >= maxPlayers) {
		printf("已达到最大玩家数.\n");
		return;
	}

	player p;
	printf("请输入您的姓名: ");
	scanf("%s", p.name);

	// 检查是否有重复的用户名
	for (int i = 0; i < n; i++) {
		if (strcmp(players[i].name, p.name) == 0) {
			printf("此用户名已被占用.\n");
			return;
		}
	}

	printf("请输入您的密码: ");
	scanf("%s", p.password);
	p.score = 0;

	players[n] = p;
	savePlayers(players, n + 1);
	printf("注册成功.\n");
}

// 画出棋盘
void drawBoard(char board[][boardSize]) {
	printf("  ");
	for (int i = 0; i < boardSize; i++) {
		printf(" %c", 'A' + i);
	}
	printf("\n");

	for (int i = 0; i < boardSize; i++) {
		printf("%2d", i + 1);
		for (int j = 0; j < boardSize; j++) {
			printf(" %c", board[i][j]);
		}
		printf("\n");
	}
}

// 让玩家输入棋子
void inputMove(char board[][boardSize], char player) {
	int row, col;

	do {
		printf("玩家 %c 移动 (例如 A1): ", player);
		char move[3];
		scanf("%s", move);
		col = move[0] - 'A';
		row = move[1] - '1';
	} while (row < 0 || row >= boardSize || col < 0 || col >= boardSize || board[row][col] != '.');

	board[row][col] = player;
}

// 检查是否有五子连珠
int checkWin(char board[][boardSize], char player) {
	// 检查每一行
	for (int i = 0; i < boardSize; i++) {
		int count = 0;
		for (int j = 0; j < boardSize; j++) {
			if (board[i][j] == player) {
				count++;
			} else {
				count = 0;
			}
			if (count == 5) {
				return 1;
			}
		}
	}

	// 检查每一列
	for (int j = 0; j < boardSize; j++) {
		int count = 0;
		for (int i = 0; i < boardSize; i++) {
			if (board[i][j] == player) {
				count++;
			} else {
				count = 0;
			}
			if (count == 5) {
				return 1;
			}
		}
	}

	// 检查每一条对角线
	for (int i = 0; i <= boardSize - 5; i++) {
		for (int j = 0; j <= boardSize - 5; j++) {
			int count = 0;
			for (int k = 0; k < 5; k++) {
				if (board[i + k][j + k] == player) {
					count++;
				} else {
					count = 0;
				}
				if (count == 5) {
					return 1;
				}
			}
		}
	}

	// 检查每一条反对角线
	for (int i = 0; i <= boardSize - 5; i++) {
		for (int j = 4; j < boardSize; j++) {
			int count = 0;
			for (int k = 0; k < 5; k++) {
				if (board[i + k][j - k] == player) {
					count++;
				} else {
					count = 0;
				}
				if (count == 5) {
					return 1;
				}
			}
		}
	}

	return 0;
}
//评分系统，评估井字棋游戏中某个位置的落子对于当前玩家的得分
int evaluateMove(char board[][boardSize], int move, char player) {
	int row = move / boardSize;
	int col = move % boardSize;
	int score = 0;

	// 横向
	int count = 0;//记录连续相同玩家棋子的个数
	for (int j = 0; j < boardSize; j++) {
		if (board[row][j] == player) {
			count++;
		} else if (board[row][j] == '.') {
			count = 0;
			break;
		} else {
			break;
		}
	}
	score += count;

	// 纵向
	count = 0;
	for (int i = 0; i < boardSize; i++) {
		if (board[i][col] == player) {
			count++;
		} else if (board[i][col] == '.') {
			count = 0;
			break;
		} else {
			break;
		}
	}
	score += count;

	// 左上到右下的对角线
	count = 0;
	int i = row, j = col;
	while (i > 0 && j > 0 && board[i - 1][j - 1] == player) {
		i--;
		j--;
		count++;
	}
	i = row, j = col;
	while (i < boardSize - 1 && j < boardSize - 1 && board[i + 1][j + 1] == player) {
		i++;
		j++;
		count++;
	}
	if (board[row][col] == player) {
		count++;
	} else if (board[row][col] != '.') {
		count = 0;
	}
	score += count;

	// 左下到右上的对角线
	count = 0;
	i = row, j = col;
	while (i > 0 && j < boardSize - 1 && board[i - 1][j + 1] == player) {
		i--;
		j++;
		count++;
	}
	i = row, j = col;
	while (i < boardSize - 1 && j > 0 && board[i + 1][j - 1] == player) {
		i++;
		j--;
		count++;
	}
	if (board[row][col] == player) {
		count++;
	} else if (board[row][col] != '.') {
		count = 0;
	}
	score += count;

	return score;
}
//AI计算best移动位置
int getAiMove(char board[][boardSize]) {
	int bestMove = -1;
	int maxScore = -1;
	for (int i = 0; i < boardSize * boardSize; i++) {
		if (board[i / boardSize][i % boardSize] == '.') {
			int score = evaluateMove(board, i, 'O');
			if (score > maxScore) {
				maxScore = score;
				bestMove = i;
			}
		}
	}
	return bestMove;
}
//完成下棋决策
void makeMove(char board[][boardSize], int move, char player) {
	int row = move / boardSize;
	int col = move % boardSize;
	board[row][col] = player;
}
// 游戏主循环
void playGame(player players[], int n, int isprime) {
	char board[boardSize][boardSize];
	memset(board, '.', sizeof(board));
	//	初始化数组，把board里面的每一个元素都设置为字符
	int turn = 0;
	while (1) {
		drawBoard(board);
		if (turn % 2 == 0) {
			inputMove(board, 'X');
		} else {
			if (isprime == 0) {
				inputMove(board, 'O');
//				printf("%d", isprime);  测试
			} else {
				int aiMove = getAiMove(board);
				printf("对面选择 行 %d, 列 %d\n", aiMove / boardSize + 1, aiMove % boardSize + 1);
				makeMove(board, aiMove, 'O');
//				printf("%d", isprime);  测试
			}
		}
		if (checkWin(board, turn % 2 == 0 ? 'X' : 'O')) {
			printf("%s 胜利!\n", turn % 2 == 0 ? players[0].name : "Computer");
			int index = turn % 2 == 0 ? 0 : 1;
			players[index].score += 10;
			savePlayers(players, n);
			break;
		}
		turn++;
	}
}

// 按积分排名显示所有玩家
void showRanking(player players[], int n) {
	// 按积分从高到低排序
	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j < n; j++) {
			if (players[j].score > players[i].score) {
				player temp = players[i];
				players[i] = players[j];
				players[j] = temp;
			}
		}
	}
	// 显示排名
	printf("\nRanking:\n");
	for (int i = 0; i < n; i++) {
		printf("%d. %s (%d 分)\n", i + 1, players[i].name, players[i].score);
	}
	printf("\n");
}

