package Graph.Cycle;

import java.util.*;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        int nodes4 = 8;
        int[][] edges4 = {{1,3},{3,5},{3,7},{6,2},{6,4},{2,8}};

        int nodes5 = 7; // forest of 2 trees
        int[][] edges5 = {{1,7},{5,2},{2,3},{2,6},{2,4}, {6, 5}};

        System.out.println(detectCycleInUndirectedGraphBFS(nodes5, edges5));

    }

    public static boolean detectCycleInUndirectedGraphDFS(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i=1; i<=nodes; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
        HashSet<Integer> visited = new HashSet<>();
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            if(!isTreeDFSIterative(node,  graph, visited)) return true;
        }
        return false;
    }
    public static boolean isTreeDFSRecursive(Integer current, Integer parent, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited ){
        if(visited.contains(current)) return false;
        visited.add(current);
        for(Integer neighbor : graph.get(current)){
            if(neighbor == parent) continue;
            if(!isTreeDFSRecursive(neighbor, current, graph, visited)) return false;
        }
        return true;
    }
    public static boolean isTreeDFSIterative(Integer node, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited ){
        Stack<Integer[]> stack = new Stack<>();
        stack.add(new Integer[]{node, -1});
        while (!stack.isEmpty()){
            Integer[] stkNode = stack.pop();
            Integer current = stkNode[0];
            Integer parent = stkNode[1];
            for(Integer neighbor : graph.get(current)){
                if(neighbor == parent) continue;
                if(visited.contains(neighbor)) return false;
                visited.add(neighbor);
                stack.add(new Integer[]{neighbor, current});
            }
        }
        return true;
    }

    public static boolean detectCycleInUndirectedGraphBFS(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i=1; i<=nodes; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer[]> queue = new LinkedList<>();
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            queue.add(new Integer[]{node, -1});
            visited.add(node);
            while (!queue.isEmpty()){
                Integer[] queueNode = queue.poll();
                Integer current = queueNode[0];
                Integer parent = queueNode[1];
                for(Integer neighbor : graph.get(current)){
                    if(parent == neighbor) continue;
                    if(visited.contains(neighbor)) return true;
                    queue.add(new Integer[]{neighbor, current});
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }

}
