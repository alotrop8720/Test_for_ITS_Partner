package base_classes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    /**
     * Find matcher IP for data text.
     * @param text
     * @return string IP.
     */
    public static String getIpAddress(String text){
        Pattern r = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        Matcher m = r.matcher(text);

        List<String> matches = new ArrayList<String>();

        while (m.find())
        {
            matches.add(m.group());
        }
        return matches.get(0);
    }
}
