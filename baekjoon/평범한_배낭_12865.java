/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(N × K)
 * 메모리: 16212 kb
 * 시간: 160 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

// 0-1 knapsack problem 문제

public class 평범한_배낭_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 물건 갯수 N, 허용 무게 K 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // "무게별" 최대 가치를 나타내는 배열 선언
        int[] dp = new int[K + 1];

        // 각 물건에 대해 반복
        for (int i = 0; i < N; i++) {
            // 물건의 무게와 가치 입력 받기
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // 뒤에서부터 순회: 같은 물건을 중복으로 넣는 것 방지
            // <<이건 찾아보고 한거라 완벽히 이해는 못했음>>
            for (int j = K; j >= weight; j--) {
                // 각 선택마다 해당 물건을 넣을 때랑 안넣을때랑 가치 비교하기!!
                // dp[j - weight] + value -> 이게 넣는 경우
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        // 최종 출력: 배낭 최대 무게에서의 최대 가치
        System.out.println(dp[K]);
    }
}