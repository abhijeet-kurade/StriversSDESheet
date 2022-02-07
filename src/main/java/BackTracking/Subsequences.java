package BackTracking;

import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
        int[] arr = {2,5,3,7};
        ArrayList<ArrayList<Integer>> subsequences = new ArrayList<>();

        allSubsequences1(0, arr, new ArrayList<>(), subsequences);
        System.out.println(subsequences);

    }

    public static void allSubsequences1(int idx, int[] arr, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> subsequences){
        if(idx >= arr.length){
            subsequences.add(new ArrayList<>(curr));
            return ;
        }
        allSubsequences1(idx+1, arr, curr, subsequences);
        curr.add(arr[idx]);
        allSubsequences1(idx+1, arr, curr, subsequences);
        curr.remove(curr.size()-1);
    }

    public static void allSubsequences(int idx, int[] arr, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> subsequences){
        if(idx >= arr.length){
            subsequences.add(new ArrayList<>(curr));
            return ;
        }

        curr.add(arr[idx]);
        allSubsequences(idx+1, arr, curr, subsequences);

        curr.remove(curr.size()-1);
        allSubsequences(idx+1, arr, curr, subsequences);
    }


}
