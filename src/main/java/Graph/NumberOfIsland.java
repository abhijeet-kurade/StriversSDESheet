package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,1,1,1,0},
                {1,1,1,0,1,1,1},
                {0,0,1,1,1,0,0},
                {0,1,1,1,1,0,0}
        };
        //System.out.println(numberOfIslandInGrid(grid));

        int nodes = 6;
        int[][] edges = {{1, 5},{2, 3},{3, 1}, {4,6}};
        System.out.println(numberOfIslandInGraph(nodes, edges));

    }

    public static int numberOfIslandInGrid(int[][] grid){
        int height = grid.length;
        int width = grid[0].length;
        int regions = 0;
        for(int row=0; row<height; row++){
            for(int col=0; col<width; col++){
                if(grid[row][col] == 1){
                    regions += 1;
                    markIslandDFS(row, col, grid);
                }
            }
        }
        return regions;
    }
    public static void markIslandDFS(int row, int col, int[][] grid){
        if(!isInside( row, col, grid) || grid[row][col] == -1 || grid[row][col] == 0) return;
        grid[row][col] = -1;
        markIslandDFS(row-1, col, grid);
        markIslandDFS(row+1, col, grid);
        markIslandDFS(row, col-1, grid);
        markIslandDFS(row, col+1, grid);
    }
    public static boolean isInside(int row, int col, int[][] grid){
        int height = grid.length;
        int width = grid[0].length;
        return 0<=row && row<height && 0<=col && col<width;
    }
    public static void markIslandBFS(int row, int col, int[][] grid){

    }


    public static int numberOfIslandInGraph(int nodes, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=1; node<=nodes; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        System.out.println(graph);
        HashSet<Integer> visited  = new HashSet<>();
        int component = 0;
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            component += 1;
            visitComponentDFSRecursive(node, graph, visited);
        }
        return component;
    }
    public static void visitComponentDFSRecursive(Integer node, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited){
        if(visited.contains(node)) return;
        visited.add(node);
        for(Integer neighbor : graph.get(node)) visitComponentDFSRecursive(neighbor, graph, visited);
    }

}
