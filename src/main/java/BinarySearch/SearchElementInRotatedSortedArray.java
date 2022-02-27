package BinarySearch;

public class SearchElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr= {4,5,6,7,1,2,3};
        System.out.println(searchInRotatedSorted(arr, 0));
    }
    public static boolean searchInRotatedSorted(int[] arr, int num){
        int left=0, right=arr.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==num) return true;
            if(arr[mid]<=arr[right]){
                if(arr[mid]<num && num<=arr[right]) left = mid+1;
                else right = mid-1;
            }
            else{
                if(arr[left]<=num && num<arr[mid]) right = mid-1;
                else left= mid+1;
            }
        }
        return false;
    }
}
