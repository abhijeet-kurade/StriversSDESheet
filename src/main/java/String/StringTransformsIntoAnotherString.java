package String;

import java.util.HashMap;
import java.util.HashSet;

public class StringTransformsIntoAnotherString {
    public static void main(String[] args) {

    }

    public static boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        if(str1.length()!=str2.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<str1.length(); i++){
            if(map.get(str1.charAt(i)) != null && map.get(str1.charAt(i)) != str2.charAt(i)) return false;
            map.put(str1.charAt(i), str2.charAt(i));
        }

        for(int i=0; i<str1.length(); i++)  set.add(str2.charAt(i));

        return set.size() < 26;

    }
}
