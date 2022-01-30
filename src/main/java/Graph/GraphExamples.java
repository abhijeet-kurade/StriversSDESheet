package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GraphExamples {
    public static void main(String[] args) {
        int nodes = 3; // Undirected K3
        int[][] edges = {{1,2},{1,3},{2,3}};

        int nodes1 = 4; // Undirected K4
        int[][] edges1 = {{1,2},{1,3},{2,4},{3,2},{3,4},{4,1}};

        int nodes2 = 5; // Undirected K5
        int[][] edges2 = {{1,2},{1,3},{1,4},{1,5},{2,4},{2,4},{2,5},{4,3},{5,3},{5,4}};

        int nodes3 = 6;
        int[][] edges3 = {{1,2},{1,3},{1,4},{1,5},{1,6},{1,3},{1,4},{1,5},};

        int nodes4 = 8; // Undirected forest of 2 trees
        int[][] edges4 = {{1,3},{3,5},{3,7},{6,2},{6,4},{2,8}};

        int nodes5 = 7; // Undirected forest of 2 trees
        int[][] edges5 = {{1,7},{5,2},{2,3},{2,6},{2,4}};

        int nodes6 = 9; // Directed with cycle
        int[][] edges6 = {{1,2},{2,3},{3,6},{3,4},{4,5},{6,5},{7,2},{7,8},{8,9},{9,7}};

        int nodes7 = 10;
        int[][] edges7 = {{1,5},{1,3},{1,6},{5,3},{5,2},{3,2},{3,6},{3,7},{2,9},{7,4},{4,9},{9,10},{10,8},{4,8},{},{}};

        int nodes8 = 3;
        int[][] edges8 = {};

        int nodes9 = 3;
        int[][] edges9 = {};

        int nodes10 = 3;
        int[][] edges10 = {};

        int nodes11 = 3;
        int[][] edges11 = {};

        int nodes12 = 8; // undirected for coloring
        int[][] edges12 = {{1,2},{2,3},{3,4},{4,5},{2,8},{8,5},{6,7}};

    }

    static class Node{
        int val;
        ArrayList<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
    public static Node[] getAdjacencyListOfNodes(int nodes, int[][] edges){
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
    public static HashMap<Integer, ArrayList<Integer>> getAdjacencyListOfHashMap(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i=1; i<=nodes; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    public static ArrayList<Integer>[] getAdjacencyListOfArray(int nodes, int[][] edges){
        ArrayList<Integer>[] graph = new ArrayList[nodes+1];
        for(int i=1; i<=nodes; i++) graph[i] = new ArrayList<>();
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
    public static int[][] getAdjacencyMatrix(int nodes, int[][] edges){
        int[][] graph = new int[nodes+1][nodes+1];
        for(int[] edge : edges){
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        return graph;
    }
}
