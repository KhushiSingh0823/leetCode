import java.util.Arrays;

public class Convert {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][];
        
        switch (m * n == original.length ? 1 : 0) {
            case 1:
                int i = 0;
                while (i < m) {
                    result[i] = Arrays.copyOfRange(original, i * n, i * n + n);
                    i++;
                }
                break;
            default:
                return new int[0][0];
        }

        return result;
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        int[] original = {1, 2, 3, 4, 5, 6};
        int m = 2;
        int n = 3;
        int[][] result = convert.construct2DArray(original, m, n);
        
        // Print the result
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
