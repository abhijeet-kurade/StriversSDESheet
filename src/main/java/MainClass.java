public class MainClass {
    public static void main(String[] args) {

        System.out.println(multiplyStrings("5", "501"));
    }

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

    public static String padZero(int num, int zeros){
        StringBuilder number = new StringBuilder(String.valueOf(num));
        for(int i=0; i<zeros; i++){
            number.append('0');
        }
        return String.valueOf(number);
    }

    public static boolean isRotated(String str1, String str2)
    {
        int n = str1.length();

        StringBuilder str = new StringBuilder(str1);
        char c1 = str.charAt(0);
        str.deleteCharAt(0);
        str.append(c1);
        c1 = str.charAt(0);
        str.deleteCharAt(0);
        str.append(c1);
        System.out.println(str);
        if(str2.equals(String.valueOf(str))) return true;

        str = new StringBuilder(str1);
        c1 = str.charAt(n-1);
        str.deleteCharAt(n-1);
        str.insert(0, c1);
        c1 = str.charAt(n-1);
        str.deleteCharAt(n-1);
        str.insert(0, c1);
        System.out.println(str);
        if(str2.equals(str)) return true;

        return false;

    }
    static int atoi(String str) {
        int n = str.length();
        int total = 0;
        int mul = 1;
        for(int i=n-1; i>=0; i--){
            char c = str.charAt(i);
            System.out.println(c + " " +(c=='-')+ total);
            if(i==0 && c=='-') return total * -1;
            if(isNumber(c)){
                int num = c - '0';
                total += mul * num;
                mul *= 10;
            }
            else return -1;
        }
        return total;
    }

    static boolean isNumber(char c){
        int num = c - '0';
        return 0<=num && num<=9;
    }

    static String addBinary(String A, String B) {

        int n = A.length(), m = B.length();
        int idx1 = n-1, idx2=m-1, carry =0;
        StringBuilder answer = new StringBuilder();
        while(idx1>=0 || idx2>=0){
            int num1 = idx1>=0?A.charAt(idx1)-'0': 0;
            int num2 = idx2>=0?B.charAt(idx2)-'0': 0;

            if(idx1>=0) idx1 -= 1;
            if(idx2>=0) idx2 -= 1;

            int sum = num1 + num2 + carry;
            System.out.println(sum);
            char ans;
            if(sum == 2){
                ans = '0';
                carry = 1;
            }
            else if(sum == 3){
                ans = '1';
                carry = 1;
            }
            else{
                ans = (char)(sum+'0');
                carry = 0;
            }
            answer.append(ans);
        }
        answer.append((char) (carry+'0'));
        answer.reverse();
        int idx = 0;
        for(int i=0; i<answer.length(); i++){
            if(answer.charAt(i) == '1'){
                idx = i;
                break;
            }
            idx = i;
        }
        return String.valueOf(answer.substring(idx, answer.length()));

    }

}
