import javax.swing.*;
import java.awt.*;

class MyWindow extends JFrame {
    public MyWindow(String title, int width, int height) {
        super(title);
        setSize(width, height); // Устанавливаем размеры окна
        // Закрыть окно - закрыть приложение
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

/*public class MultipleWindows {
    public static void main(String[] args) {
        MyWindow window = new MyWindow("Мое первое окно", 400, 300);
        window.setVisible(true);
    }
}*/

public class MultipleWindows {
    private MyWindow mw;
    private static int counter = 1;
    private static boolean mainWindowExists = false;

    // Конструктор без параметров
    public MultipleWindows() {
        this.mw = new MyWindow("Без имени " + counter, 200, 200);
        counter++;
    }

    // Конструктор с параметрами
    public MultipleWindows(int width, int height, String title) {
        this.mw = new MyWindow(title, width, height);
    }

    // Метод для показа/скрытия окна
    public void showMyWindow(boolean visibility) {
        mw.setVisible(visibility);
    }

    // Метод для перемещения окна
    public void moveMyWindow(int horizontal, int vertical) {
        mw.setLocation(horizontal, vertical);
    }

    // Метод для назначения главного окна
    public void assignMainWindow() {
        if (!mainWindowExists) {
            mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWindowExists = true;
        }
    }

    // Метод для добавления кнопки
    public void addButton(JButton btn) {
        mw.add(btn);
    }

    // Метод для изменения менеджера расположения
    public void changeLayout(LayoutManager lm) {
        mw.setLayout(lm);
    }

    public static void main(String[] args) {
        // Создаем первое окно (без параметров)
        MultipleWindows fw1 = new MultipleWindows();
        fw1.showMyWindow(true);

        // Создаем второе окно (с параметрами)
        MultipleWindows fw2 = new MultipleWindows(300, 250, "Второе окно");
        fw2.showMyWindow(true);
        fw2.moveMyWindow(250, 0);

        // Назначаем второе окно главным
        fw2.assignMainWindow();
        //fw1.assignMainWindow(); // Не сработает, так как главное окно уже назначено

        // Создаем кнопку
        JButton btn = new JButton("Моя кнопка");
        btn.setBackground(Color.YELLOW);

        // Добавляем кнопку во второе окно
        fw2.addButton(btn);

        // Меняем менеджер расположения на FlowLayout
        fw2.changeLayout(new FlowLayout());

        // Обновляем окно, чтобы изменения вступили в силу
        fw2.mw.revalidate();
    }
}