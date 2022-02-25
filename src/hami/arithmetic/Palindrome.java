package hami.arithmetic;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(reverse(125));
        System.out.println(reverse(421));
        System.out.println(reverse(404));
        System.out.println(reverse(737));
        System.out.println(reverse(9669));
    }

    private static int reverse(int n){

        int rev = 0;

        while (n > 0){

            rev = (rev*10) + n%10;
            n = n/10;
        }

        return rev;
    }
}
