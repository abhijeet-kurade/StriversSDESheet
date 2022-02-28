package BinarySearch;

import javax.swing.plaf.IconUIResource;
import java.nio.charset.MalformedInputException;
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {1,13,10,28,21,45};
        System.out.println(aggressiveCows(arr, 3));
    }

    public static boolean isPossible(int[] arr, int n, int k){
        int count = 1;
        int last = arr[0];
        for (int i=1; i<arr.length; i++){
            if( (arr[i] - last) >= n ){
                count += 1;
                last = arr[i];
            }
        }
        return count>=k;
    }
    public static void printArr(int[] arr){
        for (int num : arr) System.out.print(num +" ");
        System.out.println();
    }

    public static int aggressiveCows(int[] arr, int k){
        Arrays.sort(arr);
        int n = arr.length;
        int left = Integer.MAX_VALUE, right = arr[n-1]-arr[0];

        for(int i=1; i<n; i++){
            int diff = arr[i] - arr[i-1];
            left = Math.min(left, diff);
        }
        int ans = left;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(arr, mid, k)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return ans;
    }
}
