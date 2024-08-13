//The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must be rounded to the closest valid value.
//
//        Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
//
//        Examples (input --> output):
//        255, 255, 255 --> "FFFFFF"
//        255, 255, 300 --> "FFFFFF"
//        0, 0, 0       --> "000000"
//        148, 0, 211   --> "9400D3"

import java.lang.StringBuilder;

public class RgbToHex {

    public static String rgb(int r, int g, int b) {

        StringBuilder sb = new StringBuilder("");
        sb = sb.append(Int2Hex(r));
        sb = sb.append(Int2Hex(g));
        sb = sb.append(Int2Hex(b));
        return sb.toString();
    }

    public static String Int2Hex(int p) {

        StringBuilder sb = new StringBuilder("");

        if(p>255) return "FF";
        else if(p<0) return "00";
        else {
            int quotient = p/16;
            int residual = p%16;
            switch(quotient) {
                case 0: sb.append("0"); break;
                case 1: sb.append("1"); break;
                case 2: sb.append("2"); break;
                case 3: sb.append("3"); break;
                case 4: sb.append("4"); break;
                case 5: sb.append("5"); break;
                case 6: sb.append("6"); break;
                case 7: sb.append("7"); break;
                case 8: sb.append("8"); break;
                case 9: sb.append("9"); break;
                case 10: sb.append("A"); break;
                case 11: sb.append("B"); break;
                case 12: sb.append("C"); break;
                case 13: sb.append("D"); break;
                case 14: sb.append("E"); break;
                case 15: sb.append("F");
            }
            if(residual<=9) sb.append(String.valueOf(residual));
            else {
                switch(residual) {
                    case 10: sb.append("A"); break;
                    case 11: sb.append("B"); break;
                    case 12: sb.append("C"); break;
                    case 13: sb.append("D"); break;
                    case 14: sb.append("E"); break;
                    case 15: sb.append("F");
                }
            }
        }
        return sb.toString();

    }


}

//import java.util.stream.Collectors;
//        import java.util.stream.Stream;
//
//public class RgbToHex {
//
//    public static String rgb(int r, int g, int b) {
//
//        return Stream.of(r, g, b)
//                .map(i -> Math.max(0, i))
//                .map(i -> Math.min(255, i))
//                .map(i -> String.format("%02X", i))
//                .collect(Collectors.joining());
//    }
//}