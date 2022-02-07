package BackTracking;

import java.util.ArrayList;

public class UniquePathsIII {
    public static void main(String[] args) {
        System.out.println("Hello");
        int[][] arr = { {1,0,0,0},
                        {0,0,0,0},
                        {0,0,2,-1}};
        int[][] arr1 = { {1,0},{0,2}};
        int[][] arr3 = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,2}
        };
        System.out.println(uniquePathsIII(arr));
    }

    public static int uniquePathsIII(int[][] arr){

        int[] res = countZeros(arr);
        int zeros = res[0];
        int startI = res[1];
        int startJ = res[2];


        /*
        * 0 = valid walk
        * -1 = blocked
        * 1 = start
        * 2 = end
        * -2 = visited
        * */

        int[] paths = {0};
        //System.out.println(zeros+" "+startI+" "+startJ);



        ArrayList<String> curr = new ArrayList<>();
        ArrayList<ArrayList<String>> allPaths = new ArrayList<>();
        dfs(arr, startI, startJ, paths, zeros, curr, allPaths);

        System.out.println(allPaths);

        return paths[0];
    }

    public static boolean isValidJump(int[][] arr, int row, int col){
        int height = arr.length;
        int width = arr[0].length;
        return (0<=row && row<height && 0<=col && col <width) && (arr[row][col] != -2 && arr[row][col] != -1);
    }

    public static void dfs(int[][] arr, int row, int col, int[] paths, int zeros, ArrayList<String> curr, ArrayList<ArrayList<String>> allPaths){
        if(!isValidJump(arr, row, col)) return;

        //System.out.println(row +" "+col +" "+arr[row][col]);
        if(arr[row][col] == 1) arr[row][col] = -1;
        if(arr[row][col] == 2 ){
            if(zeros == 0){
                paths[0] += 1;
                allPaths.add(new ArrayList<>(curr));
            }
            return;
        }
        if(arr[row][col] == 0){
            arr[row][col] = -2;
            zeros -= 1;
        }
        curr.add("|"+row +" "+ col+"| ");
        // top row-1 col
        dfs(arr, row-1, col, paths, zeros, curr, allPaths);
        // bottom row+1 col
        dfs(arr, row+1, col, paths, zeros, curr, allPaths);
        // left row col-1
        dfs(arr, row, col-1, paths, zeros, curr, allPaths);
        // right row col+1
        dfs(arr, row, col+1, paths, zeros, curr, allPaths);

        if(arr[row][col] == -2){
            arr[row][col] = 0;
            zeros += 1;
        }
        curr.remove(curr.size()-1);
    }

    public static int[] countZeros(int[][] arr){
        int count = 0;
        int idx=-1, jdx=-1;
        int height = arr.length;
        int width = arr[0].length;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(arr[i][j] == 0) count += 1;
                if(arr[i][j] == 1){
                    idx = i;
                    jdx = j;
                }
            }
        }
        return new int[]{count, idx, jdx};
    }
}
