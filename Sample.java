public class Sample {

    public static void main(String args[]) {
        // 0. 1, 1, 2, 3, 5, 8, 13, 21, 34
        int a=0,b=1,c, i=0;

        System.out.println("The Fibonacci numbers are 0." );
        while(i++<7) {
            c = b;
            b = a;
            a = a + c;
            System.out.print(a + ",");
        }
        System.out.print(a+b);

    }
}
