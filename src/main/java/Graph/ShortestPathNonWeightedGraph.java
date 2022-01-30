package Graph;

import java.util.*;

public class ShortestPathNonWeightedGraph {
    public static void main(String[] args) {
        int nodes7 = 10;
        int[][] edges7 = {{1,5},{1,3},{1,6},{5,3},{5,2},{3,2},{3,6},
                {3,7},{6,7},{2,9},{7,4},{4,9},{9,10},{10,8},{4,8}};
        printArr(shortestPathInNonWeightedGraph(nodes7, edges7,1));
    }
    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }

    public static int[] shortestPathInNonWeightedGraph(int nodes, int[][] edges, int source){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[] distances = new int[nodes+1];
        int M = Integer.MAX_VALUE;
        Arrays.fill(distances, M);
        for(int node=0; node<=nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int curr_distance = 0;
        visited.add(source);
        queue.add(source);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++){
                Integer current = queue.poll();
                distances[current] = curr_distance;
                for(Integer neighbor : graph.get(current)){
                    if(visited.contains(neighbor)) continue;
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            curr_distance += 1;
        }
        return distances;
    }

}
