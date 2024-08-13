public class EqualSidesOfArray {
    public static int findEvenIndex(int[] arr) {
        int len = arr.length;
        int sum=0,L_sum=0;
        for(int i=0;i<len;i++)
            sum+=arr[i];
        for(int i=0;i<len;i++) {
            if(L_sum!=sum-arr[i]) {
                L_sum+=arr[i];
                sum-=arr[i];
            }
            if(L_sum==sum-arr[i]) return i;
            System.out.println("i, sum, L_sum are "+i+" "+sum+" "+L_sum);
        }

        return -1;

    }
}


//import java.util.Arrays;
//public class Kata {
//    public static int findEvenIndex(int[] arr) {
//        // your code
//        for(int x =0; x < arr.length ; x++){
//            if( Arrays.stream(arr, 0, x).sum() == Arrays.stream(arr, x+1, arr.length).sum() ) return x;
//
//        }
//        return -1;
//    }
//}
