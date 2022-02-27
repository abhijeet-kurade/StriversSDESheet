package BinarySearch;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] arr = { {1,3,5}, {2,6,9}, {3,6,9} };
        int[][] arr2 = { {5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5} };
        int[][] arr1 = { {-16,3,7,8}, {0,1,3,4},
                {9,15,17,19}, {1,8,9,12} };
        System.out.println(matrixMedian(arr2));

    }

    public static int matrixMedian(int[][] arr){
        int n = arr.length, m=arr[0].length;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            left = Math.min(left, arr[i][0]);
            right = Math.max(right, arr[i][m-1]);
        }
        int midIdx = (n*m + 1)/2;
        while(left <= right){
            int mid = left + (right-left)/2;
            int count = 0;
            for(int i=0; i<n; i++){
                int idx = binarySearchLessEqual(arr[i], mid);
                idx += 1;
                count += idx;
            }
            if(count < midIdx) left = mid + 1;
            else right = mid-1;
        }
        return left;
    }

    public static int binarySearch(int[] arr, int  num){
        int left = 0, right = arr.length-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if(arr[mid] == num) return mid;
            else if(arr[mid] > num) right = mid -1;
            else left = mid+1;
        }
        return -1;
    }
    public static int binarySearchLastIdx(int[] arr, int  num){
        int idx=-1, left = 0, right = arr.length-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if(arr[mid] == num) {
                idx = mid;
                left = mid + 1;
            }
            else if(arr[mid] > num) right = mid -1;
            else left = mid+1;
        }
        return idx;
    }

    public static int binarySearchLessEqual(int[] arr, double  num){
        int idx=-1, left = 0, right = arr.length-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if(arr[mid] <= num){
                idx = mid;
                left = mid +1;
            }
            else right = mid - 1;
        }
        return idx;
    }
}
