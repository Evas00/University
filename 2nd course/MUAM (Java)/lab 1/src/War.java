/*import java.util.Random;

class Warrior {
    String name;
    int health = 100;
    int energy = 100;
    int magic = 100;
    int attack = 30;
    int defense = 5;

    Random rand = new Random();

    // Конструктор
    public Warrior(String name) {
        this.name = name;
    }

    // Атака
    public void attack(Warrior enemy) {
        if (energy < 20) {
            System.out.println(name + " слишком устал для атаки");
            return;
        }

        int damage = attack + rand.nextInt(6);  // + случайный урон 0-5
        energy -= 20;

        System.out.println(name + " атакует с силой " + damage);
        enemy.takeDamage(damage);
    }

    // Получение урона
    public void takeDamage(int damage) {
        int damage2 = Math.max(0, damage - defense);
        health -= damage2;

        System.out.println(name + " получает " + damage2 + " урона");

        if (health <= 0) {
            health = 0;
            System.out.println(name + " повержен!");
        }
    }

    // Защита
    public void defend() {
        if (energy < 10) {
            System.out.println(name + " слишком устал для защиты");
            return;
        }

        defense = Math.min(20, defense + 3);
        energy -= 10;
        System.out.println(name + " готовится к защите (+3 к защите)");
    }

    // Отдых
    public void rest() {
        energy = Math.min(100, energy + 30);
        health = Math.min(100, health + 5);
        System.out.println(name + " отдыхает (+30 энергии, +5 здоровья)");
    }

    // Медитация
    public void meditate() {
        magic = Math.min(100, magic + 30);
        System.out.println(name + " медитирует (+30 магии)");
    }

    // Заклинание лечение
    public void heal() {
        if (magic < 25) {
            System.out.println(name + " не хватает магии для лечения!");
            return;
        }

        int healAmount = 15 + rand.nextInt(11);
        health = Math.min(100, health + healAmount);
        magic -= 25;

        System.out.println(name + " лечится на " + healAmount + " здоровья");
    }

    // Показатель статов
    public void showStats() {
        System.out.println("[" + name + "] Здоровье: " + health +
                ", Энергия: " + energy +
                ", Магия: " + magic +
                ", Защита: " + defense);
    }

    // Проверка жив ли воин
    public boolean isAlive() {
        return health > 0;
    }
}

public class War {
    public static void main(String[] args) {
        // Создаем двух воинов
        Warrior war1 = new Warrior("Воин А");
        Warrior war2 = new Warrior("Воин Б");
        war1.showStats();
        war2.showStats();
        System.out.println();

        while (war1.isAlive() && war2.isAlive()) {
            int ch = new Random().nextInt(5);
            switch (ch) {
                case 0:
                    war1.attack(war2);
                    break;
                case 1:
                    war1.defend(); break;
                case 2:
                    war1.rest(); break;
                case 3:
                    war1.meditate(); break;
                case 4:
                    war1.heal(); break;
            }
            war1.showStats();
            if (war2.isAlive()) {
                ch = new Random().nextInt(5);
                switch (ch) {
                    case 0:
                        war2.attack(war1);
                        break;
                    case 1:
                        war2.defend(); break;
                    case 2:
                        war2.rest(); break;
                    case 3:
                        war2.meditate(); break;
                    case 4:
                        war2.heal(); break;
                }
                war2.showStats();
            }
            System.out.println();
        }
        if (war1.isAlive()) {
            System.out.println(war1.name + " побеждает!");
        } else {
            System.out.println(war2.name + " побеждает!");
        }
    }
}*/