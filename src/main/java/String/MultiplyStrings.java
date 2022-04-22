package String;

public class MultiplyStrings {
    public static String multiplyStrings(String s1,String s2){
        int n = s1.length(), m = s2.length();

        int isNegative = 0;
        if(s1.charAt(0) == '-'){
            isNegative += 1;
            s1 = s1.substring(1, s1.length());
        }
        if(s2.charAt(0) == '-'){
            isNegative += 1;
            s2 = s2.substring(1, s2.length());
        }

        n = s1.length();
        m = s2.length();

        String total = "0";
        for(int i=n-1; i>=0; i--){
            int num1 = s1.charAt(i) - '0';
            for(int j=m-1; j>=0; j--){
                int num2 = s2.charAt(j) - '0';
                if(num1 == 0 || num2==0) continue;
                int multi = num1 * num2;
                int zeros = (n-1-i) + (m-1-j);
                String curr = padZero(multi, zeros);
                total = addStrings(total, curr);
            }
        }
        if(total.length() == 1 && Integer.parseInt(total) == 0) return "0";
        if(isNegative % 2 == 1) total = "-"+total;
        return total;
    }
    public static String padZero(int num, int zeros){
        StringBuilder number = new StringBuilder(String.valueOf(num));
        for(int i=0; i<zeros; i++){
            number.append('0');
        }
        return String.valueOf(number);
    }
    public static String addStrings(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int idx1=n-1, idx2=m-1;
        int carry=0;
        StringBuilder sum = new StringBuilder();
        while(idx1>=0 || idx2>=0){
            int num1 = idx1<0 ? 0 : s1.charAt(idx1) - '0';
            int num2 = idx2<0 ? 0 : s2.charAt(idx2) - '0';

            if(idx1>=0) idx1 -= 1;
            if(idx2>=0) idx2 -= 1;

            int s = num1 + num2 + carry;
            int unit = s % 10;
            carry = s/10;

            sum.append((char)(unit+'0'));
        }
        if(carry != 0) sum.append((char)(carry+'0'));
        sum.reverse();
        if(sum.length() == 1) return String.valueOf(sum);
        int idx = 0;
        for(int i=0; i<sum.length(); i++){
            if(sum.charAt(i)!='0'){
                idx = i;
                break;
            }
            idx=i;
        }
        if(sum.length()-1 == idx) return "0";
        return String.valueOf(sum.substring(idx, sum.length()));
    }
}
