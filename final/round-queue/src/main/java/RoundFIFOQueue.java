import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

class RoundFIFOQueue<T extends Comparable<T>> implements Iterable<T> {

    private class Node {
        T value;
        Node next;
        int debugId;
    }

    private Node enqueue, dequeue;
    private int size;
    private final int maxSize;

    // public constructor
    public RoundFIFOQueue(int maxSize) {

        if (maxSize < 1) {
            throw new RuntimeException("Max size must be at least 1");
        }

        this.maxSize = maxSize;

        Node origin = new Node();
        origin.debugId = 0;
        enqueue = origin;
        dequeue = origin;

        Node current = origin;

        for (int i = 1; i < maxSize; i++) {
            Node newNode = new Node();
            newNode.debugId = i;
            current.next = newNode;
            current = newNode;
        }

        // link the last node to the first one because circle
        current.next = origin;
    }

    // print queue (debug only)
    public void printQueue() {

        Node current = dequeue;

        for (int i = 0; i < size; i++) {
            System.out.println("Node #" + current.debugId + ": " + current.value);
            current = current.next;
        }

        if (current != enqueue) {
            throw new RuntimeException("Queue may not be circular");
        }
    }

    // enqueue
    public void enqueue(T value) {
        if (size == maxSize) {
            throw new RuntimeException("Queue is full");
        }
        enqueue.value = value;
        enqueue = enqueue.next;
        size++;
    }

    // dequeue
    public T dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        T value = dequeue.value;
        dequeue.value = null; // no need for ref anymore
        dequeue = dequeue.next;
        size--;
        return value;
    }

    // size
    public int size() {
        return size;
    }

    // to array
    public T[] toArray(T[] template) {
        T[] array = (T[]) Array.newInstance(template.getClass().getComponentType(), size);
        Node current = dequeue;
        for (int i = 0; i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    // count values
    public int countValues(T value) {
        int count = 0;
        Node current = dequeue;
        for (int i = 0; i < size; i++) {
            if (current.value.compareTo(value) == 0) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    // iterator
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node current = dequeue;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.value;
                current = current.next;
                count++;
                return value;
            }
        };
    }
}
