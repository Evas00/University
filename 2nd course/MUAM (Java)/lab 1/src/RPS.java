import java.util.Random;
import java.util.Scanner;

public class RPS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Выберите: Камень, Ножницы, Бумага");
        String user = scanner.next();

        int computer1 = random.nextInt(3) + 1; // 1 - камень, 2 - ножницы, 3 - бумага

        String computer2 = (computer1 == 1) ? "Камень" : (computer1 == 2) ? "Ножницы" : "Бумага";

        System.out.println("Ваш выбор: " + user);
        System.out.println("Выбор компьютера: " + computer2);

        String result;
        if (user.equals(computer2)) {
            result = "Ничья!";
        } else if ((user.equals("Ножницы") && computer2.equals("Бумага")) ||
                (user.equals("Бумага") && computer2.equals("Камень")) ||
                (user.equals("Камень") && computer2.equals("Ножницы"))) {
            result = "Вы выиграли!";
        } else {
            result = "Вы проиграли!";
        }
        System.out.println(result);
    }
}