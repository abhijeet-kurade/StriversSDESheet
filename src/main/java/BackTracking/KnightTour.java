package BackTracking;

public class KnightTour {
    public static void main(String[] args) {

    }
    public static void printBoard(int[][] arr){
        for (int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafeJump(int[][] board, int row, int col){
        int height = board.length;
        int width = board[0].length;
        return 0<=row && row<height && 0<=col && col<width && board[row][col]==0;
    }
    public static int[][] knightTour(int N, int[] start){
        int[][] board = new int[N][N];
        board[start[0]][start[1]] = 1;
        System.out.println(knightTour(board, start[0],start[1]));
        printBoard(board);
        return board;
    }

    public static boolean knightTour(int[][] board, int row, int col){
        //if(!isSafeJump(board, row, col)) return false;
        if(board[row][col] == (board.length * board.length - 3)) return true;

        int[] dx = {2,2,-2,-2,1,1,-1,-1};
        int[] dy = {1,-1,1,-1,2,-2,2,-2};

        for(int i=0; i<8; i++){
            int x = row + dx[i];
            int y = col + dy[i];
            if(!isSafeJump(board, x, y)) continue;
            board[x][y] = board[row][col] + 1;
            if(knightTour(board, x, y)) return true;
            board[x][y] = 0;
        }
        printBoard(board);
        System.out.println();
        return false;
    }

}
