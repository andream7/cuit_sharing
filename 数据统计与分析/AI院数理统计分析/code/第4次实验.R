
demo1 <-read.csv("./douban_movies_cn_clean.csv")

new_names <- c("ID", "Title", "Year", "Cover", "Director", "Author", "Actor", "Genre", "Date", "Country", "Language", "RunTime", "OtherName", "IMDB", "AvgRate", "RateNum", "Five", "Four", "Three", "Two", "One", "Tags", "Intro")
colnames(demo1) <- new_names

demo1 <- subset(demo1, select = -Intro)
demo1 <- subset(demo1, select = -Cover)

demo1 <- demo1[grepl("$", demo1$ID), ]
dim(demo1)
tail(demo1)

demo1 <- demo1[order(-demo1$AvgRate, -demo1$Five, -demo1$Four), ]

demo1 <- demo1[demo1$AvgRate > 6.0 & demo1$Year > 2010 & grepl('剧情', demo1$Tags), ]

demo1 <- na.omit(demo1)

breaks_avgRate <- c(0, 2, 4, 6, 8, 10)
demo1$AvgRate_group <- cut(demo1$AvgRate, breaks = breaks_avgRate, include.lowest = TRUE)

breaks_runTime <- c(0, 30, 60, 90, 120, 150, 180)
demo1$RunTime_group <- cut(demo1$RunTime, breaks = breaks_runTime, include.lowest = TRUE)






# 1.使用下面的函数，观察评分和时长变量数据性质
EDA <- function(x) {
  par(mfrow=c(2,2), mar=c(4,3,2,1), cex=0.8)
  hist(x, main='Histgram', ylab='')
  plot(x, main='Dotchart', ylab='')
  boxplot(x, horizontal=T, main='Boxplot')
  qqnorm(x, xlab='', ylab='');qqline(x)
  par(mfrow=c(1,1))
}
EDA(demo1$AvgRate)
EDA(demo1$RunTime)


# 2. 结合下面的代码和图片，观察评分与评分人数、评分与五星人数之间的关，并依据评分分组数据进行显示。
# 假设df数据框已经存在，并且包含avgRate（评分）、rateNum（评分人数）、five（五星人数）字段
with(demo1, {
  par(mfrow = c(1, 2), cex = 0.8)
  plot(AvgRate, RateNum, main = "评分与评分人数关系", xlab = "评分", ylab = "评分人数", col = 'blue', pch = 19)
  plot(AvgRate, Five, main = "评分与五星人数关系", xlab = "评分", ylab = "五星人数", col = 'red', pch = 17)
  legend("topright", levels(as.factor(AvgRate)), pch = 1:3, bty = 'n', title = "评分分组")
  par(mfrow = c(1, 1))
})




language_count <- table(demo1$Language)
par(mfrow=c(1, 2), mar=c(4, 4, 2, 1))
# 绘制条形图，设置不同颜色
barplot(language_count, 
        main="每种语言的电影数", 
        col=rainbow(length(language_count)), 
        ylab="电影数", 
        xlab="语言",
        border="white")
# 绘制饼图，设置不同颜色
pie(language_count, 
    main="每种语言的电影比例", 
    col=rainbow(length(language_count)), 
    labels=paste(names(language_count), "\n", language_count),
    radius=1.2)
# 恢复为单个图形窗口
par(mfrow=c(1, 1))



# Ftab函数：计算每种语言的电影数和占比
Ftab <- function(x) {
  f = table(x)
  s = sum(f)
  p = f / s * 100
  t = cbind('Counts' = f, 'Percent(%)' = round(p, 2))
  print(rbind(t, 'Total' = c(s, 100)))
  invisible(f)
}
language_count <- table(demo1$Language)
total_count <- sum(language_count)
percentages <- language_count / total_count * 100
# 创建一个数据框，包含语言、电影数和百分比
language_data <- data.frame(
  Language = names(language_count),
  Counts = as.integer(language_count),
  Percent = round(percentages, 2)
)

# 设置画布，按左右排列
par(mfrow=c(1, 2), mar=c(4, 4, 2, 1))

# 绘制条形图，设置不同颜色
barplot(language_count, 
        main="每种语言的电影数", 
        col=rainbow(length(language_count)), 
        ylab="电影数", 
        xlab="语言",
        border="white")
# 在条形图上添加百分比标签
text(x = seq_along(language_count), 
     y = language_count, 
     labels = paste(round(percentages, 1), "%"), 
     pos = 3, cex = 0.8, col = "black")
