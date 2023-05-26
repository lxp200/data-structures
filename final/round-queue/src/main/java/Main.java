import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // create String queue with max size of 5
        RoundFIFOQueue<String> queue = new RoundFIFOQueue<>(5);

        // enqueue some food
        queue.enqueue("Egg");
        queue.enqueue("Pear");
        queue.enqueue("Mango");
        queue.enqueue("Almond");
        queue.enqueue("Apricot");

        // print the queue
        queue.printQueue();
        System.out.println("-----");

        // dequeue some elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("-----");

        // print the queue
        queue.printQueue();
        System.out.println("-----");

        // enqueue more elements
        System.out.println("Enqueuing two new elements:");
        queue.enqueue("Zucchini");
        queue.enqueue("Asparagus");
        queue.printQueue();
        System.out.println("-----");

        // toArray()
        String[] array = queue.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array));

        // countValues()
        System.out.println("Count of 'Egg': " + queue.countValues("Egg"));
        System.out.println("Count of 'Zucchini': " + queue.countValues("Zucchini"));
        System.out.println("Count of 'Asparagus': " + queue.countValues("Asparagus"));
        System.out.println("-----");

        // iterator
        System.out.println("Iterator:");
        for (String s : queue) {
            System.out.printf("#%s ", s);
        }
    }
}
