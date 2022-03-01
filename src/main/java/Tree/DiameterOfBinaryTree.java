package Tree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Node root = tree1();
        System.out.println(diameterOfBtree(root));

    }
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


    public static int diameterOfBtree(Node root){
        int[] dia = diameter(root);
        return Math.max(dia[0], dia[1]);
    }

    public static int[] diameter(Node node){
        if(node == null) return new int[]{0, 0};// dia height
        int[] left = diameter(node.left);
        int[] right = diameter(node.right);
        int height = Math.max(left[1], right[1])+1;
        int diameter = Math.max(Math.max(left[0], right[0]), left[1]+1+right[1]);
        return new int[]{diameter, height};
    }
}
