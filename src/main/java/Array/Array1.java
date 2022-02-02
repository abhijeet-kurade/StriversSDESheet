package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array1 {
    public static void main(String[] args){
        int[][] nums = {{1,1,1,1},
                        {1,1,1,1},
                        {1,1,1,0 },
                        {1,1,1,1},
                        {1,0,1,0}};
        //for(int[] row : setMatrixZero(nums)) printArr(row);
        //pascalTriangle(7);

        printArr(sortColors(new int[]{}));
    }
    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }

    public static int[][] setMatrixZero(int[][] matrix){

        int height = matrix.length;
        int width = matrix[0].length;

        int[] rows = new int[height];
        int[] cols = new int[width];
        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);
        /* [1 0 1]
        *
        *
        *  1 1 1 1    1 0 1
        *  0 1 0 1 => 0 0 0
        *  1 1 1 1    1 0 1
        *
        * */
        // printArr(cols);
        // printArr(rows);
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                cols[i] = Math.min(cols[i], matrix[j][i]);
            }
        }
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                rows[i] = Math.min(rows[i], matrix[i][j]);
            }
        }
        // printArr(cols);
        // printArr(rows);
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                matrix[i][j] = Math.min(rows[i], cols[j]);
            }
        }
        return matrix;
    }

    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int i=1; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i) row.add(1);
                else row.add(triangle.get(i-1).get(j) + triangle.get(i-1).get(j-1));
            }
            triangle.add(row);
        }
        System.out.println(triangle);
        return null;
    }

    public static int[] nextPermutation(int[] arr){
        /*
        *
        * step 1 : the number from end that breaks ascending ordering. Let's say it's at index i.
        * step 2 : find the next max number after it. Index j.
        * step 3 : swap them index i & j
        * step 4 : reverse the array from i to end.
        *
        * */

        int n = arr.length;
        int index = -1;
        int idx = n-1;

        while(idx > 0){
            if(arr[idx-1] < arr[idx]){
                index = idx-1;
                break;
            }
            idx -= 1;
        }
        if(index == -1){
            reverseArray(arr, 0, n-1);
            return arr;
        }
        int nextGreater = index+1;
        for(int i=index+1; i<n;i++){
            if( arr[index] < arr[i] && arr[i] < arr [nextGreater]){
                nextGreater = i;
            }
        }
        swap(arr, index, nextGreater);
        reverseArray(arr, index+1, n-1);
        return arr;
    }
    public static void reverseArray(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 1;
            right += -1;
        }
    }
    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static int[] sortColors(int[] arr){
        int left = 0, mid = 0, right = arr.length - 1;
        while(mid <= right){
            if(arr[mid]==0) swap(arr, left++, mid);
            else if(arr[mid] == 2) swap(arr, right--, mid--);
            mid += 1;
        }
        return arr;
    }

}
