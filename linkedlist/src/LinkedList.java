public class LinkedList<T> {

    /**
     * Author: Sofian Ben Hamman
     * Version: 1.4
     * Description: Own implementation of a single LinkedList.
     */

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {

    }

    /**
     * Returns the number of elements in the list.
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the value at the specified position in the list.
     * @param index: The specified index.
     * @return The value at the specified position in the list.
     */
    public T get(int index) {
        return getNodeHelper(index).value;
    }

    private Node<T> getNodeHelper(int targetIndex) {
        if (targetIndex >= size || targetIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> iteratorNode = head;
        for (int i = 0; i < targetIndex; i++) {
            iteratorNode = iteratorNode.nextNode;
        }
        return iteratorNode;
    }

    /**
     * Appends the element at the end of the list.
     * @param value: Value to append in the list.
     */
    public void add(T value) {
        if (head == null) {
            head = new Node<T>();
            head.value = value;
            tail = head;
            size++;
            return;
        }
        addHelper(head, value);
    }

    private void addHelper(Node<T> node, T value) {
        if (node.nextNode == null) {
            node.nextNode = new Node<T>();
            node.nextNode.value = value;
            size++;
            tail = node.nextNode;
            return;
        }
        addHelper(node.nextNode, value);
    }

    /**
     * Appends the element at the beginning of the list.
     * @param value: Value to add in the list.
     */
    public void addFirst(T value) {
        Node<T> node = new Node<>();
        node.value = value;
        node.nextNode = head;
        head = node;
        size++;
    }

    /**
     * Appends the element at the specified index.
     * @param value: Value to add in the list.
     */
    public void addAtIndex(int targetIndex, T value) {
        if (targetIndex >= size || targetIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (targetIndex == 0) {
            addFirst(value);
            return;
        }
        Node<T> newNode = new Node<>();
        newNode.value = value;
        Node<T> previousNode = getNodeHelper(targetIndex - 1);
        Node<T> nextNode = previousNode.nextNode;
        previousNode.nextNode = newNode;
        newNode.nextNode = nextNode;
        size++;
    }

    /**
     * Removes the element at the specified position in the list.
     * @param targetIndex: Index to remove from the list if it is present.
     */
    public void remove(int targetIndex) {
        int currentIndex = 0;
        if (targetIndex >= size || targetIndex < currentIndex) {
            throw new IndexOutOfBoundsException();
        }
        if (targetIndex == 0) {
            head = head.nextNode;
            size--;
            return;
        }
        Node<T> previousNode = getNodeHelper(targetIndex - 1);
        previousNode.nextNode = previousNode.nextNode.nextNode;
        size--;
    }

    /**
     * Pops an element from the stack represented by this list.
     * @return The first element appended to the list.
     */
    public T popFirst() {
        T value = head.value;
        head = head.nextNode;
        size--;
        return value;
    }

    /**
     * Pops an element from the stack represented by this list.
     * @return The last element appended to the list.
     */
    public T pop() {
        T value = tail.value;
        tail = getNodeHelper(size - 2);
        size--;
        return value;
    }

    private static class Node<T> {

        /**
         * Class that represent each single node with value and pointing
         * to the next one.
         */

        public T value;
        public Node<T> nextNode;

        public Node() {

        }

    }
}