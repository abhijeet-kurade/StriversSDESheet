package Graph;

import java.util.*;

public class BridgesInGraph {
    public static void main(String[] args) {

        int nodes4 = 8;
        int[][] edges4 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,8}, {8,4}, {4,7}};

        int nodes3 = 6;
        int[][] edges3 = {{1,5},{2,1},{2,4},{3,4},{1,3},{4,6}};

        int nodes2 = 5;
        int[][] edges2 = {{1,2},{2,3},{3,4},{2,4},{2,5}};

        int nodes1 = 4;
        int[][] edges1 = {{1,2},{2,3},{2,4},{1,3}};

        int nodes = 15;
        int[][] edges = {{1,2},{2,3},{3,1},{4,2},{5,4},{5,3}, {5,6}, {6,7},{3,7},{6,2},{3,8},{8,9},{9,10},{8,10},{9,11},{11,12},{10,12},{11,13},{13,14},{13,15},{14,15}};

        int[][] bridges = bridgesInGraph(nodes, edges, 1);
        for(int[] brg : bridges) printArr(brg);

    }
    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }
    public static int[][] bridgesInGraph(int nodes, int[][] edges, int source){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=1; node<=nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] start = new int[nodes+1];
        int[] low = new int[nodes+1];
        Arrays.fill(start, Integer.MAX_VALUE);
        Arrays.fill(low, Integer.MAX_VALUE);
        ArrayList<int[]> bridges = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        depthFirstSearch(source, -1, start, low, new int[]{1}, visited, graph, bridges);
        int[][] brgs = new int[bridges.size()][2];
        int idx = 0;
        for(int [] brg : bridges) brgs[idx++] = brg;
        return brgs;
    }

    public static void depthFirstSearch(int current, int parent,int[] start, int[] low, int[] time, HashSet<Integer> visited,
                                        HashMap<Integer, ArrayList<Integer>> graph, ArrayList<int[]> bridges){
        if(visited.contains(current)) return;
        visited.add(current);
        start[current] = time[0]++;
        int lowest = start[current];
        for(Integer neighbor : graph.get(current)){
            if(neighbor == parent) continue;
            if(!visited.contains(neighbor)){
                depthFirstSearch(neighbor, current, start, low, time, visited, graph, bridges);
                if(start[current] < low[neighbor]) bridges.add(new int[]{current, neighbor});
            }
            lowest = Math.min(lowest, Math.min(start[neighbor], low[neighbor]));
        }
        low[current] = lowest;
    }


    public static void depthFirstSearchIterative(int source, HashMap<Integer, ArrayList<Integer>> graph, ArrayList<int[]> bridges){
        int nodes = graph.size();
        int[] start = new int[nodes+1];
        int[] low = new int[nodes+1];
        Arrays.fill(start, Integer.MAX_VALUE);
        Arrays.fill(low, Integer.MAX_VALUE);
        HashSet<Integer> visited = new HashSet<>();
        int time = 0;
        Stack<int[]> systemStack = new Stack<>();
        Stack<int[]> returnStack = new Stack<>();

        while(!systemStack.isEmpty()){
            int[] node = systemStack.pop();
            int current = node[0];
            int parent = node[1];
            if(visited.contains(current)) continue;
            visited.add(current);
            start[current] = time++;
            for(Integer neighbor : graph.get(current)){
                if(neighbor == parent) continue;
                if(!visited.contains(neighbor)){
                    systemStack.add(new int[]{neighbor, current});
                }
            }
        }
    }
}
