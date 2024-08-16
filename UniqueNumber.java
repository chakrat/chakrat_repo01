//
//There is an array with some numbers. All numbers are equal except for one. Try to find it!
//
//        Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
//        Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
//        It’s guaranteed that array contains at least 3 numbers.
//
//        The tests contain some very huge arrays, so think about performance.

public class UniqueNumber {
// Make sure your class is public

        public static double findUniq(double arr[]) {
            int len = arr.length;
            int no_of_changes = 0;
            //double rtn=0.0;
            //boolean first=true;
            //if(arr[0]==arr[1]) first=false;
            for(int i=0;i<len-1;i++) {
                if(arr[i]!=arr[i+1]) no_of_changes++;
                //System.out.println("i and #changes are "+i+" "+no_of_changes);
                //System.out.println("i-th and (i+1)-th elements are "+arr[i]+" "+arr[i+1]);
                //System.out.println("\n");

                //if(i==2) first=false;

                if(no_of_changes==2) return arr[i];

            }

            if(arr[0]==arr[1]) return arr[len-1];
            else if(arr[1]==arr[2]) return arr[0];
            else return arr[1];
            //if((no_of_changes==1)&&(first)) return arr[0];
            //else if((no_of_changes==1)&&(!first)) return arr[len-1];
            //else continue;

            //}
            // Do the magic
            //return arr[len-1];
            // return rtn;
        }
    }

// Other solution:

//public class Kata {
//    public static double findUniq(double arr[]) {
//        final double same = arr[0] == arr[1] ? arr[0] : arr[2];
//        for (double d : arr) if (same != d) return d;
//        return 0;
//    }
//}

//public class Kata {
//    public static double findUniq(double arr[]) {
//        final double common = arr[0]==arr[1] || arr[0]==arr[2] ? arr[0] : arr[1];
//        int i = 0;
//        while (arr[i] == common) i++;
//        return arr[i];
//    }
//}


