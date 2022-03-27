package String.Palindrome;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {

    }
    public static int longestPalindromicSubsequence(String str) {
        int n= str.length();
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) dp[i][i] = 1;

        for(int i=1; i<n; i++){
            int left = 0, right=i;
            while (right < n){
                if(str.charAt(left) == str.charAt(right)) dp[left][right] = dp[left+1][right-1] + 2;
                else dp[left][right] = Math.max(dp[left+1][right], dp[left][right-1]);
                left += 1;
                right += 1;
            }
        }
        return dp[0][n-1];
    }

    public static int longestPalindromicSubsequence1(String str) {
        int n = str.length();
        int[][] cache = new int[n][n];
        int len = longestPalSub(str, 0, n-1, cache);
        return len;
    }
    public static int longestPalSub(String str, int left, int right, int[][] cache){
        if(left>right) return 0;
        if(cache[left][right] != 0) return cache[left][right];
        if(left==right){
            cache[left][right] = 1;
            return cache[left][right];
        }
        if(str.charAt(left) == str.charAt(right))
            return 2 + longestPalSub(str, left+1, right-1, cache);
        else
            return Math.max(longestPalSub(str, left, right-1, cache),longestPalSub(str, left+1, right, cache));

    }
}
