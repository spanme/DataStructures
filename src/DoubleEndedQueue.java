public class DoubleEndedQueue<E>{
    Node<E> head;
    Node<E> tail;
    int size = 0;
    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        Node (E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public DoubleEndedQueue() {
        this.head = null;
        this.tail = null;
    }
    public void enqueHead(E element) {
        Node<E> newNode = new Node<>(element);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        size++;
    }


    public void enqueTail(E element) {
        Node<E> newNode = new Node<>(element);
        if (tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            tail = newNode;
            head = newNode;
        }
        size++;
    }

    public E dequeHead() {
        if (head == null) {
            return null;
        }
        E val = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return val;
    }

    public E dequeTail() {
        if (tail == null) {
            return null;
        }
        E val = tail.value;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return val;
    }

    public E peekHead() { //that returns the element at the Head but not remove it.
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public E peekTail() { //that returns the element at the Tail but not remove it.
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

}
