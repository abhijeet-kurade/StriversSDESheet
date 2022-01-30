package Graph;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args){
        int nodes = 6;
        int[][] edges = {{1,2},{1,4},{4,2},{2,3},{4,5},{4,6},{5,6},{3,5}};

        int nodes1 = 8;
        int[][] edges1 = {{1,2},{1,8},{2,3},{2,6},{3,4},{3,5},{4,5},{8,7},{7,6},{6,5},{4,8},{8,3}};


        int[] topologicalSort = topologicalSortBSF(nodes1, edges1);
        for(int num : topologicalSort) System.out.print(num + " ");
    }

    public static int[] topologicalSortBSF(int nodes, int[][] edges){
        /*
        * Kahn's Algorithm
        * step 1 : find in degree of all node
        * step 2 : find nodes with zero in degree
        * step 3 : add nodes with zero in degree in queue
        * step 4 : poll node from queue and add on stack
        * step 5 : visit its neighbor
        * step 6 : reduce in degree if neighbor and if it equals zero then add into queue
        * step 7 : go to step 4
        * step 8 : extract topological sort from stack
        *
        * */
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashSet<Integer> zeroDegree = new HashSet<>();
        for(int node=1; node<=nodes; node++){
            graph.put(node, new ArrayList<>());
            inDegree.put(node, 0);
            zeroDegree.add(node);
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            if(zeroDegree.contains(edge[1])) zeroDegree.remove(edge[1]);
            inDegree.put(edge[1], inDegree.get(edge[1])+1);
        }
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
        int[] topologicalOrder = new int[stack.size()];
        int idx = stack.size()-1;
        while(!stack.isEmpty()) topologicalOrder[idx--] = stack.pop();

        return topologicalOrder;
    }

    public static int[] topologicalSortDFS(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=1; node<=nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges) graph.get(edge[0]).add(edge[1]);
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            depthFirstSearch(node, stack, visited, graph);
        }
        int[] topologicalOrder = new int[stack.size()];
        int idx=0;
        while(!stack.isEmpty()) topologicalOrder[idx++] = stack.pop();
        return topologicalOrder;
    }
    public static void depthFirstSearch(Integer node, Stack<Integer> stack, HashSet<Integer> visited, HashMap<Integer, ArrayList<Integer>> graph){
        if(visited.contains(node)) return;
        visited.add(node);
        for(Integer neighbor : graph.get(node)) depthFirstSearch(neighbor, stack, visited, graph);
        stack.add(node);
    }



}
