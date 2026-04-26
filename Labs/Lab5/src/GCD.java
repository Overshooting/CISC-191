import java.util.Scanner;

/**
 * This is a class that computes the GCD of two numbers based on user input
 *
 * @author Alexander Melis, aamelis@gmail.com
 * @version 1.0
 * @since 4/26/2026
 */

public class GCD {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int first, second;
        String divider = "----------------------------------";

        System.out.println(divider + "\nGreatest Common Divisor Calculator\n" + divider);

        System.out.print("Enter the first number: ");
        first = input.nextInt();

        System.out.print("Enter the second number: ");
        second = input.nextInt();

        System.out.println("The greatest common divisor of " + first + " and " + second + " is "
                + gcd(first, second));
    }

    public static int gcd(int m, int n) {
        if (m % n == 0)
            return n;
        else
            return gcd(n, m % n);
    }


}
