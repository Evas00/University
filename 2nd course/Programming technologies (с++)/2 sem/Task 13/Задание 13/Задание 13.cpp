#include <iostream>
using namespace std;

class figure {
public:
	virtual double area() = 0;
};

class ellipse : public figure {
protected:
    double a = 0;
    double b = 0;
public:
    ellipse(double a0, double b0) {
        a = a0;
        b = b0;
    }
    void change(double a0, double b0) {
        a = a0;
        b = b0;
    }
    double area() override {
        return 3.14 * a * b;
    }
    void out() {
        cout << a << ' ' << b << endl;
    }
};

class rectangle : public figure {
protected:
	double a, b;
public:
	rectangle(double st1, double st2){
		a = st1;
		b = st2;
	}
	void change(double st1, double st2) {
		a = st1;
		b = st2;
	}
	double area() override {
		return a * b;
	}
    void out() {
        cout << a << ' ' << b << endl;
    }
};

class circle : public ellipse {
public:
    circle(double r) : ellipse(r, r) {}
    void set(double r) {
        a = b = r;
    }
    void out() {
        cout << a << endl;
    }
};

class square : public rectangle {
public:
    square(double c) : rectangle(c, c) {}
    void set(double c) {
        a = b = c;
    }
    void out() {
        cout << a << endl;
    }
};

int main()
{
    setlocale(LC_ALL, "RUS");
    cout << "Саргсян Ева 30.04.25" << endl;


    figure* p;
    ellipse ellipse(3, 4);      
    p = &ellipse;
    p->area();



    /*rectangle rectangle(5, 7);
    circle circle(3);	
    square square(6);
    
    ellipse.out();
    ellipse.change(5, 7);
    ellipse.out();
    cout << ellipse.area() << endl;
    cout << endl;

    rectangle.out();
    rectangle.change(3, 4);
    rectangle.out();
    cout << rectangle.area() << endl;
    cout << endl;
    
    circle.out();
    circle.change(6,6);
    circle.out();
    cout << circle.area() << endl;
    cout << endl;

    square.out();
    square.change(3, 3);
    square.out();
    cout << square.area() << endl;
    cout << endl;*/

}
