import java.util.ArrayList;
import java.util.Iterator;

public class Sample2 {

    public static void main(String args[]) {
        int arr[] = new int[10];
        int i;
        for (i = 0; i < 10; i++) {
            arr[i] = (int) (10000 * Math.random());
        }
        ArrayList AL = new ArrayList<>();
        for (i = 0; i < 10; i++) {
            AL.add(arr[i]);
        }

        ArrayList non_prime = new ArrayList<>();
        ArrayList prime = new ArrayList<>();

        for (i = 0; i < 10; i++) {
            if (isPrime((int) AL.get(i)))
                prime.add(AL.get(i));
            else
                non_prime.add(AL.get(i));
        }

        Iterator itr = prime.iterator();
        System.out.println("The prime numbers are:");
        while (itr.hasNext()) {
            int p = (int) itr.next();
            if (itr.hasNext()) {
                System.out.print(p + ", ");
            } else {
                System.out.print(p);
            }
        }

        Iterator itr1 = non_prime.iterator();
        System.out.println("\n" + "The non-prime numbers are:");
        while (itr1.hasNext()) {
            int np = (int) itr1.next();
            if (itr1.hasNext()) {
                System.out.print(np + ", ");
            } else {
                System.out.print(np);
            }
        }
    }

      public static boolean isPrime(int n) {
          int i;
          int sqr_rt= (int) Math.sqrt((double)(n));
          for(i=2;i<=sqr_rt;i++) {
              if (n % i == 0)
                  return false;
              else
                  continue;
          }
          return true;
        }


}
