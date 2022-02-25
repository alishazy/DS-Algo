package hami.bits;

public class SingleNumber {

    /*
    * Given an array of integers A, every element appears twice except for one. Find that single one.
    * Input:  A = [1, 2, 2]
      Output: 3

      Input: A = [1, 2, 2, 3, 1]
      Output: 1
     */

    public static void main(String[] args) {
        System.out.println(single(new int[]{1, 2, 2, 3, 1}));
        System.out.println(single(new int[]{1, 2, 2}));
    }


    public static int single(int a[]) {

        int res = 0;

        for(int i=0; i<a.length; i++){
            res ^= a[i];    //XOR with itself is 0 and XOR with 0 is number itself
                            //So any repeating number in the array will XOR itslef to 0 and final remaining number will XOR with 0 to itself.
        }

        return res;
    }
}
