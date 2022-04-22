package String;

public class AddBinary {
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
