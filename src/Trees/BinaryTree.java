package Trees;

import LinkedList.LinkedListImplementation;

import java.util.Comparator;

public class BinaryTree<T> {
    public BinaryNode<T> root;
    private boolean isTreeBST = false;
    private Comparator<T> nodeComparator;

    // Below queue maintains next Nodes in which we will insert child nodes for a balanced tree.
    // At most it maintains [currentLevel + currentLevel/2] nodes
    private LinkedListImplementation<BinaryNode> queue = new LinkedListImplementation<>();

    public BinaryTree() {
    }

    public BinaryTree(Comparator<T> nodeComparator) {
        this.isTreeBST = true;
        this.nodeComparator = nodeComparator;
    }

    public BinaryNode add(T data) {
        BinaryNode<T> node = new BinaryNode<>(data);

        if (root == null) {
            System.out.println("Setting root value as: " + node.data);
            root = node;
            queue.add(root);
            return node;
        }

        return isTreeBST ? createBST(node, root) : createBalancedTree(node);
    }

    private BinaryNode createBST(BinaryNode<T> node, BinaryNode<T> currentParent) {

        int dataComparison = nodeComparator.compare(node.data, currentParent.data);
        if (dataComparison > 0) {
            if (currentParent.right != null) {
                System.out.println("Going right of tree with current parent as [" + currentParent.data + "] for node [" + node.data + "]");
                createBST(node, currentParent.right);
            } else {
                System.out.println("adding [" + node.data + "] to right of parent [" + currentParent.data + "]");
                currentParent.right = node;
            }
        } else if (dataComparison < 0) {
            if (currentParent.left != null) {
                System.out.println("Going left of tree with current parent as [" + currentParent.data + "] for node [" + node.data + "]");
                createBST(node, currentParent.left);
            } else {
                System.out.println("adding [" + node.data + "] to left of parent [" + currentParent.data + "]");
                currentParent.left = node;
            }
        } else {
            System.out.println("No repeated values allowed");
        }
        return node;
    }

    private BinaryNode createBalancedTree(BinaryNode<T> node) {
        queue.printList();
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

    public int heightOfTree() {
        BinaryNode<T> root = getRoot();
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = getSubtreeHeight(root.left);
        int rightTreeHeight = getSubtreeHeight(root.right);

        return leftTreeHeight > rightTreeHeight ? leftTreeHeight : rightTreeHeight;
    }

    public int getSubtreeHeight(BinaryNode<T> node) {
        if (node == null)
            return 0;

        int leftTreeHeight = 1 + getSubtreeHeight(node.left);
        int rightTreeHeight = 1 + getSubtreeHeight(node.right);

        return leftTreeHeight > rightTreeHeight ? leftTreeHeight : rightTreeHeight;
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void printNodesLevelWise() {
        LinkedListImplementation<BinaryNode> queue = new LinkedListImplementation<>();
        queue.add(this.getRoot());
        while (queue.size() > 0) {
            BinaryNode currentNode = queue.pop();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        int nodes = 1;
        while (nodes <= 5)
            tree.add(nodes++);

        System.out.print("\nInorder traversal: ");
        tree.inorderTraversal(tree.root);
        System.out.print("\nPre order traversal: ");
        tree.preOrderTraversal(tree.root);
        System.out.print("\nPost order traversal: ");
        tree.postOrderTraversal(tree.root);

        System.out.print("\nLevel order traversal: ");
        tree.printNodesLevelWise();
    }
}


/**
 * //       Output:
 * //       Setting root value as: 1
 * //
 * //       binaryNode.data=1 ->
 * //       adding [2] left child to 1
 * //
 * //       binaryNode.data=1 ->
 * //       adding [3] right child to 1
 * //
 * //       binaryNode.data=2 -> binaryNode.data=3 ->
 * //       adding [4] left child to 2
 * //
 * //       binaryNode.data=2 -> binaryNode.data=3 ->
 * //       adding [5] right child to 2
 * //
 * //       Inorder traversal: 4 2 5 1 3
 * //       Pre order traversal: 1 2 4 5 3
 * //       Post order traversal: 4 5 2 3 1
 * //       Level order traversal: 1 2 3 4 5
 */
