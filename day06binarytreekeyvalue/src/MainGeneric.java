import java.util.Arrays;

public class MainGeneric {
    public static void main(String[] args) {

        BinaryTreeKeyValueGen<Integer, String> tree = new BinaryTreeKeyValueGen<>();

        // Add some key-value pairs
        tree.put(10, "apple");
        tree.put(20, "banana");
        tree.put(30, "cherry");
        tree.put(40, "date");
        tree.put(50, "elderberry");

        // Add a duplicate key
        tree.put(2, "blueberry");

        // Retrieve and print some values
        try {
            System.out.println("Value of '2': " + tree.getValByKey(2));
            System.out.println("Value of '99': " + tree.getValByKey(99));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Print all key-value pairs
        System.out.println("\n--------------------");
        System.out.println("All key-value pairs:\n");
        tree.printAllKeyValPairs();

        System.out.println(Arrays.toString(tree.getKeysInOrder(Integer.class)));

        // separator
        System.out.println("\n==================\n");

        // same thing but with string keys and integer values
        BinaryTreeKeyValueGen<String, Integer> tree2 = new BinaryTreeKeyValueGen<>();

        // Add some key-value pairs
        tree2.put("strawberry", 10);
        tree2.put("banana", 20);
        tree2.put("orange", 30);
        tree2.put("apple", 40);
        tree2.put("mango", 50);

        // Add a duplicate key
        tree2.put("mango", 5);


        // Retrieve and print some values
        try {
            System.out.println("Value of 'banana': " + tree2.getValByKey("banana"));
            System.out.println("Value of 'platypus': " + tree2.getValByKey("platypus"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Print all key-value pairs
        System.out.println("\n--------------------");
        System.out.println("All key-value pairs:\n");
        tree2.printAllKeyValPairs();

        System.out.println(Arrays.toString(tree2.getKeysInOrder(String.class)));

        // print all key-value pairs using iterator
        System.out.println("\n--------------------");
        System.out.println("All key-value pairs using iterator:\n");
        for (Pair<String, Integer> pair : tree2) {
            System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
        }
    }
}
