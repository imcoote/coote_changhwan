/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(N logN)
 *      -> 전체 시간복잡도는 힙에 원소를 삽입하고 삭제하는 연산을 N번 반복하므로 O(N log N)이다
 * 메모리: 26980 kb
 * 시간: 472 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 절대값_힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Comparator 클래스를 활용해서
        // 절댓값으로 먼저 비교하고 같다면 오름차순으로 정렬
        PriorityQueue<Integer> absoluteHeap = new PriorityQueue<>(Comparator
                .comparingInt((Integer x) -> Math.abs(x))
                .thenComparing(x -> x));

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (absoluteHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(absoluteHeap.poll());
                }
            } else {
                absoluteHeap.offer(num);
            }
        }
    }
}
