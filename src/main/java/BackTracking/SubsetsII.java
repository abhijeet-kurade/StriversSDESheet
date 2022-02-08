package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
    /*
    *
    Problem Statement: Given an array of integers that may contain duplicates the task is to return all possible subsets. Return only unique subsets and they can be in any order.

    Examples:

    Example 1:

    Input: array[] = [1,2,2]

    Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]

    Explanation: We can have subsets ranging from  length 0 to 3. which are listed above. Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.

    Input: array[] = [1]

    Output: [ [ ], [1] ]

    Explanation: Only two unique subsets are available

    *
    * */
public class SubsetsII {
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> subsetsIIHashSet(int[] arr){
        HashSet<ArrayList<Integer>> sums = new HashSet<>();
        subSetIIHashSet(0, new ArrayList<>(), arr, sums);
        return new ArrayList<>(sums);
    }

    public static void subSetIIHashSet(int idx, ArrayList<Integer> currSum, int[] arr, HashSet<ArrayList<Integer>> sums){
        if(idx == arr.length) {
            sums.add(new ArrayList<>(currSum));
            return;
        }

        currSum.add(arr[idx]);
        subSetIIHashSet(idx+1, currSum, arr, sums);

        currSum.remove(currSum.size()-1);
        subSetIIHashSet(idx+1, currSum, arr, sums);

    }

    public static ArrayList<ArrayList<Integer>> subsetIISort(int[] arr){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsetIISort(0,arr, new ArrayList(), subsets);
        return subsets;
    }
    public static void subsetIISort(int idx, int[] arr, ArrayList<Integer> currSubset, ArrayList<ArrayList<Integer>> subsets){
        subsets.add(new ArrayList<>(currSubset));
        for(int i=idx; i<arr.length; i++){
            if(i != idx && arr[i] == arr[i-1]) continue;
            currSubset.add(arr[i]);
            subsetIISort(i+1, arr, currSubset, subsets);
            currSubset.remove(currSubset.size()-1);
        }
    }
}
