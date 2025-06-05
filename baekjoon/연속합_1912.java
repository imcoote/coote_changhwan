/*******************************************************************************
 * 소요시간: 1시간 20분
 * 시간복잡도: O(n)
 * 메모리: 23280 kb
 * 시간: 236 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 연속합_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = num[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            // num[i]값과 이전 최댓값에서 num[i] 더한값 중에 뭐가 더 높은 값일지 결정
            dp[i] = Math.max(num[i], dp[i-1] + num[i]);

            // dp 중에 최댓값 갱신
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}