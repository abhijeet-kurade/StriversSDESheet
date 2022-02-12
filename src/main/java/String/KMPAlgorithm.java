package String;

import java.util.ArrayList;
import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        System.out.println(KMP("aefaefaefaedaefaedaefaefaefa", "aefaedaefaefaefas"));


    }

    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }

    public static boolean KMP(String exp, String pat){
        int n = exp.length();
        int m = pat.length();

        int[] match = new int[m];
        Arrays.fill(match, -1);

        int i = 1;
        int j = 0;

        while(i < m){
            if(pat.charAt(i) == pat.charAt(j)) match[i++] = j++;
            else if(j>0) j = match[j-1] + 1;
            else i += 1;
        }
        i=0; j=0;
        while (i < n) {
            if(pat.charAt(j) == exp.charAt(i)){
                i += 1;
                j += 1;
                if(j == m) return true;
            }
            else if(j > 0) j = match[j-1] + 1;
            else i += 1;
        }
        return false;
    }
}
