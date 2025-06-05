/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(n + m)
 * 메모리: 14144 kb
 * 시간: 100 ms
 *******************************************************************************/

// 이 문제도 양방향 그래프 만들어 bfs 돌리기

import java.io.*;
import java.util.*;

public class 촌수계산_2644 {
    static int n, start, end, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        m = Integer.parseInt(br.readLine());

        // 부모 자식간 양방향 관계 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph[parent].add(child);
            graph[child].add(parent);
        }

        System.out.println(bfs(start, end));
    }

    static int bfs(int now, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{now, 0});
        visited[now] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int person = cur[0];
            int depth = cur[1];

            if (person == target) return depth;

            for (int next : graph[person]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, depth + 1});
                }
            }
        }

        return -1;
    }
}