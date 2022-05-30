public class LinkedList<T> {

    /**
     * Author: Sofian Ben Hamman
     * Version: 1.0
     * Description: Own implementation of a single LinkedList.
     */

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size;

    public LinkedList() {

    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return head.get(index);
    }

    public T getFirstOne() {
        return this.head.value;
    }

    public T getLastOne() {
        return this.tail.value;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<T>();
        }
        tail = head.add(value);
        size++;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        head = head.remove(index);
        tail = head.getTail();
        size--;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {

        private T value = null;
        private Node<T> nextValue = null;

        public Node() {

        }

        public Node<T> add(T value) {
            if (this.value == null) {
                this.value = value;
                return this;
            }
            if (this.nextValue == null) {
                this.nextValue = new Node<T>();
            }
            return this.nextValue.add(value);
        }

        public Node<T> remove(int index) {
            return remove(index, 0);
        }

        private Node<T> remove(int targetIndex, int currentIndex) {
            if (targetIndex == currentIndex) {
                return this.nextValue;
            } else {
                this.nextValue = this.nextValue.remove(targetIndex, ++currentIndex);
                return this;
            }
        }

        public T get(int index) {
            return get(index, 0);
        }

        private T get(int targetIndex, int currentIndex) {
            if (targetIndex == currentIndex) {
                return this.value;
            } else {
                return this.nextValue.get(targetIndex, ++currentIndex);
            }
        }

        private Node<T> getTail() {
            if (this.nextValue == null) {
                return this;
            } else {
                return this.nextValue.getTail();
            }
        }
    }

}
