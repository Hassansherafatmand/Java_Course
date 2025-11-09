public class Perfect {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);

        for (long n = 1; ; n += x) {
            long sum = 0;
            for (long i = 1; i < n; i++)
                if (n % i == 0) sum += i;

            System.out.println("The sum of the divisors of " + n + " is " + sum);
            if (sum == n) {
                System.out.println("Perfect number found: " + n);
                break;
            }
        }
    }
}