package hami.arrays;

public class BinarySearchInfiniteSortedArray {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-4, -1, 3, 7, 10, 11}, 10));
    }

    static boolean binarySearch(int a[], int key){
        int low=0;
        int high = 1;

        while (a[high] < key){
            low = high;
            high = 2*high;
        }

        return binarySearchIterative(a, key, low, high);
    }

    static boolean binarySearchIterative(int a[], int key, int low, int high){

        while (low <= high){
            int mid = (low + high)/2;

            if(a[mid] == key)
                return true;

            if(key < a[mid])
                high = mid-1;
            else
                low = mid+1;
        }

        return false;
    }
}
