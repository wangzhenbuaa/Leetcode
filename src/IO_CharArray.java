import java.util.Scanner;

public class IO_CharArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        char[][] Graph = new char[m][n];
        String[] strs = new String[m];
        for (int i = 0; i < m; i++) {
            strs[i] = sc.nextLine();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Graph[i][j] = strs[i].charAt(2*j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
