interface IBeep { void sound(); }

class Boom implements IBeep {
    public void sound() {
        System.out.println("Бум!");
    }
}
class Bam implements IBeep {
    public void sound() {
        System.out.println("Бам!");
    }
}
class Buh implements IBeep {
    public void sound() {
        System.out.println("Бух!!!");
    }
}

//Основной клас
public class InheritedBeep {
    private IBeep beepObject;

    public InheritedBeep(int beepType) {
        switch(beepType) {
            case 0: beepObject = new Boom(); break;
            case 1: beepObject = new Bam(); break;
            case 2: beepObject = new Buh(); break;
            default: beepObject = new Boom();
        }
    }

    // Метод для воспроизведения звука
    public void sound() {
        beepObject.sound();
    }

    public static void main(String[] args) {
        InheritedBeep beep1 = new InheritedBeep(0);
        InheritedBeep beep2 = new InheritedBeep(1);
        InheritedBeep beep3 = new InheritedBeep(2);
        beep1.sound();
        beep2.sound();
        beep3.sound();
    }
}