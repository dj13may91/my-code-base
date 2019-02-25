package LinkedList;

// TODO: Add two numbers represented by linked lists

// Implemented using recursive approach
public class AddTwoNumber {
    private Node list1 = new Node();
    private Node list2 = new Node();

    class Node {
        int data;
        Node next;

        Node() {
            this.data = -1;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public void append(int data, Node head) {
        if (head.data < 0) {
            head.data = data;
            head.next = null;

            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node();
        temp = temp.next;
        temp.data = data;
        temp.next = null;
    }

    public int size(Node head) {
        int nodeLength = 0;
        while (head != null) {
            nodeLength++;
            head = head.next;
        }
        return nodeLength;
    }

    public void printList(Node head) {
        System.out.print("List size: " + size(head) + ", LIST: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        addTwoNumber.append(7, addTwoNumber.list1);
        addTwoNumber.append(9, addTwoNumber.list1);
        addTwoNumber.append(9, addTwoNumber.list1);
        addTwoNumber.append(2, addTwoNumber.list1);
        addTwoNumber.append(3, addTwoNumber.list1);
        addTwoNumber.append(0, addTwoNumber.list1);

        addTwoNumber.printList(addTwoNumber.list1);

        addTwoNumber.append(4, addTwoNumber.list2);
        addTwoNumber.append(9, addTwoNumber.list2);
        addTwoNumber.append(9, addTwoNumber.list2);
        addTwoNumber.append(9, addTwoNumber.list2);
        addTwoNumber.append(9, addTwoNumber.list2);
        addTwoNumber.append(9, addTwoNumber.list2);

        addTwoNumber.printList(addTwoNumber.list2);
        addTwoNumber.addLinkedLists(addTwoNumber.list1, addTwoNumber.list2);
    }

    public void addLinkedLists(Node head1, Node head2) {
        Node sumList = new Node();
        int list1size = size(head1);
        int list2size = size(head2);

        // Append zero in start of shorter list
        if (list1size > list2size) {
            while (list1size != list2size) {
                Node newNode = new Node();
                newNode.data = 0;
                newNode.next = head2;
                head2 = newNode;
                list1size--;
            }
        } else if (list1size < list2size) {
            while (list1size != list2size) {
                Node newNode = new Node();
                newNode.data = 0;
                newNode.next = head1;
                head1 = newNode;
                list2size--;
            }
        }

        printList(head1);

        int carry = addNodeData(sumList, head1, head2);

        // to remove head which is -1 as to run recursively,
        sumList = sumList.next;

        // if a recursive carry of 1 is sent back, we need to create a first head node with data = -1
        if (carry > 0) {
            Node headNode = new Node();
            headNode.data = carry;
            headNode.next = sumList;
            sumList = headNode;
        }

        printList(sumList);
    }

    private int addNodeData(Node sumList, Node node1, Node node2) {
        int sum;
        Node nextNode = new Node();

        if (node1.next != null && node2.next != null) {
            sum = (node1.data + node2.data) + addNodeData(nextNode, node1.next, node2.next);
        } else {
            sum = node1.data + node2.data;
        }

        // data = 15 % 10 = 5 and return carry of 1
        nextNode.data = sum % 10;
        sumList.next = nextNode;
        System.out.println("current sum: " + sum + ", CARRY forward: " + (sum / 10));
        return (sum) / 10;
    }
}

/**
 * Output:
    List size: 6, LIST: 7 -> 9 -> 9 -> 2 -> 3 -> 0 ->
    List size: 6, LIST: 4 -> 9 -> 9 -> 9 -> 9 -> 9 ->
    List size: 6, LIST: 7 -> 9 -> 9 -> 2 -> 3 -> 0 ->
    current sum: 9, CARRY forward: 0
    current sum: 12, CARRY forward: 1
    current sum: 12, CARRY forward: 1
    current sum: 19, CARRY forward: 1
    current sum: 19, CARRY forward: 1
    current sum: 12, CARRY forward: 1
    List size: 7, LIST: 1 -> 2 -> 9 -> 9 -> 2 -> 2 -> 9 ->
 */
