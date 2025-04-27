/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(N + M)
 * 메모리: 142044 kb
 * 시간: 624 ms
 *******************************************************************************/

import java.util.*;
import java.io.*;

public class 연결_요소의_개수_11724 {
    // 연결요소는 서로 연결되어 있는 정점들의 집합임
    // 서로 연결되어있으면 하나의 집합

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점과 간선 갯수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;

        // dfs로 탐색하다가 새로운 그룹 발견하면 count + 1
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int node) {
        visited[node] = true;

        // for-each로 node랑 연결되어있는 번호 방문
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
