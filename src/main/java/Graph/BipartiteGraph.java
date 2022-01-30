package Graph;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        int nodes = 8;
        int[][] edges = {{1,2},{2,3},{3,4},{4,5},{2,8},{8,5},{6,7}};
        System.out.println(isBipartiteBFS(nodes, edges));
    }

    public static boolean isBipartiteDFS(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=1; node <= nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
        HashMap<Integer, Integer> color = new HashMap<>();
        for(int node=1; node <= nodes; node++) color.put(node, -1); // -1 : no color, 1 : green, 0 : red
        for(Integer node : graph.keySet()){
            if(color.get(node) != -1) continue;
            if(!coloringGraphWithTwoColorsDFSIterative(node, graph, color)) return false;
        }
        System.out.println(color);
        return true;
    }

    public static boolean coloringGraphWithTwoColorsDFSRecursive(Integer node, int color, HashMap<Integer, ArrayList<Integer>> graph, HashMap<Integer, Integer> colors){
        if(colors.get(node) != -1)
            if(colors.get(node) != color) return false;
            else return true;
        colors.put(node, color);
        for(Integer neighbor : graph.get(node)){
            if(!coloringGraphWithTwoColorsDFSRecursive(neighbor, (color+1)%2, graph, colors)) return false;
        }
        return true;
    }
    public static boolean coloringGraphWithTwoColorsDFSIterative(Integer node, HashMap<Integer, ArrayList<Integer>> graph, HashMap<Integer, Integer> colors){
        Stack<Integer[]> stack = new Stack<>();
        stack.add(new Integer[]{node, 0});
        colors.put(node, 0);
        while(!stack.isEmpty()){
            Integer[] stkNode = stack.pop();
            Integer current = stkNode[0];
            Integer clr = stkNode[1];
            for(Integer neighbor : graph.get(current)){
                int newColor = (clr+1)%2;
                if(colors.get(neighbor) != -1){
                    if(colors.get(neighbor) != newColor) return false;
                    else continue;
                }
                colors.put(neighbor, newColor);
                stack.add(new Integer[]{neighbor, newColor});
            }
        }
        return true;
    }

    public static boolean isBipartiteBFS(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=1; node <= nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
        HashMap<Integer, Integer> color = new HashMap<>();
        for(int node=1; node <= nodes; node++) color.put(node, -1); // -1 : no color, 1 : green, 0 : red
        for(Integer node : graph.keySet()) {
            if (color.get(node) != -1) continue;
            if(!coloringGraphWithTwoColorBFS(node, graph, color)) return false;
        }
        return true;
    }

    public static boolean coloringGraphWithTwoColorBFS(Integer node, HashMap<Integer, ArrayList<Integer>> graph, HashMap<Integer, Integer> colors){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{node, 0});
        colors.put(node, 0);
        while(!queue.isEmpty()){
            Integer[] queueNode = queue.poll();
            Integer current = queueNode[0];
            Integer clr = queueNode[1];
            for(Integer neighbor : graph.get(current)){
                if(colors.get(neighbor) != -1){
                    if(colors.get(neighbor) == clr) return false;
                    else continue;
                }
                colors.put(neighbor, (clr+1)%2);
                queue.add(new Integer[]{neighbor, (clr+1)%2});
            }
        }
        return true;
    }

}
