package Array;

import java.util.LinkedList;
import java.util.Queue;

public class Inversions {
}

class MergeSort{
    public static void main(String[] args) {
        //int[] arr = {4,3,7,5,9,1,80,45,2,1,67};
        int[] arr = {4,9,12,17,19,5,8,9};
        int[] arr1 = {4,9,12,17,19};
        int[] arr2 = {5,8,9};

        //int[] arr = {4,3,2,1};
        int[] inversions = new int[]{0};
        //mergeSortedArraysForReversePair(arr1, arr2, inversions);
        printArr(reversePair(arr, 0, arr.length-1, inversions));
        //printArr(mergeSortedArraysForReversePair(arr1, arr2, inversions));
        System.out.println(inversions[0]);
        //System.out.println(countReversePairsBruteForce(arr1));

    }

    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }


    public static int[] mergeSortWithInversionCount(int[] arr, int start, int end, int[] inversions){
        //System.out.println(start +" "+end);
        if(start==end) return new int[]{arr[start]};
        //if(start>end) return new int[]{};
        int mid = start + (end - start)/2;
        int[] left = mergeSortWithInversionCount(arr, start, mid, inversions);
        int[] right = mergeSortWithInversionCount(arr, mid+1, end, inversions);
        return mergeSortedArraysWithInversionCount(left, right, inversions);
    }

    public static int[] mergeSortedArraysWithInversionCount(int[] arr1, int[] arr2, int[] inversions){
        int n = arr1.length;
        int m = arr2.length;
        int[] arr = new int[m+n];
        int idx = 0;
        int i=0, j=0;
        while(idx < m+n){
            int num;
            //System.out.println(i +" "+j+" "+n +" "+m);
            if(i==n){
                num = arr2[j];
                j += 1;
            }
            else if(j==m){
                num = arr1[i];
                i += 1;
            }
            else if(arr1[i] <= arr2[j]){
                num = arr1[i];
                i += 1;
            }
            else{
                num = arr2[j];
                j += 1;
                inversions[0] += n-i;
            }
            arr[idx] = num;
            idx+=1;
        }
        /*printArr(arr1);
        printArr(arr2);
        printArr(arr);
        System.out.println();*/
        return arr;
    }

    // 4,3,7,5,9,1,80,45,2,1,67
    public static int countInversionsBruteForce(int[] arr){
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]) count += 1;
            }
        }
        return count;
    }


    public static int[] reversePair(int[] arr, int start, int end, int[] reversePairs){
        //System.out.println(start +" "+end);
        if(start==end) return new int[]{arr[start]};
        //if(start>end) return new int[]{};
        int mid = start + (end - start)/2;
        int[] left = reversePair(arr, start, mid, reversePairs);
        int[] right = reversePair(arr, mid+1, end, reversePairs);
        return mergeSortedArraysForReversePair(left, right, reversePairs);
    }
    public static int[] mergeSortedArraysForReversePair(int[] arr1, int[] arr2, int[] reversePairs){
        int n = arr1.length;
        int m = arr2.length;
        int[] arr = new int[m+n];
        int idx = 0;
        int i=0, j=0;
        Queue<Integer> queue = new LinkedList<>();
        while(idx < m+n){
            int num;
            if(i==n){
                num = arr2[j];
                j += 1;
            }
            else if(j==m){
                num = arr1[i];
                while(!queue.isEmpty() && arr1[i] > (2*queue.peek())){
                    reversePairs[0] += n-i;
                    queue.poll();
                }
                i += 1;
            }
            else if(arr1[i] <= arr2[j]){
                while(!queue.isEmpty() && arr1[i] > (2*queue.peek())){
                    reversePairs[0] += n-i;
                    queue.poll();
                }
                num = arr1[i];
                i += 1;
            }
            else{
                num = arr2[j];
                while(!queue.isEmpty() && arr1[i] > (2*queue.peek())){
                    reversePairs[0] += n-i;
                    queue.poll();
                }
                if(arr1[i] > 2*arr2[j]){
                    reversePairs[0] += n-i;
                }
                else {
                    queue.add(arr2[j]);
                }
                j += 1;
            }
            arr[idx] = num;
            idx+=1;
        }
        return arr;
    }
    public static int countReversePairsBruteForce(int[] arr){
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>(2*arr[j])) count += 1;
            }
        }
        return count;
    }




}
