package hami.arrays;

public class BinarySearchArray {

    public static void main(String[] args) {
        System.out.println(binarySearchRecursive(new int[]{-4, -1, 3, 7, 10, 11}, 10, 0, 5));
        System.out.println(binarySearchIterative(new int[]{-4, -1, 3, 7, 10, 11}, 11));
    }

    static boolean binarySearchRecursive(int a[], int key, int low, int high){
        if(low>high)
            return false;

        int mid = (low + high)/2;
        if(key == a[mid])
            return true;

        if(key < a[mid]){
            high = mid-1;
        }else {
            low = mid +1;
        }

        return binarySearchRecursive(a, key, low, high);
    }

    static boolean binarySearchIterative(int a[], int key){
        int low=0;
        int high = a.length-1;

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
