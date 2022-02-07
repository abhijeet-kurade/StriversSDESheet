package DisjointSet;

import java.util.HashMap;

public class DisjointSetClass {
    public static void main(String[] args) {
        System.out.println("Checking commit from another computer.");
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
    }

    public DisjointSet() {
        this.map = new HashMap<>();
    }

    /*
    *  function makeset is used to create a set of only one element
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
        return findSet(this.map.get(data).data);
    }

    public Node findSet(Node node){
        Node parent = node.parent;
        if(parent != node) node.parent = findSet(parent);
        return node.parent;
    }
}
