package BackTracking;

import java.util.ArrayList;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        combinationSum(arr, 7);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target){

        ArrayList<ArrayList<Integer>> sums = new ArrayList<>();
        combinationSum(0, arr, target,  new ArrayList<>(), sums);
        System.out.println(sums);
        return sums;
    }

    public static void combinationSum(int idx, int[] arr, int target,  ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> sums){

        System.out.println(curr);
        if(idx >= arr.length){
            if(target == 0) sums.add(new ArrayList<>(curr));
            return;
        }

        if(arr[idx] <= target){
            curr.add(arr[idx]);
            combinationSum(idx, arr, target-arr[idx], curr, sums);
            curr.remove(curr.size()-1);
        }
        combinationSum(idx+1, arr, target,  curr, sums);
    }
}
