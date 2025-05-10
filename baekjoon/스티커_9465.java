/*******************************************************************************
 * 소요시간: 1시간 10분
 * 시간복잡도: O(T × n)
 * 메모리: 111072 kb
 * 시간: 624 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 스티커_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수 입력받기
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[2][n + 1];

            // i행 j열 선택했을 때 최대 점수 기록하기 위한 배열
            int[][] dp = new int[2][n + 1];

            // 스티커 점수 입력
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값 설정
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            // 왼쪽에서 오른쪽으로 선택해 나가면서 최댓값을 구함
            for (int i = 2; i <= n; i++) {
                // 현재 윗줄(j열)을 선택하려면:
                // 1. 이전 열의 아랫줄에서 오거나
                // 2. 전전 열의 아랫줄에서 오는 경우 중 최대 선택
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];

                // 현재 아랫줄(j열)을 선택하려면:
                // 1. 이전 열의 윗줄에서 오거나
                // 2. 전전 열의 윗줄에서 오는 경우 중 최대 선택
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
