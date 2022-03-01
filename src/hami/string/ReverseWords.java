package hami.string;

import java.util.Iterator;
import java.util.Stack;

public class ReverseWords {

    //Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

    //Input:
    //S = i.like.this.program.very.much
    //Output: much.very.program.this.like.i
    public static void main(String[] args) {

        System.out.println(reverse("i.like.this.program.very.much"));
        System.out.println(reverseStack("i.like.this.program.very.much"));
    }

    //One way of using split function
    static String reverse(String s){
        String output="";

        String sArr[] = s.split("\\.");
        for(int i=sArr.length -1; i>=0; i--){
            output += sArr[i];
            if(i!=0)
                output += ".";
        }

        return output;
    }

    //Another way by using Stack
    static String reverseStack(String s){
        String output="";
        Stack<Character> stack = new Stack<>();

        for(int i=s.length()-1; i>=0; i--){

            if(s.charAt(i) == '.'){
                Iterator itr = stack.iterator();
                while(itr.hasNext()) {
                    output += stack.pop();
                }
                output += ".";
            }else {
                stack.push(s.charAt(i));
            }
        }

        if(stack.size() > 0)
            output += stack.pop();

        return output;
    }
}
