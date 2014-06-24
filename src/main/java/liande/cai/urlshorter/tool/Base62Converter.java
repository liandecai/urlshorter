package liande.cai.urlshorter.tool;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Description:
 * 
 * @author liandecai
 * @time Jun 20, 2014
 */
public class Base62Converter {

    private static final int BASE = 62;
    private static final List<Character> charmap = ImmutableList.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static String dec2base62(int num) {

        StringBuffer url = new StringBuffer();
        while (num != 0) {
            url.append(charmap.get(num % BASE));
            num = num / BASE;
        }
        return url.reverse().toString();
    }

    public static int base622dec(String shortURL) {
        int mul = 1;
        int result = 0;
        for (int i = shortURL.length() - 1; i >= 0; i--) {
            result += mul *charmap.indexOf(shortURL.charAt(i));
            mul *= BASE;
        }
        return result;
    }
}
