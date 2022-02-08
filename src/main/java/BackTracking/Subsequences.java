package BackTracking;

import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        ArrayList<ArrayList<Integer>> subsequences = new ArrayList<>();
        allSubsequences1(0, arr, new ArrayList<>(), subsequences);
        System.out.println(subsequences);


    }

    public static void allSubsequences1(int idx, int[] arr, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> subsequences){
        /*
        * not considering number first and then considering it.
        * */
        if(idx >= arr.length){
            subsequences.add(new ArrayList<>(curr));
            return ;
        }
        //curr.add(0);
        allSubsequences1(idx+1, arr, curr, subsequences);
        //curr.remove(curr.size()-1);
        curr.add(arr[idx]);
        allSubsequences1(idx+1, arr, curr, subsequences);
        curr.remove(curr.size()-1);
    }

    public static void allSubsequences(int idx, int[] arr, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> subsequences){
        /*
        * Considering the number first and then removing it.
        * */
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
