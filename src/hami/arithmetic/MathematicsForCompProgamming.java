package hami.arithmetic;

import hami.BasePrint;

import java.util.Arrays;

public class MathematicsForCompProgamming extends BasePrint {

    public static void main(String[] args) {
        print(sieveOfEratoSthenes(30));
        System.out.println(gcd(24, 60));
        System.out.println(fastPower(3987626, 5, 1000000007));
        System.out.println(findPowerRecursive(3, 4));

    }

    /*
    *
    * a^b can also be written as
    *
    * if b is odd - a*a^b-1;
    * if b is even - (a^2)^b/2;
    *
    * Modulo properties--
    *       (a+b)%n = (a%n + b%n) % n
    *       (a*b)%n = (a%n * b%n) % n
    * */
    static long fastPower(long a, long b, int n){
      long res = 1;

      while(b > 0){

          //check if b is odd
          if((b&1) !=0){
              res = (res * a % n) % n;
          }

          a = (a % n * a % n) % n;  //(a^2)^b/2 means, keep doing a^2, until b/2 times
          b = b >> 1;
      }

      return res;
    }

    /*
    * a^b using recursion
    * */

    static int findPowerRecursive(int a, int b){
        if(b == 0)
            return 1;

        return findPowerRecursive(a, b-1) * a;
    }

    static int gcd(int a, int b){

        /*
            Theoram: gcd (a, b) = gcd (b, a % b) while (a % b != 0)
        * */

        if(b == 0) return a;

        return gcd( b, a % b);
    }

    static boolean[] sieveOfEratoSthenes(int n){

        boolean isPrime[] = new boolean[n+1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false; //To avoid '0' based array indexing
        isPrime[1] = false;

        for( int i = 2; i*i <=n; i++){  // i^2 = n, i = sqrt(n)

            for(int j = 2*i; j<=n; j+=i){   //to get multiples of i
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}
