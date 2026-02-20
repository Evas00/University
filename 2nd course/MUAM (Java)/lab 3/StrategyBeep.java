class StrategyBeep {
    private IBeep beepObject;

    StrategyBeep(IBeep beepStrategy) {
        this.beepObject = beepStrategy;
    }

    void setStrategy(IBeep beepStrategy) {
        this.beepObject = beepStrategy;
    }

    void sound() {
        beepObject.sound();
    }

    public static void main(String[] args) {
        StrategyBeep beep1 = new StrategyBeep(new Boom());
        StrategyBeep beep2 = new StrategyBeep(new Bam());
        beep1.sound();
        beep2.sound();

        StrategyBeep beep3 = new StrategyBeep(new Buh());
        beep3.sound();

        // Демонстрация смены стратегии
        System.out.println("\nМеняем стратегию для beep1:");
        beep1.setStrategy(new Buh());
        beep1.sound();

        System.out.println("Меняем стратегию для beep2:");
        beep2.setStrategy(new Boom());
        beep2.sound();
    }
}