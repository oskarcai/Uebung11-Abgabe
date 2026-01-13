package p3;

public class P3_main {
    public static void main(String[] args) {
        int zins = verzinsung(1004,2);
        System.out.println(zins);
    }

    // Verzingung des Kaptitals nach n Jahren zu 5% Zinsen (jährliche Zinsen werden abgerundet auf Euro)
    public static int verzinsung(double kapital, int n) {
        double zinssatz = 1.05;

        if (n == 0) return (int)kapital;

        return (int)(zinssatz * verzinsung(kapital, n-1));
    }

    /*
         Für kapital = 100; n = 4;

    -> verzinsung(100, 4);
          -> 1.05 * verzinsung(100, 3);
                  -> 1.05 * verzinsung(100, 2);
                            -> 1.05 * verzinsung(100, 1);
                                      -> 1.05 * verzinsung(100, 0);
                                                -> 100
    */

}
