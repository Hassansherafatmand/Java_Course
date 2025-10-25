import java.util.Iterator;

public class RandomQueue <Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    @SuppressWarnings("unchecked")
	public RandomQueue() {
        items = (Item[]) new Object[1];
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public int size()       { return size; }

    public void enqueue(Item item) {
        if (size == items.length) resize(2 * items.length);
        items[size++] = item;
    }

    public Item sample() {
        int index = (int) (Math.random() * size);
        return items[index];
    }

    @SuppressWarnings("unchecked")
	private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) temp[i] = items[i];
        items = temp;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int current = 0;
            public boolean hasNext() { return current < size; }
            public Item next()      { return items[current++]; }
            public void remove()    { throw new UnsupportedOperationException(); }
        };
    }
}
