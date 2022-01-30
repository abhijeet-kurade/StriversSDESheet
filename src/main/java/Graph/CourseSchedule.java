package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int node=0; node<numCourses; node++) graph.put(node, new ArrayList<>());
        for(int[] edge : prerequisites) graph.get(edge[1]).add(edge[0]);
        HashSet<Integer> visited = new HashSet<>();
        for(Integer node : graph.keySet()){
            if(visited.contains(node)) continue;
            boolean result = validateDFS(node, -1, graph, visited);
            if(!result) return false;
        }
        return true;
    }

    public boolean validateDFS(int current, int parent, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited){
        if(visited.contains(current)) return false;
        visited.add(current);
        for(Integer child : graph.get(current)){
            if(!validateDFS(child, current, graph, visited)) return false;
        }
        return true;
    }
}
