package SlidingWindow;

import java.util.HashMap;

public class MinSubStringWith012 {
    public static void main(String[] args) {
        System.out.println(minSubStringWith012("00001111"));
    }
    public static int minSubStringWith012(String str){
        int ans = Integer.MAX_VALUE;
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = -1, right = -1;
        while (right < n){
            while (map.size() < 3){
                right += 1;
                if(right>=n) break;
                char c = str.charAt(right);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                }
                else map.put(c, 1);
            }
            while (map.size()>=3){
                ans = Math.min(ans, right-left);
                left += 1;
                char c = str.charAt(left);
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) map.remove(c);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
