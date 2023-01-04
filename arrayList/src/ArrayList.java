public class ArrayList<T> {

    /**
     * Author: Sofian Ben Hamman
     * Version: 1.2
     * Description: Own implementation of an ArrayList.
     */

    private final int SIZE = 10;
    private Object[] values;
    private int size = 0;

    public ArrayList() {
        this.values = new Object[SIZE];
    }

    /**
     * Appends the element at the end of the list.
     * @param value: Value to append in the list.
     */
    public void add(T value) {
        if (size >= this.values.length) {
            Object[] copy = this.values;
            Object[] bridge = new Object[this.values.length + SIZE];
            System.arraycopy(copy, 0, bridge, 0, this.values.length);
            this.values = bridge;
        }
        this.values[size++] = value;
    }

    /**
     * Returns the value at the specified position in the list.
     * @param index: The specified index.
     * @return The value at the specified position in the list.
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) this.values[index];
    }

    /**
     * Returns the number of elements in the list.
     * @return The number of elements in the list.
     */
    public int size() {
        return this.size;
    }


}
