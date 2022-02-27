package BackTracking;

public class NoThreeConsecutiveLetters {
    public static void main(String[] args) {
        String str = "?????????bba?";//"???bb??b??aa?";
        System.out.println(str +" : "+filters("???bb??b??aa?"));
    }
    public static String filters(String str){
        StringBuilder str1 = new StringBuilder(str);
        filterBackTrack(str1, 0);
        return String.valueOf(str1);
    }
    public static boolean isSafe(StringBuilder str, int idx){
        if(idx < 1) return true;
        if(idx == str.length()-1) return !(str.charAt(idx) == str.charAt(idx-1) && str.charAt(idx) == str.charAt(idx-2));
        boolean middle = !(str.charAt(idx) == str.charAt(idx+1) && str.charAt(idx) == str.charAt(idx -1));
        boolean last = idx >= 2 ? !(str.charAt(idx) == str.charAt(idx-2) && str.charAt(idx) == str.charAt(idx -1) ) : true;
        boolean first = idx < str.length()-2 ? !(str.charAt(idx) == str.charAt(idx+1) && str.charAt(idx) == str.charAt(idx+2)) : true;
        return middle && last && first;
    }

    public static boolean filterBackTrack(StringBuilder str, int idx){
        if(!isSafe(str, idx-1)) return false;
        if(idx>=str.length()) return true;
        if(str.charAt(idx) == '?'){
            str.setCharAt(idx, 'a');
            if(filterBackTrack(str, idx+1)) return true;

            str.setCharAt(idx, 'b');
            if(filterBackTrack(str, idx+1)) return true;

            str.setCharAt(idx, '?');
            return false;
        }
        return filterBackTrack(str, idx+1);

    }
}
