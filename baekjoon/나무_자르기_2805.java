/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(N * log(maxHeight))
 * 메모리: 119560 kb
 * 시간: 528 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 나무_자르기_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = Arrays.stream(trees).max().getAsInt();
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = Arrays.stream(trees)
                             .mapToLong(tree -> Math.max(tree - mid, 0))
                             .sum();

            if (sum >= M) {
                answer = mid;       
                left = mid + 1;
            } else {
                right = mid - 1;    
            }
        }

        System.out.println(answer);
    }
}
