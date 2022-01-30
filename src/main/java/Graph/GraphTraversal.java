package Graph;

import java.util.*;

public class GraphTraversal {

    public static void main(String[] args) {
        int[][] edges = {
                {1,2},{1,3},{1,7},{2,7},{2,4},{3,4},{3,5},{3,6},{4,5},{5,6}
        };
        int[][] edges1 = {
                {1,2},{1,3},{1,4},{2,3},{2,4},{3,4}
        };
        int[][] edges2 = {
                {1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}
        };

        int nodes12 = 8; // undirected for coloring
        int[][] edges12 = {{1,2},{2,3},{3,4},{4,5},{2,8},{8,5},{6,7},{1,7}};

        breathFirstSearchTraversal(nodes12, edges12);

        /*Node[] graph1 = getAdjacencyList(7, edges);
        printGraph(graph1);
        System.out.println();
        graphBFS(graph1);*/
    }

    public static void printGraph(Node[] graph){
        for(Node node : graph){
            System.out.println(node +" -> "+node.getNeighbors());
        }
    }

    public static int[][] getAdjacencyMatrix(int nodes, int[][] edges){
        int[][] matrix = new int[nodes+1][nodes+1];
        for(int[] edge : edges){
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }
        return matrix;
    }
    public static Node[] getAdjacencyList(int nodes, int[][] edges){
        Node[] graph = new Node[nodes];
        for(int i=1; i<=nodes; i++){
            graph[i-1] = new Node(i);
        }
        for(int[] edge : edges){
            graph[edge[0]-1].neighbors.add(graph[edge[1]-1]);
            graph[edge[1]-1].neighbors.add(graph[edge[0]-1]);
        }
        return graph;
    }

    public static void graphDFS(Node[] nodes){
        int n = nodes.length;
        if(n == 0) return;
        HashSet<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        for(int i=0; i<n; i++){
            Node node = nodes[i];
            if(visited.contains(node)) continue;
            graphDFSIterative(node, visited);
        }
    }
    public static void graphDFSIterative(Node node, HashSet<Node> visited){
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        visited.add(node);
        while(!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node +" ");
            for(Node neighbor : node.neighbors){
                if(visited.contains(neighbor)) continue;
                stack.add(neighbor);
                visited.add(neighbor);
            }
        }
        System.out.println();
    }
    public static void graphDFSRecursive(Node node, HashSet<Node> visited){
        if(visited.contains(node)) return;
        visited.add(node);
        System.out.print(node +" ");
        for(Node neighbor : node.neighbors){
            graphDFSRecursive(neighbor, visited);
        }

    }

    public static void graphBFS(Node[] nodes){
        int n = nodes.length;
        if(n == 0) return;
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            Node node = nodes[i];
            if(visited.contains(node)) continue;
            queue.add(node);
            visited.add(node);
            while (!queue.isEmpty()){
                node = queue.poll();
                System.out.print(node +" ");
                for(Node neighbor : node.neighbors){
                    if(visited.contains(neighbor)) continue;
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

    }

    public static boolean validTreeDFSRecursive(Node current, Node parent, HashSet<Node> visited){
        if(visited.contains(current)) return false;
        visited.add(current);
        for(Node neighbor : current.neighbors){
            if(current == parent) continue;
            if(!validTreeDFSRecursive(neighbor, current, visited)) return false;
        }
        return true;
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



    public static void depthFirstSearchTraversal(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=1; node<=nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);

        HashSet<Integer> visited = new HashSet<>();
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            dfs(node, graph, visited);
        }

    }
    public static void dfs(Integer node, HashMap<Integer, ArrayList<Integer>> graph,  HashSet<Integer> visited){
        if(visited.contains(node)) return;
        visited.add(node);
        System.out.print(node + " ");
        for(Integer neighbor : graph.get(node)) dfs(neighbor, graph, visited);
    }
    public static void breathFirstSearchTraversal(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=1; node<=nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            queue.add(node);
            visited.add(node);
            while(!queue.isEmpty()){
                node = queue.poll();
                System.out.print(node + " ");
                for(Integer neighbor : graph.get(node)){
                    if(visited.contains(neighbor)) continue;
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

}
