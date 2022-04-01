package hami.arrays;

public class BinarySearchRotatedArray {

    public static void main(String[] args) {
        System.out.println(rotatedArray(new int[]{20, 30, 40, 50, 60, 5, 10}, 0, 6, 20));
        System.out.println(rotatedArray(new int[]{120, 130, 40, 50, 90, 100, 110}, 0, 6, 40));
    }

    static int rotatedArray(int a[], int low, int high, int key){
        int mid = (low + high)/2;

        if(a[mid] == key)
            return mid;

        if(a[low] < a[mid]){    //left part is sorted
            if(a[low] <=key && key <= a[mid-1]){
                return binarySearchIterative(a, key, low, mid-1);
            }else {
                return rotatedArray(a, mid+1, high, key);
            }
        }else {             //right part is sorted

            if(a[mid+1] <=key && key <= a[high]){
                return binarySearchIterative(a, key, mid+1, high);
            }else {
                return rotatedArray(a, low, mid-1, key);
            }
        }
    }


    static int binarySearchIterative(int a[], int key, int low, int high){

        while (low <= high){
            int mid = (low + high)/2;

            if(a[mid] == key)
                return mid;

            if(key < a[mid])
                high = mid-1;
            else
                low = mid+1;
        }

        return -1;
    }
}
