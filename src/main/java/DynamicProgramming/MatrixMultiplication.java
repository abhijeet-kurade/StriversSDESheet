package DynamicProgramming;

public class MatrixMultiplication {
    public static void main(String[] args) {

        int[][] arr = {{3,2},{2,4},{4,2},{2,5}};

        int[][] arr1 = {{30,15},{35,15},{15,5},{5,10},{10,20},{20,25}};
        System.out.println(matrixMultiplication(arr1));

    }

    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }

    public static int matrixMultiplication(int[][] matrix){
        int n = matrix.length;
        int[] indices = new int[n+1];
        indices[0] = matrix[0][0];
        for(int i=0; i<n; i++) indices[i+1] = matrix[i][1];

        int[][] cost = new int[n][n];
        int[][] para = new int[n][n];
        /*
        *
        * c[i, j] = Min (i<=k<j) {c[i, k] + c[k+1, j] + di * dk+1 * dj+1}
        *
        */

        for(int len=1; len<n; len++){
            for(int i=0; i<n; i++){
                int j=i+len;
                if(j>=n) break;
                int multiplications = Integer.MAX_VALUE;
                int idx = -1;
                for(int k=i; k<j; k++){
                    int count = cost[i][k] + cost[k+1][j] + indices[i]*indices[k+1]*indices[j+1];
                    if(multiplications > count){
                        multiplications = count;
                        idx = k;
                    }
                }
                cost[i][j] = multiplications;
                para[i][j] = idx;
            }
        }
        for(int[] arr : cost) printArr(arr);
        System.out.println();
        for(int[] arr : para) printArr(arr);
        return cost[0][n-1];
    }
}
