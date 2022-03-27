package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JPM {
    public static void main(String[] args) {

        closestNumber(new ArrayList<>(Arrays.asList(4,2,1,3)));
    }

    public static int changeAd(int base10){
        int num = base10;
        int count = 0;
        while(num > 0){
            count+=1;
            num >>= 1;
        }
        return ~base10 & ((1<<count) - 1);
    }

    public static void closestNumber(List<Integer> numbers){
        Collections.sort(numbers);
        int n = numbers.size();
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            minDiff = Math.min(numbers.get(i) - numbers.get(i-1), minDiff);
        }
        for(int i=1; i<n; i++){
            if(numbers.get(i) - numbers.get(i-1) == minDiff){
                System.out.println(numbers.get(i-1) +" "+numbers.get(i));
            }
        }
    }

}
