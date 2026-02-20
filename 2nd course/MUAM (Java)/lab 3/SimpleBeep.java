public class SimpleBeep {
    String[] signals = {"Бум!", "Бам!", "Бух!"};
    int signalType;

    public SimpleBeep(int Id) {
        if (Id >= 0 && Id < signals.length) {
            this.signalType = Id;
        } else {
            this.signalType = 0;
        }
    }
    // Метод для воспроизведения звука
    public void sound() {
        System.out.println(signals[signalType]);
    }

    public static void main(String[] args) {
        SimpleBeep beep1 = new SimpleBeep(0);
        SimpleBeep beep2 = new SimpleBeep(1);
        SimpleBeep beep3 = new SimpleBeep(2);
        beep1.sound();
        beep2.sound();
        beep3.sound();
    }
}