public class BinaryTreeKeyValue {

    private static class Node {
        String key;
        int value;
        Node left, right;
    }

    Node root;
    int nodesCount;

    void put(String key, int value) {

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
            if (key.compareTo(currNode.key) < 0) {

                if (currNode.left == null) {
                    Node newNode = new Node();
                    newNode.key = key;
                    newNode.value = value;
                    currNode.left = newNode;
                    nodesCount++;
                    return;
                }

                currNode = currNode.left;

            } else if (key.compareTo(currNode.key) > 0) {

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

    public int getValByKey(String key) throws RuntimeException {
        Node node = getNodeByKey(root, key);
        if (node == null) {
            throw new RuntimeException("Key not found: " + key);
        }
        return node.value;
    }

    private Node getNodeByKey(Node node, String key) {
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
}
