package Array;

import java.util.Arrays;

public class Array3 {
    public static void main(String[] args) {
        System.out.println(countPathsRecursive(8,5));
        System.out.println(countPathsDP(8,5));
        System.out.println(countPathsMath(8,5));
    }
    public static boolean searchInMatrix(int[][] matrix, int num){
        int height = matrix.length;
        int width = matrix[0].length;

        int row=0, col=width-1;
        while(row<height && col>=0){
            if(matrix[row][col] == num) return true;

            if(num < matrix[row][col]) col += -1;
            else row += 1;
        }
        return false;
    }
    public static boolean searchInMatrixLeetcode(int[][] matrix, int num){
        int height = matrix.length;
        int width = matrix[0].length;
        int left = 0;
        int right = (height*width)-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int current = matrix[mid/width][mid%width];
            if(current == num) return true;
            else if(current > num) right = mid-1;
            else left = mid+1;
        }
        return false;
    }

    public static double pow(double number, int power){
        if(power == 0) return 1.0;
        if(power == 1) return number;
        double val = pow(number, power/2);
        if(power%2==1) return val * val * number;
        else return val * val;
    }

    public static int countPathsRecursive(int row, int col){
        if(row == 1 && col == 1) return 1;
        if(row < 1 || col < 1) return 0;
        return countPathsRecursive(row-1, col) + countPathsRecursive(row, col-1);
    }

    public static int countPathsDP(int row, int col){
        int[] previous = new int[col+1];
        int[] current = new int[col+1];

        Arrays.fill(previous, 0);
        previous[1] = 1;
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                current[j] = previous[j] + current[j-1];
                previous[j] = current[j];
            }
        }
        return current[col];
    }

    public static int countPathsMath(int row, int col){
        int numerator = factorial(row + col -2);
        int denominator =  factorial(row-1) *  factorial(col-1);
        return numerator/denominator;
    }

    public static int factorial(int num){
        int val = 1;
        while(num > 0) val *= num--;
        return val;
    }


}
