package BackTracking;

import java.util.ArrayList;

public class SubsetsSum {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> subsetSum(int[] arr){
        ArrayList<Integer> sums = new ArrayList<>();
        subSetSum(0, 0, arr, sums);
        return sums;
    }
    public static void subSetSum(int idx, int currSum, int[] arr, ArrayList<Integer> sums){
        if(idx == arr.length) {
            sums.add(currSum);
            return;
        };

        /* adding current number in the sum
         * */
        currSum += arr[idx];
        sums.add(currSum);
        subSetSum(idx+1, currSum, arr, sums);

        /*removing current number from the sum
         * */
        currSum -= arr[idx];
        subSetSum(idx+1, currSum, arr, sums);

    }
    public static void subSetSum1(int idx, int currSum, int[] arr, ArrayList<Integer> sums){

        if(idx == arr.length) {
            sums.add(currSum);
            return;
        };

        /*removing current number from the sum
         * */
        subSetSum1(idx+1, currSum, arr, sums);

        /* adding current number in the sum
         * */
        currSum += arr[idx];
        subSetSum1(idx+1, currSum, arr, sums);

    }
}
