package Trees;

import LinkedList.LinkedListImplementation;

public class BinaryTree {
    public BinaryNode root;

    // Below queue maintains next Nodes in which we will insert child nodes.
    // At most it maintains [currentLevel + currentLevel/2] nodes
    private LinkedListImplementation<BinaryNode> queue = new LinkedListImplementation<>();

    public BinaryNode add(int data) {
        BinaryNode<Integer> node = new BinaryNode<>(data);
        queue.printList();

        if (root == null) {
            System.out.println("Setting root value as: " + node.data);
            root = node;
            queue.add(root);
            return node;
        }

        BinaryNode currentParent = queue.getHead();
        if (currentParent.left == null) {
            System.out.println("adding [" + node.data + "] left child to " + currentParent.data);
            currentParent.left = node;
        } else if (currentParent.right == null) {
            System.out.println("adding [" + node.data + "] right child to " + currentParent.data);
            currentParent.right = node;
            queue.add(currentParent.left);
            queue.add(currentParent.right);
            queue.pop();
        }
        return node;
    }

    public void inorderTraversal(BinaryNode binaryNode) {
        if (binaryNode == null) {
            return;
        }
        inorderTraversal(binaryNode.left);
        System.out.print(binaryNode.data + " ");
        inorderTraversal(binaryNode.right);
    }

    public void preOrderTraversal(BinaryNode binaryNode) {
        if (binaryNode == null) {
            return;
        }
        System.out.print(binaryNode.data + " ");
        preOrderTraversal(binaryNode.left);
        preOrderTraversal(binaryNode.right);
    }

    public void postOrderTraversal(BinaryNode binaryNode) {
        if (binaryNode == null) {
            return;
        }
        postOrderTraversal(binaryNode.left);
        postOrderTraversal(binaryNode.right);
        System.out.print(binaryNode.data + " ");
    }

    public BinaryNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int nodes = 1;
        while (nodes <= 5)
            tree.add(nodes++);

        System.out.println();
        tree.inorderTraversal(tree.root);
        System.out.println();
        tree.preOrderTraversal(tree.root);
        System.out.println();
        tree.postOrderTraversal(tree.root);
    }
}


 /**
 Output:

 Setting root value as: 1

 binaryNode.data=1 ->
 adding [2] left child to 1

 binaryNode.data=1 ->
 adding [3] right child to 1

 binaryNode.data=2 -> binaryNode.data=3 ->
 adding [4] left child to 2

 binaryNode.data=2 -> binaryNode.data=3 ->
 adding [5] right child to 2

 4 2 5 1 3
 1 2 4 5 3
 4 5 2 3 1
 */