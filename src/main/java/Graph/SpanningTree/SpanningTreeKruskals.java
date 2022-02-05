package Graph.SpanningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SpanningTreeKruskals {
    public static void main(String[] args) {
        SpanningTreeKruskals sp = new SpanningTreeKruskals();
        int nodes = 9;
        int[][] edges = {{0,1,4},{0,7,8},{1,2,8},{1,7,11},{7,8,7},{7,6,1},{2,8,2},{8,6,6},{2,3,7},{2,5,4},{6,5,2},{3,5,14},{3,4,9},{4,5,10},};
        int[][] tree = sp.kruskals(nodes, edges);
        for(int[] node : tree){
            System.out.println(node[0] + " "+node[1] +" "+node[2]);
        }
    }
    public int[][] kruskals(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for(int node=0; node<=nodes; node++){
            graph.put(node, new ArrayList<>());
        }
        QueueForKruskal queue = new QueueForKruskal();
        for(int[] edge : edges){
            int s = edge[0], d = edge[1], w = edge[2];
            graph.get(s).add(new int[]{d, w});
            graph.get(d).add(new int[]{s, w});
            queue.add(new Edge(s, d, w));
        }
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<int[]> spanningTree = new ArrayList<>();
        while(!queue.isEmpty()){
            Edge edge = queue.poll();
            int s = visited.contains(edge.source) ? 1 : 0;
            int d = visited.contains(edge.destination) ? 1 : 0;
            if((s+d) == 2 ) continue;
            spanningTree.add(new int[]{edge.source, edge.destination, edge.weight});
            visited.add(edge.source);
            visited.add(edge.destination);
        }
        int[][] spanning_tree = new int[spanningTree.size()][3];
        int idx =0;
        for(int[] edg : spanningTree) spanning_tree[idx++] = edg;
        return spanning_tree;
    }
}

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" +source + " " + destination + " " + weight + ']';
    }
}
class QueueForKruskal {
    ArrayList<Edge> heap;
    public QueueForKruskal() {
        this.heap = new ArrayList<>();
    }

    public QueueForKruskal(ArrayList<Edge> heap) {
        this.heap = heap;
        heapify(this.heap);
    }
    private void swap(ArrayList<Edge> heap, int i, int j){
        Edge temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    private void heapify(ArrayList<Edge> heap){
        for(int i=(heap.size()-2)/2; i>=0; i--){
            shiftDown(heap, i);
        }
    }
    private void shiftDown(ArrayList<Edge> heap, int parent){
        int left = 2*parent + 1;
        while(left < heap.size()){
            int right = 2*parent + 2;
            if(right >= heap.size()){
                if(heap.get(left).weight < heap.get(parent).weight) swap(heap, parent, left);
                break;
            }
            if(heap.get(left).weight == Math.min(heap.get(left).weight, heap.get(right).weight)){
                if(heap.get(parent).weight <= heap.get(left).weight) return;
                swap(heap, parent, left);
                parent = left;
            }
            else{
                if(heap.get(parent).weight <= heap.get(right).weight) return;
                swap(heap, parent, right);
                parent = right;
            }
            left = 2*parent + 1;
        }
    }
    private void shiftUp(ArrayList<Edge> heap, int child){
        int parent = (child-1)/2;
        while (parent >= 0){
            if(heap.get(parent).weight <= heap.get(child).weight) return;
            swap(heap, parent, child);
            child = parent;
            parent = (child-1)/2;
        }
    }
    public void add(Edge edge){
        this.heap.add(edge);
        shiftUp(this.heap, this.heap.size()-1);
    }
    public Edge poll(){
        int n = heap.size()-1;
        if(n<0) return null;
        Edge edge = this.heap.get(0);
        swap(this.heap, 0, n);
        this.heap.remove(n);
        shiftDown(this.heap, 0);
        return edge;
    }
    public boolean isEmpty(){
        return this.heap.size() == 0;
    }

}

