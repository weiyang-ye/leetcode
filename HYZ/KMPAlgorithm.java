import java.util.Arrays;

/**
 * @author jude
 * @create 2022-09-02-15:19
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";
        int[] next = getNext(s2);
        System.out.println(Arrays.toString(next));
        System.out.println(KMP(s1,s2));
    }

    public static int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];

            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int KMP(String s1, String s2) {
        int[] next = getNext(s2);
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

}
