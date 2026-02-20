import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double w = scan.nextDouble();
        double h = scan.nextDouble();
        double ind = w / (h * h);
        System.out.println(ind);
    }
}