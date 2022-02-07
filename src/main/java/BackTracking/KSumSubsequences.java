package BackTracking;

import java.util.ArrayList;

public class KSumSubsequences {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayList<ArrayList<Integer>> subs = new ArrayList<>();
        subsequencesWithKSum(0, arr, 10, 0, new ArrayList<>(), subs);
        System.out.println(subs);
    }

    public  static void subsequencesWithKSum(int idx, int[] arr, int K, int currSum,  ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> subs){
        if(currSum == K){
            subs.add(new ArrayList<>(curr));
            return;
        }
        if(currSum > K || idx == arr.length) return;
        for(int i=idx; i<arr.length; i++){
            currSum += arr[i];
            curr.add(arr[i]);
            subsequencesWithKSum(i+1, arr, K, currSum, curr, subs);

            currSum -= arr[i];
            curr.remove(curr.size()-1);
        }
    }

    public  static void subsequencesWithKSum1(int idx, int[] arr, int K, int currSum,  ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> subs){
        if(currSum == K){
            subs.add(new ArrayList<>(curr));
            return;
        }
        if(currSum > K || idx == arr.length) return;
        currSum += arr[idx];
        curr.add(arr[idx]);
        subsequencesWithKSum1(idx+1, arr, K, currSum, curr, subs);

        currSum -= arr[idx];
        curr.remove(curr.size()-1);
        subsequencesWithKSum1(idx+1, arr, K, currSum, curr, subs);
    }

}
