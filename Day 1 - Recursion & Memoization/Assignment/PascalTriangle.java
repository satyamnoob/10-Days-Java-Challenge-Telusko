import java.util.*;

class PascalTriangle {

    public static void main(String[] args) {
        int rows = 5;

        List<List<Integer>> answer = pascalTriangleIterative(rows);
        System.out.println("Output after iterative approach - " + answer);


        answer = pascalTriangleRecursive(rows);
        System.out.println("Output after iterative approach - " + answer);
    }

    // Iterative Approach        --------------------------------------->

    public static List<List<Integer>> pascalTriangleIterative(int rows) {
        
        // Create an array list to store the answer result...
        List<List<Integer>> answer = new ArrayList<>();
        
        // Base case...
	    if (rows <= 0)  return answer;
        
        // Create an array list to store the prev triangle value for further addition...
	    ArrayList<Integer> prev = new ArrayList<>();
        
        // Inserting for the first row & store the prev array to the answer array...
	    prev.add(1);
	    answer.add(prev);
        
        // For rest of the rows, Traverse all elements through a for loop...
	    for (int i = 2; i <= rows; i++) {
            // Create another array to store the current triangle value...
		    ArrayList<Integer> curr = new ArrayList<>();
		    curr.add(1);    //first
            
            // Calculate for each of the next values...
		    for (int j = 0; j < prev.size() - 1; j++) {
                // Inserting the addition of the prev array two values...
			    curr.add(prev.get(j) + prev.get(j + 1));        //middle
		    }
            
            // Store the number 1...
		    curr.add(1);    //last
            
            // Store the value in the answer array...
		    answer.add(curr);
            
            // Set prev is equal to curr...
		    prev = curr;
	    }
	    
        return answer;      // Return the answer list of pascal values...
    }

    // Recursive Approach ------------------------------------------------->

    public static List<List<Integer>> pascalTriangleRecursive(int rows) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> cache = new HashMap<>(); // Memoization table

        if (rows <= 0) {
            return answer;
        }

        generateRows(rows, answer, cache); // helper function to generate rows

        return answer;
    }

    private static void generateRows(int rows, List<List<Integer>> answer, Map<Integer, List<Integer>> cache) {
        if (cache.containsKey(rows)) { // Check if the value is already memoized
            answer.add(cache.get(rows));
        } else {
            if (rows == 1) {
                // Base case: First row
                List<Integer> row = new ArrayList<>();
                row.add(1);
                answer.add(row);
                cache.put(1, row); // Memoize the computed row
            } else {
                // Recursive case: Generate previous rows
                generateRows(rows - 1, answer, cache);

                List<Integer> prevRow = answer.get(rows - 2); // Previous Row
                List<Integer> currRow = new ArrayList<>();
                currRow.add(1); // first

                for (int i = 1; i < rows - 1; i++) {
                    // Compute current row elements
                    int sum = prevRow.get(i - 1) + prevRow.get(i); // middle
                    currRow.add(sum);
                }

                currRow.add(1); // last
                answer.add(currRow);
                cache.put(rows, currRow); // Memoize the computed row
            }
        }
    }
}