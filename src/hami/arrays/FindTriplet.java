package hami.arrays;

import java.util.HashSet;

public class FindTriplet {

   /** Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array,
    * then print the triplet and return true. Else return false.

    Examples:
    Input: array = {12, 3, 4, 1, 6, 9}, sum = 24;
    Output: 12, 3, 9
    Explanation: There is a triplet (12, 3 and 9) present in the array whose sum is 24.

    Input: array = {1, 2, 3, 4, 5}, sum = 9
    Output: 5, 3, 1
    Explanation: There is a triplet (5, 3 and 1) present in the array whose sum is 9.

    **/

   public static void main(String[] args) {
       int a[] = {12, 3, 4, 1, 6, 9};
//       int a[] = {1, 2, 3, 4, 5};
       int sum = 24;
//       int sum = 9;
       System.out.println(findUsingSpace(a, sum));
   }

   /*
   * Traversing only twice and look up is O(1) so Time complexity is O (n^2)
   *
   * */
    private static boolean findUsingSpace(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i< arr.length-2; i++){

            int curr_sum = target - arr[i];

            for(int j = i+1; j< arr.length; j++){
                if(set.contains(curr_sum - arr[j])){
                    System.out.println(arr[i] +", " +arr[j] +", "+ (curr_sum - arr[j]));
                    return true;
                }
                set.add(arr[j]);
            }
        }
        return false;
    }

    /*
    *
    * Traversing three times so O(n^3)
    * */
   private static boolean find(int[] arr, int target){

       for(int i=0; i< arr.length-2; i++){
           for(int j = i+1; j< arr.length -1; j++){
               for(int k = j+1; k< arr.length; k++){
                   if(arr[i] + arr[j] + arr[k] == target){

                       System.out.println(arr[i] +", " +arr[j] +", "+ arr[k]);
                       return true;
                   }
               }
           }
       }
       return false;
   }
}
