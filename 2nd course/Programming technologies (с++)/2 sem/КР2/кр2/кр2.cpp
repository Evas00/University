#include <iostream>
using namespace std;

class ellipse {
protected:
    double a, b;
public:
    ellipse(double a0, double b0) {
        a = a0;
        b = b0;
    }
    void in() {
        cin >> a >> b;
    }
    void out() {
        cout << a << ' ' << b << endl;
    }
    double area() {
        return 3.14 * a * b;
    }
};

class circle : public ellipse {
public:
    circle(double r) : ellipse(r, r) {}
    void in(){
        cin >> a;
        b = a;
    }
    circle operator +(circle other) {
        double area2 = this->area() + other.area();
        double r2 = sqrt(area2 / 3.14);
        return circle(r2);
    }
};

int main()
{
    setlocale(LC_ALL, "RUS");
    cout << "Саргсян Ева 14.05.25" << endl;

    ellipse e(3, 4);
    circle c(2), c1(4), c2(5);

    e.out();
    e.in();
    e.out();
    cout << e.area() << endl;
    cout << endl;

    c.out();
    c.in();
    c.out();
    cout << c.area() << endl;
    cout << endl;

    circle c3 = c1 + c2;
    cout << c1.area() << endl;
    cout << c2.area() << endl;
    cout << c3.area() << endl;
    c3.out();
}
