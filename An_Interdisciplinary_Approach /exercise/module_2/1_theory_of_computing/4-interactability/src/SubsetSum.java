public class SubsetSum {

    // Function to check whether the chosen subset sums to zero
    public static boolean check(int[] values, boolean[] inSubset) {
        int sum = 0;
        int n = values.length;

        for (int i = 0; i < n; i++) {
            if (inSubset[i]) {
                sum += values[i];
            }
        }

        return sum == 0;
    }

    public static void main(String[] args) {
        
        int[] values = {1342, -1991, 231, -351, 1000};
        boolean[] inSubset = {true, true, false, true, true};

        // Print the chosen subset
        System.out.print("Subset: { ");
        for (int i = 0; i < values.length; i++) {
            if (inSubset[i]) System.out.print(values[i] + " ");
        }
        System.out.println("}");

        // Check if subset sums to zero
        if (check(values, inSubset))
            System.out.println("The subset sums to 0 (valid solution).");
        else
            System.out.println("The subset does NOT sum to 0.");
    }
}
