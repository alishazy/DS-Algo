package hami.string;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingChars {

    //Given a string S consisting of lowercase Latin Letters. Find the first non-repeating character in S.
    /*
    * Input:
        S = hello
        Output: h
        Explanation: In the given string, the
        first character which is non-repeating
        is h, as it appears first and there is
        no other 'h' in the string.
    * */

    public static void main(String[] args) {
        System.out.println(nonRepeatingChar("hello"));
        System.out.println(nonRepeatingChar("zxvczbtxyzvy"));
    }

    /*
    * O(n) for looping through string length at least once, add one more round for finding first occurance
    * O(n) + O(n) = O(n)
    *
    * Space = O(n) where n = number of distinct characters.
    * */
    static char nonRepeatingChar(String s){
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){

            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        System.out.println(map);

        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }

        return '$';
    }
}
