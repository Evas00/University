#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

template <typename T>
class CName {
private:
    const char* I;
public:
    CName(const char* filename) {
        I = filename;
    }
    ~CName() {
        cout << "Саргсян Ева Артуровна" << endl;
    }
    void OutF() {
        FILE* File = fopen(I, "rb");
        while (true) {
            T data;
            fread(&data, sizeof(T), 1, File);
            if (feof(File)) break;
            cout << data << ' ';
        }
        cout << endl;
        fclose(File);
    }

    void Cor(int i1, const T& i2) {
        FILE* File = fopen(I, "rb");
        fseek(File, i1 * sizeof(T), SEEK_SET);
        fwrite(&i2, sizeof(int), 1, File);
        fclose(File);
    }
};

int main()
{
    setlocale(LC_ALL, "RUS");
    int t = 1;
    int* mas = new int[13];
    FILE* File = fopen("NFil.bin", "wb");
    for (int i = 0; i < 13; i++) {
        mas[i] = 2 * i * t;
        t *= -1;
        fwrite(&mas[i], sizeof(mas[i]), 1, File);
    }
    fclose(File);
    CName<int> intFile("NFil.bin");
    intFile.OutF();
    intFile.Cor(5, 12);
    intFile.OutF();
    return 0;
}