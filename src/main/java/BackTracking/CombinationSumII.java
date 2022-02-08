package BackTracking;

import java.util.ArrayList;

public class CombinationSumII {
    public static void main(String[] args) {

    }

    /*
    Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.

    Examples:

    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8

    Output:
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]]


    Explanation: These are the unique combinations whose sum is equal to target.

    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5

    Output: [[1,2,2],[5]]

    Explanation: These are the unique combinations whose sum is equal to target.
    * */

    public static ArrayList<ArrayList<Integer>> combinationSumII(int[] arr, int target){

        ArrayList<ArrayList<Integer>> sums = new ArrayList<>();
        combinationSumII(0, arr, target,  new ArrayList<>(), sums);
        System.out.println(sums);
        return sums;
    }
    public static void combinationSumII(int idx, int[] arr, int target,  ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> sums){

        if(idx >= arr.length){
            if(target == 0) sums.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx; i<arr.length; i++){
            if(i!=idx && arr[i-1] == arr[i]) continue;
            if(arr[i] > target) return;

            curr.add(arr[i]);
            combinationSumII(i+1, arr, target-arr[i], curr, sums);
            curr.remove(curr.size()-1);
        }


    }
}
