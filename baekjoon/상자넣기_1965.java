/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(N^2)
 * 메모리: 14400 kb
 * 시간: 124 ms
 *******************************************************************************/

// 최장 증가 부분 수열(LIS)

import java.io.*;
import java.util.*;

public class 상자넣기_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; 
        }

        // LIS 알고리즘 -> 앞에서부터 차례대로 확인
        for (int i = 0; i < N; i++) {
            // i보다 앞에 있는 상자들 중에서
            for (int j = 0; j < i; j++) {
                // 현재 상자보다 작은 상자가 있다면, 그 상자까지 넣은 개수 + 1과 비교
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}