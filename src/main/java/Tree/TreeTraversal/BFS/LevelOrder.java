package Tree.TreeTraversal.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
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
        System.out.println(levelWiseOrder(root));
    }

    public static ArrayList<Integer> levelOrder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return list;
    }

    public static ArrayList<ArrayList<Integer>> levelWiseOrder(Node root){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int s = queue.size();
            ArrayList<Integer> curr = new ArrayList<>();
            for(int i=0; i<s; i++){
                Node node = queue.poll();
                curr.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(curr);

        }
        return list;
    }

}
