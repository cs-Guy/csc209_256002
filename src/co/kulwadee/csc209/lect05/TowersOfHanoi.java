package co.kulwadee.csc209.lect05;

/**
 * https://introcs.cs.princeton.edu/java/23recursion/TowersOfHanoi.java.html
 */
public class TowersOfHanoi {
    public static void moves(int n, boolean left) {
        if (n == 0) return;
        moves(n-1, !left);
        if (left) System.out.println(n + " left");
        else      System.out.println(n + " right");
        moves(n-1, !left);
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        moves(n, true);
    }
}
