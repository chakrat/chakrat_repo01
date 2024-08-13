import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;

public class SpinWords {

    public String spinWords(String sentence) {

        if(!sentence.contains(" ")){
            if(sentence.length()>5)
                return reverse(sentence);
            else
                return sentence;
        }
        
        String[] strSplit = sentence.split(" ");
        ArrayList<String> strList = new ArrayList<String>(
                Arrays.asList(strSplit));
        int word_count=strList.size();
        for (int i=0;i<word_count;i++) {
            if(strList.get(i).length() >= 5)
            {
                String rev = reverse(strList.get(i));
                strList.set(i,rev);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i=0;i<word_count-1;i++)
            sb.append(strList.get(i)).append(" ");
        sb.append(strList.get(word_count-1));

        return sb.toString();

    }

    public String reverse(String original) {
        StringBuilder sb = new StringBuilder(original);
        return sb.reverse().toString();
    }
}