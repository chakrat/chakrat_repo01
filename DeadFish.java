//Write a simple parser that will parse and run Deadfish.
//
//        Deadfish has 4 commands, each 1 character long:
//
//        i increments the value (initially 0)
//        d decrements the value
//        s squares the value
//        o outputs the value into the return array
//        Invalid characters should be ignored.
//
//        Deadfish.parse("iiisdoso") =- new int[] {8, 64};



import java.util.ArrayList;

public class DeadFish {
    public static int[] parse(String data) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        int val =0;

        for(int i=0;i<data.length();i++)
            switch(data.charAt(i)) {
                case 'i' : val++; break;
                case 'd' : val--; break;
                case 's' : val = val*val; break;
                case 'o' : arrList.add(val); break;
                default  : ;
            }
        int[] outputArray = new int[arrList.size()];

        for(int i=0;i<arrList.size();i++) {
            outputArray[i] = arrList.get(i);
        }


        return outputArray;
    }
}


//import java.util.ArrayList;
//        import java.util.List;
//
//public class DeadFish {
//    public static int[] parse(String data) {
//        int value = 0;
//        List<Integer> result = new ArrayList<>();
//        for(char letter : data.toCharArray()) {
//            switch(letter) {
//                case 'i': value++; break;
//                case 'd': value--; break;
//                case 's': value *= value; break;
//                case 'o': result.add(value); break;
//                default: throw new IllegalArgumentException("Not valid code letter");
//            }
//        }
//        return result.stream().mapToInt(Integer::intValue).toArray();
//    }
//}



//public class DeadFish {
//
//    public static int[] parse(String data) {
//        int v = 0, i = 0, ret[] = new int[data.replaceAll("[^o]","").length()];
//        for (char c : data.toCharArray()) {
//            switch (c) {
//                case 'i' : v++;        break;
//                case 'd' : v--;        break;
//                case 's' : v=v*v;      break;
//                case 'o' : ret[i++]=v; break;
//            }
//        }
//        return ret;
//    }
//
//}

