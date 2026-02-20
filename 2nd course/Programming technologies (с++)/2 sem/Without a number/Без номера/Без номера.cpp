#include <iostream>
using namespace std;

class Massivi {
protected:
    double* ukaz;
    int n;
public:
    Massivi(int n) {
        this->n = n;
        ukaz = new double[n]{0.0};
    }

    void OutMas() {
        for (int i = 0; i < n; i++) {
            cout << ukaz[i] << ' ';
        }
        cout << endl;
    }

    void InMas(double a, double b) {
        for (int i = 0; i < n; i++) {
            ukaz[i] = a * i / b * 1.0;
        }
    }

    double& operator[] (int i) {
        return ukaz[i];
    }
};

// Наследуемый класс
class Ujas : public Massivi {
public:
     Ujas(int n) : Massivi(n) {};

     Ujas operator+(Ujas toje){
        Ujas res(n);
        for (int i = 0; i < n; i++) {
            res[i] = ukaz[i] + toje[i];
        }
        return res;
     }

     friend Ujas operator-(Ujas b, Ujas a) {
         int n = b.n;
         Ujas res(n);
         for (int i = 0; i < n; ++i) {
             res[i] = b[i]-a[i];
         }
         return res;
     }
};

int main()
{
    setlocale(LC_ALL, "RUS");
    int n = 10;
    Massivi mas1(n), mas2(n), mas3(n);
    mas1.InMas(2.0, 3.0);
    mas2.InMas(1.0, 3.0);
    mas1.OutMas();
    mas2.OutMas();
    mas3.OutMas();

    cout << endl;
    for (int i = 0; i < n; i++) {
        mas3[i] = mas2[i] + mas1[i];
    }
    mas1.OutMas();
    mas2.OutMas();
    mas3.OutMas();

    cout << endl;

    n = 5;
    Ujas mas2_1(n), mas2_2(n);
    mas2_1.InMas(1.0, 2.0);
    mas2_2.InMas(1.0, 3.0);
    mas2_1.OutMas();
    mas2_2.OutMas();
    cout << endl;
    Ujas mas2_3 = mas2_1 - mas2_2;
    mas2_3.OutMas();
    cout << endl;
    mas2_3 = mas2_1 + mas2_2;
    mas2_3.OutMas();
}