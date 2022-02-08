package BackTracking;

public class NQueens {
    public static void main(String[] args) {

        placeNQueens(5);
    }

    public static void placeNQueens(int n){
        int[][] board = new int[n][n];
        int[] forward_diagonals = new int[2*n-1];
        int[] backward_diagonals = new int[2*n-1];
        int[] cols = new int[n];

        boolean solved = placeQueenOnRow(0, board, cols, forward_diagonals, backward_diagonals);
        System.out.println(solved);
        printBoard(board);
    }

    public static void printBoard(int[][] arr){
        for (int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }



    public static boolean isSafeBox(int x, int y, int[] cols, int[] forward_diagonals, int[] backward_diagonals){
        return (cols[y] != 1) && (forward_diagonals[x+y] != 1) && (backward_diagonals[(cols.length-1) + y - x] != 1);
    }

    public static void placeQueen(int x, int y, int[][] board, int[] cols, int[] forward_diagonals, int[] backward_diagonals){
        cols[y] = 1; board[x][y] = 1;
        forward_diagonals[x+y] = 1;
        backward_diagonals[(cols.length-1) + y - x] = 1;
    }
    public static void removeQueen(int x, int y, int[][] board, int[] cols, int[] forward_diagonals, int[] backward_diagonals){
        cols[y] = 0; board[x][y] = 0;
        forward_diagonals[x+y] = 0;
        backward_diagonals[(cols.length-1) + y - x] = 0;
    }

    public static boolean placeQueenOnRow(int row, int[][] board, int[] cols, int[] forward_diagonals, int[] backward_diagonals){
        if(row == cols.length) return true;
        for(int i=0; i<cols.length; i++){
            if(!isSafeBox(row, i, cols, forward_diagonals, backward_diagonals)) continue;
            placeQueen(row, i, board, cols, forward_diagonals, backward_diagonals);
            if(placeQueenOnRow(row+1, board, cols, forward_diagonals, backward_diagonals)) return true;
            removeQueen(row, i, board, cols, forward_diagonals, backward_diagonals);
        }
        return false;
    }
}
