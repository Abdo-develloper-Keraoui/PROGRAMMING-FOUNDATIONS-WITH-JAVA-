package Chapter5;

public class FilterEvens {

    public static int[] filterEvens(int[] array) {
        if(array == null) {
            return new int[0];
        }

        // Count evens
        int evensCount = 0;
        for(int val: array) {
            if(val % 2 == 0) {
                evensCount++;
            }
        }

        int[] result = new int[evensCount];
        int index = 0;
        for(int val: array) {
            if(val % 2 == 0) {
                result[index++] = val;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] evens = filterEvens(data);
        for (int val : evens) {
            System.out.print(val + " ");
        }
    }

}
