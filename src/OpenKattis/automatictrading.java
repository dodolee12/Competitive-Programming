package OpenKattis;

import java.util.*;

class automatictrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int q = sc.nextInt();

        for (int i = 0; i < q; ++i) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            System.out.println(solve(s, left, right));
        }

        sc.close();
    }

    public static int solve(String s, int i, int j) {
        int len = 0;
        while (i < s.length() && j < s.length() && s.charAt(i) == s.charAt(j)) {
            ++len;
            ++i;
            ++j;
        }
        return len;
    }
}
