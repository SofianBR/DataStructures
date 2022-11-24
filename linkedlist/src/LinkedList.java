public class LinkedList<T> {

    /**
     * Author: Sofian Ben Hamman
     * Version: 1.2
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
     * @param index
     * @return The value at the specified position in the list.
     */
    public T get(int index) {
        return getNodeHelper(index).getValue();
    }

    private Node<T> getNodeHelper(int targetIndex) {
        int currentIndex = 0;
        if (targetIndex >= size || targetIndex < currentIndex) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> iteratorNode = head;
        while (currentIndex != targetIndex) {
            iteratorNode = iteratorNode.getNextNode();
            currentIndex++;
        }
        return iteratorNode;
    }

    /**
     * Appends the element at the end of the list.
     * @param value: Value to append in the list.
     */
    public void add(T value) {
        size++;
        if (head == null) {
            head = new Node<T>();
            head.setValue(value);
            tail = head;
            return;
        }
        Node<T> node = new Node<T>();
        node.setValue(value);
        tail.setNextNode(node);
        tail = tail.getNextNode();
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
        size--;
        if (targetIndex == 0) {
            head = head.getNextNode();
            return;
        }
        Node<T> previousNode = getNodeHelper(targetIndex - 1);
        Node<T> nextNode = previousNode.getNextNode().getNextNode();
        previousNode.setNextNode(nextNode);
    }
}