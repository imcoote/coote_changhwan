/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(N logN)
 *      -> 전체 시간복잡도는 힙에 원소를 삽입하고 삭제하는 연산을 N번 반복하므로 O(N log N)이다
 * 메모리: 32596 kb
 * 시간: 792 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 최소_힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(minHeap.poll());
                }
            } else {
                minHeap.offer(num);
            }
        }
    }
}
