package hami.bits;

public class ThreeNumbers {

    /*
    * Given an array of integers A, every element appears three times (or k times) except for one. Find that number.
    *
        Input : A = [5, 4, 1, 4, 3, 5, 1, 1, 4, 5]
        Output : 3
     */

    public static void main(String[] args) {
        System.out.println(thrice(new int[]{5, 4, 1, 4, 3, 5, 1, 1, 4, 5}));
    }

    public static int thrice(int A[]) {
        int count[] = new int[32];

        for (int i = 0; i < 32; i++)
            for (int j = 0; j < A.length; j++)
                if ((A[j] & (1 << i)) != 0)
                    count[i] += 1;

        int res = 0;
        for (int i = 0; i < 32; i++)
            res += (count[i] % 3) * (1 << i);

        return res;
    }
}
