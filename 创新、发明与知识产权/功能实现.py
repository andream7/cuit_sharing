import os
import re
import pandas as pd
import shutil

# 获取当前目录
current_directory = os.getcwd()

# 创建正确和不正确目录
correct_directory = os.path.join(current_directory, '正确')
incorrect_directory = os.path.join(current_directory, '不正确')

if not os.path.exists(correct_directory):
    os.makedirs(correct_directory)

if not os.path.exists(incorrect_directory):
    os.makedirs(incorrect_directory)

# 定义正则表达式匹配模式
pattern = r'^(.*)-(.*)-(.*)-(.*)-(.*).pdf$'

# 初始化数据集
correct_data = []
incorrect_data = []

# 处理文件
total_files = 0
success_count = 0

for filename in os.listdir(current_directory):
    if filename.endswith('.pdf'):
        total_files += 1
        match = re.match(pattern, filename)
        if match:
            success_count += 1
            # 对正确命名的文件进行处理
            info = list(match.groups())
            correct_data.append(info)

            # 将文件移动到正确目录
            shutil.move(os.path.join(current_directory, filename),
                        os.path.join(correct_directory, filename))
        else:
            # 对不正确命名的文件进行处理
            if '院' in filename:
                parts = filename.split('院', 1)
                incorrect_data.append(parts)
            else:
                incorrect_data.append([filename, '未识别'])

            # 将文件移动到不正确目录
            shutil.move(os.path.join(current_directory, filename),
                        os.path.join(incorrect_directory, filename))

# 将数据导出到Excel表格
correct_df = pd.DataFrame(correct_data, columns=[
                          '姓名', '学院', '专业班级', '学号', '联系方式'])
incorrect_df = pd.DataFrame(incorrect_data, columns=['姓名/信息', '未识别'])

# 排序并去重
correct_df = correct_df.sort_values(by='学院').drop_duplicates()
incorrect_df = incorrect_df.sort_values(by='姓名/信息').drop_duplicates()

# 导出数据到Excel表格
correct_excel_path = os.path.join(correct_directory, '正确统计.xlsx')
incorrect_excel_path = os.path.join(incorrect_directory, '不正确统计.xlsx')

with pd.ExcelWriter(correct_excel_path) as writer:
    correct_df.to_excel(writer, index=False, sheet_name='正确统计')

with pd.ExcelWriter(incorrect_excel_path) as writer:
    incorrect_df.to_excel(writer, index=False, sheet_name='不正确统计')

# 输出处理结果
print(f'本次处理的文件数量（按格式进行统计）: {success_count}/{total_files}')
print(f'成功导出到表格的文件数量: {len(correct_data)}')
