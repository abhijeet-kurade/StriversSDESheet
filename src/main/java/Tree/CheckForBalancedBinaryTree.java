package Tree;

public class CheckForBalancedBinaryTree {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static Node tree1(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.left.right = new Node(9);

        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        root.right.right = new Node(8);


        return root;
    }

    public static void main(String[] args) {

    }

    public boolean isBalanced(Node root) {
        return dfsHeight(root) != -1;
    }
    public static int dfsHeight(Node node){
        if(node == null) return 0;
        int left = dfsHeight(node.left);
        int right = dfsHeight(node.right);
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

}
