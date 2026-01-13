package p2;

public class P2_main {
    public static void main(String[] args) {
        System.out.println(log_2_i(32));
        System.out.println(log_2_r(32));
    }

    // Iterativer Logarithmus:
    public static int log_2_i(int n) {
        int count = 1;
        while(n != 2) {
            n /= 2;
            count++;
        }
        return count;
    }

    // Rekursiver Logarithmus:
    public static int log_2_r(int n) {
        if(n == 1) return 0;
        return 1 + log_2_r(n / 2);
    }
    /* Beispiel: n = 16
        -> log_2(16)
            -> 1 + log_2(8)
                -> 1 + log_2(4)
                    -> 1 + log_2(2)
                        -> 1 + log_2(1)
                                 -> 0
     */

}
