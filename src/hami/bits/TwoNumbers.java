package hami.bits;


import hami.BasePrint;

public class TwoNumbers extends BasePrint {

    /*
    * Given an array of integers A, every element appears twice except for two. Find those two numbers.
    *
        Input : A = [5, 4, 1, 4, 3, 5, 1, 2]
        Output : 2, 3
     */
    public static void main(String[] args) {
        print(two(new int[]{5, 4, 1, 4, 3, 5, 1, 2}));
    }

    public static int[] two(int a[]) {

        int firstPass = 0;

        for(int i=0; i<a.length; i++){
            firstPass ^= a[i];
        }
        // now firstPass should have 3^2, but we need those two numbers individually

        //Divide main array into two buckets of even and odd. Only odd will be used

        int temp=0;

        for(int i=0; i<a.length; i++){
            if((a[i] & 1) == 1)
                temp ^=a[i];    //5^1^3^5^1
        }

        //now odd list should have only those element whose right most bit was 1
        //5^1^3^5^1
        //now we XOR it with our firstPass to get the first number.
        int firstNumber= firstPass ^ temp;

        //now first number is out. XOR it again with first pass and you get second number.
        int secondNumber = firstNumber ^ firstPass;


        return new int[] {firstNumber, secondNumber};
    }
}
