/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(n)
 * 메모리: 14180 kb
 * 시간: 100 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 포도주_시식_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }


        // 포도주 잔이 2개 이하인 경우 !!
        // --> 다 마셔야 최대 시식
        dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];

        // 포도주 잔이 3개 이상인 경우
        for (int i = 3; i <= n; i++) {
            int case1 = dp[i - 1];
            int case2 = dp[i - 2] + wine[i];
            int case3 = dp[i - 3] + wine[i - 1] + wine[i];

            dp[i] = Math.max(case1, Math.max(case2, case3));
        }

        System.out.println(dp[n]);
    }
}