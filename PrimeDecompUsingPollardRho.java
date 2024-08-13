import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;

//Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :
//
//        "(p1**n1)(p2**n2)...(pk**nk)"
//        with the p(i) in increasing order and n(i) empty if n(i) is 1.
//
//        Example: n = 86240 should return "(2**5)(5)(7**2)(11)"


//  Clean code. Also, it fails for (181's square or for a prime product whose factorization ends with a square of a moderately big prime like that


public class PrimeDecomp {


    public static String factors(int n) {

        if(n<1000000)
            return factors_small(n);
        else
            return factors_big(n);

    }

    //method to calculate GCD of two numbers
    static long GCD(long x, long y) {
        return y == 0 ? x : GCD(y, x % y);
    }

    static long Absolute(long x) {
        return (x>0) ? x : -x;
    }

    public static long findFactor(long n) {
        long x = 2, y = x, d = 1;


        while (d == 1) {
            x = (x * x + 1) % n;
            y = (y * y + 1) % n;
            y = (y * y + 1) % n;   // y ← g(g(y))
            d = GCD(Absolute(x - y), n);
        }

        if (d == n)
            return n;
        else
            return d;
    }

    public static String factors_big(long n) {
        // your code
        ArrayList<Long> prime_factors = new ArrayList<Long>();
        ArrayList<Integer> small_prime_factors = new ArrayList<Integer>();
        long original = n;

        while(n!=1) {
            long fact = findFactor(n);
            System.out.println("n is "+n+" and fact is "+fact);
            if(fact==original) return "("+original+")";
            else {
                n = n/fact;

                if(fact%8==0) { prime_factors.add(Long.valueOf(2)); prime_factors.add(Long.valueOf(2)); prime_factors.add(Long.valueOf(2));  fact/=8; }
                else if(fact%4==0) { prime_factors.add(Long.valueOf(2)); prime_factors.add(Long.valueOf(2));  fact/=4; }
                else if(fact%2==0) { prime_factors.add(Long.valueOf(2)); fact/=2; }
                else if(fact%27==0) { prime_factors.add(Long.valueOf(3)); prime_factors.add(Long.valueOf(3)); prime_factors.add(Long.valueOf(3));  fact/=27; }
                else if(fact%9==0) { prime_factors.add(Long.valueOf(3)); prime_factors.add(Long.valueOf(3));  fact/=9; }
                else if(fact%3==0) { prime_factors.add(Long.valueOf(3)); fact/=3; }
                if(fact!=1) {
                    if(isPrime((int)fact)) prime_factors.add(fact);
                    else {
                        System.out.println("fact in line 73 is "+fact);
                        small_prime_factors = add_factors_small((int)fact);
                        int small_size = small_prime_factors.size();
                        for(int i=0;i<small_size;i++) {
                            System.out.println("number in line 77 is "+small_prime_factors.get(i));
                            prime_factors.add(Long.valueOf(small_prime_factors.get(i)));
                        }
                    }
                }
            }
        }



        Collections.sort(prime_factors);

        return publish(prime_factors);

    }

    public static String publish(ArrayList<Long> prime_factors) {
        StringBuilder sb = new StringBuilder("");
        int size = prime_factors.size();
        System.out.println("size is " + size);
        for (int i = 0; i < size;i++) {
            int power = 1;
            int j = i;
            while ((j<(size-1))&&(prime_factors.get(j) == prime_factors.get(j + 1))){
                System.out.println("j = "+j);
                power++;
                j++;
            }
            if (power == 1) sb.append("(" + prime_factors.get(j) + ")");
            else if (power > 1) sb.append("(" + prime_factors.get(j) + "**" + power + ")");
            i=j;
        }
        return sb.toString();
    }

