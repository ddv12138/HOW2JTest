package tk.ddvudo.KMPStringParttenMatch;

import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KMPSample {
    private static Logger logger = LoggerFactory.getLogger(KMPSample.class.getName());

    public static void main(String... args) {
        String p = "ababbaaa";
        int[] next = new int[]{0, 0, 1, 2, 0, 0, 0, 0};
//        logger.info(violentMatch(p, "baaa") + "");
        logger.info(KMPMatch(p, "baaa", next) + "");
    }

    private static int KMPMatch(String p, String t, int[] next) {
        int i = 0, j = 0;
        while (i < p.length() && j < t.length()) {
            if (p.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = next[i];
                logger.info("next-->" + next[i]);
            }
            if (j == t.length()) {
                return i - j;
            }
        }
        return -1;
    }

    private static int violentMatch(@NotNull String p, String t) {
        int i = 0, j = 0;
        while (i < p.length() && j < t.length()) {
            if (p.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == t.length()) {
                return i - j;
            }
        }
        return -1;
    }

    //@TODO: 2019-7-17 写不出来了，先放着
    private static int[] get_next(String p) {
        int[] next = new int[p.length()];
        int i = 1, j = 0;
        while (i < p.length()) {
            if (j == 0 || p.charAt(i) == p.charAt(j)) {
                ++i;
                ++j;
                next[i - 1] = j;
            } else {
                j = next[j - 1];
            }
        }
        return next;
    }
}
