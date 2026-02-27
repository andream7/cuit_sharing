## knowledge:

na.omit() 是 R 语言中用于处理缺失值的一个基本函数，它的主要功能是删除数据集中包含 NA（缺失值）的行。



## 题目
1. 查看数据集结构，增加一列编号列，为数据添加编号，并输出编号最后一位数字与学号最后一位数字相等的观测值的最后8行（例如：2022131123，选取编号最后一位数字为3的行，并输出最后8行）。

seq_len 就是生成length长度的序列

`[row, col]` 筛选操作符号
```r
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
```

2. 3.检查数据集中是否存在缺失值，如果存在，填补或剔除。

```r
if(any(is.na(house_data))){
    house_data_clean <- na.omit(house_data)
}
```

3. 对 medv 进行分类，将房价中位数分为两个类别：高房价（medv > 25）和低房价（medv <= 25），并新增列 price_category，取值为 "High" 或 "Low"。

```r
house_data$price_category <- ifelse(house_data$medv > 25,"High","Low")
```

4. 使用聚合函数，计算每个变量的基本统计量（均值、中位数、标准差等），并以chas列为分组依据，求取tax、ptratio、lstat和medv列的基本统计量
```r
subset_data <- house_data[, c("CHAS", "TAX", "PTRATIO", "LSTAT", "MEDV")]

result <- aggregate(
    . ~ chas, # 所有其他列，按照chas分组
    data = subset_data,
    FUN = function(x) c(
        mean = mean(x),
        median = median(x),# 中位数
        sd = sd(x),       # 标准差
        min = min(x),     # 最小值
        max = max(x)      # 最大值
    )
)
```

5. 绘制 medv 的直方图，观察房价的分布情况。
histogram
```r
hist(
  house_data$MEDV, 
  breaks = 20,               # 设定分组的数量
  col = "skyblue",           # 设置柱子的颜色
  border = "white",          # 设置柱子边框颜色
  main = "Distribution of MEDV", # 设置标题
  xlab = "Median Value of Homes (MEDV)", # 设置 X 轴标签
  ylab = "Frequency"         # 设置 Y 轴标签
)

```

6. 散点图，回归线
```r
# 绘制散点图
plot(x, y,
     main = "分组散点图",
     xlab = "X变量",
     ylab = "Y变量",
     col = c("blue","red")[groups],
     pch = 16,
     cex = 1.2)
     
# 创建箱线图
boxplot(MEDV ~ CHAS, data = house_data,
        main = "是否临河对房价的影响",
        xlab = "是否临河",
        ylab = "房价中位数",
        col = c("lightblue", "lightgreen"))

# 添加回归线
abline(lm(y ~ x), 
       col = "green",
       lwd = 2)
```