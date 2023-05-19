/**
 * factorial
 */
public class Factorial {

    public static void main(String[] args) {
        int num = 5;

        int factorial = factorialIterative(num);
        System.out.println("Factorial by iterative approach - " + factorial);
        
        factorial  = factorialRecursive(num);
        System.out.println("Factorial by recursive approach - " + factorial);
    }

    private static int factorialRecursive(int num) {
        if(num == 0)
            return 1;
        
        return num * factorialRecursive(num - 1);
    }

    private static int factorialIterative(int num) {
        int factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
