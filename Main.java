package pkg;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        try {
        Scanner in = new Scanner(System.in);
        System.out.println("How many soldiers?");
        int n = in.nextInt();
        final int k = 2; //skip is always 2
        System.out.println("The surviving soldier is at place " + josephus(n, k));
        } catch (InputMismatchException e){ //handle non-integer input
            System.err.println("Invalid input! Try again.");
            main(args);
        } catch (StackOverflowError e){ //handle too large of an input
            System.err.println("Input too large! Try again.");
            main(args);
        }

    }
    private static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
    /* The position returned by josephus(n - 1, k)
    is adjusted because the recursive call
    josephus(n - 1, k) considers the original
    position k%n + 1 as position 1 */
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }
}
