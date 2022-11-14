public class Node<T> {

    private T value;
    private Node<T> nextNode;

    public Node() {

    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> node) {
        nextNode = node;
    }
}
