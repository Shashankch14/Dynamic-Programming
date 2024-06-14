/*
Problem Statement
There are 𝑁 stones, numbered 1,2,…,𝑁1,2,…,N. For each 𝑖 (1≤𝑖≤𝑁1≤i≤N), the height of Stone 𝑖 is ℎ𝑖​.

There is a frog who is initially on Stone 11. He will repeat the following action some number of times to reach Stone 𝑁:

If the frog is currently on Stone 𝑖, jump to Stone 𝑖+1 or Stone 𝑖+2. Here, a cost of ∣ℎ𝑖−ℎ𝑗∣ is incurred, where 𝑗 is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone 𝑁.
I/P
4
10 30 40 20
O/P
30
--If we follow the path 1 → 2 → 4, the total cost incurred would be 
∣10−30∣+∣30−20∣=30.

*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] b = new long[n+1];
        
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextLong();
        }
        
        long[] dp = new long[n+1];
        
        dp[1] = 0;
        dp[2] = Math.abs(b[1] - b[2]);
        
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + Math.abs(b[i] - b[i-1]), dp[i-2] + Math.abs(b[i] - b[i-2]));
        }
        
        System.out.println(dp[n]);
    }
}
