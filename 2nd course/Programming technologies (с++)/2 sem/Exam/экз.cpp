#include <iostream>
using namespace std;

class EE {
private:
    char k14;
protected:
    double fk;
    int G2(char){}
public:
    string f3(void){}
};

class EE2 {
private:
    float okl;
protected:
    string Fru;
    double f1(double){}
public:
    void fk(void){}
};

class B1EE: public EE, protected EE2 {
private:
    double cnc;
public:
    void fc(double){}
};

class CP: public EE2 {
protected:
    double nd;
    int f(int){}
};

class DP: private CP {
private:
    char chf;
public:
    float f(int, int){}
};

int main()
{
    EE ee_fk();
    EE2 ee2_fru();
    EE2 ee2_okl();
    B1EE b1ee_cnc();
    CP cp_nd();
    DP dp_chf();
}



/*class Aircraft {
protected:
    int Hi;
    int C_mem;
public:
    Aircraft(int Hi0, int C_mem0) {
        Hi = Hi0;
        C_mem = C_mem0;
    }
    int getHi() { return Hi; }
protected:
    int getC_() { return C_mem; }
};

class Reactive: public Aircraft {
protected:
    int C_eng;
public:
    Reactive(int Hi0, int C_mem0, int C_eng0=2): Aircraft(Hi0, C_mem0) { C_eng = C_eng0; }
    void Out() {
        cout << "Поля: " << Hi << ", " << C_mem << ", " << C_eng << endl;
    }
};

int main()
{
    setlocale(LC_ALL, "RUS");
    Reactive samolet(2, 10, 4);
    samolet.Out();
}*/
