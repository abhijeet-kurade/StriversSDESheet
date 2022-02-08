package DisjointSet;

import java.util.HashMap;
import java.util.HashSet;

public class DisjointSetClass {
    public static void main(String[] args) {
        System.out.println("Disjoint Set.");
        DisjointSet ds = new DisjointSet();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);
        ds.makeSet(8);
        ds.makeSet(9);
        ds.makeSet(10);
        ds.makeSet(11);
        ds.makeSet(12);
        ds.makeSet(13);
        ds.makeSet(14);
        ds.makeSet(15);

        ds.union(1,2);
        ds.union(3,5);
        ds.union(15,3);
        ds.union(6,7);
        ds.union(8,12);
        ds.union(13,14);
        ds.union(11,10);
        ds.union(3,11);
        ds.union(4,10);
        ds.union(8,6);

        //System.out.println(ds.getAllLeaders());

        System.out.println(ds);
    }
}

class DisjointSet{
    HashMap<Integer, Node> map;
    private class Node{
        int data;
        int rank;
        Node parent;

        public Node(int data) {
            this.data = data;
            this.rank = 0;
            this.parent = this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", rank=" + rank +
                    ", parent=" + parent.data +
                    '}';
        }
    }
    public HashSet<Integer> getAllLeaders(){
        HashSet<Integer> leaders = new HashSet<>();
        for(Integer node : map.keySet()){
            leaders.add(findSet(node));
        }
        return leaders;
    }

    @Override
    public String toString() {
        for(Integer node : map.keySet()){
            System.out.println(node +" : "+map.get(node));
        }
        return "";
    }

    public DisjointSet() {
        this.map = new HashMap<>();
    }

    /*
    *  @function makeSet is used to create a set of only one element
    * */
    public void makeSet(int data){
        Node node = new Node(data);
        this.map.put(data, node);
    }


    /*
    *
    * */
    public boolean union(int data1, int data2){
        Node node1 = this.map.get(data1);
        Node node2 = this.map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if(parent1 == parent2) return false;

        if(parent1.rank == parent2.rank) {
            parent1.rank += 1;
            parent2.parent = parent1;
        }
        else{
            if(parent1.rank > parent2.rank) parent2.parent = parent1;
            else parent1.parent = parent2;
        }
        return true;
    }

    public int findSet(int data){
        return findSet(this.map.get(data)).data;
    }

    public Node findSet(Node node){
        Node parent = node.parent;
        if(parent != node) node.parent = findSet(parent);
        return node.parent;
    }
}
