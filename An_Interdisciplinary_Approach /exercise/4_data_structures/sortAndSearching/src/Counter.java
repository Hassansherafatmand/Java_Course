public class Counter implements Comparable<Counter> {

    private int count;

    // Constructor
    public Counter(String words, int count) {
        this.count = count;
    }

    // Compare by count value
    @Override
    public int compareTo(Counter other) {
        if (count < other.count) return -1;
        else if (count > other.count) return 1;
        else return 0;
    }

       
    @Override
    public String toString() {
        return String.valueOf(count);
    }

	public void increment() {
		count++;
		
	}
}
