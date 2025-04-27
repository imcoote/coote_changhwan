/*******************************************************************************
 * 소요시간: 45분
 * 시간복잡도: O(K)
 * 메모리: 14344 kb
 * 시간: 104 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 회전하는_큐_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> targets = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            targets.add(Integer.parseInt(st.nextToken()));
        }

        // 값이 정해져 있지는 않지만 인덱스로 값도 통일하기
        // 큐 초기화: 1부터 N까지
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int total = 0;

        for (int target : targets) {
            int idx = 0;
            for (int num : deque) {
                if (num == target) break;
                idx++;
            }

            // 왼쪽으로 회전, 오른쪽으로 회전 중에 선택하기
            int left = idx;
            int right = deque.size() - idx;

            if (left <= right) {
                // 왼쪽으로 회전
                for (int i = 0; i < left; i++) {
                    deque.offerLast(deque.pollFirst());
                    total++;
                }
            } else {
                // 오른쪽으로 회전
                for (int i = 0; i < right; i++) {
                    deque.offerFirst(deque.pollLast());
                    total++;
                }
            }

            // 맨 앞에서 제거하기
            deque.pollFirst();
        }

        System.out.println(total);
    }
}
