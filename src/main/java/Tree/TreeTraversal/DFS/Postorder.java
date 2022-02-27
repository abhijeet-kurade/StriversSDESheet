package Tree.TreeTraversal.DFS;

import java.util.ArrayList;
import java.util.Stack;

public class Postorder {
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
        System.out.println(postorder(root, new ArrayList<>()));
        System.out.println(postorder(root));

    }
    public static ArrayList<Integer> postorder(Node node, ArrayList<Integer> list){
        if(node == null) return list;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
        return list;
    }
    public static ArrayList<Integer> postorder(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        stack.add(node);
        while(!stack.isEmpty()){
            Node curr = stack.peek();
            if(curr.left==null && curr.right==null){
                list.add(stack.pop().val);
                prev = curr;
                continue;
            }
            Node last = curr.right != null ? curr.right : curr.left;
            if(last == prev){
                list.add(stack.pop().val);
                prev = curr;
                continue;
            }
            if(curr.right != null) stack.add(curr.right);
            if(curr.left != null) stack.add(curr.left);
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

        root.left.right.left.left = new Node(10);

        root.left.right.left.left.left = new Node(11);
        root.left.right.left.left.right = new Node(12);

        root.right.right = new Node(8);


        return root;
    }


}
