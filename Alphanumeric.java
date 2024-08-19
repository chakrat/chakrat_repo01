//In this example you have to validate if a user input string is alphanumeric. The given string is not nil/null/NULL/None, so you don't have to check that.
//
//        The string has the following conditions to be alphanumeric:
//
//        At least one character ("" is not valid)
//        Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
//        No whitespaces / underscore
//

public class Alphanumeric {

    public static boolean alphanumeric(String s){
        int len = s.length();
        boolean rtn;
        if(len==0) return false;
        else if((s.contains(" "))||(s.contains("\\n"))||(s.contains("\\t"))||(s.contains("_")))
            return false;
        for(int i=0;i<len;i++) {
            char c = s.charAt(i);
            int j = (int) c;
            if(!(((48<=j)&&(j<=57))||((65<=j)&&(j<=90))||((97<=j)&&(j<=122)))) {
                //if(!((""+c).contains("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"))) {
                System.out.println("Came here and c is "+c);
                return false; }
        }
        return true;
    }

}

// Other solutions:

//public class SecureTester{
//
//    public static boolean alphanumeric(String s) {
//        return s.matches("[a-zA-Z0-9]+");
//    }
//
//}



//public class SecureTester{
//
//    public static boolean alphanumeric(String s){
//        if (s.isEmpty()) return false;
//
//        char [] alphanumerics = s.toCharArray();
//
//        for (char x: alphanumerics) {
//            if( (x < 48 || x > 57 ) && (x < 65 || x > 90) && (x < 97 || x > 122)) return false;
//        }
//
//        return true;
//    }
//
//}