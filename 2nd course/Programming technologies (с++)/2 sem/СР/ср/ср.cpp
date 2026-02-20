#include <iostream>
using namespace std;

class KR {
private:
    float R;
    int T;
public:
    KR() {
        R = 7;
        T = 7;
    }
    ~KR() {
        cout << "Саргсян Ева Артуровна" << endl;
    }
    void EI() {
        cout << R << endl << T << endl;
    }
    KR RY(float x, int y) {
        R = x;
        T = y;
        return(*this);
    }
    KR operator / (KR y) {
        KR a;
        a.R = R / y.R;
        a.T = T / y.T;
        return a;
    }
    friend KR operator + (KR&, KR&);
};

KR operator + (KR& x, KR& y) {
    KR a;
    a.RY(x.R + y.R, x.T + y.T);
    return(a);
}

int main()
{
    setlocale(LC_ALL, "RUS");
    KR b, y, rh;
    b.RY(4.7, 4);
    y.RY(4.0, 5);
    rh = b / y;
    rh.EI();
    rh = y+b;
    rh.EI();
}