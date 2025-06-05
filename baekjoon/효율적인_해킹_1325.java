/*******************************************************************************
 * 소요시간: 1시간 10분
 * 시간복잡도: O(N × M)
 * 메모리: 306036 kb
 * 시간: 10852 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 효율적인_해킹_1325 {
    static int N, M;
    static List<Integer>[] graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[B].add(A);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
        }
}

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    result[start]++;
                    q.offer(next);
                }
            }
        }
    }
}
