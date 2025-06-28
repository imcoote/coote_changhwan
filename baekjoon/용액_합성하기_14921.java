/*******************************************************************************
 * 소요시간: 50분
 * 시간복잡도: O(N)
 * 메모리: 25140 kb
 * 시간: 296 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 용액_합성하기_14921{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] liquid = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int closeToZero = Integer.MAX_VALUE;
        int result = 0;

        while (left < right) {
            int sum = liquid[left] + liquid[right];

            if (Math.abs(sum) < closeToZero) {
                closeToZero = Math.abs(sum);
                result = sum;
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result);
    }
}