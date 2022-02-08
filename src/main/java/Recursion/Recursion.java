package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Recursion {
    public static void main(String[] args) {
        int arr[] = {2,2,2,2};
        System.out.println(subsetIISort(arr));
    }



    public static ArrayList<ArrayList<Integer>> subsetsIIHashSet(int[] arr){
        HashSet<ArrayList<Integer>> sums = new HashSet<>();
        subSetIIHashSet(0, new ArrayList<>(), arr, sums);
        return new ArrayList<>(sums);
    }
    
    public static void subSetIIHashSet(int idx, ArrayList<Integer> currSum, int[] arr, HashSet<ArrayList<Integer>> sums){
        if(idx == arr.length) {
            sums.add(new ArrayList<>(currSum));
            return;
        }
        
        currSum.add(arr[idx]);
        subSetIIHashSet(idx+1, currSum, arr, sums);

        currSum.remove(currSum.size()-1);
        subSetIIHashSet(idx+1, currSum, arr, sums);

    }

    public static ArrayList<ArrayList<Integer>> subsetIISort(int[] arr){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsetIISort(0,arr, new ArrayList(), subsets);
        return subsets;
    }
    public static void subsetIISort(int idx, int[] arr, ArrayList<Integer> currSubset, ArrayList<ArrayList<Integer>> subsets){        
        subsets.add(new ArrayList<>(currSubset));
        for(int i=idx; i<arr.length; i++){
            if(i != idx && arr[i] == arr[i-1]) continue;
            currSubset.add(arr[i]);
            subsetIISort(i+1, arr, currSubset, subsets);
            currSubset.remove(currSubset.size()-1);
        }
    }

}

class StackSorting{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(8);stack.add(-8);stack.add(7);stack.add(9);stack.add(0);
        stack.add(8);stack.add(2);stack.add(3);
        System.out.println(stack);
        stackPop(stack);
        System.out.println(stack);

    }
    public static void stackPop(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int num = stack.pop();
        stackPop(stack);
        stackPush(stack, num);
    }

    public static void stackPush(Stack<Integer> stack, int num){
        if(!stack.isEmpty() && stack.peek() > num) {
            int curr = stack.pop();
            stackPush(stack, num);
            stack.add(curr);
        }
        else stack.add(num);

    }
}
