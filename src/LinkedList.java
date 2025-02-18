import java.util.ArrayList;
import java.util.Arrays;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

}
class LinkedList {
    private Node head;
    private Node tail;
    public LinkedList() {
        this.head = new Node(-1); //a dummy node, just so we can have something to start from
        this.tail = this.head;
    }

    public int get(int index) {
        int i = 0;
        Node curr = head.next;
        while (curr != null) {
            if (i == index) {
                return curr.val;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }



    public void insertTail(int val) {
        this.tail.next = new Node(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (i == index) {
                prev.next = curr.next;
                if (curr.next == null) {
                    tail = prev;
                } else {
                    curr.next = null;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();
        Node curr = head.next;
        while (curr != null) {
            result.add(curr.val);
            curr = curr.next;
        }
        return result;
    }
}
