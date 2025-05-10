/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(O((n + m) log n))
 * 메모리: 15388 kb
 * 시간: 144 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 카드_합체_놀이_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 알고리즘 분류에 우선순위 큐가 적혀 있는 걸 보고 힌트를 얻었다
        // 그리고 자료형도 Integer로 설정하니까 틀렸다고 떴음;;
        // 계산 하다보면 Integer 자료형의 한계 -> 2,147,483,647 (약 2 × 10⁹)
        // 를 넘었수있기 때문
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;
            pq.add(sum);
            pq.add(sum);
        }

        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }
}
