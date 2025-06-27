#include <iostream>
using namespace std;
	//继续补全Matrix矩阵类的声明和定义，矩阵元素均为整型，以及operator<<输出运算符重载函数的友元声明，并以};结束。然后在类外定义operator<<输出运算符重载函数以及剩下的类成员函数实现。也可自行选择方法。
	/* 请在这里填写答案 */
//做法一：使用动态数组
	class Matrix {
	public:
		int* data;
		int rows, cols;

		Matrix(int r, int c) :rows(r),cols(c) {
			this->data = new int[rows * cols];
		};
		~Matrix() {
			delete[] data;
		}
		friend ostream& operator<<(ostream& out,const Matrix& a );
  };
        
	ostream& operator<<(ostream& out,const Matrix& a) {
		out << "Matrix:" << a.rows << "x" << a.cols<<endl;
		for (int i = 0; i < a.rows;i++)
		{
			for (int j = 0; j < a.cols; j++)
			{
				out << a.data[i*a.cols + j]<<" ";
			}
			out << endl;
		}
		return out;

	}
	
	int main()
	{
		int rows, cols;
		std::cin >> rows >> cols;
		Matrix mat(rows, cols);
		for (int k = 0; k < rows * cols;++k)
		{
			mat.data[k] = k;
		}
		cout << mat;
		return 0;
	}