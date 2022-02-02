package Array;


import java.util.Arrays;
import java.util.HashSet;

public class Array4 {
    public static void main(String[] args) {

    }

    public static boolean twoSumBruteForce(int[] arr, int target){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]+arr[j]==target) return true;
            }
        }
        return false;
    }
    public static boolean twoSum(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            if(set.contains(target-num)) return true;
            set.add(num);
        }
        return false;
    }
    public static boolean threeSum(int[] arr, int target){
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            int left = i+1, right = arr.length-1;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == target) return true;
                else if(sum < target) left += 1;
                else right += -1;
            }
        }
        return false;
    }
    public static boolean fourSum(int[] arr, int target){

        return false;
    }

}
