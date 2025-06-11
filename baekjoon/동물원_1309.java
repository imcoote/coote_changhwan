/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(N)
 * 메모리: 17628 kb
 * 시간: 116 ms
 *******************************************************************************/

import java.io.*;

public class 동물원_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];

        // 각 행마다 총 3가지 경우의 수 -> 놓지 않거나 / 왼쪽에 놓거나 / 오른쪽에 놓거나
        dp[1][0] = 1; 
        dp[1][1] = 1; 
        dp[1][2] = 1; 

        // 놓지않는 선택을 했을 경우 그전 단계의 모든 경우의 수 들고와도 됨
        // 왼쪽에 놓는 선택은 그전 단계의 왼쪽에 넣는 경우의 수만 빼고
        // 오른쪽도 오른쪽 넣는 경우의 수만 빼고
        for (int i = 2; i <= N; i++) {
            // 숫자 크기 때문에 MOD를 계속 나눠준다
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
        System.out.println(result);
    }
}