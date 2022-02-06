package Array;


import java.util.*;

public class Array4 {
    public static void main(String[] args) {

        int[] arr = {6,-2,2,-8,1,7,4};
        System.out.println(longestSubArrayWIthSumZero(arr));

    }

    public static boolean twoSumBruteForce(int[] arr, int target){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]+arr[j]==target) return true;
            }
        }
        return false;
    }
    public static boolean twoSum(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            if(set.contains(target-num)) return true;
            set.add(num);
        }
        return false;
    }
    public static boolean threeSum(int[] arr, int target){
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            int left = i+1, right = arr.length-1;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == target) return true;
                else if(sum < target) left += 1;
                else right += -1;
            }
        }
        return false;
    }
    public static int[][] fourSum(int[] arr, int sum){
        int n = arr.length;
        if(n<=4) return new int[][]{};
        Arrays.sort(arr);
        List<int[]> sums = new ArrayList<>();
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int sum1 = arr[i] + arr[j];
                if(map.get(sum1) == null) map.put(sum1, new ArrayList<>());
                map.get(sum1).add(new int[]{arr[i], arr[j]});
            }
        }
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int target = sum - (arr[i]+arr[j]);
                if(map.get(target) != null){
                    for(int[] pair : map.get(target)){
                        if(pair[0] > arr[j])
                            sums.add(new int[]{arr[i], arr[j], pair[0], pair[1]});
                    }
                }
            }
        }
        int[][] sumsInt = new int[sums.size()][4];
        int idx = 0;
        for(int[] sum1 : sums) sumsInt[idx++] = sum1;
        return sumsInt;
    }

    public static int longestConsecutiveSequence(int[] arr){
        int n = arr.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : arr) map.put(num, false);
        int maxSequence = 0;
        for(int num : arr){
            if(!map.get(num)){
                int count = 1;
                map.put(num, true);
                int previous = num-1;
                while(map.get(previous) != null && (!map.get(previous)) ){
                    count += 1;
                    map.put(previous, true);
                    previous -= 1;
                }
                int next = num+1;
                while(map.get(next) != null && (!map.get(next))){
                    count += 1;
                    map.put(next, true);
                    next += 1;
                }
                maxSequence = Math.max(maxSequence, count);
            }
        }
        return maxSequence;
    }

    public static int longestSubArrayWIthSumZero(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int currSum = 0;
        for(int  i=0; i<n; i++){
            currSum += arr[i];
            if(currSum == 0){
                maxLen = i+1;
                continue;
            }
            if(map.get(currSum) != null){
                maxLen = Math.max(maxLen, i - map.get(currSum));
            }
            else {
                map.put(currSum, i);
            }
        }
        return maxLen;
    }

    public static int numberOfSubArraysWithXor(int[] arr, int k){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currXor = 0;
        for(int i=0; i<n; i++){
            currXor ^= arr[i];
            if(currXor == k) count += 1;

            int reqXor = currXor^k;
            if(map.get(reqXor) != null) count += map.get(reqXor);

            if(map.get(currXor) != null) map.put(currXor, map.get(currXor)+1);
            else map.put(currXor, 1);

        }
        return count;
    }





}
