/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(T(N + M))
 * 메모리: 55012 kb
 * 시간: 384 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 상근이의_여행_9372 {
    // 그래프 인접 리스트, 방문여부, 사용한 비행기 수 변수 설정
    static List<Integer>[] graph;
    static boolean[] visited;
    static int planesCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 국가수, 비행기 수 입력받기
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 비행기 정보 입력 (양방향)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            visited = new boolean[N + 1];
            planesCount = 0;

            // 1번 부터 dfs 시작
            dfs(1);

            // 비행기 탄 최소 횟수 출력
            System.out.println(planesCount);
        }
    }

    // DFS로 그래프 탐색하면서
    // 새로운 나라 방문 할때 비행기 사용
    private static void dfs(int curr) {
        visited[curr] = true;

        for (int next : graph[curr]) {
            if (!visited[next]) {
                planesCount++;
                dfs(next);
            }
        }
    }
}