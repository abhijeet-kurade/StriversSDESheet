package Tree.TreeTraversal.DFS;


import java.util.ArrayList;
import java.util.Stack;

// left | root | right
public class Inorder {
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
        System.out.println(inorderTraversal(root, new ArrayList<>()));
        System.out.println(inorderTraversal(root));
    }
    public static ArrayList<Integer> inorderTraversal(Node root, ArrayList<Integer> list){
        if(root == null) return list;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        return list;
    }

    public static ArrayList<Integer> inorderTraversal(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}
