public class CheckPrime {



    public static boolean isPrime(int p) {
        int sq_root = (int) Math.sqrt(p);
        for (int i = 2; i <= sq_root; i++) {
            if (p % i == 0)
                return false;
            else continue;
        }
        return true;
    }

    public static void main(String args[]) {
        //int n = 18195729;
        int n = 677;
        if(isPrime(n)) System.out.println("It is a prime number");
        else System.out.println("It is a composite number");
    }
}
