import java.util.Random;

class Warrior {
    String name;
    int health;
    int energy;
    int magic;
    int attack;
    int defense;
    boolean frozen = false;
    int frozenTurns = 0;

    Random rand = new Random();

    // Конструктор
    public Warrior(String name, int health, int energy, int magic, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.energy = energy;
        this.magic = magic;
        this.attack = attack;
        this.defense = defense;
    }

    // Атака
    public void attack(Warrior enemy) {
        if (frozen) {
             System.out.println(name + " заморожен и не может атаковать");
             return;
        }
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
        if (frozen) {
            System.out.println(name + " заморожен и не может защищаться");
            health -= damage;
        } else {
            int damage2 = Math.max(0, damage - defense);
            health -= damage2;

            System.out.println(name + " получает " + damage2 + " урона");

            if (health <= 0) {
                health = 0;
                System.out.println(name + " повержен!");
            }
        }
    }

    // Защита
    public void defend() {
        if (frozen) {
            System.out.println(name + " заморожен и не может защищаться");
            return;
        }
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
        if (frozen) {
            System.out.println(name + " заморожен и не может отдыхать");
            return;
        }
        energy = Math.min(100, energy + 30);
        health = Math.min(100, health + 5);
        System.out.println(name + " отдыхает (+30 энергии, +5 здоровья)");
    }

    // Медитация
    public void meditate() {
        if (frozen) {
            System.out.println(name + " заморожен и не может отдыхать");
            return;
        }
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
                ", Защита: " + defense+
                ", Заморозка: " + frozen);
    }

    // Проверка жив ли воин
    public boolean isAlive() {
        return health > 0;
    }

    public void freeze(Warrior enemy) {
        if (magic < 40) {
            System.out.println(name + " не хватает магии для заморозки");
            return;
        }
        enemy.frozen = true;
        enemy.frozenTurns = 3;
        magic -= 40;
        System.out.println(name + " замораживает " + enemy.name + " на 3 хода");
    }

    public void updateFrozenStatus() {
        if (frozen) {
            frozenTurns--;
            if (frozenTurns <= 0) {
                frozen = false;
                System.out.println(name + " размораживается");
            }
        }
    }
}

// Класс Маг
class Mage extends Warrior {
    // Конструктор
    public Mage(String name) {
        super(name, 70, 60, 150, 15, 2);
    }

    // Переопределенный метод атаки с шансом заморозки
    @Override
    public void attack(Warrior enemy) {
        if (!enemy.frozen && rand.nextDouble()<0.45) {
            freeze(enemy);
        } else {
            castSpell(enemy);
        }
    }

    // Метод магического заклинания
    public void castSpell(Warrior enemy) {
        if (frozen) {
            System.out.println(name + " заморожен и не может использовать заклинание");
            return;
        }
        if (magic < 30) {
            System.out.println(name + " не хватает магии для заклинания");
            return;
        }

        int damage = 40 + rand.nextInt(21); // Урон 40-60
        magic -= 30;
        System.out.println(name + " использует магическое заклинание и наносит " + damage + " урона");
        enemy.takeDamage(damage);
    }
}

// Класс Лучник
class Archer extends Warrior {
    private int arrows = 3;        // Количество стрел

    // Конструктор
    public Archer(String name) {
        super(name, 90, 80, 80, 25, 8);
    }

    // Переопределенный метод атаки
    @Override
    public void attack(Warrior enemy) {
        if (arrows > 0) {
            shootArrow(enemy);
            if (arrows > 0 && rand.nextDouble() < 0.5) { // Второй выстрел 50% шанс
                shootArrow(enemy);
            }
        } else {
            super.attack(enemy);  // Обычная атака, если стрел нет
        }
    }

    // Метод выстрела из арбалета
    public void shootArrow(Warrior enemy) {
        if (frozen) {
            System.out.println(name + " заморожен и не может стрелять");
            return;
        }
        // Урон от стрелы (20-35)
        int damage = 20 + rand.nextInt(16);
        arrows--;
        System.out.println(name + " стреляет из арбалета и наносит " + damage + " урона (Осталось стрел: " + arrows + ")");
        enemy.takeDamage(damage);
    }
}


// Класс Рыцарь
class Knight extends Warrior {
    private int turnsSincePowerStrike = 0;  // Счетчик ходов (мощный удар)

    // Конструктор
    public Knight(String name) {
        super(name, 120, 120, 50, 35, 15);  // Высокие health, energy и defense
    }

    // Переопределенный метод атаки
    @Override
    public void attack(Warrior enemy) {
        turnsSincePowerStrike++;

        // Проверка возможности мощного удара
        if (turnsSincePowerStrike >= 10) {
            powerStrike(enemy);
            turnsSincePowerStrike = 0;
        } else if (rand.nextDouble()<0.5) {
            berserkAttack(enemy);
        } else {
            super.attack(enemy);
        }
    }

    // Метод мощного удара
    private void powerStrike(Warrior enemy) {
        if (frozen) {
            System.out.println(name + " заморожен и не может нанести мощный удар");
            return;
        }
        if (energy < 50) {
            System.out.println(name + " слишком устал для мощного удара");
            return;
        }

        // Урон = 70% текущего здоровья врага
        int damage = (int)(enemy.health * 0.7);
        energy -= 60;
        System.out.println(name + " наносит сокрушительный удар, снимая " + damage + " здоровья");
        enemy.takeDamage(damage);
    }

    // Метод атаки берсерка
    private void berserkAttack(Warrior enemy) {
        if (frozen) {
            System.out.println(name + " заморожен и не может нанести мощный удар");
            return;
        }
        if (energy < 60) {
            System.out.println(name + " слишком устал для атаки берсерка");
            return;
        }

        // Два удара с разным уроном
        int damage1 = attack + rand.nextInt(11);
        int damage2 = attack + rand.nextInt(11);
        energy -= 60;

        System.out.println(name + " в режиме берсерка атакует дважды: " + damage1 + " и " + damage2 + " урона");
        enemy.takeDamage(damage1);
        enemy.takeDamage(damage2);
    }
}


public class War2 {
    public static void main(String[] args) {
        // Создаем двух воинов
        Warrior war1 = new Knight("Рыцарь");
        Warrior war2 = new Mage("Маг");
        Warrior war3 = new Archer("Лучник");
        war1.showStats();
        war2.showStats();
        war3.showStats();
        System.out.println();

        while (war1.isAlive() && war2.isAlive()) {
            int ch = new Random().nextInt(5);
            switch (ch) {
                case 0:
                    ((Knight)war1).attack(war2); break;
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
                        ((Mage)war2).castSpell(war1); break;
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
            /*if (war3.isAlive()) {
                ch = new Random().nextInt(5);
                switch (ch) {
                    case 0:
                        ((Archer)war3).shootArrow(war1); break;
                    case 1:
                        war3.defend(); break;
                    case 2:
                        war3.rest(); break;
                    case 3:
                        war3.meditate(); break;
                    case 4:
                        war3.heal(); break;
                }
                war3.showStats();
            }*/
            System.out.println();
        }
        if (war1.isAlive()) {
            System.out.println(war1.name + " побеждает!");
        } else {
            System.out.println(war2.name + " побеждает!");
        }
    }
}