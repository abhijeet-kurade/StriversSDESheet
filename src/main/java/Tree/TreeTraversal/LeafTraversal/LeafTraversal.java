package Tree.TreeTraversal.LeafTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class LeafTraversal {
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
        Node root = tree1();
        System.out.println(leafTraversal(root));


    }

    public static ArrayList<Integer> leafTraversal(Node root){

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if(node.left== null && node.right== null) list.add(node.val);
            if(node.left!=null)stack.add(node.left);
            if(node.right!=null) stack.add(node.right);
        }
        return list;
    }
}
