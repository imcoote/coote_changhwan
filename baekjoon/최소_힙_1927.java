/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(N logN)
 *      -> 전체 시간복잡도는 힙에 원소를 삽입하고 삭제하는 연산을 N번 반복하므로 O(N log N)이다
 * 메모리: 115140 kb
 * 시간: 1564 ms
 *******************************************************************************/

import java.util.*;

public class 최소_힙_1927 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();

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
