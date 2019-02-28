package LinkedList;

public class ReverseLinkedList {

    private static LinkedListImplementation<Integer> linkedList = new LinkedListImplementation<>();

    public static void main(String[] args) {
        linkedList.add(6);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.printList();
        System.out.println("reversing list: ");
        linkedList.reverseList();
        linkedList.printList();
        linkedList.add(0);
        linkedList.add(-1);
        linkedList.printList();
        System.out.println("reversing list in sizes of three ");
        linkedList.reverseListInGroups(3);
        linkedList.printList();



    }
}
