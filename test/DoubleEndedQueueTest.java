import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoubleEndedQueueTest {

    @Test
    void testEnqueHead() {
        // Given: an empty queue, enqueue an element at the head
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        queue.enqueHead(10);

        assertEquals((Integer) 10, queue.peekHead()); // Explicit casting
        assertEquals((Integer) 10, queue.peekTail());
    }

    @Test
    void testEnqueTail() {
        // Given: an empty queue, enqueue an element at the tail
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        queue.enqueTail(20);

        assertEquals((Integer) 20, queue.peekHead());
        assertEquals((Integer) 20, queue.peekTail());
    }

    @Test
    void testDequeHead() {
        // Given: a queue with elements, dequeue from head
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        queue.enqueHead(10);
        queue.enqueHead(20);

        assertEquals((Integer) 20, queue.dequeHead());
        assertEquals((Integer) 10, queue.peekHead());
    }

    @Test
    void testDequeTail() {
        // Given: a queue with elements, dequeue from tail
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        queue.enqueTail(10);
        queue.enqueTail(20);

        assertEquals((Integer) 20, queue.dequeTail());
        assertEquals((Integer) 10, queue.peekTail());
    }

    @Test
    void testPeekHead() {
        // Given: a queue with elements, peek the head without removing it
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        queue.enqueHead(30);
        queue.enqueHead(40);

        assertEquals((Integer) 40, queue.peekHead());
        assertEquals((Integer) 40, queue.peekHead()); // Ensure it does not remove
    }

    @Test
    void testPeekTail() {
        // Given: a queue with elements, peek the tail without removing it
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        queue.enqueTail(50);
        queue.enqueTail(60);

        assertEquals((Integer) 60, queue.peekTail());
        assertEquals((Integer) 60, queue.peekTail()); // Ensure it does not remove
    }

    @Test
    void testDequeHeadOnEmptyQueue() {
        // Given: an empty queue, dequeuing from head should return null
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        assertNull(queue.dequeHead());
    }

    @Test
    void testDequeTailOnEmptyQueue() {
        // Given: an empty queue, dequeuing from tail should return null
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        assertNull(queue.dequeTail());
    }

    @Test
    void testMixedOperations() {
        // Given: a mix of enqueuing and dequeuing operations
        DoubleEndedQueue<Integer> queue = new DoubleEndedQueue<>();
        queue.enqueHead(10);
        queue.enqueTail(20);
        queue.enqueHead(30);
        queue.enqueTail(40);

        assertEquals((Integer) 30, queue.dequeHead());
        assertEquals((Integer) 40, queue.dequeTail());
        assertEquals((Integer) 10, queue.dequeHead());
        assertEquals((Integer) 20, queue.dequeTail());
        assertNull(queue.dequeHead()); // Queue should now be empty
    }
}
