import java.util.Stack;

public class BinaryTree {

    /**
     * Author: Sofian Ben Hamman
     * Version: 1.1
     * Description: Own implementation of a Binary Tree.
     */

    private Node root;
    private int size;

    public BinaryTree() {
    }

    /**
     * Returns the number of elements in the binary tree.
     * @return The number of elements in the binary tree.
     */
    public int size() {
        return size;
    }

    /**
     * Adds the value to the binary tree.
     * @param value: Value to add to the binary tree.
     */
    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            size++;
            return;
        }
        Node newNode = new Node(value);
        root = addHelper(root, newNode);
    }

    private Node addHelper(Node currentNode, Node newNode) {
        if (currentNode == null) {
            size++;
            return newNode;
        }
        if (newNode.value < currentNode.value) {
            currentNode.leftNode = addHelper(currentNode.leftNode, newNode);
        } else {
            currentNode.rightNode = addHelper(currentNode.rightNode, newNode);
        }
        return currentNode;
    }

    // Inorder, Preorder (breath-first) and Postorder (depth-first)
    /**
     * Traversing the binary tree in a recursive inorder way.
     * @param currentNode: The binary tree's root.
     */
    private void recursiveInorder(Node currentNode) {
        if (currentNode.leftNode != null) {
            recursiveInorder(currentNode.leftNode);
        }
        System.out.println(currentNode.value);
        if (currentNode.rightNode != null) {
            recursiveInorder(currentNode.rightNode);
        }
    }

    /**
     * Traversing the binary tree in a recursive preorder way.
     * @param currentNode: The binary tree's root.
     */
    public void recursivePreorder(Node currentNode) {
        System.out.println(currentNode.value);
        if (currentNode.leftNode != null) {
            recursivePreorder(currentNode.leftNode);
        }
        if (currentNode.rightNode != null) {
            recursivePreorder(currentNode.rightNode);
        }
    }

    /**
     * Traversing the binary tree in a recursive postorder way.
     * @param currentNode: The binary tree's root.
     */
    public void recursivePostorder(Node currentNode) {
        if (currentNode.leftNode != null) {
            recursivePostorder(currentNode.leftNode);
        }
        if (currentNode.rightNode != null) {
            recursivePostorder(currentNode.rightNode);
        }
        System.out.println(currentNode.value);
    }

    /**
     * Traversing the binary tree in an iterative inorder way.
     * @param root: The binary tree's root.
     */
    public void iterativeInorder(Node root) {
        Stack<Node> nodes = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || nodes.size() > 0) {
            while (currentNode != null) {
                nodes.push(currentNode);
                currentNode = currentNode.leftNode;
            }
            currentNode = nodes.pop();
            System.out.println(currentNode.value);
            currentNode = currentNode.rightNode;
        }
    }

    /**
     * Traversing the binary tree in an iterative preorder way.
     * @param root: The binary tree's root.
     */
    public void iterativePreorder(Node root) {
        Stack<Node> nodes = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || nodes.size() > 0) {
            while (currentNode != null) {
                nodes.push(currentNode);
                System.out.println(currentNode.value);
                currentNode = currentNode.leftNode;
            }
            currentNode = nodes.pop();
            currentNode = currentNode.rightNode;
        }
    }

    /**
     * Traversing the binary tree in an iterative postorder way.
     * @param root: The binary tree's root.
     */
    public void iterativePostorder(Node root) {
        Stack<Node> nodes = new Stack<>();
        Node currentNode = root;
        Node prev = null;
        while (currentNode != null || nodes.size() > 0) {
            if (currentNode != null) {
                nodes.push(currentNode);
                prev = currentNode;
                currentNode = currentNode.leftNode;
            } else {
                currentNode = nodes.peek();
                if (currentNode.rightNode == null || currentNode.rightNode == prev) {
                    nodes.pop();
                    System.out.println(currentNode.value);
                    prev = currentNode;
                    currentNode = null;
                } else {
                    currentNode = currentNode.rightNode;
                }
            }
        }
    }

    private static class Node {

        /**
         * Class that represent each single node with value and pointing
         * to another 2 nodes.
         */

        public int value;
        public Node leftNode;
        public Node rightNode;

        public Node(int value) {
            this.value = value;
        }

    }
}
