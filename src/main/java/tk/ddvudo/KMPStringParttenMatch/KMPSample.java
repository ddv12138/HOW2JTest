package tk.ddvudo.KMPStringParttenMatch;

import com.alibaba.fastjson.JSON;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KMPSample {
    private static Logger logger = LoggerFactory.getLogger(KMPSample.class.getName());

    public static void main(String... args) {
        String s = "abababaaa";
        String p = "abaa";
        int[] next = get_next(s);
        logger.info("next-->" + JSON.toJSONString(next));
        logger.info(violentMatch(s, p) + "");
        logger.info(KMPMatch(s, p, next) + "");
    }

    private static int KMPMatch(String p, String t, int[] next) {
        int i = 0, j = 0, count = 0;
        while (i < p.length() && j < t.length()) {
            if (j == 0 || p.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            count++;
            if (j == t.length()) {
                logger.info("count-->" + count);
                return i - j;
            }
        }
        return -1;
    }

    private static int violentMatch(@NotNull String p, String t) {
        int i = 0, j = 0, count = 0;
        while (i < p.length() && j < t.length()) {
            if (p.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            count++;
        }
        if (j == t.length()) {
            logger.info("count-->" + count);
            return i - j;
        }
        return -1;
    }

    private static int[] get_next(String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
