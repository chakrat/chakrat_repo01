//Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').
//
//        Examples:
//
//        * 'abc' =>  ['ab', 'c_']
//        * 'abcdef' => ['ab', 'cd', 'ef']


import java.util.ArrayList;

public class StringSplit {
    public static String[] solution(String s) {

        int len = s.length();
        ArrayList<String> arrList = new ArrayList<>();
        // String[] strList = new String[len/2];

        if(len%2==0) {
            for(int j=0;j<len;j=j+2) {
                String two = s.substring(0,2);
                //System.out.println("now j is "+j);
                s = s.substring(2,s.length());
                //System.out.println("now s is "+s);
                arrList.add(two);
            }
        }

        else {// len is odd number
            for(int j=0;j<len-1;j=j+2) {
                String two = s.substring(0,2);
                s = s.substring(2,s.length());
                arrList.add(two);
            }
            arrList.add(s.charAt(0)+"_");

        }

        String[] strList = arrList.toArray(new String[0]);
        return strList;
    }
}

/***
// other way:
public class StringSplit {
    public static String[] solution(String s) {
        s = (s.length() % 2 == 0)?s:s+"_";
        return s.split("(?<=\\G.{2})");
    }
}

 public class StringSplit {
 public static String[] solution(String s) {
 return s.length() % 2 == 0 ? s.split("(?<=\\G.{2})")
 : (s + "_").split("(?<=\\G.{2})");
 }
 }

 public class StringSplit {
 public static String[] solution(String s) {
 //Write your code here
 if(s.length()%2==1) s+="_";
 int n=s.length()/2;


 String[] sub=new String[n];
 for(int i=0;i<n;++i)
 sub[i]=""+s.charAt(i*2)+s.charAt(1+i*2);

 return sub;
 }
 }

 ***/