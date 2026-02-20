class Student1 {//1
    private String education = "Среднее";
    // Конструктор с параметром
    public Student1(String education) {
        this.education = education;
    }
    // Конструктор без параметров
    public Student1() {}
    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Образование: " + education;
    }
}

class Student2 {//2
    private String name;
    private int age;
    private int yearOfStudy;
    // Конструктор с двумя параметрами
    public Student2(String name, int yearOfStudy) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
    }
    // Конструктор с тремя параметрами
    public Student2(String name, int age, int yearOfStudy) {
        this(name, yearOfStudy); // Вызов конструктора с двумя параметрами
        this.age = age; //явно инициализируем age
    }
    // Переопределение метода toString()
    @Override
    public String toString() {
        if (age == 0) {
            return name + ", нет данных, " + yearOfStudy + " курс";
        } else {
            return name + ", " + age + " лет, " + yearOfStudy + " курс";
        }
    }
}
//3
class Senior extends Student2 {
    private String theme;
    public Senior(String name, int age, String theme) {
        super(name, age, 4); // Вызов конструктора суперкласса
        this.theme = theme;         //инициализация поля темы
    }
    @Override
    public String toString() {
        return super.toString() + ", Тема выпускной работы: " + theme;
    }
}
//4
interface EmptyInterface {}
class Freshman extends Student2 implements EmptyInterface { //создаем вспомогательный класс, который является наследником student2 и реализует интерфейс
    public Freshman(String name, int age) {
        super(name, age, 1);//конструктов Student2
    }
}
public class Main {
    public static void main(String[] args) {    // передаем массив строк
        //1
        Student1 st1 = new Student1(); // без параметров
        Student1 st2 = new Student1("Высшее"); // с параметром
        System.out.println(st1);
        System.out.println(st2);
        //2
        Student2 st3 = new Student2("Ева", 2);// с 2 параметрами
        Student2 st4 = new Student2("Мариам", 22, 3);// с 3 параметрами
        System.out.println(st3);
        System.out.println(st4);
        //3
        Senior senior = new Senior("Ева", 25, "Авокадо");
        System.out.println(senior);
        //4
        boolean f1_1 = senior instanceof Student2;
        boolean f1_2 = senior instanceof Object;
        System.out.println("senior со Student2: " + f1_1);
        System.out.println("senior со Object: " + f1_2);

        Freshman fr = new Freshman("Мариам", 22); //проверить является ли freshman экзмепляром предыдущих классов и интерфейсов
        // Проверка принадлежности (fr экземпляр класса Student2)
        boolean f1 = fr instanceof Student2; //класс freshman - подкласc Student2
        boolean f2 = fr instanceof EmptyInterface;
        //boolean f3 = fr instanceof Senior;
        // не является экземпляром класса Senior, тк fr не является подклассом Senior

        System.out.println("fr со Student2: " + f1);
        System.out.println("fr со EmptyInterface: " + f2);
        //System.out.println("fr со Senior: " + f3);

        Object obj = fr; // Создание переменной типа Object
        boolean f3 = obj instanceof Student2;
        boolean f4 = obj instanceof EmptyInterface;
        boolean f5 = obj instanceof Senior;
        //ошибки нет ведь object супперкласс для всех классов и fr сразу является подклассом obj
        System.out.println("obj со Student2: " + f3);
        System.out.println("obj со EmptyInterface: " + f4);
        System.out.println("obj со Senior: " + f5);
    }
}
