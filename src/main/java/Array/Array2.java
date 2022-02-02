package Array;

public class Array2 {
    public static void main(String[] args) {

        int[][] matrix = {   {1,2,3,4}
                            ,{5,6,7,8}
                            ,{9,10,11,12}
                            ,{13,14,15,16}};
        //rotateSqrMatrix(matrix);
        //for(int[] row : matrix) printArr(row);
        mergeSortedArray(new int[]{13,16,18,20,28}, new int[]{1,2,4,5,8,9,10,11,35});
    }
    public static void rotateSqrMatrix(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            int left=0, right=n-1;
            while(left<right) swap(matrix[i], left++, right--);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1-i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;
            }
        }
    }

    public static void mergeSortedArray(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int window = (int) Math.ceil((n+m)/2);
        while(window>0){
            int left = 0;
            int right = window;
            while (right < (m+n)){
                int num1 = left < n ? arr1[left] : arr2[left-n];
                int num2 = right < n ? arr1[right] : arr2[right-n];
                if(left < n ) arr1[left] = Math.min(num1, num2);
                else arr2[left-n] = Math.min(num1, num2);
                if(right < n) arr1[right] = Math.max(num1, num2);
                else arr2[right-n] = Math.max(num1, num2);
                left += 1;
                right += 1;
            }
            window += -1;
        }
        printArr(arr1);
        printArr(arr2);
    }
    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }
}
