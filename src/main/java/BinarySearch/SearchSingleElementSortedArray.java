package BinarySearch;

public class SearchSingleElementSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
        System.out.println(singleElement(arr));

    }
    public static int singleElement(int[] arr){
        int left=0, right=arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(mid != 0 && mid != arr.length-1 && (arr[mid-1] != arr[mid] && arr[mid] != arr[mid+1])) return arr[mid];
            if(mid == 0 && arr[mid] != arr[mid+1]) return arr[mid];
            if(mid == arr.length-1 && arr[mid-1] != arr[mid]) return arr[mid];
            if(mid%2 == 0){
                if(arr[mid] == arr[mid+1]) left = mid+1;
                else right = mid-1;
            }
            else {
                if(arr[mid-1] == arr[mid]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }
}
