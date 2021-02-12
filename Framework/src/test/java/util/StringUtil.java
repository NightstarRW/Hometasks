package util;

import exception.CantFoundEstimateCost;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static double getDoubleValueFromString(String input) {
        Pattern pattern = Pattern.compile("\\d+[,]?\\d+[.]\\d+");
        Matcher matcher = pattern.matcher(input);
        String output;
        if (matcher.find()) {
            output = matcher.group(0);
        } else {
            throw new CantFoundEstimateCost("Can't found a double value in string");
        }
        return Double.parseDouble(output.replace(",", ""));
    }
}
