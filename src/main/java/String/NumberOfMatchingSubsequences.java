package String;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {


        String exp = "abcde";
        String[] arr= {"a","bb","acd","ace"};

        ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(2,1));
        System.out.println(lst);

        //System.out.println(numMatchingSubSeq(exp, arr));

    }

    public static int numMatchingSubSeq(String exp, String[] words){
        int n = exp.length();
        ArrayList<Node>[] buckets = new ArrayList[26];

        for(int i=0; i<26; i++){
            buckets[i] = new ArrayList<>();
        }

        for(String word : words){
            char c = word.charAt(0);
            buckets[c-'a'].add(new Node(word, 0));
        }
        int count = 0;
        for(int i=0; i<n; i++){
            char c = exp.charAt(i);
            ArrayList<Node> list = buckets[c-'a'];
            buckets[c-'a'] = new ArrayList<>();
            for(Node node : list){
                node.idx += 1;
                if(node.idx == node.str.length()) count += 1;
                else {
                    char b = node.str.charAt(node.idx);
                    buckets[b-'a'].add(new Node(node.str, node.idx));
                }
            }
        }
        return count;
    }


}

class Node{
    String str;
    int idx;
    public Node(String str, int idx){
        this.str = str;
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "["+str+" "+idx+"]";
    }
}
