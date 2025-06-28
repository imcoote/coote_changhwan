/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n)
 * 메모리: 14052 kb
 * 시간: 104 ms
 *******************************************************************************/

import java.io.*;

public class 계단_오르기_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n + 1];
        int[] step = new int[n + 1]; 
        
        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = step[1];
        if (n >= 2) dp[2] = step[1] + step[2];
        if (n >= 3) dp[3] = Math.max(step[1] + step[3], step[2] + step[3]);

        for (int i = 4; i <= n; i++) {
            int case2 = dp[i - 2] + step[i];
            int case3 = dp[i - 3] + step[i - 1] + step[i];

            dp[i] = Math.max(case2, case3);
        }

        System.out.println(dp[n]);
    }
}
