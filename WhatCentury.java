public class WhatCentury{
    public static String whatCentury(int year) {

        int century = year%100==0 ? year/100 : year/100 +1;
        String year_s = Integer.toString(century);

        //if(year==2000) return "20th";

        if((century==11)||(century==12)||(century==13)) return year_s+"th";

        else {
            switch(century%10) {
                case 0:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9: year_s+="th"; break;
                case 1: year_s+="st"; break;
                case 2: year_s+="nd"; break;
                case 3: year_s+="rd";
            }
        }

        return year_s;
    }
}


// Other solutions:

//public class Solution{
//    public static String whatCentury(int year) {
//        int century = (year + 99) / 100;
//        if (century / 10 == 1) return century + "th";
//        switch(century % 10) {
//            case 1: return century + "st";
//            case 2: return century + "nd";
//            case 3: return century + "rd";
//            default: return century + "th";
//        }
//    }
//}


//public class Solution{
//    public static String whatCentury(int year) {
//
//        int century = year/100;
//        if (year%100 > 0) {
//            century++;
//        }
//
//        String ending = "";
//
//        if(century == 11 || century == 12 || century == 13) ending = "th";
//        else if(String.valueOf(century).endsWith("1")) ending = "st";
//        else if(String.valueOf(century).endsWith("2")) ending = "nd";
//        else if(String.valueOf(century).endsWith("3")) ending = "rd";
//        else ending = "th";
//
//        return century + ending;
//    }
//}


//import static java.util.Map.of;
//
//interface Solution {
//    static String whatCentury(int y) {
//        return (y = (int) Math.ceil(y / 100.)) + of(1, "st", 2, "nd", 3, "rd").getOrDefault(y > 13 ? y % 10 : 0, "th");
//    }
//}

//public class Solution{
//    public static String whatCentury(int year) {
//        int c = (int)Math.ceil(year/100.), a = c%100, b = c%10;
//        return c + (10 < a && a < 14 ? "th" : b == 1 ? "st" : b == 2 ? "nd" : b == 3 ? "rd" : "th");
//    }
//}

//public class Solution{
//    public static String whatCentury(int x) {
//
//
//        if (((x/100)%10==0) && (x>2000)) return String.valueOf((x/100)+1)+"st";
//        if (((x/100)%10==1)&& (x>2000)) return String.valueOf((x/100)+1)+"nd";
//        if (((x/100)%10==2)&& (x>2000)) return String.valueOf((x/100)+1)+"rd";
//        if(x%100==0) return String.valueOf((x/100))+"th";
//        else return String.valueOf(x/100+1) +"th";
//
//
//
//    }
//}

