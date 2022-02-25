package hami.bits;

public class ReverseBits {

    /*Example Input
        Input 1: 0
        Input 2: 3

    Example Output
        Output 1: 0
        Output 2: 3221225472


    Example Explanation
       Explanation 1:
                00000000000000000000000000000000
        =>      00000000000000000000000000000000
       Explanation 2:
                00000000000000000000000000000011
        =>      11000000000000000000000000000000*/

    public static void main(String[] args) {

        System.out.println(reverseWithBitOps(3));
        System.out.println(reverse(3));
    }

    /*
    * It can be done using StringBuilder
    * */
    public static long reverse(long a) {
        if(a == 0)
            return 0;

        String s = Long.toBinaryString(a);
        String format = String.format("%32s", s);
        String withLeadingZeros = format.replace(' ', '0');

        StringBuilder sb = new StringBuilder(withLeadingZeros);
        String reversedNumber = sb.reverse().toString();


        String withLeadingZerosRev = String.format("%32s", reversedNumber).replace(' ', '0');

        return Long.parseLong(withLeadingZerosRev, 2);
    }

    /*
    * If leading zeroes are not considered then, this simple approach can be used.
    * */
    public static int reverseWithBitOps(int a){

        int rev = 0;

        while (a > 0){
            rev <<= 1;  //left shift 1 bit;

            if((a&1) == 1)  //check if 1 or 0
                rev = rev ^ 1;  //if 1, XOR with 1 to get 1

            a >>=1;
        }

        return rev;
    }
}
