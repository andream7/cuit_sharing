#pragma once
#ifndef MAIN_H
#define MAIN_H
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define maxPlayers 100 // 最大玩家数
#define maxNameLength 20 // 最大用户名长度
#define maxPasswordLength 20 // 最大密码长度
#define boardSize 15 // 棋盘大小

// 玩家结构体，用于保存玩家信息
typedef struct {
	char name[maxNameLength]; // 用户名
	char password[maxPasswordLength]; // 密码
	int score; // 积分
} player;
// 从文件中加载玩家数据
int loadPlayers(player players[]);

// 将玩家数据保存到文件中
void savePlayers(player players[], int n);

// 注册新玩家
void registerPlayer(player players[], int n);

// 画出棋盘
void drawBoard(char board[][boardSize]);

// 让玩家输入棋子
void inputMove(char board[][boardSize], char player);

// 检查是否有五子连珠
int checkWin(char board[][boardSize], char player);

//评分系统
int evaluateMove(char board[][boardSize], int move, char player);

//AI计算best移动位置
int getAiMove(char board[][boardSize]);

//计算得出具体下棋位置
void makeMove(char board[][boardSize], int move, char player);

//游戏主循环
void playGame(player players[], int n,int isprime);

// 按积分排名显示所有玩家
void showRanking(player players[], int n);
#endif
