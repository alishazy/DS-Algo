package hami.arrays;

import hami.BasePrint;

public class StockBuyNSell extends BasePrint {

    public static void main(String[] args) {
        System.out.println(maxProfitOneTransactionWithSpace(new int[]{3, 1, 4, 8, 7, 2, 5}));
        System.out.println(maxProfitOneTransaction(new int[]{3, 1, 4, 8, 7, 2, 5}));
        System.out.println(maxProfitMultipleTransactions(new int[]{5, 2, 7, 3, 6, 1, 2, 4}));
        System.out.println(maxProfitMultipleTransactionsEasy(new int[]{5, 2, 6, 1, 4, 7, 3, 6}));
    }

    static int maxProfitMultipleTransactionsEasy(int[] a){
        int maxProfit=0;
        for (int i=1; i < a.length; i++){
            if(a[i] > a[i-1])
                maxProfit += a[i] - a[i-1];
        }

        return maxProfit;
    }

    static int maxProfitMultipleTransactions(int[] a){
        int localMin=0;
        int localMax=0;

        int maxProfit=0;
        //5, 2, 7, 3, 6, 1, 2, 4
        for (int i=1; i < a.length; i++){
            if(i != a.length-1){
                if(a[i] < a[i+1] && a[i] < a[i-1])
                    localMin = a[i];
                if(a[i] > a[i+1] && a[i] > a[i-1])
                    localMax = a[i];
            }else
                localMax = a[i];

            if(localMax > localMin) {
                maxProfit += localMax - localMin;
                localMax=0;
                localMin=0;
            }

        }

        return maxProfit;
    }

    //O(n) - T ; O(1) - S
    static int maxProfitOneTransaction(int[] a){

        int minSoFar=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0; i< a.length; i++){
            if(minSoFar > a[i]){
                minSoFar = a[i];
            }

            if(a[i] - minSoFar > maxProfit)
                maxProfit = a[i] - minSoFar;
        }

        return maxProfit;
    }


    //O(n) time complexity, O(n) space complexity
    static int maxProfitOneTransactionWithSpace(int[] a){
        //pre processing to find max elements
        int[] aux = new int[a.length];
        int maxElem = Integer.MIN_VALUE;
        for (int i=a.length-1; i >= 0; i--){
            if(maxElem < a[i]){
                aux[i] = a[i];
                maxElem = a[i];
            }else {
                aux[i] = maxElem;
            }
        }

        //traverse one more time to find the max difference
        int maxProfit=0;
        for (int i=0; i < a.length; i++){
            if(aux[i] - a[i] > maxProfit)
                maxProfit = aux[i] - a[i];
        }

        return maxProfit;
    }
}
