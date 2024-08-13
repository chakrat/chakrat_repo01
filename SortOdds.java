//You will be given an array of numbers. You have to sort the odd numbers in ascending order
// while leaving the even numbers at their original positions.
//        Examples
//        [7, 1]  =>  [1, 7]
//        [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]


import java.util.ArrayList;
import java.util.Collections;


public class SortOdds {
    public static int[] sortArray(int[] array) {

        int len = array.length;

        ArrayList<Integer> oddPositions = new
                ArrayList<Integer>();

        ArrayList<Integer> oddValues = new
                ArrayList<Integer>();


        for(int i=0;i<len;i++) {
            if(array[i]%2!=0) {
                oddPositions.add(i);
                oddValues.add(array[i]);
            }
        }

        Collections.sort(oddValues);

        for(int i=0;i<oddPositions.size();i++) {
            array[oddPositions.get(i)] = oddValues.get(i);
        }

        return array;
    }
}
