#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <math.h>

using namespace std;

void f1(double* mas, int n, double& min, int& id)
{
    cout << "Double" << endl;
    min = mas[0];
    id = 0;
    for (int i = 1; i < n; i++)
    {
        if (mas[i] < min)
        {
            min = mas[i];
            id = i;
        }
    }
}

void f1(int* mas, int n, int& min, int& id)
{
    cout << "Int" << endl;
    min = mas[0];
    id = 0;
    for (int i = 1; i < n; i++)
    {
        if (mas[i] < min)
        {
            min = mas[i];
            id = i;
        }
    }
}

template <class DA, class DADA>
DA f2(DADA* mas, int k, int& n, DADA& min) {
    DADA result;
    int i = 0;
    n = i;
    min = mas[i];
    for (i; i < k; i++) {
        if (mas[i] < min) {
            min = mas[i];
            n = i;
        }
    }
    result = min * n;
    return result;
}


int main()
{
    setlocale(LC_ALL, "RUS");
    cout << "Саргсян 26.02.25" << endl;
    double* mas1 = new double[10];

    for (int i = 0; i < 10; i++)
    {
        mas1[i] = ((-2.5 + 0.5 * i) * (-2.5 + 0.5 * i) - 1) / ((-2.5 + 0.5 * i) * (-2.5 + 0.5 * i) + 1);
        cout << mas1[i] << ' ';
    }
    cout << endl;

    int* mas2 = new int[10];
    int t = 1;

    for (int i = 0; i < 10; i++)
    {
        mas2[i] = t * (i * i * i + 2);
        t *= -1;
        cout << mas2[i] << ' ';
    }
    cout << endl;
    {
        double min1, res1 = 0;
        int id1;
        int  min2, id2, res2 = 0;

        f1(mas1, 10, min1, id1);
        f1(mas2, 10, min2, id2);


        cout << min1 << ' ' << id1 << endl;
        cout << min2 << ' ' << id2 << endl;
    }
    cout << endl;
    {
        double min1, res1 = 0;
        int id1;
        int  min2, id2, res2 = 0;
        cout << ' ' << min1 << ' ' << id1 << ' ' << f2<double>(mas1, 10, id1, min1) << endl;

        cout << ' ' << min2 << ' ' << id2 << ' ' << f2<int>(mas2, 10, id2, min2) << endl;
    }
    int n, m;
    cin >> n >> m;

    double** masnm = new double* [n];
    t = 1;

    for (int i = 0; i < n; i++)
    {
        masnm[i] = new double[m];
        for (int j = 0; j < m; j++)
        {
            masnm[i][j] = t * (2.0 * i * j) / (i + j + 1);
            cout << ' ' << masnm[i][j];
        }
        t *= -1;
        cout << endl;
    }
}
