/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(N)
 * 메모리: 14140 kb
 * 시간: 108 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 카드2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        // N까지 카드 넣기
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 제일 위 카드를 버리고
        // 그 다음 카드는 맨 아래로 이동하기
        // 단 한개 남을 때 까지 반복
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        // 마지막 남은 카드 출력 하기
        System.out.println(queue.poll());
    }
}
