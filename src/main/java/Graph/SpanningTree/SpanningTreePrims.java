package Graph.SpanningTree;

import java.util.*;

public class SpanningTreePrims {
    public static void main(String[] args) {
        SpanningTreePrims sp = new SpanningTreePrims();
        int nodes = 9;
        int[][] edges = {{0,1,4},{0,7,8},{1,2,8},{1,7,11},{7,8,7},{7,6,1},{2,8,2},{8,6,6},{2,3,7},{2,5,4},{6,5,2},{3,5,14},{3,4,9},{4,5,10},};
        int[][] tree = sp.prims(nodes, edges);
        for(int[] node : tree){
            System.out.println(node[0] + " "+node[1] +" "+node[2]);
        }

    }
    public int[][] prims(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for(int node=0; node<=nodes; node++){
            graph.put(node, new ArrayList<>());
        }
        int start = -1, minW = Integer.MAX_VALUE;
        for(int[] edge : edges){
            int s = edge[0], d = edge[1], w = edge[2];
            graph.get(s).add(new int[]{s, d, w});
            graph.get(d).add(new int[]{d, s, w});
            if(minW > w){
                minW = w;
                start = s;
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2)->{return o1[2]-o2[2];}
        );
        for(int[] edge : graph.get(start)) queue.add(edge);

        ArrayList<int[]> spanningTree = new ArrayList<>();
        while (!queue.isEmpty()){
            int[] edge = queue.poll();
            int s = visited.contains(edge[0]) ? 1 : 0;
            int d = visited.contains(edge[1]) ? 1 : 0;
            if((s+d) == 2) continue;
            spanningTree.add(edge);
            int node ;
            if(s==0) node = edge[0];
            else node = edge[1];
            visited.add(node);
            for(int[] neighbor : graph.get(node)){
                int s1 = visited.contains(neighbor[0]) ? 1 : 0;
                int d1 = visited.contains(neighbor[1]) ? 1 : 0;
                if((s1+d1) == 2) continue;
                queue.add(neighbor);
            }
        }
        int[][] spanning_tree = new int[spanningTree.size()][3];
        int idx =0;
        for(int[] edg : spanningTree) spanning_tree[idx++] = edg;
        return spanning_tree;
    }
}
