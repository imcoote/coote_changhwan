/*******************************************************************************
 * 소요시간: 1시간 15분
 * 시간복잡도: O(1)
 * 메모리: 14196 kb
 * 시간: 104 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 걷기_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long answer;

        // 같은 거리인 대각선 이동 비용이 가로 + 세로 비용보다 비쌀경우
        // 직선만 사용해서 이동
        if (s > 2 * w) {
            answer = (x + y) * w;

        // 가로 혹은 세로 한칸 이동하는 비용이 대각선 이동하는 것보다 비싼 경우
        // 대각선으로만 이동!! 그렇지만 모든 케이스에서 대각선으로 이동할 수 없다
        // 좌표값 합이 짝수면 대각선으로만 이동이 가능한데 홀수면 한칸은 직선거리를 이동해야함
        } else if (s <= w) {
            // 좌표값 합이 짝수인 경우
            if ((x + y) % 2 == 0) {
                answer = Math.max(x, y) * s;
            // 좌표값 합이 홀수인 경우
            } else {
                answer = (Math.max(x, y) - 1) * s + w;
            }

        // 대각선 이동 비용이 가로 + 세로보다는 싸지만
        // 그렇다고 해서 가로 혹은 세로 한칸 이동하는 것보다는 비싼 경우
        // 대각선으로 이동후 남은 거리는 직선으로 이동해야 한다
        } else {
            long min = Math.min(x, y);
            long diff = Math.abs(x - y);
            answer = min * s + diff * w;
        }

        System.out.println(answer);
    }
}