package Graph;

import java.util.*;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        int nodes = 2;
        int[][] edges = {};
        shortestPathWeightedGraph(nodes, edges, 1);
    }
    public static int[] shortestPathWeightedGraph(int nodes, int[][] edges, int source){
        HashMap<Integer, ArrayList<Integer[]>> graph = new HashMap<>();
        int[] distances = new int[nodes+1];
        int M = Integer.MAX_VALUE;
        for(int node=0; node<=nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(new Integer[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new Integer[]{edge[0], edge[2]});
        }
        HashSet<Integer> explored = new HashSet<>();
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(
                (o1, o2)->{return o1[0] - o2[0];}
        );
        while(!queue.isEmpty()){
            Integer[] node = queue.poll();
            int distance = node[0];
            int current = node[1];
            explored.add(current);
            for(Integer[] neighborNode : graph.get(current)){
                Integer neighbor = neighborNode[0];
                if(explored.contains(neighbor)) continue;
                Integer edgeDistance = neighborNode[1];


            }
        }
        return null;
    }

    static class MinHeap{

    }
}
