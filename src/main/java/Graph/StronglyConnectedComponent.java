package Graph;

import java.util.*;

public class StronglyConnectedComponent {
    public static void main(String[] args) {
        int nodes = 7;
        int[][] edges = {{1,2},{2,3},{3,1},{2,4},{4,5},{5,6},{6,7},{5,2}};
        System.out.println(stronglyConnectedComponent(nodes, edges));
    }

    public static ArrayList<ArrayList<Integer>> stronglyConnectedComponent(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> reversedGraph = new HashMap<>();
        for(int node=1; node<=nodes; node++){
            graph.put(node, new ArrayList<>());
            reversedGraph.put(node, new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            reversedGraph.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> topologicalOrder = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            depthFirstSearch(node, graph, visited, topologicalOrder);
        }
        ArrayList<ArrayList<Integer>> stronglyConnectedComponents = new ArrayList<>();
        visited.clear();
        while(!topologicalOrder.isEmpty()){
            Integer node = topologicalOrder.pop();
            if(visited.contains(node)) continue;
            ArrayList<Integer> component = new ArrayList<>();
            depthFirstSearch(node, reversedGraph, visited, component);
            stronglyConnectedComponents.add(component);
        }
        return stronglyConnectedComponents;
    }
    public static void depthFirstSearch(Integer node, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited, Stack<Integer> topologicalOrder){
        if(visited.contains(node)) return;
        visited.add(node);
        for(Integer neighbor : graph.get(node)) depthFirstSearch(neighbor, graph, visited, topologicalOrder);
        topologicalOrder.add(node);
    }
    public static void depthFirstSearch(Integer node, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited, ArrayList<Integer> component){
        if(visited.contains(node)) return;
        visited.add(node);
        component.add(node);
        for(Integer neighbor : graph.get(node)) depthFirstSearch(neighbor, graph, visited, component);
    }

}
