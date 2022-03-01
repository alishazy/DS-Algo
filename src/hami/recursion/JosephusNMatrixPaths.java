package hami.recursion;

public class JosephusNMatrixPaths {

    /*
    * Given a matrix of n(rows) and m(columns), find number of ways to reach from top left column to bottom right column
    * Constraints: You can only traverse right or bottom. You cannot traverse back.
    * */

    public static void main(String[] args) {
        System.out.println(matrixPaths(3, 3));
        System.out.println(josephus(5, 3));
    }
    static int matrixPaths(int n, int m){

        if(n==1 || m==1)
            return 1;

        return matrixPaths(n-1, m) + matrixPaths(n, m-1);
    }

    /* Josephus Problem

    There are N people standing in a circle numbered from 1 to N. Also given an integer K.
    First, count the K-th number starting from the first one and delete it.
    Then K numbers are counted starting from the next one and the K-th one is removed again, and so on.
    The process stops when one number remains. The task is to find the last number.

    Input: N = 5, K = 3
    Output: 3

    f(n, k) = (f(n-1, k) + k) %n
    */

    static int josephus(int n, int k){
        if(n==1)
            return 0;

        return (josephus(n-1, k) + k) %n;
    }
}
