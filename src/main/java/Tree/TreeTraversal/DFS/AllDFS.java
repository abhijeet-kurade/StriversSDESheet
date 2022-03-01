package Tree.TreeTraversal.DFS;

import java.util.ArrayList;
import java.util.Stack;

public class AllDFS {
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
        System.out.println(allOrderTraversal(root));
    }

    static class StackNode{
        Node node;
        int rank;
        public StackNode(Node node) {
            this.node = node;
            this.rank = 0;
        }
    }

    public static ArrayList<ArrayList<Integer>> allOrderTraversal(Node root){
        ArrayList<ArrayList<Integer>> traversals = new ArrayList<>();
        traversals.add(new ArrayList<>());
        traversals.add(new ArrayList<>());
        traversals.add(new ArrayList<>());

        Stack<StackNode> stack = new Stack<>();
        stack.add(new StackNode(root));
        while(!stack.isEmpty()){
            StackNode curr = stack.pop();
            if(curr.rank == 0){
                traversals.get(curr.rank).add(curr.node.val);
                curr.rank += 1;
                stack.add(curr);
                if(curr.node.left != null) stack.add(new StackNode(curr.node.left));
            }
            else if(curr.rank == 1){
                traversals.get(curr.rank).add(curr.node.val);
                curr.rank += 1;
                stack.add(curr);
                if(curr.node.right != null) stack.add(new StackNode(curr.node.right));
            }
            else {
                traversals.get(curr.rank).add(curr.node.val);
            }
        }
        return traversals;
    }

    public static ArrayList<ArrayList<Integer>> allOrderTraversal1(Node root){
        ArrayList<ArrayList<Integer>> traversals = new ArrayList<>();
        traversals.add(new ArrayList<>());
        traversals.add(new ArrayList<>());
        traversals.add(new ArrayList<>());

        Stack<StackNode> stack = new Stack<>();
        stack.add(new StackNode(root));
        while(!stack.isEmpty()){
            StackNode curr = stack.peek();
            if(curr.rank == 0){
                traversals.get(curr.rank).add(curr.node.val);
                curr.rank += 1;
                if(curr.node.left != null) stack.add(new StackNode(curr.node.left));
            }
            else if(curr.rank == 1){
                traversals.get(curr.rank).add(curr.node.val);
                curr.rank += 1;
                if(curr.node.right != null) stack.add(new StackNode(curr.node.right));
            }
            else {
                traversals.get(curr.rank).add(curr.node.val);
                stack.pop();
            }
        }
        return traversals;
    }
}