    public static String factors_small(int n) {
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

    public static ArrayList<Integer> add_factors_small(int n) {
        // your code
        ArrayList<Integer> primes_till_n = new ArrayList<Integer>();

        ArrayList<Integer> small_factors_array_list = new ArrayList<Integer>();

        primes_till_n.add(2);
        primes_till_n.add(3);

        for (int i = 5; i <= n; i=i+2) {
            if (isPrime(i))
                primes_till_n.add(i);
        }

        int size = primes_till_n.size();
        for(int i=0;i<size;i++) {
            while(n%primes_till_n.get(i)==0) {
                n=n/primes_till_n.get(i);
                small_factors_array_list.add(primes_till_n.get(i));
            }
        }
        return small_factors_array_list;
    }


    public static boolean isPrime(int p) {
        int sq_root = (int) Math.sqrt(p);
        if(p%2==0) return false;
        if(p%3==0) return false;
        if((p!=5)&&(p%5==0)) return false; else if(p==5) return true;
        if((p!=7)&&(p%7==0)) return false;  else if(p==7) return true;
        if((p!=11)&&(p%11==0)) return false;  else if(p==11) return true;
        if((p!=13)&&(p%7==13)) return false;  else if(p==13) return true;
        if((p!=17)&&(p%7==17)) return false;  else if(p==17) return true;
        if((p!=19)&&(p%7==19)) return false;  else if(p==19) return true;
        if((p!=23)&&(p%7==23)) return false;  else if(p==23) return true;
        if((p!=29)&&(p%7==29)) return false;  else if(p==29) return true;
        if((p!=31)&&(p%7==31)) return false;  else if(p==31) return true;
        if((p!=37)&&(p%7==37)) return false;  else if(p==37) return true;
        for (int i = 1; i <= (1+sq_root/6); i++) {
            if (p % (6*i-1) == 0)
                return false;
            else if (p % (6*i+1) == 0)
                return false;
            else continue;
        }
        return true;
    }

}



// Other solutions are below:

//import java.util.Map;
//        import java.util.TreeMap;
//        import java.util.stream.Collectors;
//
//public class PrimeDecomp {
//
//    public static String factors(int n) {
//        Map<Integer, Integer> factorsMap = new TreeMap<>();
//        recursiveDecompose(n, factorsMap);
//        return factorsMap.entrySet().stream()
//                .map(entry -> "(" + entry.getKey() + (entry.getValue() != 1 ? "**" + entry.getValue() : "") + ")")
//                .collect(Collectors.joining());
//    }
//
//    private static void recursiveDecompose(int n, Map<Integer, Integer> factorsMap) {
//        if (n == 1) {
//            return;
//        }
//        for (int i = 2; i <= n; i++) {
//            if (n % i == 0) {
//                updateFactors(factorsMap, i);
//                recursiveDecompose(n / i, factorsMap);
//                return;
//            }
//        }
//    }
//
//    private static void updateFactors(Map<Integer, Integer> factorsMap, int i) {
//        if (!factorsMap.containsKey(i)) {
//            factorsMap.put(i, 1);
//        } else {
//            factorsMap.put(i, factorsMap.get(i) + 1);
//        }
//    }
//}


//import java.util.TreeMap;
//        import java.util.stream.Collectors;
//
//public class PrimeDecomp {
//
//    public static String factors(int n) {
//        TreeMap<Integer, Integer> resultMap = new TreeMap<>();
//        int divider = 2;
//
//        while (n != 1) {
//            if (n % divider == 0) {
//                if (resultMap.containsKey(divider)) {
//                    resultMap.replace(divider, resultMap.get(divider) + 1);
//                } else {
//                    resultMap.put(divider, 1);
//                }
//
//                n /= divider;
//            } else {
//                divider ++;
//            }
//        }
//
//        return resultMap.entrySet()
//                .stream()
//                .map(entry -> entry.getValue() == 1
//                        ? "(" + entry.getKey() + ")"
//                        : "(" + entry.getKey() + "**" + entry.getValue() + ")"
//                )
//                .collect(Collectors.joining());
//
//    }
//
//}


//import java.util.*;
//        import java.util.stream.*;
//
//public class PrimeDecomp {
//    public static String factors(int n) {
//        List<String> l = new ArrayList<String>();
//        for (int i = 2; i <= n; i++) {
//            int times = 0;
//            while (n % i == 0) {
//                n /= i;
//                times++;
//            }
//            if (times == 1) l.add(Integer.toString(i));
//            else if (times > 1) l.add(String.format("%d**%d", i, times));
//        }
//        return l.stream().collect(Collectors.joining(")(", "(", ")"));
//    }
//}


//public class PrimeDecomp {
//
//    public static String factors(int lst) {
//        String result = "";
//        for (int fac = 2; fac <= lst; ++fac) {
//            int count;
//            for (count = 0; lst % fac == 0; ++count) {
//                lst /= fac;
//            }
//            if (count > 0) {
//                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
//            }
//        }
//        return result;
//    }
//}