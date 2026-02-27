print("题目1")
# 1. 使用R语言加载波士顿房价数据集
house_data <- read.csv("./house_data.csv")

print("题目2")
# 2. 查看数据集结构，添加编号列并筛选数据
# 首先查看数据结构
str(house_data)

# 添加编号列
house_data$ID <- seq_len(nrow(house_data))

# 筛选编号最后一位为3的行（根据你的学号最后一位修改这个数字）
filtered_data <- house_data[house_data$ID %% 10 == 3, ]

# 提取最后8行
result <- tail(filtered_data, 8)

# 输出结果
print(result)

print("题目3")
# 3. 检查数据集中是否存在缺失值，如果存在，填补或剔除
# 首先检查每列的缺失值数量
na_counts <- colSums(is.na(house_data))
print("每列的缺失值数量：")
print(na_counts)

# 检查是否存在缺失值
if(any(is.na(house_data))) {
    # 方法1：删除包含缺失值的行
    house_data_clean <- na.omit(house_data)
    
    # 或者方法2：用均值填充缺失值
    # for(col in names(house_data)) {
    #     house_data[[col]][is.na(house_data[[col]])] <- mean(house_data[[col]], na.rm = TRUE)
    # }
    
    print("缺失值已处理")
} else {
    print("数据集中没有缺失值")
}

print("题目4")
# 4. 对 medv 进行分类，将房价中位数分为两个类别
# 创建新的分类列，根据 medv 值分类
house_data$price_category <- ifelse(house_data$MEDV > 25, "High", "Low")

# 查看分类结果
print("价格分类结果统计：")
table(house_data$price_category)

# 查看部分数据，确认分类结果
print("部分数据示例：")
head(house_data[, c("MEDV", "price_category")])

print("题目5")
# 5. 使用聚合函数计算基本统计量
# 首先计算所有数值变量的基本统计量
print("所有变量的基本统计量：")
summary(house_data)

# 以CHAS为分组依据计算指定列的统计量
# 选取需要的列
subset_data <- house_data[, c("CHAS", "TAX", "PTRATIO", "LSTAT", "MEDV")]

# 分组统计
print("按CHAS分组的统计结果：")
result <- aggregate(. ~ CHAS, data = subset_data, 
                   FUN = function(x) c(
                     mean = mean(x),
                     median = median(x),
                     sd = sd(x),
                     min = min(x),
                     max = max(x)
                   ))

# 转换为更易读的格式
result <- do.call(data.frame, result)
print(result)

print("题目6")
# 6. 绘制 medv 的直方图，观察房价的分布情况
# 绘制直方图
hist(
  house_data$MEDV, 
  breaks = 20,               # 设定分组的数量
  col = "skyblue",           # 设置柱子的颜色
  border = "white",          # 设置柱子边框颜色
  main = "Distribution of MEDV", # 设置标题
  xlab = "Median Value of Homes (MEDV)", # 设置 X 轴标签
  ylab = "Frequency"         # 设置 Y 轴标签
)

print("题目7")
# 7. 使用散点图观察 rm（房间数）与 medv（房价中位数）的关系，观察是否存在相关关系
# 绘制散点图
plot(
  house_data$RM, 
  house_data$MEDV,
  main = "Relationship between RM and MEDV",  # 图表标题
  xlab = "Average Number of Rooms (RM)",     # X轴标签
  ylab = "Median Value of Homes (MEDV)",     # Y轴标签
  col = "blue",                              # 点的颜色
  pch = 16                                   # 点的形状
)

# 添加拟合直线
abline(lm(MEDV ~ RM, data = house_data), col = "red", lwd = 2)

print("题目8")
# 8. 使用箱线图比较 chas（是否临河）对房价的影响，观察是否临河的房价更高
# 绘制箱线图
boxplot(
  MEDV ~ CHAS, 
  data = house_data,
  main = "Impact of CHAS (River Proximity) on MEDV", # 设置图标题
  xlab = "CHAS (1 = Tracts near river, 0 = Otherwise)", # 设置 X 轴标签
  ylab = "Median Value of Homes (MEDV)",              # 设置 Y 轴标签
  col = c("skyblue", "orange"),                       # 设置箱体颜色
  notch = TRUE                                        # 显示中位数凹槽
)

# 添加辅助说明
legend(
  "topright", 
  legend = c("0: Not near river", "1: Near river"), 
  fill = c("skyblue", "orange"), 
  title = "CHAS Categories"
)

print("题目9")
# 9. 计算 lstat（低收入人口比例）与 medv（房价）之间的相关系数
# 计算 lstat 与 medv 之间的相关系数
correlation <- cor(house_data$LSTAT, house_data$MEDV, use = "complete.obs")

# 打印相关系数
print(correlation)

print("题目10")
# 10. 构建多元线性回归模型，以 medv 为因变量，rm、lstat 和 tax 为自变量，输出模型的回归系数和显著性检验结果。
# 构建多元线性回归模型
model <- lm(MEDV ~ RM + LSTAT + TAX, data = house_data)

# 输出模型回归系数和显著性检验结果
summary(model)

print("题目11")
# 11. 使用模型对数据集中的房价进行预测，并计算预测值与真实值之间的均方误差（MSE）
# 使用模型对数据集进行预测
predictions <- predict(model, newdata = house_data)

# 计算预测值与真实值之间的均方误差 (MSE)
mse <- mean((predictions - house_data$MEDV)^2)

# 打印均方误差
print(paste("Mean Squared Error (MSE):", mse))

print("题目12")
# 12. 绘制预测值与真实值的对比散点图
# 绘制预测值与真实值的对比散点图
plot(
  house_data$MEDV, 
  predictions,
  main = "Predicted vs Actual MEDV",         # 图表标题
  xlab = "Actual MEDV",                      # X 轴标签（真实值）
  ylab = "Predicted MEDV",                   # Y 轴标签（预测值）
  col = "blue",                              # 点的颜色
  pch = 16                                   # 点的形状
)

# 添加对角线，表示预测值与真实值完全相等时的情况
abline(a = 0, b = 1, col = "red", lwd = 2)
















