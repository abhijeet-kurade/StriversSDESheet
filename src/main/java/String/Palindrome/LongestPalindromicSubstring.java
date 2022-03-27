package String.Palindrome;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

    }

    public static String longestPalindromicSubstring(String str) {
        int start =-1, end =-1;
        int len = 0;
        int n = str.length();
        for(int i=0; i<n; i++){
            int left = i-1, right = i+1;
            while(left>=0 && right<n && str.charAt(left) == str.charAt(right)){
                left -= 1;
                right += 1;
            }
            if(len < (right - left -1)){
                len = right - left -1;
                start = left+1;
                end = right-1;
            }

            left = i-1; right =i;
            while(left>=0 && right<n && str.charAt(left) == str.charAt(right)){
                left -= 1;
                right += 1;
            }
            if(len < (right - left -1)){
                len = right - left -1;
                start = left+1;
                end = right-1;
            }
        }
        return str.substring(start, end+1);
    }
}
