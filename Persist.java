//Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.
//
//        For example (Input --> Output):
//
//        39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit, there are 3 multiplications)
//        999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2, there are 4 multiplications)
//        4 --> 0 (because 4 is already a one-digit number, there is no multiplication)



class Persist {

    static boolean toggle_flag = false;


    public static int getNumOfDigits(long n) {
        int len=1;
        while((n=n/10)>0) len++;
        return len;
    }

    public static int persistence(long n) {

        int turn_count = 0;
        while(getNumOfDigits(n)!=1) {
            System.out.println("getNumOfDigits(n) is "+ getNumOfDigits(n)+" and original number here is "+n);
            n = productOfDigits(getDigits(n));
            turn_count++;
        }
        return turn_count;
    }

    public static int[] getDigits(long n) {

        long original = n;
        int len=1;

        while((n=n/10)>0) len++;

        toggle_flag = true;

        int[] digits = new int[len];

        n = original;

        while(n>0) { digits[len-- -1] = (int)n%10;  n/=10; }

        return digits;
    }

    public static long productOfDigits(int[] arr) {

        int len = arr.length;
        long product = 1;
        for(int i=0;i<len;i++) product*=arr[i];

        return product;
    }

}

// Other solutions

//class Persist {
//    public static int persistence(long n) {
//        int i = 0;
//        for (; n >= 10; i++) n = per("" + n);
//        return i;
//    }
//    public static long per(String s) {
//        long ans = 1;
//        for(int i = 0; i < s.length(); i++) ans *= (long) Character.getNumericValue(s.charAt(i));
//        return ans;
//    }
//}



//import java.util.Arrays;
//
//class Persist {
//
//    public static int persistence(long n) {
//        if (n < 10) return 0;
//
//        final long newN = Arrays.stream(String.valueOf(n).split(""))
//                .mapToLong(Long::valueOf)
//                .reduce(1, (acc, next) -> acc * next);
//
//        return persistence(newN) + 1;
//    }
//}

// Best and Simplest solution:
//class Persist {
//    public static int persistence(long n) {
//        long m = 1, r = n;
//
//        if (r / 10 == 0)
//            return 0;
//
//        for (r = n; r != 0; r /= 10)
//            m *= r % 10;
//
//        return persistence(m) + 1;
//
//    }
//}