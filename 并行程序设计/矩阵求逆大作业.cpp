#include <iostream>
#include<fstream>
#include <vector>
#include <time.h>
#include <omp.h>
#include<random>
#include<iomanip>
using namespace std;
const int siz=2000;
const int Threads=6;
const double eps=1e-6;
ofstream write;
vector<vector<double>> generate_random_double_matrix()
{
    vector<vector<double>> matrix;
    matrix.resize(siz);
    mt19937 rng(random_device{}());
    for (int i=0;i<siz;i++)
    {
        matrix[i].resize(siz);
        for(int j=0;j<siz;++j)
            matrix[i][j]=rng();
    }
    return matrix;
}
vector<vector<double>> generate_identity()
{
    vector<vector<double>> I;
    I.resize(siz);
    for (int i = 0; i < siz; i++)
    {
        I[i].assign(siz,0);
        I[i][i]=1;
    }
    return I;
}

vector<vector<double>> generate_inverse_parallel(vector<vector<double>> input_matrix)
{
    vector<vector<double>> I = generate_identity();
    for (int i = 0; i < siz; i++)
    {
        if (abs(input_matrix[i][i]) <eps)//使主元不为0
        {
            for (int j = i + 1; j < siz; j++)
            {
                if (abs(input_matrix[j][i])>eps)
                {
                    swap(input_matrix[i], input_matrix[j]);
                    swap(I[i],I[j]);
                    break;
                }
                if (j == siz - 1)
                {
                    write << "Inverse does not exist for this matrix";
                    exit(0);
                }
            }
        }
        double scale = input_matrix[i][i];
        omp_set_num_threads(Threads);
#pragma omp parallel for
        for (int col = 0; col < siz; col++)
        {
            input_matrix[i][col] = input_matrix[i][col] / scale;
            I[i][col] = I[i][col] / scale;
        }
#pragma omp parallel for
        for (int row = 0; row < siz; row++)
        {
            if(row==i)
                continue;
            double factor = input_matrix[row][i];
            for (int col = 0; col < siz; col++)
            {
                input_matrix[row][col] -= factor * input_matrix[i][col];
                I[row][col] -= factor * I[i][col];
            }
        }
    }
    return I;
}
void print_matrix(vector<vector<double>> matrix)
{
    for (int i = 0; i <siz; i++)
    {
        for (int j = 0; j <siz; j++)
            write <<fixed<<setprecision(4)<<matrix[i][j] << " ";
        write << endl;
    }
    write <<endl;
}
vector<vector<double>> generate_inverse_serial(vector<vector<double>> input_matrix)//高斯约旦消元法
{
    vector<vector<double>> I = generate_identity();
    for (int i = 0; i < siz; i++)
    {
        if (abs(input_matrix[i][i]) <eps)//使主元不为0
        {
            for (int j = i + 1; j < siz; j++)
            {
                if (abs(input_matrix[j][i])>eps)
                {
                    swap(input_matrix[i], input_matrix[j]);
                    swap(I[i],I[j]);
                    break;
                }
                if (j == siz - 1)
                {
                    write << "Inverse does not exist for this matrix";
                    exit(0);
                }
            }
        }
        double scale = input_matrix[i][i];
        for (int col = 0; col < siz; col++)//使主元为1
        {
            input_matrix[i][col] = input_matrix[i][col] / scale;
            I[i][col] = I[i][col] / scale;
        }
        for (int row = 0; row < siz; row++)//使主元所在列的其他数为0
        {
            if(row==i)
                continue;
            double factor = input_matrix[row][i];
            for (int col = 0; col < siz; col++)
            {
                input_matrix[row][col] -= factor * input_matrix[i][col];
                I[row][col] -= factor * I[i][col];
            }
        }
    }
    return I;
}


int main()
{
    double dtime;
    vector<vector<double>> matrix;
    vector<vector<double>> matrix_serial;
    vector<vector<double>> matrix_parallel;

    // ifstream read;
    // read.open("in2.txt");
    
    write.open("out.txt");
    // matrix.resize(siz);
    // for (int i=0;i<siz;i++)
    // {
    //     matrix[i].resize(siz);
    //     for(int j=0;j<siz;++j)
    //         read>>matrix[i][j];
    // }
    matrix = generate_random_double_matrix();

    write << "Input Matrix is:\n";
    print_matrix(matrix);

    dtime = omp_get_wtime();
    matrix_parallel = generate_inverse_parallel(matrix);
    write << "Time taken in parallel:" << omp_get_wtime() - dtime << endl;
    write << "Parallel Matrix output is:\n";
    print_matrix(matrix_parallel);

    dtime = omp_get_wtime();
    matrix_serial = generate_inverse_serial(matrix);
    write << "Time taken in serial:" << omp_get_wtime() - dtime << endl;
    write << "Serial Matrix output is:\n";
    print_matrix(matrix_serial);
    return 0;
}