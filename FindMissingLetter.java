//Find the missing letter
//        Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.
//
//        You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
//        The array will always contain letters in only one case.
//
//        Example:
//
//        ['a','b','c','d','f'] -> 'e'
//        ['O','Q','R','S'] -> 'P'

public class FindMissingLetter
{
    public static char findMissingLetter(char[] array)
    {
        int len = array.length;
        int start_char = (int) array[0];
        char missing_char='0';

        System.out.println(start_char);

        for(int i=start_char;i<start_char+len;i++) {
            if(i!=(int)array[i-start_char]) {
                missing_char = (char)i;
                System.out.println("i= "+i);
                System.out.println("missing_char= "+missing_char);
                break;
            }
        }
        return missing_char;
    }
}

// Other solutions

//public class Kata
//{
//    public static char findMissingLetter(char[] array){
//        char expectableLetter = array[0];
//        for(char letter : array){
//            if(letter != expectableLetter) break;
//            expectableLetter++;
//        }
//        return expectableLetter;
//    }
//}

//public class Kata
//{
//    public static char findMissingLetter(char[] array) {
//        int n = 0;
//        while ( 1 + (int) array[n] == (int) array[++n] ) {}
//        return ++array[--n];
//    }
//}