package dars8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String matn = "+998941233107";
        String pattern = "\\+998\\d{9}";

        Pattern p =  Pattern.compile(pattern);
        Matcher m = p.matcher(matn);

        System.out.println(p.matcher(matn).matches());
    }
}