# 绘制饼图，设置不同颜色
pie(language_count, 
    main="每种语言的电影比例", 
    col=rainbow(length(language_count)), 
    labels = paste(names(language_count), "\n", round(percentages, 1), "%"),
    radius=1.2)
# 恢复为单个图形窗口
par(mfrow=c(1, 1))
# 调用Ftab函数显示电影数和百分比
Ftab(demo1$Language)



# 计算评分的均值
mean_rating <- mean(demo1$AvgRate, na.rm = TRUE)  #用于忽略 NA 值
cat("Mean (平均值): ", mean_rating, "\n")
# 计算评分的中位数
median_rating <- median(demo1$AvgRate, na.rm = TRUE)
cat("Median (中位数): ", median_rating, "\n")
# 计算评分的方差
var_rating <- var(demo1$AvgRate, na.rm = TRUE)
cat("Variance (方差): ", var_rating, "\n")
# 计算评分的标准差
sd_rating <- sd(demo1$AvgRate, na.rm = TRUE)
cat("Standard Deviation (标准差): ", sd_rating, "\n")
# 使用summary函数获取更多的统计量（包括最小值、最大值、四分位数等）
summary_rating <- summary(demo1$AvgRate)
cat("Summary (摘要统计): \n")
print(summary_rating)



Freq <- function(x, Bs=10) { #自定义计量频数表函数
  h=hist(x, breaks=Bs, xlab='', main='')  # 使用 hist() 函数生成直方图
  f=h$counts  # 获取频数（每个区间内的数据个数
  p=f/sum(f)*100  # 计算频率百分比：
  cp=cumsum(p)    # 计算累积频率
  freq=data.frame(m=h$mids, f=f, p=p, cp=round(cp,2))
  names(freq)=c('Median', 'Counts', 'Frequency(%)', 'CumsumFreq(%)')
  freq
}
# 使用 Freq 函数生成频数表
freq_data <- Freq(demo1$AvgRate, Bs=5)
# 输出频数表
print(freq_data)
# 绘制直方图
hist(demo1$AvgRate, breaks=5, col="lightblue", main="Histogram of avgRate", xlab="Rating", ylab="Frequency")
# 生成评分分组的条形图
rating_table <- table(demo1$AvgRate)
barplot(rating_table, col="lightgreen", main="Barplot of avgRate", xlab="Rating", ylab="Frequency")



# 计算不同语言评分数据的基本统计量
summary_stats <- tapply(demo1$AvgRate, demo1$Language, summary)
print(summary_stats)
# 绘制箱式图和点带图（对角线排列）
par(mfrow = c(1, 2))  # 设置画布为1行2列
# 绘制箱式图
boxplot(AvgRate ~ Language, data = demo1, main = "Boxplot by Language", 
        xlab = "Language", ylab = "Avg Rating", col = "lightblue")
# 绘制点带图
stripchart(AvgRate ~ Language, data = demo1, method = "jitter", 
           main = "Stripchart by Language", 
           xlab = "Language", ylab = "Avg Rating", 
           pch = 19, col = "darkgreen")
par(mfrow = c(1, 1))  # 恢复为单个画布



result <- aggregate(
  cbind(AvgRate, RunTime, RateNum, Five, Four, Three, Two, One) ~ 1, 
  data = demo1, 
  FUN = function(x) c(
    mean = mean(x), 
    min = min(x), 
    max = max(x), 
    median = median(x), 
    sd = sd(x), 
    quantile_25 = quantile(x, 0.25), 
    quantile_75 = quantile(x, 0.75)
  )
)

# 整理输出为一个清晰的表格
formatted_result <- do.call(rbind, result[,-1])
rownames(formatted_result) <- colnames(result)[-1]
colnames(formatted_result) <- c("Mean", "Min", "Max", "Median", "SD", "25th Percentile", "75th Percentile")

# 打印清晰结果
print(formatted_result)



# 9. 依据评分分组数据和时长分组数据求出评分、评分人数、五星人数和时长的均值和标准差。 
# 按评分 (avgRate) 分组，计算评分、评分人数、五星人数和时长的均值和标准差
summary_by_rating <- aggregate(cbind(AvgRate, RateNum, Five, RunTime) ~ AvgRate, 
                               data = demo1, 
                               FUN = function(x) c(mean = mean(x), sd = sd(x)))

# 按时长 (runtime) 分组，计算评分、评分人数、五星人数和时长的均值和标准差
summary_by_runtime <- aggregate(cbind(AvgRate, RateNum, Five, RunTime) ~ RunTime, 
                                data = demo1, 
                                FUN = function(x) c(mean = mean(x), sd = sd(x)))

# 打印结果
print(summary_by_rating)
print(summary_by_runtime)



