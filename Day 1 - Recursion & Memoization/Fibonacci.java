import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    
    private static Map<Integer, Integer> cache = new HashMap<>();  // Map for memoization.

    public static void main(String[] args) {
        int pos = 8;

        int result = fibIterative(pos);
        System.out.println("Fibonacci by iterative approach - " + result);

        result = fibRecursive(pos);
        System.out.println("Fibonacci by recursive approach - " + result);
    }

    private static int fibRecursive(int pos) {
        // Recursive Approach
        if(pos == 0)  
            return 0;

        if(pos == 1 || pos == 2)
            return 1;
        
        if(cache.containsKey(pos)) {  // Checking if current sub-problem is cached in the past
            return cache.get(pos);    // If yes return simply the value instead of calculating it again.
        }

        int result = fibRecursive(pos - 1) + fibRecursive(pos - 2);
        cache.put(pos, result);       // Storing the solution to a sub-problem for future use.
        return result;
    }

    public static int fibIterative(int pos) {
        // Iterative Approach
        int a = 0, b = 1, c = 0;
        
        // 0 1 1 2 3 5 8 13 21 34....
        // a b c
        for (int i = 2; i <= pos; i++) { // First two elements are already known so we start with 2
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    } 
}
