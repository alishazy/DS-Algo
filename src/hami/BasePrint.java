package hami;

public class BasePrint {

    protected static void print(int[] result){

        for (int i=0; i< result.length; i++) {
            System.out.println(result[i]);

        }
    }

    protected static void print(int[] result, int start, int end){

        for (int i=start; i< end; i++) {
            System.out.println(result[i]);

        }
    }

    protected static void print(boolean[] result){

        for (int i=0; i< result.length; i++) {
            System.out.println(i + " "+result[i]);

        }
    }
}
