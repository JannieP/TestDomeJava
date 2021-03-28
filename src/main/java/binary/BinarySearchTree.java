package binary;

public class BinarySearchTree {


    public static boolean contains(Node root, int value) {

        boolean b = root.value == value
                    ? true
                    : root.value < value
                        ? root.right != null
                            ? contains(root.right, value)
                            : false
                        : root.left != null
                            ? contains(root.left, value)
                            : false;
        return b;

        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }
}
