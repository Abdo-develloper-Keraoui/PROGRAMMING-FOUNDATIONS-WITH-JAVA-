package Chapter4;

public class MaxFinder {
    /** Method with no overloading!
    public static int max(int a, int b, int c) {
        int max = a;
        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }
        return max;
    }
    */
    public static int max(int a, int b) {
        if(a >= b) {
            return a;
        }
        return b;
    }

    public static int max(int a, int b, int c) {
        return max(max(a,b), c);
    }


        public static void main(String[] args) {
        System.out.println(max(1,5,9));
    }
}
