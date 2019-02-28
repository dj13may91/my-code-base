package LinkedList;

public class LinkedListImplementation<T> {

    Node head;
    Node tail;
    int listSize = 0;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        public T getData() {
            return data;
        }
    }

    public void add(T data) {
        appendAtEnd(data);
    }

    public void appendAtStart(T data) {
        if (checkHeadExists(data)) {
            return;
        }

        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
        listSize++;
    }

    public void appendAtEnd(T data) {
        if (checkHeadExists(data)) {
            return;
        }

        Node newTail = new Node(data);
        tail.next = newTail;
        tail = newTail;
        listSize++;
    }

    // Starts from index 0
    public T getElement(int index){
        Node current = head;
        int count = 0;
        while(current != null && index >= count){
            if(count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        return null;
    }

    public void printList() {
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node pop(){
        Node currentHead = head;
        if(head != null)
            head = head.next;
        else
            head = null;
        return currentHead;
    }

    public boolean delete(T data) {
        if (head.data == data) {
            head = head.next;
            listSize--;
            return true;
        }

        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.data == data) {
                previous.next = current.next;
                listSize--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    public void reverseList() {
        Node current = head;
        Node previous = null;
        Node temp;
        tail = head;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
    }

    public void reverseListInGroups(int groupSize) {
        head = reverseInGroupUtil(head, groupSize);
    }

    private Node reverseInGroupUtil(Node currentHead, int groupSize) {
        Node current = currentHead;
        Node previous = null;
        Node temp = null;
        int count = 0;
        while (current != null && groupSize > count++) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        if (temp != null) {
            currentHead.next = reverseInGroupUtil(temp, groupSize);
        }
        return previous;
    }


    public int size() {
        return this.listSize;
    }

    public T getHead() {
        return head.getData();
    }

    public T getTail() {
        return tail.getData();
    }

    private boolean checkHeadExists(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            listSize++;
            return true;
        }
        return false;
    }
}
