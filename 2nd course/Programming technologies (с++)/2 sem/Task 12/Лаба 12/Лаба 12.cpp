#include <iostream>
using namespace std;

class figure {
protected:
	double x, y;
public:
	figure(double x1, double y1) {
		x = x1;
		y = y1;
	}
	virtual double area() = 0;
};

class circle : public figure {
protected:
	double r;
public:
	circle(double radius, double x, double y) : figure(x, y) {
		r = radius;
	}
	void change(double radius) {
		r = radius;
	}
	void out() {
		cout << r << endl;
	}
	double area() {
		double itog = 0;
		itog = 3.14 * r * r;
		return itog;
	}
};

class square : public figure {
protected:
	double a;
public:
	square(double st, double x, double y) : figure(x, y) {
		a = st;
	}
	void change(double st) {
		a = st;
	}
	void out() {
		cout << a << endl;
	}
	double area() {
		double itog = 0;
		itog = a * a;
		return itog;
	}
};

class rectangle : public figure {
protected:
	double a, b;
public:
	rectangle(double st1, double st2, double x, double y) : figure(x, y) {
		a = st1;
		b = st2;
	}
	void change(double st1, double st2) {
		a = st1;
		b = st2;
	}
	void out() {
		cout << a << ' ' << b << endl;
	}
	rectangle operator +(rectangle G) {
		rectangle itog(0, 0, 0, 0);
		itog.change(a + G.a, b + G.b);
		return itog;
	}
	double area() {
		double itog = 0;
		itog = a * b;
		return itog;
	}
};

int main()
{
	setlocale(LC_ALL, "RUS");
	double p;
	cout << "Саргсян Ева 23.04.25" << endl;

	cout << "Квадрат" << endl;
	square k(5, 0, 0);
	k.out();
	k.change(4);
	k.out();
	square* u1 = &k;
	//объявление указателя на объект класса, берем адреса объекта k 
	//для доступа к его методам и полям
	p = u1->area();
	cout << p << endl << endl;

	cout << "Прямоугольник" << endl;
	rectangle a(1, 2, 0, 0), b(2, 3, 0, 0), c(0, 0, 0, 0);
	a.out();
	b.out();
	c = a + b;
	c.out();
	rectangle* u2 = &c;
	//объявление указателя на объект класса, берем адреса объекта c 
	//для доступа к его методам и полям
	p = u2->area();
	cout << p << endl << endl;

	cout << "Круг" << endl;
	circle krug(2, 3, 5);
	krug.out();
	krug.change(3);
	krug.out();
	circle* u3 = &krug;
	p = u3->area();
	//объявление указателя на объект класса, берем адреса объекта krug 
	//для доступа к его методам и полям
	p = u2->area();
	cout << p << endl << endl;
}