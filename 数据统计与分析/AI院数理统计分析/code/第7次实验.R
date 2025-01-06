cat("第一题：\n")
# 1.今测得汽车的行驶速度 speed 和刹车距腐 dist 数据如下。
# Speed	4, 4, 7, 7, 8, 9
# Dist	2, 10, 4, 22, 16, 10
#（1) 作speed与dist的散点图，并以此判断 speed 与dist 之间是否大致呈线性关系。
#（2）计算speed 与dist 的相关系数并做假设检验。
#（3）做speed 对dist 的最小二乘回归，并给出常用统计量。
#（4）预测当speed =30 时，dist 等于多少？
# 数据输入
speed <- c(4, 4, 7, 7, 8, 9)
dist <- c(2, 10, 4, 22, 16, 10)

# (1) 绘制散点图
plot(speed, dist, main="Scatter Plot of Speed vs Dist", xlab="Speed", ylab="Dist", pch=19, col="blue")

# (2) 计算相关系数并做假设检验
correlation <- cor(speed, dist)
cat("相关系数:", correlation, "\n")

# 假设检验
cor_test <- cor.test(speed, dist)
cat("相关系数假设检验结果：\n")
print(cor_test)

# (3) 做最小二乘回归并给出统计量
lm_model <- lm(dist ~ speed)
cat("回归模型的结果：\n")
summary(lm_model)

# (4) 预测当speed=30时的dist
new_data <- data.frame(speed = 30)
predicted_dist <- predict(lm_model, new_data)
cat("当speed = 30时，预测的dist值为：", predicted_dist, "\n")

cat("第二题：\n")
# 2.由专业知识可知，合金的强度y(Pa）与合金中的碳的含量x（%）有关。为了生产出强度满足顾客需要的合金，在治炼时应该如何控制碳的含量？如果在冾炼过程中通过化验得知了碳的含量，能否预测这炉合金的强度？
# x	0.10, 0.11, 0. 12, 0.13, 0.14, 0.15, 0.16, 0.17, 0.18, 0.20, 0.21, 0.23
# y	42, 43.5, 45, 45.5, 45, 47.5, 49, 53, 50, 55, 55, 60
#（1）作x与y的散点图，并以此判断x与y之间是否大致呈线性关系。
#（2）计算x与y的相关系数并做假设检验。
#（3）做y对x的最小二乘回归，并给出常用统计量。
#（4）预测当x=0.22 时，y等于多少？预测当 x=0.25时，y等于至少？
# 数据输入
x <- c(0.10, 0.11, 0.12, 0.13, 0.14, 0.15, 0.16, 0.17, 0.18, 0.20, 0.21, 0.23)
y <- c(42, 43.5, 45, 45.5, 45, 47.5, 49, 53, 50, 55, 55, 60)

# (1) 绘制散点图
plot(x, y, main="Scatter Plot of Carbon Content vs Strength", xlab="Carbon Content (x)", ylab="Strength (y)", pch=19, col="blue")

# (2) 计算相关系数并做假设检验
correlation <- cor(x, y)
cat("相关系数:", correlation, "\n")

# 假设检验
cor_test <- cor.test(x, y)
cat("相关系数假设检验结果：\n")
print(cor_test)

# (3) 做最小二乘回归并给出统计量
lm_model <- lm(y ~ x)
cat("回归模型的结果：\n")
summary(lm_model)

# (4) 预测当x=0.22和x=0.25时的y
new_data <- data.frame(x = c(0.22, 0.25))
predicted_y <- predict(lm_model, new_data)
cat("当x = 0.22时，预测的y值为：", predicted_y[1], "\n")
cat("当x = 0.25时，预测的y值为：", predicted_y[2], "\n")

cat("第三题：\n")
# 3.多元回归：1609年，伽利略证明了一个物体在一个水平力的作用下，其下落轨造为一地物线。为了验证这一事实，他做了一项实验并度量了两个变量：高度和距高，数据如下：
# 高度（x)	100, 200, 300, 450, 600, 800, 1000
# 距离 (g)	253, 337, 395, 451, 495, 534, 574
# 通过数据描点，伽利略显然看到数据分布呈抛物线，且在数学上证明了它。在现代的眼光看来，如果确信为抛物线，我们可用用二元回归模型得到哪些系数？
# 数据输入
x <- c(100, 200, 300, 450, 600, 800, 1000)
g <- c(253, 337, 395, 451, 495, 534, 574)

# 创建一个包含 x 和 x^2 的数据框
x_squared <- x^2
data <- data.frame(g = g, x = x, x_squared = x_squared)

# 二次回归模型：g = β0 + β1 * x + β2 * x^2
model <- lm(g ~ x + x_squared, data = data)

# 输出回归结果
summary(model)

cat("第四题：\n")
# 4.针对数据：电影评分、人数、五星、四星
#（1）计算相关系数矩阵，绘制相关系数图。
# 加载必要的库
library(corrplot)

df <- data.frame(
  avgRate = c(4.5, 4.0, 3.5, 5.0, 4.2),
  rateNum = c(1000, 1500, 2000, 2500, 3000),
  five = c(50, 45, 40, 55, 60),
  four = c(30, 35, 25, 20, 25)
)
# 计算相关系数矩阵
cor_matrix <- cor(df[, c("avgRate", "rateNum", "five", "four")])

# 打印相关系数矩阵
print(cor_matrix)

# 绘制相关系数图
corrplot(cor_matrix, method = "circle", type = "upper", tl.col = "black")

#（2）试建立y（评分）和x（其余变量）的线性回归模型，检验该回归方程有无统计学意义。
# 建立线性回归模型
lm_model <- lm(avgRate ~ rateNum + five + four, data = df)

# 输出回归模型的统计摘要
summary(lm_model)

#（3）计算该模型的复相关系数、决定系数和剩余标准差。
# 获取模型的复相关系数 (R)
correlation <- sqrt(summary(lm_model)$r.squared)
cat("复相关系数 R:", correlation, "\n")

# 获取决定系数 (R-squared)
r_squared <- summary(lm_model)$r.squared
cat("决定系数 R-squared:", r_squared, "\n")

# 获取剩余标准差
residual_standard_error <- summary(lm_model)$sigma
cat("剩余标准差:", residual_standard_error, "\n")

#（4）试用该方程对电影评分进行预测，已知：人数300000，五星35（%），四星20（%），试写出预测其结果的R语句并用建立的模型计算预测结果。
# 新的输入数据
new_data <- data.frame(rateNum = 300000, five = 35, four = 20)

# 使用回归模型进行预测
predicted_rate <- predict(lm_model, newdata = new_data)
cat("预测的评分为:", predicted_rate, "\n")

















