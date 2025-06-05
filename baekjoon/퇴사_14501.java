/*******************************************************************************
 * 소요시간: 50분
 * 시간복잡도: O(N)
 * 메모리: 15328 kb
 * 시간: 140 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 퇴사_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // T -> i 일부터 걸리는 상담 기간
        // P -> i 일부터 시작했을 때 얻는 이익
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];

        // 보통은 0을 제외하고 1 ~ N 까지의 값을 사용하기 위해 크기는 N + 1
        // !! 하지만 dp 계산에서 수익은 다음날 N + 1 까지 잡아야 하므로 배열 크기를 N + 2로 잡아야함
        // 즉 N + 1 까지 인덱스를 사용해야함
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 오늘 상담하는가? 안하는가?
        for (int i = 1; i <= N + 1; i++) {
            // >> 안한다
            // 이전 날까지의 값을 오늘로 넘겨줘야함
            // 이전 날 값과 현재 값 중 최댓값 선택
            dp[i] = Math.max(dp[i], dp[i - 1]);

            // >> 한다
            // 현재에서 T[i] 날로 점프하고 P[i]을 값을 더한 값인 dp[i] + P[i]와
            // dp[i + T[i]]를 비교해서 선택
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}