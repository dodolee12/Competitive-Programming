package OpenKattis;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class wizardofodds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger();
        BigInteger k = sc.nextBigInteger();

        System.out.println(wizardOfOdds(n, k));

        sc.close();
    }

    // binary search method is most optimal so finding log_2(n) <= k will always
    // answer the problem correctly
    private static String wizardOfOdds(BigInteger n, BigInteger k) {
        return (new BigDecimal(Math.log(n.doubleValue()) / Math.log(2))).compareTo(new BigDecimal(k)) <= 0
                ? "Your wish is granted!"
                : "You will become a flying monkey!";
    }
}
