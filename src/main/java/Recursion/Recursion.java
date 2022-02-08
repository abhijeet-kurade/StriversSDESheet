package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Recursion {
    public static void main(String[] args) {
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
