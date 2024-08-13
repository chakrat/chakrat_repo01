import java.util.Arrays;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.lang.Character;

public class JadenCase {

    public String toJadenCase(String phrase) {
        // TODO put your code below this comment

        if((phrase==null)||(phrase=="")) return null;

        String[] strSplit = phrase.split(" ");
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));

        int word_count = strList.size();

        StringBuilder sb = new StringBuilder("");
        for (int i=0;i<word_count-1;i++)
            sb.append(capitalize(strList.get(i))).append(" ");
        sb.append(capitalize(strList.get(word_count-1)));

        return sb.toString();
    }

    public String capitalize(String input) {
        char c = input.charAt(0);
        c= Character.toUpperCase(c);
        StringBuilder sb = new StringBuilder(("")+c);
        return sb.append(input.substring(1,input.length())).toString();
    }

}