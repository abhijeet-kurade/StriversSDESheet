package SegmentTree;

public class SegmentTreeClass {
    public static void main(String[] args) {
        int[] arr = {14,7,8,3,9,15};
        SegmentTree st = new SegmentTree(arr);
        st.printTree();
        st.set(5,10);
        st.printTree();
        System.out.println(st.getSum(1,3));
    }
}

class SegmentTree{
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        int nMax = n;
        if((nMax & (nMax-1)) != 0){
            while( (nMax & (nMax-1)) != 0){
                nMax = nMax & (nMax-1);
            }
            nMax <<= 1;
        }
        nMax = 2 * nMax - 1;
        tree = new int[nMax];
        constructSegmentTree(arr, 0, n-1, 0);
    }
    private int constructSegmentTree(int[] arr, int left, int right, int curr){
        if(left == right){
            tree[curr] = arr[left];
            return tree[curr];
        }
        int mid = left + (right - left)/2;
        tree[curr] = constructSegmentTree(arr, left, mid, 2*curr+1) + constructSegmentTree(arr, mid+1, right, 2*curr+2);
        return tree[curr];
    }

    public void set(int idx, int val){
        set(idx, val, 0, n-1, 0);
    }
    private int set(int idx, int val, int left, int right, int curr){
        if(idx < left || right < idx){
            if(idx < 0 || tree.length <= idx) return 0;
            return tree[curr];
        }
        if(left == right){
            tree[curr] = val;
            return tree[curr];
        }
        int mid = left + (right-left)/2;
        tree[curr] =  set(idx, val, left, mid, 2*curr+1) + set(idx, val, mid+1, right, 2*curr+2) ;
        return tree[curr];
    }

    public int getSum(int left, int right){
        return getSum(left, right, 0, n-1, 0);
    }
    private int getSum(int left, int right, int start, int end, int curr){
        if(left <= start && end <= right) return tree[curr];
        if(right < start || end < left) return 0;
        int mid = start + (end-start)/2;
        return getSum(left, right, start, mid, 2*curr+1) + getSum(left, right, mid+1, end, 2*curr+2);
    }

    public void printTree(){
        for(int num : tree) System.out.print(num +" ");
        System.out.println();
    }
}
