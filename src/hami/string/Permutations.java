package hami.string;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba", 0, 3));
        System.out.println(isPalindrome("abadvaba", 0, 7));
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
}
