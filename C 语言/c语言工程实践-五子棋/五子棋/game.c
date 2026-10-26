#include"main.h"

int main() {
	player players[maxPlayers];
	int n = loadPlayers(players);
	printf("======================================\n");
	printf("      欢迎来到五子棋游戏！\n");
	printf("======================================\n");
	printf("\n");
	printf("游戏规则：\n");
	printf("1. 五子棋是一种双人对弈的纯策略型棋类游戏。\n");
	printf("2. 棋盘是一个15x15的网格，双方各执黑白两色棋子。\n");
	printf("3. 玩家轮流下棋，先在棋盘上形成五个连续的棋子的一方获胜。\n");
	printf("4. 连续的棋子可以是横、竖、斜线方向的，不能有间隔。\n");
	printf("\n");
	printf("======================================\n");
	while (1) {
		printf("请选择以下操作：\n");
		printf("1. 注册账号\n2. 人机对战\n3. 玩家对战\n4. rank排行\n5. 退出游戏\n");
		char choice;
		scanf("%s", &choice);
		switch (choice) {
			case '1':
				registerPlayer(players, n);
				n++;
				break;
			case '2':
				printf("输入你的id: ");
				char name[maxNameLength];
				scanf("%s", name);
				int found = 0;
				for (int i = 0; i < n; i++) {
					if (strcmp(players[i].name, name) == 0) {
						found = 1;
						printf("欢迎, %s!\n", name);
						playGame(players, n, 1);
						break;
					}
				}
				if (!found) {
					printf("没有这个id.\n");
				}
				break;
			case '3':
				printf("请输入两名选手的姓名:\n");
				char player1[maxNameLength], player2[maxNameLength];
				scanf("%s %s", player1, player2);
				int index1 = -1, index2 = -1;
				for (int i = 0; i < n; i++) {
					if (strcmp(players[i].name, player1) == 0) {
						index1 = i;
						if (index2 != -1) {
							break;
						}
					}
					if (strcmp(players[i].name, player2) == 0) {
						index2 = i;
						if (index1 != -1) {
							break;
						}
					}
				}
				if (index1 == -1 || index2 == -1) {
					printf("其中一个玩家不存在.\n");
				} else {
					printf("欢迎, %s 和 %s!\n", player1, player2);
					player twoPlayers[2] = {players[index1], players[index2]};
					playGame(twoPlayers, 2, 0);
				}
				break;
			case '4':
				showRanking(players, n);
				break;
			case '5':
				return 0;
			default:
				printf("无效的选择，请重新输入.\n");
		}
	}
}
