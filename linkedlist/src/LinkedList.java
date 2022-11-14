public class LinkedList<T> {

    /**
     * Author: Sofian Ben Hamman
     * Version: 1.1
     * Description: Own implementation of a single LinkedList.
     */

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {

    }

    public T get(int index) {
        return getNodeHelper(index).getValue();
    }

    private Node<T> getNodeHelper(int targetIndex) {
        int currentIndex = 0;
        if (targetIndex >= size || targetIndex < currentIndex) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> iteratorNode = head;
        while (iteratorNode != null) {
            if (currentIndex == targetIndex) {
                return iteratorNode;
            }
            iteratorNode = iteratorNode.getNextNode();
            currentIndex++;
        }
        return null;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<T>();
            head.setValue(value);
            tail = head;
            size++;
            return;
        }
        head.setNextNode(addHelper(value, head.getNextNode()));
    }

    private Node<T> addHelper(T value, Node<T> currentNode) {
        if (currentNode == null) {
            currentNode = new Node<T>();
            currentNode.setValue(value);
            tail = currentNode;
            size++;
            return currentNode;
        }
        currentNode.setNextNode(addHelper(value, currentNode.getNextNode()));
        return currentNode;
    }

    public int size() {
        return size;
    }

}