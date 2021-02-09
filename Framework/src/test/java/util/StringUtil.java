package util;

import org.apache.tools.ant.util.StringUtils;

public class StringUtil {

    public static double getDoubleValueFromString(String string, boolean removeMonth) {
        String buffer = string.replaceAll("[^1234567890.]", "");
        if (removeMonth) {
            buffer = StringUtils.removeSuffix(buffer, "1");
        }
        return Double.parseDouble(buffer);
    }

    public static double getDoubleValueFromString(String string) {
        String buffer = string.replaceAll("[^1234567890.]", "");
        return Double.parseDouble(buffer);
    }
}
