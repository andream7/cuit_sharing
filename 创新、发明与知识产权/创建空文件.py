import os

# 获取当前目录
current_directory = os.getcwd()

# 获取当前目录下的所有文件
files = os.listdir(current_directory)

# 遍历所有文件
for file in files:
    # 确保是文件而不是文件夹
    if os.path.isfile(file):
        # 获取文件名和扩展名
        file_name, file_extension = os.path.splitext(file)

        # 创建空文件，文件名与当前文件相同
        with open(file, 'w') as new_file:
            pass  # 创建了一个空文件

print("空文件已创建完成。")
