public class Main {
    public static void main(String[] args) {

        BinaryTreeKeyValue tree = new BinaryTreeKeyValue();

        // Add some key-value pairs
        tree.put("apple", 1);
        tree.put("banana", 2);
        tree.put("cherry", 3);
        tree.put("date", 4);
        tree.put("elderberry", 5);

        // Add a duplicate key
        tree.put("banana", 20);

        // Retrieve and print some values
        try {
            System.out.println("Value of 'banana': " + tree.getValByKey("banana"));
            System.out.println("Value of 'date': " + tree.getValByKey("date"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Print all key-value pairs
        System.out.println("\n--------------------");
        System.out.println("All key-value pairs:\n");
        tree.printAllKeyValPairs();
    }
}
