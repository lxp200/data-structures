import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Stack;

public class BinaryTreeKeyValueGen<K extends Comparable<K>, V> implements Iterable<Pair<K, V>> {

    private class Node {
        K key;
        V value;
        Node left, right;
    }

    Node root;
    int nodesCount;

    void put(K key, V value) {
        if (root == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            root = newNode;
            nodesCount++;
            return;
        }

        Node currNode = root;

        while (true) {
            int cmp = key.compareTo(currNode.key);
            if (cmp < 0) {
                if (currNode.left == null) {
                    Node newNode = new Node();
                    newNode.key = key;
                    newNode.value = value;
                    currNode.left = newNode;
                    nodesCount++;
                    return;
                }
                currNode = currNode.left;
            } else if (cmp > 0) {
                if (currNode.right == null) {
                    Node newNode = new Node();
                    newNode.key = key;
                    newNode.value = value;
                    currNode.right = newNode;
                    nodesCount++;
                    return;
                }
                currNode = currNode.right;
            } else {
                currNode.value = value;
                return;
            }
        }
    }

    public V getValByKey(K key) throws RuntimeException {
        Node node = getNodeByKey(root, key);
        if (node == null) {
            throw new RuntimeException("Key not found: " + key);
        }
        return node.value;
    }

    private Node getNodeByKey(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return getNodeByKey(node.left, key);
        } else if (cmp > 0) {
            return getNodeByKey(node.right, key);
        } else {
            return node;
        }
    }

    void printAllKeyValPairs() {
        printAllKeyValPairs(root);
    }

    private void printAllKeyValPairs(Node node) {
        if (node != null) {
            printAllKeyValPairs(node.left);
            System.out.println("Key: " + node.key + ", Value: " + node.value);
            printAllKeyValPairs(node.right);
        }
    }

    public K[] getKeysInOrder(Class<K> keyArrayClass) {
        @SuppressWarnings("unchecked")
        K[] keys = (K[]) Array.newInstance(keyArrayClass, nodesCount);
        getKeysInOrder(root, keys, 0);
        return keys;
    }

    private int getKeysInOrder(Node node, K[] keys, int index) {
        if (node != null) {
            index = getKeysInOrder(node.left, keys, index);
            keys[index++] = node.key;
            index = getKeysInOrder(node.right, keys, index);
        }
        return index;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new BinaryTreeIterator(root);
    }

    private class BinaryTreeIterator implements Iterator<Pair<K, V>> {
        private final Stack<Node> stack = new Stack<>();

        public BinaryTreeIterator(Node root) {
            pushLeft(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Pair<K, V> next() {
            Node node = stack.pop();
            pushLeft(node.right);
            return new Pair<>(node.key, node.value);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
