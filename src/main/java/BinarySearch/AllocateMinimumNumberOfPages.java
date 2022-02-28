package BinarySearch;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        int[] arr = {7,3,2,4,7,2,6};
        System.out.println(minNumberOfBooks(arr, 3));
    }

    public static boolean isPossible(int[] arr, int n, int k){
        int count = 1;
        int curr = 0;
        for(int num : arr){
            if(curr+num <= n){
                curr += num;
                continue;
            }
            count += 1;
            curr = num;
        }
        return count<=k;
    }

    public static int minNumberOfBooks(int[] arr, int k){
        int left=0, right=0;
        for(int num : arr){
            left = Math.max(left, num);
            right += num;
        }
        int ans = right;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(arr, mid, k)){
                ans = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return ans;
    }
}
