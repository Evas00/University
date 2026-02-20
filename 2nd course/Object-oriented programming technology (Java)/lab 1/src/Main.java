//2
class IntPoint {
    int x;
    int y;
    //Конструктор
    public IntPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void change(int x0,int y0) {
        x = x0;
        y = y0;
    }
    @Override
    public String toString() {
        return "x=" + x + " y=" + y;
    }
}

public class Main {
    public static void main(String[] args) {
        { //1
            //double x= 1/2;
            //System.out.print(x);

            //int x=1;
            //byte b=x;
            //Нельзя приводить больший тип к меньшему (потеря данных)

            //byte b=1;
            //byte c=b+1;
            //1 integer, поэтому не допускает перевод

            //byte b=5;
            //byte c=-b;
            //byte принимает значения только от 0 до 255

            //int x=0;
            //x--;
            //System.out.print(x);
            //x++;
            //System.out.print(x);

            //System.out.print(1/0.0);
            //infinity
            //System.out.print(1/0);
            //Ошибка деления на ноль

            //int a=2;
            //int b=a;
            //a=3;
            //System.out.print(a);
            //System.out.print(b);
            //Это переменнные примитивного типа
        }
        {//2
            //IntPoint z1 = new IntPoint(4, 5);
            //IntPoint z2 = z1;
            //System.out.println(z1);
            //System.out.println(z2);
            //z1.change(2, 3);
            //System.out.println(z1);
            //System.out.println(z2);
            //Изменились оба элемента, потому что хранятся ссылки указывающие на элемент
        }
        {//3
            //Integer w1 = 15;
            //System.out.println(w1.byteValue());
            //System.out.println(w1.floatValue());
            //Integer w2 = w1 * w1;
            //System.out.println(w2.byteValue());
            //System.out.println(w2.floatValue());
            //При переводе в байты возникает потеря данных
        }
        {//4
            //int[] arr = {1, 2, 3, 4, 5};
            //int[] a = new int[10];
            //arr = a;
            //System.out.println(arr.length);
            //Это ссылочный тип данных и при присвоении arr ссылки на 'a' получаем массив инициализированный длиной 10 элементов

            double[] mas = {1.0, 2.0, 3.0, 4.0, 5.0};
            //System.out.println(sum1(mas));
            //System.out.println(sum2(mas));
            //Результаты индентичны
            //static метод был использован, чтобы вызывать его можно было только через имя класса, но не через экземпляры

            Main obj = new Main();
            System.out.println((obj.sum1(mas)));
            System.out.println((obj.sum2(mas)));
            //Создала экземпляр класса Main и только потом использовал методы не static, которые разрешены в экземлярах
        }
    }

    double sum1(double[] mas) {
        double s = 0;
        for (int i = 0; i < 5; i++) {
            s += mas[i];
        }
        return s;
    }
     double sum2(double[] mas) {
        double s = 0;
        for (double elementVariable : mas) {
            s += elementVariable;
        }
        return s;
    }
}

