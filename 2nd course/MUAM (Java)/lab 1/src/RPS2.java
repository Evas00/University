import java.util.Random;
import java.util.Scanner;

public class RPS2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Камень", "Ножницы", "Бумага", "Ящерица", "Спок"};
        int u = 0;
        int c = 0;

            while (true) {
            System.out.println("Выберите: Камень, Ножницы, Бумага, Ящерица, Спок");
            String user1 = scanner.next();
            int user2 = (user1.equals("Камень")) ? 1 : (user1.equals("Ножницы")) ? 2 : (user1.equals("Бумага")) ? 3 : (user1.equals("Ящерица")) ? 4 : 5;
            System.out.println("Ваш выбор: " + user1);

            int computer = random.nextInt(5) + 1;
            System.out.println("Выбор компьютера: " + choices[computer - 1]);
            int r = 1;
            if (user2 == computer) {
                System.out.println("Ничья!");
                r = 2;
            } else {
                switch (user2) {
                    case 1: { // Камень
                        if ((computer == 3) || (computer == 4)) {
                            r = 0;
                        }
                    }
                    case 2: { // Ножницы
                        if ((computer == 1) || (computer == 5)) {
                            r = 0;
                        }
                    }
                    case 3: { // Бумага
                        if ((computer == 2) || (computer == 4)) {
                            r = 0;
                        }
                    }
                    case 4: { // Ящерица
                        if ((computer == 1) || (computer == 2)) {
                            r = 0;
                        }
                    }
                    case 5: { // Спок
                        if ((computer == 3) || (computer == 4)) {
                            r = 0;
                        }
                    }
                }
            }

            if (r == 0) {
                c++;
                System.out.println("Вы проиграли!");
            } else if (r == 1) {
                u++;
                System.out.println("Вы выиграли!");
            }

            System.out.println("Счёт: Вы " + u + " - " + c + " Компьютер");

            System.out.println("Хотите сыграть ещё раз? (да/нет)");
            String play = scanner.next();
            if (play.equals("нет")) {
                break;
            }
        }
    }
}