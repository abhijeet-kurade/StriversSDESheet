package Heap;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap {
    public static void main(String[] args) {
        PQueue queue = new PQueue();
        queue.insert(4);
    }

}
class PQueue{
    ArrayList<Integer>  heap;
    public PQueue(){
        this.heap = new ArrayList<>();
    }

    public PQueue(ArrayList<Integer> heap) {
        this.heap = heap;
        heapify(this.heap);
    }

    private void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private void heapify(ArrayList<Integer> heap){
        for(int i=heap.size()-2; i>=0; i++){
            shiftDown(heap, i);
        }
    }

    private void shiftDown(ArrayList<Integer> heap, int parent){
        int left = 2 * parent + 1;
        while(left < heap.size()){
            int right = 2 * parent + 2;
            if(right >= heap.size()){
                if(heap.get(left) < heap.get(parent)) swap(heap, parent, left);
                return;
            }

            if(heap.get(left) == Math.min(heap.get(left), heap.get(right))){
                if(heap.get(parent) <= heap.get(left)) return;
                swap(heap, parent, left);
                parent = left;
            }
            else{
                if(heap.get(parent) <= heap.get(right)) return;
                swap(heap, parent, right);
                parent = right;
            }
            left = 2 * parent + 1;

        }
    }

    private void shiftUp(ArrayList<Integer> heap, int child){
        int parent = (child-1)/2;
        System.out.println(parent);
        while(parent >= 0){
            if(heap.get(parent) <= heap.get(child)) return;
            swap(heap, parent, child);
            child = parent;
            parent = (child-1)/2;
        }
    }

    public void insert(int node){
        this.heap.add(node);
        System.out.println(this.heap + " "+ (this.heap.size()-1));
        shiftUp(this.heap, this.heap.size()-1);
    }

    public Integer poll(){
        int node = this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.size()-1));
        this.heap.remove(this.heap.size()-1);
        shiftDown(heap, 0);
        return node;
    }

}


