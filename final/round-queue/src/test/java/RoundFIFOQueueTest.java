import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoundFIFOQueueTest {
    @Test
    public void testEnqueueDequeue() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
    }

    @Test
    public void testSize() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());

        queue.dequeue();
        queue.dequeue();

        assertEquals(1, queue.size());
    }

    @Test
    public void testToArray() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, queue.toArray(new Integer[0]));
    }

    @Test
    public void testCountValues() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.countValues(1));
        assertEquals(2, queue.countValues(2));
        assertEquals(1, queue.countValues(3));
    }

    @Test
    public void testIterator() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        int sum = 0;
        for (Integer i : queue) {
            if (i != null) {
                sum += i;
            }
        }

        assertEquals(15, sum);
    }

    @Test
    public void testMaxSizeException() {
        Exception exception = assertThrows(RuntimeException.class, () -> new RoundFIFOQueue<>(0));
        assertEquals("Max size must be at least 1", exception.getMessage());
    }

    @Test
    public void testFullQueueException() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        Exception exception = assertThrows(RuntimeException.class, () -> queue.enqueue(6));
        assertEquals("Queue is full", exception.getMessage());
    }

    @Test
    public void testEmptyQueueException() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(5);

        Exception exception = assertThrows(RuntimeException.class, queue::dequeue);
        assertEquals("Queue is empty", exception.getMessage());
    }
}
