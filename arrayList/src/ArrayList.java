public class ArrayList<T> {

    private final int SIZE = 10;
    private Object[] values;
    private int size = 0;

    public ArrayList() {
        this.values = new Object[SIZE];
    }

    public void add(T value) {
        if (size >= this.values.length) {
            Object[] copy = this.values;
            Object[] bridge = new Object[this.values.length + SIZE];
            System.arraycopy(copy, 0, bridge, 0, this.values.length);
            this.values = bridge;
        }
        this.values[size++] = value;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) this.values[index];
    }

    public int size() {
        return this.size;
    }


}
