package Trees;

/**
 * Here width = 2 + 1 + 2 = 5
 * how ?
 * 1 to 4 distance = 2
 * 1 to 7 distance = 2
 * also we need to include 1
 * //         1
 * //    2        3
 * //4       5 6      7
 */

//This problem can also be named as number of unique vertical lines in a binary tree
// In upper tree: 4, 2, 1-5-6, 3, 7 => 5 lines


/**
 * //                1
 * //            2        3
 * //         4      5
 * //            6
 * //        7
 * //    8
 * // 9
 * <p>
 * For this width = 6
 */

public class WidthOfBinaryTree {
    public static BinaryTree tree = new BinaryTree();

    public static void main(String[] args) {
        int nodeCount = 1;
        BinaryNode lastNodeAdded = null;
        while (nodeCount < 6)
            lastNodeAdded = tree.add(nodeCount++);

        lastNodeAdded.left = new BinaryNode<>(nodeCount++);
        lastNodeAdded.left.left = new BinaryNode<>(nodeCount++);
        lastNodeAdded.left.left.left = new BinaryNode<>(nodeCount++);
        lastNodeAdded.left.left.left.left = new BinaryNode<>(nodeCount++);

        System.out.print("\nInorder traversal of tree: ");
        tree.inorderTraversal(tree.getRoot());
        System.out.println();
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();

        System.out.println("\nWidth of tree is: " + widthOfBinaryTree.getWidth());

    }

    public int getWidth() {
        int leftSubTree = leftSubTreeCount(tree.getRoot().left);
        int rightSubTree = rightSubTreeCount(tree.getRoot().right);
        return 1 + leftSubTree + rightSubTree;
    }

    public int leftSubTreeCount(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        int leftCount = 1 + leftSubTreeCount(node.left);
        int rightCount = rightSubTreeCount(node.right);
        int count = leftCount > rightCount ? leftCount : rightCount;
        System.out.println("Returning count [" + count + "] for node: " + node.data);
        return count;
    }

    public int rightSubTreeCount(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        int leftCount = leftSubTreeCount(node.left);
        int rightCount = 1 + rightSubTreeCount(node.right);
        int count = leftCount > rightCount ? leftCount : rightCount;
        System.out.println("Returning count [" + count + "] for node: " + node.data);
        return count;
    }
}