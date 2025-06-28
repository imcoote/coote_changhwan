/*******************************************************************************
 * 소요시간: 45분
 * 시간복잡도: O(N + M)
 * 메모리: 14116 kb
 * 시간: 100 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 극장_좌석_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> vipSeatList = new ArrayList<>();
        int[] dp = new int[N+1];

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            vipSeatList.add(num);
        }
        vipSeatList.add(N+1);

        dp[0] = 1;
        dp[1] = 1;

        // vip석이 없다는 가정하에 dp값
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int prevVipSeat = 0;
        int result = 1;

        for (int vipSeat : vipSeatList) {
            result *= dp[vipSeat - prevVipSeat - 1];
            prevVipSeat = vipSeat;
        }

        System.out.println(result);
    }
}
