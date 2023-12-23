
import java.util.Scanner;

public class Main {
    public static String calc (String input) throws Exception {

        Interpretator inter = new Interpretator();
        String s = inter.interpretator(input);
        return s;
    }

    public static void main(String[] args) throws Exception {

        //ввод выражения
        Scanner scan = new Scanner(System.in);
        System.out.println("Input:");
        String input = scan.nextLine();
        scan.close();
        System.out.println("Output:");
        System.out.println(calc(input));
    }

}