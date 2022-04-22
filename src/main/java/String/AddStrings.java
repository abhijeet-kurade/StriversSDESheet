package String;

public class AddStrings {
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
