package SlidingWindow;

import Array.Array2;

import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxWindow {
    public static void main(String[] args) {
        int[] arr = {5, -1, 3, 3, 6, 5, 8, 7, 9};
        System.out.println(minMaxSumInWindow(arr, 3));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        System.out.println(list);
        list.remove(0);
        list.add(10);
        System.out.println(list);
    }

    public static List<Integer> minMaxSumInWindow(int[] arr, int w){
        List<Integer> min = minWindow(arr, w);
        List<Integer> max = maxWindow(arr, w);
        int n = min.size();
        List<Integer> sum = new ArrayList<>();
        for(int i=0; i<n; i++){
            sum.add(min.get(i) + max.get(i));
        }
        return sum;
    }

    public static List<Integer> maxWindow(int[] arr, int w){
        int n = arr.length;
        int[] nextMax = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) stack.pop();
            if(stack.isEmpty()) nextMax[i] = n;
            else nextMax[i] = stack.peek();
            stack.push(i);
        }
        int i=0, k=0;
        List<Integer> maxWindow = new ArrayList<>();
        while (i+w < n+1){
            if(k < i) k = i;
            while(nextMax[k] < i+w){
                k = nextMax[k];
            }
            maxWindow.add(arr[k]);
            i += 1;
        }
        System.out.println(maxWindow);
        return maxWindow;
    }
    
    public static List<Integer> minWindow(int[] arr, int w){
        int n = arr.length;
        int[] nextMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty()  && arr[i] <= arr[stack.peek()]) stack.pop();
            if(stack.isEmpty()) nextMin[i] = n;
            else nextMin[i] = stack.peek();
            stack.push(i);
        }
        List<Integer> minWindow = new ArrayList<>();
        int i=0, k=0;
        while (i+w <= n){
            if(k<i) k=i;
            while(nextMin[k] < i+w) k = nextMin[k];
            minWindow.add(arr[k]);
            i += 1;
        }
        System.out.println(minWindow);
        return minWindow;
    }
}
