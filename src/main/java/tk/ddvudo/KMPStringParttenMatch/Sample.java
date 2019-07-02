package tk.ddvudo.KMPStringParttenMatch;

public class Sample {
    public static void main(String... args) {
        String p = "ababaaaba";
        //011234223
        int[] next = get_next(p);
        for (int i : next) {
            System.out.print(i + " , ");
        }
    }

    private static int[] get_next(String t) {
        int[] next = new int[t.length()];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length(); j++) {
            k = next[j - 1];
            while (k != -1) {
                if (t.charAt(j - 1) == t.charAt(k)) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }
}
