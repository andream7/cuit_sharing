# 1. x1,x2,x3,xn,1.是服从正态分布的独立样本，求μ的置信度为1-α的置信区间。 如果取得如下观测值：1.8, 2.1, 2.0, 2.2, 1.9, 2.2, 1.8，求μ的区间估计值
# 数据观测值
data <- c(1.8, 2.1, 2.0, 2.2, 1.9, 2.2, 1.8)

# 置信水平 (1-alpha)，例如 0.95 表示 95% 的置信区间
conf_level <- 0.95

# 样本均值和标准误
sample_mean <- mean(data)
sample_sd <- sd(data)
n <- length(data)
se <- sample_sd / sqrt(n)

# t 分布的临界值
t_value <- qt((1 + conf_level) / 2, df = n - 1)

# 置信区间计算
lower_bound <- sample_mean - t_value * se
upper_bound <- sample_mean + t_value * se

# 输出结果
cat("置信区间为：(", lower_bound, ", ", upper_bound, ")\n")

cat("第二题：\n")
# 2. 某送信服务公司登出广告声称它的本地信件传送时间不长于6小时，随机抽样其传送一包裹到一指定地址所花时间如下：7.2, 3.5, 4.3, 6.2, 10.1,5.4, 6.8, 4.5, 5.1, 6.6, 3.8和8.2小时，求平均传送时间的95% 置信度的置信区间。
# 输入数据
data <- c(7.2, 3.5, 4.3, 6.2, 10.1, 5.4, 6.8, 4.5, 5.1, 6.6, 3.8, 8.2)

# 计算样本均值和样本标准差
mean_data <- mean(data)
sd_data <- sd(data)

# 样本大小
n <- length(data)

# 计算 t 临界值 (置信度 95% 对应的 alpha = 0.05)
t_critical <- qt(0.975, df = n - 1)  # 0.975 是 95% 置信度的右尾

# 计算置信区间
error_margin <- t_critical * (sd_data / sqrt(n))
lower_bound <- mean_data - error_margin
upper_bound <- mean_data + error_margin

# 输出结果
cat("样本均值:", mean_data, "\n")
cat("置信区间: [", lower_bound, ", ", upper_bound, "]\n")

cat("第三题：\n")
# 3. 过去大量资料显示，菜厂生产的灯泡的使用寿命服从正态分布 N (1020, 100^2)。观从最近生产的一批产品中随机抽取 16 只，测得样本平均寿命为1080小时。试在0.05的显著性水平下判断这批产品的使用寿命是否有显著提高。(α=0.05)
# 已知信息
mu0 <- 1020  # 总体平均寿命
sigma <- 100  # 总体标准差
n <- 16  # 样本大小
x_bar <- 1080  # 样本平均寿命
alpha <- 0.05  # 显著性水平

# 计算标准误差
SE <- sigma / sqrt(n)

# 计算z统计量
z <- (x_bar - mu0) / SE

# 查找临界值
z_critical <- qnorm(1 - alpha)

# 输出z统计量和临界值
cat("z统计量:", z, "\n")
cat("临界值:", z_critical, "\n")

# 判断是否拒绝原假设
if (z > z_critical) {
  cat("拒绝原假设：使用寿命显著提高。\n")
} else {
  cat("不能拒绝原假设：使用寿命没有显著提高。\n")
}

cat("第四题：\n")
# 4. 一员工对乘当地公交车上班快还是自己开车快产生了兴趣。在一次试验中，她用两种交通方式各进行了10天，每一种方式的天数是随机选取的，她每天同一时刻离开家，然后记录到达工作地的时间。坐公交车的时间为：48, 47, 44, 45, 46, 47,43, 47, 42和48分钟；自己开车去的时间为：36, 45, 47, 38, 39, 42, 36, 42, 46和35分钟。假设乘车时间服从正态分布，试按下列要求进行分析，这些数据能提供充分的证据说明开车去的平均时间短吗？用显著水平5%，并考志用单尾检验还是双尾检验。
#（1）方差齐性检验。
#（2）均值的检验（方差不齐时）。
#（3）均值的检验（方差齐性时）。
# 数据输入
bus_time <- c(48, 47, 44, 45, 46, 47, 43, 47, 42, 48)
car_time <- c(36, 45, 47, 38, 39, 42, 36, 42, 46, 35)

# (1) 方差齐性检验 (F检验)
var_test <- var.test(bus_time, car_time)
cat("方差齐性检验结果：\n")
print(var_test)

# (2) 均值的检验（方差不齐时，Welch t 检验）
t_test_unequal_var <- t.test(bus_time, car_time, var.equal = FALSE)
cat("方差不齐时的均值检验结果：\n")
print(t_test_unequal_var)

# (3) 均值的检验（方差齐性时，独立样本 t 检验）
t_test_equal_var <- t.test(bus_time, car_time, var.equal = TRUE)
cat("方差齐性时的均值检验结果：\n")
print(t_test_equal_var)


cat("第五题：\n")
# 5. 为测定一个大型化工广对周围环境的污染，选了A1，A2，A3，A4四个观察点，在每个观察点三各测定4次空气中的SO2含量，现得到每一处观察点上4次观察的均值及4次观察的标准差，i=1，2，3，4，数据如下：
# 观察点	A1	A2	A3	A4
# 均值	0.031	0.100	0.079	0.058
# 方差	0.009	0.014	0.010	0.011
# 假定每一观察点上SO2的含量服从正态分布，且方差相等，试问在显著水平 α=0.05上各观察点空气中SO2的平均含量有无显著差异？
# 数据输入
means <- c(0.031, 0.100, 0.079, 0.058)
variances <- c(0.009, 0.014, 0.010, 0.011)
n <- 4  # 每组的样本量

# 计算总体均值
overall_mean <- mean(means)

# 计算组间平方和 (SSA)
SSA <- sum(n * (means - overall_mean)^2)

# 计算组内平方和 (SSE)
SSE <- sum((n - 1) * variances)

# 计算自由度
df_A <- length(means) - 1  # 组间自由度
df_E <- length(means) * (n - 1)  # 组内自由度

# 计算均方
MSA <- SSA / df_A
MSE <- SSE / df_E

# 计算F统计量
F_statistic <- MSA / MSE

# 查找临界值
F_critical <- qf(0.95, df_A, df_E)

# 输出结果
cat("F统计量:", F_statistic, "\n")
cat("临界值:", F_critical, "\n")

# 判断是否拒绝原假设
if (F_statistic > F_critical) {
  cat("拒绝原假设：存在显著差异。\n")
} else {
  cat("不能拒绝原假设：没有显著差异。\n")
}


