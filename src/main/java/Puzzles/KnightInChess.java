package Puzzles;

import java.util.LinkedList;
import java.util.Queue;

public class KnightInChess {
    public static void main(String[] args) {

    }

    public static int knightStepsToReachTarget(int N, int[] start, int[] end){
        return -1;
    }

    public static boolean isValidJump(int[][] board, int row, int col){
        int height = board.length;
        int width = board[0].length;
        return 0<=row && row<height && 0<=col && col<width && board[row][col]==0;
    }
    public static int knightJumpsBFS(int N, int[] start, int[] end){
        int[][] visited = new int[N][N];
        end[0] -= 1; end[1] -=1; start[0] -= 1; start[1] -= 1;

        int[] dx = {1,1,-1,-1,2,2,-2,-2};
        int[] dy = {2,-1,2,-2,1,-1,1,-1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0],start[1]});
        visited[start[0]][start[1]] = 1;

        while (!queue.isEmpty()){
            int[] cell = queue.poll();

            for(int i=0; i<8; i++){
                int x = cell[0] + dx[i];
                int y = cell[1] + dy[i];
                if(!isValidJump(visited, x, y)) continue;
                if(x==end[0] && y==end[1]) {
                    printBoard(visited);
                    return visited[cell[0]][cell[1]];
                }
                visited[x][y] = visited[cell[0]][cell[1]] + 1;
                queue.add(new int[]{x,y});
            }
        }
        return -1;
    }
    public static void printBoard(int[][] arr){
        for (int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


}
