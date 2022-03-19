package hami.arrays;

public class MaxSumSubArray {

    public static void main(String[] args) {
        System.out.println(kadenesAlgorithm(new int[]{-5, 4, 6, -3, 4, -1}));
    }

    //Only traverse one time, complexity O(n)
    static int kadenesAlgorithm(int a[]){
        int maxSum=0;
        int currSum=0;

        for(int i=0; i < a.length; i++){
            currSum = currSum + a[i];

            if(currSum > maxSum){
                maxSum = currSum;
            }

            if(currSum < 0){
                currSum = 0;
            }
        }

        return maxSum;
    }
}
