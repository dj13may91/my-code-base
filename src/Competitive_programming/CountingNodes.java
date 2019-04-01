package Competitive_programming;


import java.util.*;

/**
 * You are given a tree of N nodes from 1 to N where Node 1 is the root of the tree .
 * For each Node i from 1 to N ,you have to find the number of nodes which are in the subtree of i
 * and are at distance equal to height of subtree of i.
 * Distance between a & b = Total number of edges in path from A to B.
 * Height of subtree = maximum distance from the root of the subtree to any node in the subtree.
 * Input Format
 * The first line of input consists of an integer n. The next n-1 line contains two space -separated integers
 * x,y showing that there is an undirected edge between x and y.
 * Constraints : 1 <= n <= 100000 , 1 <= x,y <= n
 * Output Format: Print n space separated integers where i from 1 to N , answer when i is considered as the root of the tree.
 * Sample TestCase 1
 * Input
 * 4
 * 1 2
 * 2 3
 * 2 4
 * Output
 * 2 2 1 1
 */

class Node {
    int level;
    int key;
    Node left, right, parent;
    int height;

    public Node(int item) {
        key = item;
        left = right = null;
        height = 0;
        level = 0;
    }

    @Override
    public String toString() {
        return "Node {" +
                "key=" + key +
                ", left=" + (left == null ? "null" : left.key) +
                ", right=" + (right == null ? "null" : right.key) +
                ", parent=" + (parent == null ? "null" : parent.key) +
                ", height=" + height +
                ", level=" + level + '}' + '\n';
    }
}

public class CountingNodes {
    private static Map<Integer, Node> presentNodes = new LinkedHashMap<>();
    private static Node root = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int edges = Integer.parseInt(scan.nextLine().trim());
        for (int i = 0; i < edges - 1; i++) {
            String edge[] = scan.nextLine().split(" ");
            add(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }

        System.out.println(getHeight(presentNodes.get(1)));
        generateLevels();
        System.out.println(presentNodes);
        StringBuilder output = new StringBuilder();
        presentNodes.forEach((key, node) -> {
            output.append(elementInSubtree(node)).append(" ");
        });
        System.out.println(output);
    }

    public static void add(int parent, int item) {
        Node parentNode = presentNodes.get(parent);
        if (parentNode == null) {
            parentNode = new Node(parent);
        }
        Node node = new Node(item);
        if (parentNode.left == null) {
            parentNode.left = node;
            node.parent = parentNode;
        } else if (parentNode.right == null) {
            parentNode.right = node;
            node.parent = parentNode;
        }

        if (root == null) {
            root = parentNode;
        }
        presentNodes.put(parent, parentNode);
        presentNodes.put(item, node);
    }

    public static void generateLevels() {
        Queue<Node> firstQ = new LinkedList<>();
        Queue<Node> secondQ = new LinkedList<>();
        firstQ.add(root);
        int currentLevel = 0;
        while (!firstQ.isEmpty() || !secondQ.isEmpty()) {
            while (!firstQ.isEmpty()) {
                Node item = firstQ.poll();
                item.level = currentLevel;
                insertItemInQueue(item, secondQ);
            }
            currentLevel++;
            while (!secondQ.isEmpty()) {
                Node item = secondQ.poll();
                item.level = currentLevel;
                insertItemInQueue(item, firstQ);
            }
            currentLevel++;
        }
    }

    private static int getHeight(Node node) {
        if (node == null)
            return 0;
        int leftHeight = 1 + getHeight(node.left);
        int rightHeight = 1 + getHeight(node.right);
        node.height = (leftHeight > rightHeight ? leftHeight : rightHeight) - 1;
        return node.height + 1;
    }

    private static void insertItemInQueue(Node item, Queue<Node> queue) {
        if (item.left != null)
            queue.add(item.left);
        if (item.right != null)
            queue.add(item.right);
    }

    private static int elementInSubtree(Node root) {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("Node: " + root.key);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            insertItemInQueue(node, queue);
            if (node.height == 0 && (node.height + node.level == root.height + root.level)) {
                System.out.print(" -> " + node.key);
                count++;
            }
        }
        System.out.println();
        return count;
    }
}


/**
 * 7
 * 1 2
 * 2 3
 * 2 4
 * 3 5
 * 5 6
 * 4 7
 * height map :
 * {  1=Node {key=1, left=2, right=null, height=4}
 * ,  2=Node {key=2, left=3, right=4, height=3}
 * ,  3=Node {key=3, left=5, right=null, height=2}
 * ,  4=Node {key=4, left=7, right=null, height=1}
 * ,  5=Node {key=5, left=6, right=null, height=1}
 * ,  6=Node {key=6, left=null, right=null, height=0}
 * ,  7=Node {key=7, left=null, right=null, height=0}
 * }
 */