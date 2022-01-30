package Graph;

import java.util.*;

public class CloneAGraph {
    public static void main(String[] args) {

    }

    public static Node cloneGraphBFS(Node node){
        if(node == null) return null;

        HashSet<Node> visited  = new HashSet<>();
        HashMap<Node, Node> nodes = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node(node.val);
        nodes.put(node, newNode);
        visited.add(node);
        queue.add(node);

        while(!queue.isEmpty()){
            Node node1 = queue.poll();
            for(Node neighbour1 : node1.neighbors){
                if(visited.contains(neighbour1)){
                    nodes.get(node1).neighbors.add(nodes.get(neighbour1));
                    continue;
                }
                Node neighbour2 = new Node(neighbour1.val);
                nodes.put(neighbour1, neighbour2);
                nodes.get(node1).neighbors.add(neighbour2);
                visited.add(neighbour1);
                queue.add(neighbour1);
            }
        }
        return newNode;
    }

    public static Node cloneGraphDFS(Node start){
        if(start == null) return null;
        HashMap<Node, Node> nodes = new HashMap<>();
        //HashSet<Node> visited = new HashSet<>();

        Node newNode = new Node(start.val);
        nodes.put(start, newNode);
        //visited.add(start);

        Stack<Node> stack = new Stack<>();
        stack.add(start);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            for(Node neighbor : node.neighbors){
                if(nodes.get(neighbor) != null){
                    nodes.get(node).neighbors.add(nodes.get(neighbor));
                    continue;
                }
                //Node neighbor2 = new Node(neighbor1.val);
                nodes.put(neighbor, new Node(neighbor.val));
                stack.add(neighbor);
                nodes.get(node).neighbors.add(nodes.get(neighbor));
                //visited.add(neighbor);
            }
        }
        return newNode;
    }

    public static Node cloneGraphDFSIterativeImproved(Node start){
        if(start == null) return null;
        HashMap<Node, Node> clone = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        Node head= new Node(start.val);
        clone.put(start, head);
        stack.add(start);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            for(Node neighbor : node.neighbors){
                if(clone.get(neighbor) == null) {
                    clone.put(neighbor, new Node(neighbor.val));
                    stack.add(neighbor);
                }
                clone.get(node).neighbors.add(clone.get(neighbor));
            }
        }
        return head;
    }

    public static Node cloneGraphDFSRecursiveImproved(Node start){
        if(start == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node head= new Node(start.val);
        map.put(start, head);

        return head;
    }
    public static void cloneGraphDFSRecursive(Node node, HashMap<Node, Node> map){
        for(Node neighbor : node.neighbors){
            if(map.get(neighbor) == null) map.put(neighbor, new Node(neighbor.val));
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }

    public static Node cloneGraphBFSImproved(Node start){
        if(start == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node head = new Node(start.val);
        map.put(start, head);

        queue.add(start);
        while(queue.isEmpty()){
            Node node = queue.poll();
            for(Node neighbor : node.neighbors){
                if(map.get(neighbor) == null){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(node).neighbors.add(map.get(neighbor));
            }
        }
        return head;
    }




    static class Node{
        int val;
        ArrayList<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors =  new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors =  new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

        @Override
        public String toString() {
            return "("+ val +")";
        }

        public String getNeighbors() {
            String str = "[ ";
            for(Node node : this.neighbors){
                str += node.toString() + " ";
            }
            str += "]";
            return str;
        }
    }

}
