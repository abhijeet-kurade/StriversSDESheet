package Graph.Cycle;

import java.util.*;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        int nodes6 = 9; // Directed with cycle
        int[][] edges6 = {{1,2},{2,3},{3,6},{3,4},{4,5},{6,5},{7,2},{7,8},{8,9},{7,9}};

        int nodes10 = 2;
        int[][] edges10 = {{0,1}};
        System.out.println(detectCycleInDirectedGraphBFS(nodes10, edges10));
    }

    public static boolean detectCycleInDirectedGraph(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=1; node<=nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges) graph.get(edge[0]).add(edge[1]);

        System.out.println(graph);
        HashSet<Integer> visited  = new HashSet<>();
        HashSet<Integer> currPath  = new HashSet<>();
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            if(!isTreeDFSRecursive(node, graph, visited, currPath)) return true;
        }
        return false;
    }


    public static boolean isTreeDFSRecursive(Integer current, HashMap<Integer, ArrayList<Integer>> graph,
                                             HashSet<Integer> visited, HashSet<Integer> currPath ){
        if(currPath.contains(current)) return false;
        visited.add(current);
        currPath.add(current);
        for(Integer neighbor : graph.get(current)){
            if(!isTreeDFSRecursive(neighbor, graph, visited, currPath)) return false;
        }
        currPath.remove(current);
        return true;
    }

    public static boolean isTreeDFSIterative(Integer node, HashMap<Integer, ArrayList<Integer>> graph,
                                             HashSet<Integer> visited){

        return true;
    }


    public static boolean detectCycleInDirectedGraphBFS(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashSet<Integer> zeroDegree = new HashSet<>();
        for(int node=0; node<=nodes; node++){
            graph.put(node, new ArrayList<>());
            inDegree.put(node, 0);
            zeroDegree.add(node);
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            if(zeroDegree.contains(edge[1])) zeroDegree.remove(edge[1]);
            inDegree.put(edge[1], inDegree.get(edge[1])+1);
        }
        System.out.println(graph +" "+inDegree);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for(Integer node : zeroDegree) queue.add(node);
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            stack.add(current);
            for(Integer neighbor : graph.get(current)){
                if(inDegree.get(neighbor)>0){
                    inDegree.put(neighbor, inDegree.get(neighbor)-1);
                    if(inDegree.get(neighbor)==0) queue.add(neighbor);
                }
            }
        }
        System.out.println(stack);
        return nodes != stack.size();
    }

}
