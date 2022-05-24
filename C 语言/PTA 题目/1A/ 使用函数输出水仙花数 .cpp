#include <stdio.h>

int narcissistic(int number);
void PrintN(int m, int n);

int main()
{
	int m, n;

	scanf("%d %d", &m, &n);
	if (narcissistic(m))
		printf("%d is a narcissistic number\n", m);
	PrintN(m, n);
	if (narcissistic(n))
		printf("%d is a narcissistic number\n", n);

	return 0;
}

int narcissistic(int number)
{
	int sum = 0, n = number, cnt = 0, i;
	while (n)
	{
		cnt++;
		n /= 10;
	}
	n = number;
	while (n)
	{
		int temp = 1;
		for (i = 0; i < cnt; i++)
			temp *= n % 10;
		n /= 10;
		sum += temp;
	}
	if (sum == number)
		return 1;
	else
		return 0;
}

void PrintN(int m, int n)
{
	int i, j;
	for (i = m + 1; i < n; i++)
	{
		if (narcissistic(i))
			printf("%d\n", i);
	}
}
