/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(C(N, M) × M)
 * 메모리: 15888 kb
 * 시간: 124 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class N과_M_2_15650{
    static int N, M;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];
        dfs(1, 0);
    }

    static void dfs(int start, int len) {
        if (len == M) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            sequence[len] = i;
            dfs(i + 1, len + 1);  
        }
    }
}