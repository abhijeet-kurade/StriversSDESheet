package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ShortestPathInWeightedGraph {
    public static void main(String[] args) {
        ShortestPathInWeightedGraph sp = new ShortestPathInWeightedGraph();
        int nodes = 6;
        int[][] edges = {{1,2,7},{1,6,12},{2,6,2},{2,3,9},{3,4,1},{3,5,4},{6,5,10},{5,4,5}};

        int nodes1 = 9;
        int[][] edges1 = {{0,1,4},{0,7,8},{1,2,8},{1,7,11},{7,8,7},{7,6,1},{2,8,2},{8,6,6},{2,3,7},{2,5,4},{6,5,2},{3,5,14},{3,4,9},{4,5,10},};
        int[][] dists = sp.dijkstraNonWeighted(nodes1, edges1, 8);
        for(int[] node : dists){
            System.out.println(node[0] + " "+node[1]);
        }
    }
    public int[][] dijkstra(int nodes, int[][] edges, int start){
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        HashMap<Integer, Integer> distances = new HashMap<>();
        int inf = Integer.MAX_VALUE;
        for(int node=0; node<=nodes; node++){
            graph.put(node, new ArrayList<>());
            distances.put(node, inf);
        }
        for(int[] edge : edges){
            int s = edge[0], d = edge[1], w = edge[2];
            graph.get(s).add(new int[]{d, w});
        }
        HashSet<Integer> explored = new HashSet<>();
        QueueForDijkstra queue = new QueueForDijkstra();
        Node startNode = new Node(start, 0);
        queue.add(startNode);

        while (!queue.isEmpty()){
            Node currentNode = queue.poll();
            distances.put(currentNode.val, currentNode.dist);
            explored.add(currentNode.val);
            int current = currentNode.val;
            for(int[] node : graph.get(current)){
                int neighbor = node[0];
                int dist = node[1];
                if(explored.contains(neighbor)) continue;
                if(distances.get(neighbor) <= distances.get(current)+dist) continue;
                distances.put(neighbor, distances.get(current)+dist);
                if(queue.contains(neighbor)) queue.set(neighbor, distances.get(current)+dist);
                else queue.add(new Node(neighbor, distances.get(current)+dist));
            }
        }
        int[][] dists = new int[distances.size()][2];
        for(int i=0; i<dists.length; i++){
            dists[i][0] = i;
            dists[i][1] = distances.get(i);
        }
        return dists;
    }

    public int[][] dijkstraNonWeighted(int nodes, int[][] edges, int start){
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        HashMap<Integer, Integer> distances = new HashMap<>();
        int inf = Integer.MAX_VALUE;
        for(int node=0; node<=nodes; node++){
            graph.put(node, new ArrayList<>());
            distances.put(node, inf);
        }
        for(int[] edge : edges){
            int s = edge[0], d = edge[1], w = edge[2];
            graph.get(s).add(new int[]{d, w});
            graph.get(d).add(new int[]{s, w});
        }
        HashSet<Integer> explored = new HashSet<>();
        QueueForDijkstra queue = new QueueForDijkstra();
        Node startNode = new Node(start, 0);
        queue.add(startNode);

        while (!queue.isEmpty()){
            Node currentNode = queue.poll();
            distances.put(currentNode.val, currentNode.dist);
            explored.add(currentNode.val);
            int current = currentNode.val;
            for(int[] node : graph.get(current)){
                int neighbor = node[0];
                int dist = node[1];
                if(explored.contains(neighbor)) continue;
                if(distances.get(neighbor) <= distances.get(current)+dist) continue;
                distances.put(neighbor, distances.get(current)+dist);
                if(queue.contains(neighbor)) queue.set(neighbor, distances.get(current)+dist);
                else queue.add(new Node(neighbor, distances.get(current)+dist));
            }
        }
        int[][] dists = new int[distances.size()][2];
        for(int i=0; i<dists.length; i++){
            dists[i][0] = i;
            dists[i][1] = distances.get(i);
        }
        return dists;
    }
}
class Node{
    int val;
    int dist;
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, int dist) {
        this.val = val;
        this.dist = dist;
    }
    @Override
    public String toString() {
        return "[" + val + " " + dist + ']';
    }
}
class QueueForDijkstra {
    ArrayList<Node> heap;
    HashMap<Integer, Integer> nodes;
    public QueueForDijkstra() {
        this.heap = new ArrayList<>();
        this.nodes = new HashMap<>();
    }

    public QueueForDijkstra(ArrayList<Node> heap) {
        this.heap = heap;
        this.nodes = new HashMap<>();
        for(int i=0; i<heap.size(); i++){
            nodes.put(heap.get(i).val, i);
        }
        heapify(this.heap, this.nodes);
    }

    private void swap(ArrayList<Node> heap, HashMap<Integer, Integer> nodes, int i, int j){
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        nodes.put(heap.get(i).val, i);
        nodes.put(heap.get(j).val, j);
    }

    private void heapify(ArrayList<Node> heap, HashMap<Integer, Integer> nodes){
        for(int i=(heap.size()-2)/2; i>=0; i--){
            shiftDown(heap, nodes, i);
        }
    }

    private void shiftDown(ArrayList<Node> heap, HashMap<Integer, Integer> nodes, int parent){
        int left = 2*parent + 1;
        while(left < heap.size()){
            int right = 2*parent + 2;
            if(right >= heap.size()){
                if(heap.get(left).dist < heap.get(parent).dist) swap(heap, nodes, parent, left);
                break;
            }
            if(heap.get(left).dist == Math.min(heap.get(left).dist, heap.get(right).dist)){
                if(heap.get(parent).dist <= heap.get(left).dist) return;
                swap(heap, nodes, parent, left);
                parent = left;
            }
            else{
                if(heap.get(parent).dist <= heap.get(right).dist) return;
                swap(heap, nodes, parent, right);
                parent = right;
            }
            left = 2*parent + 1;
        }
    }

    private void shiftUp(ArrayList<Node> heap, HashMap<Integer, Integer> nodes, int child){
        int parent = (child-1)/2;
        while (parent >= 0){
            if(heap.get(parent).dist <= heap.get(child).dist) return;
            swap(heap, nodes, parent, child);
            child = parent;
            parent = (child-1)/2;
        }
    }


    public void add(Node node){
        this.nodes.put(node.val, this.heap.size());
        this.heap.add(node);
        shiftUp(this.heap, this.nodes, this.heap.size()-1);
    }
    public Node get(int node){
        if(nodes.get(node)==null) return null;
        return this.heap.get(nodes.get(node));
    }
    public boolean contains(int node){
        return this.nodes.get(node) != null;
    }
    public Node poll(){
        int n = heap.size()-1;
        if(n<0) return null;
        Node node = this.heap.get(0);
        swap(this.heap, this.nodes, 0, n);
        this.nodes.remove(this.heap.get(n).val);
        this.heap.remove(n);
        shiftDown(this.heap, this.nodes, 0);
        return node;
    }
    public void set(Integer node, int newDist){
        Node current = this.heap.get(this.nodes.get(node));
        int oldDist = current.dist;
        current.dist = newDist;
        if(oldDist<newDist) shiftDown(this.heap, this.nodes, this.nodes.get(node));
        else shiftUp(this.heap, this.nodes, this.nodes.get(node));
    }
    public boolean isEmpty(){
        return this.heap.size() == 0;
    }

}
