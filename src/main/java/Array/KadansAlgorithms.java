package Array;

public class KadansAlgorithms {
    public static void main(String[] args) {

    }

    public static int maxSumSubArray(int[] arr){
        int n = arr.length;
        if(n==0) return 0;
        int max_sum = arr[0];
        int curr_sum = arr[0];
        for(int i=1; i<n; i++){
            curr_sum = Math.max(curr_sum+arr[i], arr[i]);
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }

    public static int maxProductSubArray(int[] arr){
        int maxProduct = arr[0];  //Stores the maximum product soo far
        int minProduct = arr[0];  //Stores the minimum product soo far basically the -ve product
        int ans = arr[0];   //Stores the answer to be returned
        for(int i=1;i<arr.length;i++){
            int first = arr[i];         //First Possibility
            int second = maxProduct * arr[i];   //Second Possibility
            int third = minProduct * arr[i];    //Third Possibility
            minProduct = Math.min(Math.min(first,second), third);
            maxProduct = Math.max(Math.max(first,second), third);
            ans = Math.max(ans, maxProduct);
        }
        return ans;
    }



}
