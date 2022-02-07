package Recursion;

import java.util.ArrayList;

public class Recursion {
    public static void main(String[] args) {
        int arr[] = {1,5,9};
        System.out.println(subsetSum(arr));
    }

    public static ArrayList<Integer> subsetSum(int[] arr){
        ArrayList<Integer> sums = new ArrayList<>();
        subSetSum2(0, 0, arr, sums);
        return sums;
    }
    public static void subSetSum(int idx, int currSum, int[] arr, ArrayList<Integer> sums){
        if(idx == arr.length) return;

        currSum += arr[idx];
        sums.add(currSum);
        subSetSum(idx+1, currSum, arr, sums);

        currSum -= arr[idx];
        subSetSum(idx+1, currSum, arr, sums);

    }
    public static void subSetSum1(int idx, int currSum, int[] arr, ArrayList<Integer> sums){

        if(idx == arr.length) {
            sums.add(currSum);
            return;
        };

        subSetSum1(idx+1, currSum, arr, sums);
        currSum += arr[idx];
        subSetSum1(idx+1, currSum, arr, sums);

    }
    public static void subSetSum2(int idx, int currSum, int[] arr, ArrayList<Integer> sums){

        if(idx == arr.length) {
            sums.add(currSum);
            return;
        };

        currSum += arr[idx];
        subSetSum2(idx+1, currSum, arr, sums);

        currSum -= arr[idx];
        subSetSum2(idx+1, currSum, arr, sums);

    }






}

