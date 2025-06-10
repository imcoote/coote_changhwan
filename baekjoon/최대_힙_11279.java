/*******************************************************************************
 * 소요시간: 5분
 * 시간복잡도: O(N logN)
 *      -> 전체 시간복잡도는 힙에 원소를 삽입하고 삭제하는 연산을 N번 반복하므로 O(N log N)이다
 * 메모리: 32592 kb
 * 시간: 800 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 최대_힙_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 최소 힙에서 reverseOrder 메서드를 활용해 최대 힙으로 변경
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (maxHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(maxHeap.poll());
                }
            } else {
                maxHeap.offer(num);
            }
        }
    }
}
