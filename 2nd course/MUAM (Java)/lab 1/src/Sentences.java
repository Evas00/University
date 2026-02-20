import java.util.Random;
import java.util.Scanner;

public class Sentences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите количество предложений: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int ch = random.nextInt(10) + 1;
            switch (ch) {
                case 1:
                    System.out.print("Товарищи! ");
                    break;
                case 2:
                    System.out.print("с другой стороны ");
                    break;
                case 3:
                    System.out.print("равным образом ");
                    break;
                case 4:
                    System.out.print("Не следует, однако, забывать, что ");
                    break;
                case 5:
                    System.out.print("Таким образом ");
                    break;
                case 6:
                    System.out.print("Повседневная практика показывает, что ");
                    break;
                case 7:
                    System.out.print("Значимость этих проблем настолько очевидна, что ");
                    break;
                case 8:
                    System.out.print("Разнообразный и богатый опыт ");
                    break;
                case 9:
                    System.out.print("Задача организации, в особенности же ");
                    break;
                case 10:
                    System.out.print("Идейные соображения высшего порядка, ");
                    break;
            }

            ch = random.nextInt(10) + 1;
            switch (ch) {
                case 1:
                    System.out.print("реализация намеченных планов ");
                    break;
                case 2:
                    System.out.print("рамки и место обучения кадров ");
                    break;
                case 3:
                    System.out.print("постоянный количественный рост и сфера нашей активности ");
                    break;
                case 4:
                    System.out.print("сложившаяся структура организации ");
                    break;
                case 5:
                    System.out.print("новая модель организационной деятельности ");
                    break;
                case 6:
                    System.out.print("дальнейшее развитие различных форм деятельности ");
                    break;
                case 7:
                    System.out.print("постоянное информационно - пропагандистское обеспечение нашей деятельности ");
                    break;
                case 8:
                    System.out.print("укрепление и развития структуры ");
                    break;
                case 9:
                    System.out.print("консультация с широким активом ");
                    break;
                case 10:
                    System.out.print("начало повседневной работы по формированию позиции ");
                    break;
            }

            ch = random.nextInt(10) + 1;
            switch (ch) {
                case 1:
                    System.out.print("играет важную роль в формировании ");
                    break;
                case 2:
                    System.out.print("требуют от нас анализа ");
                    break;
                case 3:
                    System.out.print("требуют определения и уточнения ");
                    break;
                case 4:
                    System.out.print("способствуют подготовке и реализации ");
                    break;
                case 5:
                    System.out.print("обеспечивает широкому кругу специалистов) участие в формировании ");
                    break;
                case 6:
                    System.out.print("позволяет выполнить важные задания по разработке ");
                    break;
                case 7:
                    System.out.print("в значительной степени обуславливает создание ");
                    break;
                case 8:
                    System.out.print("позволяет оценить значение ");
                    break;
                case 9:
                    System.out.print("представляет собой интересный эксперимент проверки ");
                    break;
                case 10:
                    System.out.print("влечет за собой процесс внедрения и модернизации ");
                    break;
            }

            ch = random.nextInt(10) + 1;
            switch (ch) {
                case 1:
                    System.out.print("существующих финансовых и административных условий");
                    break;
                case 2:
                    System.out.print("дальнейших направлений развития");
                    break;
                case 3:
                    System.out.print("системы массового участия");
                    break;
                case 4:
                    System.out.print("позиций, занимаемых участниками в отношении поставленных задач");
                    break;
                case 5:
                    System.out.print("новых предложений");
                    break;
                case 6:
                    System.out.print("направлений прогрессивного развития");
                    break;
                case 7:
                    System.out.print("системы обучения кадров, соответствующей насущным потребностям");
                    break;
                case 8:
                    System.out.print("соответствующий условий активизации");
                    break;
                case 9:
                    System.out.print("модели развития");
                    break;
                case 10:
                    System.out.print("форм воздействия");
                    break;
            }

            System.out.println(".");
        }
    }
}