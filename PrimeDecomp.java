import java.util.ArrayList;
import java.lang.StringBuilder;

//Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :
//
//        "(p1**n1)(p2**n2)...(pk**nk)"
//        with the p(i) in increasing order and n(i) empty if n(i) is 1.
//
//        Example: n = 86240 should return "(2**5)(5)(7**2)(11)"


public class PrimeDecomp {

    public static String factors(int n) {
        // your code
        ArrayList<Integer> primes_till_n = new ArrayList<Integer>();

        primes_till_n.add(2);
        primes_till_n.add(3);

        for (int i = 5; i <= n; i++) {
            if (isPrime(i))
                primes_till_n.add(i);
        }

        StringBuilder sb = new StringBuilder("");
        int size = primes_till_n.size();
        for(int i=0;i<size;i++) {
            int power=0;
            while(n%primes_till_n.get(i)==0) {
                n=n/primes_till_n.get(i);
                power++;
            }
            if(power==1) sb.append("("+primes_till_n.get(i)+")");
            else if(power >1) sb.append("("+primes_till_n.get(i)+"**"+power+")");
        }
        return sb.toString();

    }

    public static boolean isPrime(int p) {
        int sq_root = (int) Math.sqrt(p);
        if(p%2==0) return false;
        if(p%3==0) return false;
        for (int i = 1; i <= sq_root/6; i++) {
            if (p % (6*i-1) == 0)
                return false;
            else if (p % (6*i+1) == 0)
                return false;
            else continue;
        }
        return true;
    }

}