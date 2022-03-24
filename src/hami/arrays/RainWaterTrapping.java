package hami.arrays;

public class RainWaterTrapping {

    public static void main(String[] args) {
        System.out.println(maxWater(new int[]{3, 1, 2, 4, 0, 1, 3, 2}));
    }

    /*
    * Pre processing using aux array to store left and right indices
    * O(n) - T, O(n) - S
    * */
    static int maxWater(int a[]){
        //3, 1, 2, 4, 0, 1, 3, 2
        int left[] = new int[a.length];
        int right[] = new int[a.length];

        //preprocessing for left array
        left[0] = a[0];
        for (int i=1; i< a.length; i++){
            if(a[i] > left[i-1])
                left[i] = a[i];
            else
                left[i] = left[i-1];
        }

        //preprocessing for right array
        right[a.length-1] = a[a.length-1];
        for (int i=a.length-2; i>=0 ; i--){
            if(a[i] > right [i+1])
                right[i] = a[i];
            else
                right[i] = right [i+1];
        }

        //One traversal of original array
        int maxWater=0;
        for (int i=0; i< a.length; i++){
            maxWater += Math.min(left[i], right[i]) - a[i];
        }

        return maxWater;
    }
}
