//
//Please write code in Java for the following and give its time-complexity:
//
//        For a given list [x1, x2, x3,...,xn] compute the last (decimal) digit of x1^(x2^(x3^(...^xn))).


import java.util.*;

public class LastDigit {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 3, 1); // Example list
        System.out.println(findLastDigit(list)); // Expected output: 1
    }

    public static int findLastDigit(List<Integer> list) {
        int n = list.size();

        // Base case
        if (n == 0) return 1;

        // Modulo properties to reduce the exponentiation problem
        int result = 1;
        for (int i = n - 1; i >= 0; i--) {
            result = modExp(list.get(i), result, 10);
            if (result == 0) return 0; // If the result is 0, the last digit is 0
        }

        return result;
    }

    // Function to perform modular exponentiation: (base^exp) % mod
    public static int modExp(int base, int exp, int mod) {
        if (mod == 1) return 0;
        int result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd, multiply base with result
                result = (result * base) % mod;
            }
            exp = exp >> 1; // Divide exp by 2
            base = (base * base) % mod; // Square the base
        }
        return result;
    }
}

