package BackTracking;

import java.util.ArrayList;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        combinationSum(arr, 7);
    }
    /*
    Problem Statement:

    Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

    Examples:

    Example 1:

    Input: array = [2,3,6,7], target = 7

    Output: [[2,2,3],[7]]

    Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
                 7 is a candidate, and 7 = 7.
                 These are the only two combinations.


    Example 2:

    Input: array = [2], target = 1

    Output: []

    Explaination: No combination is possible.

    * */

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
