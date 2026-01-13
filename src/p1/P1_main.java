package p1;

public class P1_main {
    public static void main(String[] args) {
        double potenz_iterativ = potenzieren_i(5.2,10);
        double potenz_rekursiv = potenzieren_r(5.2,10);

        System.out.println(potenz_iterativ);
        System.out.println(potenz_rekursiv);
    }

    // Iteratives Potenzieren:
    public static double potenzieren_i(double a, int b) {
        double potenz = 1;
        for(int i = 0; i < b; i++) {
            potenz *= a;
        }
        return potenz;
    }

    // Rekursives Potenzieren:
    public static double potenzieren_r(double a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;

        return a * potenzieren_r(a,b-1);
    }

}
