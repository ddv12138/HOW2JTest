package tk.ddvudo.KMPStringParttenMatch;

public class Sample {
    public static void main(String... args) {
        String p = "ababaaaba";
        int[] next = get_next(p);
        for (int i : next) {
            System.out.print(i + " , ");
        }
    }

    private static int[] get_next(String p) {
        int[] next = new int[p.length() + 1];
        int i = 1, j = 0;
        next[1] = 1;
        while (i < p.length()) {
            if (j == 0 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
