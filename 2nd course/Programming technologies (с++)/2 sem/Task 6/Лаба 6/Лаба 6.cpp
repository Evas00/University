#include <iostream>
#include <cmath>
using namespace std;

class chuy
{
private:						                                    
    double zel;         //1 Реальная часть
    double chor;        //1 Мнимая часть

public:
    double getzel();	//2 Получение реальной части	                                             
    double getchor();	//2	Получение мнимой части	                                            
    void scan();	    //2	Ввод значений		                                   
    void print();		//2	Вывод значений		                                  
    chuy()              //3 Конструктор по-умолчанию
    {
        zel = 0;
        chor = 0;
    }
    chuy(double zelValue, double chorValue)   //3 Конструктор с параметрами
    {
        zel = zelValue;
        chor = chorValue;
    }
    ~chuy()  //4 Деструктор
    {
        cout << "Деструктор работает " << endl;
    }
    chuy operator+ (const chuy& z)   //6 Переопределение оператора +
    {
        return chuy(zel + z.zel, chor + z.chor);
    }
    friend chuy operator- (const chuy& z, const chuy& c);  //7 Дружественная функция для -
};

double chuy::getzel()	//2 Получение реальной части                             
{
    return zel;
}

double chuy::getchor()	   //2 Получение мнимой части	                         
{
    return chor;
}

void chuy::scan()   //2 Ввод значений
{
    cin >> zel;
    cin >> chor;
}

void chuy::print()	//2 Вывод значений
{
    cout <<  zel << " +(" << chor << ")i" << endl;
}

chuy sum(chuy& z, chuy& c)   //5 +
{
    return chuy(z.getzel() + c.getzel(), z.getchor() + c.getchor());
}

chuy operator-(const chuy& z, const chuy& c)   //7 -
{
    return chuy(z.zel - c.zel, z.chor - c.chor);
}

int main()
{
    setlocale(LC_ALL, "RUS");

    cout << "Саргсян 05.03.25" << endl;

    chuy a;                
    a.scan();   
    a.print();  

    chuy b(8, 9);
    b.print();

    chuy c = sum(a, b);
    c.print();

    chuy d = a + b;
    d.print();

    chuy f = a - b;  
    f.print();
}