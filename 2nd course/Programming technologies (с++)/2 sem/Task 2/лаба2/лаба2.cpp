#define _CRT_SECURE_NO_WARNINGS
#define Cubyk(x) ((x)*(x)*(x))
#define Koren(x) (sqrt(x))
#include <iostream>
#include <string>
#include <math.h>

using namespace std;

void f1()
{
    FILE* file;
    int n = 10;
    float mas[10];

    file = fopen("2", "wb");
    mas[0] = 0.5;
    fwrite(&mas[0], sizeof(mas[0]), 1, file);

    for (int i = 1; i < n; i++) {
        mas[i] = 2.0 * i * mas[i - 1];
        fwrite(&mas[i], sizeof(mas[i]), 1, file);
    }
    fclose(file);
}

void f2()
{
    FILE* file;
    const int n = 10;
    float mas[n], sum = 0;

    file = fopen("2", "rb");

    for (int i = 0; i < n; i++) {
        fread(&mas[i], sizeof(mas[i]), 1, file);
        cout << mas[i] << endl;
        if (mas[i] > 0)
            sum += mas[i];
    }
    cout << sum;
    fclose(file);
}

void f3()
{
    FILE* file;
    float k;

    file = fopen("2", "rb");

    while (true) {
        fread(&k, sizeof(k), 1, file);
        if (feof(file))
            break;
        cout << k << endl;
    }
    fclose(file);
}

void f4()
{
    FILE* bf;
    FILE* tf;

    float k;

    tf = fopen("t2.txt", "w");
    bf = fopen("2", "rb");

    while (true) {
        fread(&k, sizeof(float), 1, bf);
        if (feof(bf))
            break;
        cout << k << endl;
        fprintf(tf, "%.3f\n", k);
    }
    fclose(bf);
    fclose(tf);
}

void f5(int pos, float a)
{
    FILE* file;

    file = fopen("2", "rb+");

    fseek(file, pos * sizeof(a), SEEK_SET);
    fwrite(&a, sizeof(a), 1, file);
    fclose(file);

    f3();
}

void f6()
{
    FILE* file;
    const int n = 5;
    float k;

    file = fopen("2", "rb");

    for (int i = 1; i <= n; i++) {
        fseek(file, -i * sizeof(k), SEEK_END);
        fread(&k, sizeof(k), 1, file);
        cout << k << endl;
    }
    fclose(file);
}

void f7(float x)
{
    cout << Cubyk(x) << endl << Koren(x);
}

int main()
{
    setlocale(LC_ALL, "RUS");
    cout << "Саргсян 19.02.25";

    int n = 1;
    while (n != 0) {
        cin >> n;
        switch (n){
        case 0:
            break;
        case 1:
            f1(); break;
        case 2:
            f2(); break;
        case 3:
            f3(); break;
        case 4:
            f4(); break;
        case 5: {
            int pos, a;
            cin >> pos >> a;
                f5(pos, a); 
                break;
        }
        case 6:
            f6(); break;
        case 7: {
            int x;
            cin >> x;
            f7(x);
            break;
        }
        }
    }
}