/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(n log n))
 * 메모리: 25452 kb
 * 시간: 336 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 카드_정렬하기_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long total = 0;
        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;
            total += sum;
            pq.add(sum);
        }

        System.out.println(total);
    }
}
