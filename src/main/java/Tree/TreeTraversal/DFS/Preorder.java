package Tree.TreeTraversal.DFS;

import java.util.ArrayList;
import java.util.Stack;

// root | left | right
public class Preorder {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = tree1();
        System.out.println(preorder(root, new ArrayList<>()));
        System.out.println(preorder(root));
    }

    public static ArrayList<Integer> preorder(Node node, ArrayList<Integer> list){
        if(node == null) return list;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
        return list;
    }

    public static ArrayList<Integer> preorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }
        return list;
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
}
