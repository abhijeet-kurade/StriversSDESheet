package String;

public class AOTI {
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
}
