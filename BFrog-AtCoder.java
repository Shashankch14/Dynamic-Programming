/*
There are N stones, numbered 1,2,…,N. For each i (1≤i≤N), the height of Stone i is h i​ .
There is a frog who is initially on Stone 
1. He will repeat the following action some number of times to reach Stone N:If the frog is currently on Stone i, jump to one of the following: Stone 
i+1,i+2,…,i+K. Here, a cost of ∣hi − hj∣ is incurred, where j is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone 
N.
I/P
5 3
10 30 40 50 20
O/P
30
If we follow the path 1 →2 → 5, the total cost incurred would be ∣10−30∣+∣30−20∣=30.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();

        long[] b = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextLong();
        }

        long[] dp = new long[n + 1];

        // Initialize dp array
        for (int i = 1; i <= n; i++) {
            dp[i] = Long.MAX_VALUE;
        }

        dp[1] = 0;
        dp[2] = Math.abs(b[1] - b[2]);

        int i = 3;
        while (i <= n) {
            long answer = Long.MAX_VALUE;
            int j = 1;
            while (j <= k && i - j >= 1) {
                long yy = dp[i - j] + Math.abs(b[i] - b[i - j]);
                answer = Math.min(answer, yy);
                j++;
            }
            dp[i] = answer;
            i++;
        }

        System.out.println(dp[n]);
    }
}
