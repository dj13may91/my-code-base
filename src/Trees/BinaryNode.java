package Trees;

class BinaryNode<T> {
    T data;
    BinaryNode left;
    BinaryNode right;

    BinaryNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "binaryNode.data=" + String.valueOf(data);
    }

}
