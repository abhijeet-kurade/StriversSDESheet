package Array;

public class Array2 {
    public static void main(String[] args) {

        int[][] matrix = {   {1,2,3,4}
                            ,{5,6,7,8}
                            ,{9,10,11,12}
                            ,{13,14,15,16}};
        rotateSqrMatrix(matrix);
        for(int[] row : matrix) printArr(row);
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
