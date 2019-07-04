package tk.ddvudo.KMPStringParttenMatch;

public class KMPSample {
    public static void main(String... args) {
        String p = "ababaaaba";
        //011234223
        System.out.println(violentMatch(p, "baaa"));
        int[] next = get_next(p);
        for (int i : next) {
            System.out.print(i + " , ");
        }
    }

    public static int violentMatch(String p, String t) {
        for (int i = 0, j = 0; i < p.length() && j < t.length(); ) {
            if (p.charAt(i) != t.charAt(j)) {
                i = i - j + 1;
                j = 0;
            } else {
                i++;
                j++;
            }
            if (j == t.length()) {
                return j - 1;
            }
        }
        return -1;
    }

    private static int[] get_next(String p) {
        int[] next = new int[p.length() + 10];
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
