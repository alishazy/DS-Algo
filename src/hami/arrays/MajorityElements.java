package hami.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElements {

    //Given an array of size n, find if an element is present more than n/2 times.
    public static void main(String[] args) {
        System.out.println(bruteForce(new int[]{5, 1, 4, 1, 1}));   //O(n^2)
        System.out.println(sortedArray(new int[]{5, 1, 4, 1, 1}));   //O(nLogN)
        System.out.println(usingSpace(new int[]{5, 1, 4, 1, 1}));   //O(n)
    }

    static int usingSpace(int a[]){
        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i< a.length; i++){ //one time traversal O(n)
            if(map.containsKey(a[i])){
                map.put(a[i], map.get(a[i])+1);
            }else
                map.put(a[i], 1);
        }

        int maxCount=0;
        int element=0;
        for (Map.Entry entry : map.entrySet()){ //another traversal==> O(n) + O(n) = O(n)
            if((int)entry.getValue() > maxCount){
                maxCount = (int)entry.getValue();
                element = (int)entry.getKey();
            }
        }

        if(maxCount > (a.length/2)){
            System.out.println("Element is ::"+element);
            return maxCount;
        }

        return -1;//not found
    }

    static int sortedArray(int a[]){    //Total complexity will be O(nlogn) + O(n) = O(nlogn)
        Arrays.sort(a); //nlogn

        int maxCount=0;
        int temp=0;
        int count =1;
        for(int i=0; i< a.length; i++){ // O(n) 1, 1, 1, 4, 5
            if(temp==0)
                temp = a[i];
            else{
                if(temp == a[i])
                    count++;
                else {
                    if(count > maxCount)
                        maxCount = count;

                    temp = a[i];
                    count=1;
                }
            }
        }

        if(maxCount > (a.length/2)){
            return maxCount;
        }

        return -1;//not found
    }

    //Brute fore way of traversing array twice, O(n^2)
    static int bruteForce(int a[]){
        int maxCount=0;
        int element=0;

        for (int i=0; i< a.length; i++){
            int count=0;
            for (int j=0; j< a.length; j++){
                if(a[i] == a[j])
                    count++;
            }

            if(count > maxCount){
                element = a[i];
                maxCount = count;
            }
        }

        if(maxCount > (a.length/2)){
            System.out.println("Element is ::"+element);
            return maxCount;
        }

        return -1;//not found
    }
}
