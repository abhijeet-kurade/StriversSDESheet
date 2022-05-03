package DisjointSet;

public class UnionFindArray {
    int[] parent;
    int[] rank;

    public static void main(String[] args) {

    }

    public UnionFindArray(){
        this.parent = new int[100];
        this.rank = new int[100];
        for(int i=0; i<100; i++){
            this.parent[i] = i;
            this.rank[i] = i;
        }
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return;

        if(this.rank[px] == this.rank[py]){
            this.parent[py] = px;
            this.rank[px] += 1;
        }
        else if(this.rank[px] > this.rank[py]){
            this.parent[py] = px;
        }
        else{
            this.parent[px] = py;
        }
    }

    public int find(int x){
        if(this.parent[x] != x) this.parent[x] = find(this.parent[x]);
        return this.parent[x];
    }

}
