import java.util.Random;

public class laba081 {
    public static void main(String[] args) {
        String[] mas1 = {"1-1", "1-2", "1-3", "1-4", "1-5", "1-6"};
        String[] mas2 = {"2-1", "2-2", "2-3", "2-4", "2-5", "2-6"};
        String[] mas3 = {"3-1", "3-2", "3-3", "3-4", "3-5", "3-6"};
        int i1=0, i2=0, i3=0;
        Random random = new Random();

        while (i1< mas1.length || i2< mas2.length || i3< mas3.length){
            int n = random.nextInt(3);;
            switch (n) {
                case 0:
                    if (i1 < mas1.length) {
                        System.out.println(mas1[i1]);
                        i1++;
                    }
                    break;
                case 1:
                    if (i2 < mas2.length) {
                        System.out.println(mas2[i2]);
                        i2++;
                    }
                    break;
                case 2:
                    if (i3 < mas3.length) {
                        System.out.println(mas3[i3]);
                        i3++;
                    }
                    break;
            }
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException _) {}
        }
    }
}