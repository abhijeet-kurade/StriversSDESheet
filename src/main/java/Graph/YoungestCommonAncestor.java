package Graph;

public class YoungestCommonAncestor {
    static class AncestralTree{
        char name;
        AncestralTree ancestor;
    }
    public static AncestralTree getYoungestCommonAncestor(AncestralTree one, AncestralTree two){
        if(checkAncestor(one, two)) return one;
        if(checkAncestor(two, one)) return two;

        AncestralTree node1 = one;
        AncestralTree node2 = two;

        while(true){
            if(node1 == node2) return node1;
            node1 = node1.ancestor == null ? two : node1.ancestor;
            node2 = node2.ancestor == null ? one : node2.ancestor;
        }

    }
    public static boolean checkAncestor(AncestralTree ancestor, AncestralTree descendant){
        while(descendant != null){
            if(ancestor == descendant) return true;
            descendant = descendant.ancestor;
        }
        return false;
    }
}
