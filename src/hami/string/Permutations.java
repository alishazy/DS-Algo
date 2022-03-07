package hami.string;

import java.util.HashSet;
import java.util.Set;

public class Permutations {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba", 0, 3));
        System.out.println(isPalindrome("abadvaba", 0, 7));
        powerSet("abc", 0, "");
        permute("abcd", 0, 3);
    }

    /*
    * f(s, l, r) ==> f(s, l+1, r-1)
    * */
    static boolean isPalindrome(String s, int l, int r){
        if(l >=r)
            return true;

        if(s.charAt(l) != s.charAt(r))
            return false;

        return isPalindrome(s, l+1, r-1);
    }

    //Powerset of abc = {"", a, b, c, ab, bc, ac, abc}
    static void powerSet(String s, int i, String curr){

        if(i == s.length()){
            System.out.println(curr);
            return;
        }

        powerSet(s, i+1, curr + s.charAt(i));
        powerSet(s, i+1, curr);

    }

    //permutation of string abc = {abc, acb, bac, bca, cab, cba};
    //Complexity = O(n*n!)
    static void permute(String s, int l, int r){
        if(l == r){
            if(set.contains(s)) return;
            set.add(s);
            System.out.println(s);
            return;
        }

        for(int i = l; i<=r; i++){
            s = swap(s, l, i);

            permute(s, l+1, r);

            s = swap(s, l, i);
        }
    }

    static String swap(String s, int a, int b) {
        char array[] = s.toCharArray();
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return String.valueOf(array);
    }
}
