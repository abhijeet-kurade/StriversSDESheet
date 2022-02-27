package Tree;

public class MaximumDepthBinaryTree {
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
    public static Node tree2(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);

        root.right.right.left = new Node(6);

        return root;
    }

    public static void main(String[] args) {
        Node root = tree2();
        System.out.println(dfsHeight(root));

    }

    public static int depthFirstSearch(Node root){
        return dfsHeight(root, 0);
    }

    public static int dfsHeight(Node node, int depth){
        if(node==null) return depth;
        depth += 1;
        int left = dfsHeight(node.left, depth);
        int right = dfsHeight(node.right, depth);
        return Math.max(left, right);
    }
    public static int dfsHeight(Node node){
        if(node == null) return 0;
        int left = dfsHeight(node.left);
        int right = dfsHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
