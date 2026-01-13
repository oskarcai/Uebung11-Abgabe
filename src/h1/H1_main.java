package h1;

public class H1_main {
    public static void main(String[] args){
        Node e = new Node(null);
        Node d = new Node(e);
        Node c = new Node(d);
        Node b = new Node(c);
        Node a = new Node(b);
        // a -> b -> c -> d -> e -> null

        System.out.println(distance(a,d));
    }

    public static int distance(Node x, Node y) {
        if (x.equals(y)) return 0;
        return 1 + distance(x.getNext(), y);
    }

    /* distance(a,d);
        -> 1 + distance(b,d);
            -> 1 + distance(c,d);
                -> 1 + distance(d,d);
                    -> 0;
     */

}
