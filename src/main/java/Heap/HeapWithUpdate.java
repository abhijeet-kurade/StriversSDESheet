package Heap;

import java.util.ArrayList;
import java.util.HashMap;

public class HeapWithUpdate {
    public static void main(String[] args) {

        ChangingPriorityQueue queue = new ChangingPriorityQueue();
        queue.add(new Node(3,12));
        queue.add(new Node(5,8));
        queue.add(new Node(2,35));
        queue.add(new Node(1,24));
        queue.add(new Node(6,4));
        queue.add(new Node(7,7));
        queue.add(new Node(8,15));

        System.out.println(queue.nodes);
        System.out.println(queue.heap);

        queue.set(2, 2);

        System.out.println(queue.nodes);
        System.out.println(queue.heap);
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
class ChangingPriorityQueue {
    ArrayList<Node> heap;
    HashMap<Integer, Integer> nodes;
    public ChangingPriorityQueue() {
        this.heap = new ArrayList<>();
        this.nodes = new HashMap<>();
    }

    public ChangingPriorityQueue(ArrayList<Node> heap) {
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
            /*if(right < heap.size()){
                if(heap.get(left).val == Math.min(heap.get(left).val, heap.get(right).val)){
                    swap(heap, nodes, parent, left);
                    parent = left;
                }
                else{
                    swap(heap, nodes, parent, right);
                    parent = right;
                }
                left = 2*parent + 1;
            }
            else{
                if(heap.get(left).val < heap.get(parent).val) swap(heap, nodes, parent, left);
                break;
            }*/
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
        if(heap.size()==0) return null;
        return this.heap.get(nodes.get(node));
    }
    public boolean contains(Node node){
        return this.nodes.get(node.val) != null;
    }
    public int size(){
        return this.heap.size();
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
}
