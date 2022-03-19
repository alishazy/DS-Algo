package hami.arrays;

import hami.BasePrint;

import java.util.HashSet;
import java.util.Set;

public class FindPair extends BasePrint {

    /**
     * Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in A[] whose sum is exactly x.
     *
     * Examples:
     *
     * Input: arr[] = {0, -1, 2, -3, 1}
     *         sum = -2
     * Output: -3, 1
     *          Valid pair exists.
     *
     * If we calculate the sum of the output,
     * 1 + (-3) = -2
     *
     * Input: arr[] = {1, -2, 1, 0, 5}
     *        sum = 0
     * Output:
     *         No valid pair exists.
     *
     */

    public static void main(String[] args) {
        int a[] = {0, -1, 2, -3, 1};
        int target = -2;

        int[] result = findUsingSpace(a, target);
        if(result ==null){
            System.out.println(" No valid pair exists");
        }else
            print(result);
    }

    //Using space Time complexity is O(n) since we traverse once, space complexity is O(n)
    private static int[] findUsingSpace(int[] a, int target){
        Set<Integer> set = new HashSet<>();

        for(int i=0; i < a.length; i++){

            int diff = target - a[i];
            if(set.contains(diff)){
                return new int[]{diff, a[i]};
            }

            set.add(a[i]);
        }

        return null;
    }

    /**
     *
     * Traversing twice so complexity O(n^2)
     *
     */
    private static int[] find(int[] a, int target){

        for(int i=0; i < a.length -1; i++){
            for(int j=i+1; j< a.length; j++){
                if(a[i] + a[j] == target){
                    return new int[]{a[i], a[j]};
                }
            }
        }

        return null;
    }
}
