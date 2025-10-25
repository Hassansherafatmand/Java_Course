import princetonLibs.*;

public class LoadBalance {

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);   // number of servers
        int n = Integer.parseInt(args[1]);   // number of items
        int s = Integer.parseInt(args[2]);   // number of random samples

        // Create server queues.
        RandomQueue<Queue<Integer>> servers = new RandomQueue<Queue<Integer>>();

        for (int i = 0; i < m; i++) {
            servers.enqueue(new Queue<Integer>());
        }

        // Assign each item to a server
        for (int j = 0; j < n; j++) {

            // Pick a random server, update if a new minimum is found
            Queue<Integer> min = servers.sample();
            for (int k = 1; k < s; k++) {
                Queue<Integer> queue = servers.sample();
                if (queue.length() < min.length()) min = queue;
            }

            // min is the shortest server queue
            min.enqueue(j);
        }

        int i = 0;
        double[] lengths = new double[m];
        for (Queue<Integer> queue : servers) {
            lengths[i++] = queue.length();
        }

        // Draw and display results
        StdDraw.setYscale(0, 2.0 * n / m);
        StdStats.plotBars(lengths);
    }
}
