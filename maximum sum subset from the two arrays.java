/*
Select maximum sum subset from the two arrays such that no two elements are consecutive.
*/

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] dp = new int[n + 1];
 
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
 
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }
 
        dp[1] = Math.max(a[1], b[1]);
        dp[2] = Math.max(dp[1], Math.max(a[2], b[2]));
 
        for (int i = 3; i <= n; i++) {
            int x = dp[i - 1];
            int y = b[i] + dp[i - 2];
            int z = a[i] + dp[i - 2];
            dp[i] = Math.max(x, Math.max(y, z));
        }
 
        System.out.println("Answer: " + dp[n]);
    }
}
 
