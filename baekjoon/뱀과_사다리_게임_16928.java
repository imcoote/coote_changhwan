/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(1)
 * 메모리: 14388 kb
 * 시간: 116 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 뱀과_사다리_게임_16928 {
    // 사다리와 뱀의 연결 정보를 담는 배열
    // map[i] = i번 칸에 도착했을 때 최종적으로 도착하는 칸
    // dist[i] = i번 칸까지 도달하는 데 필요한 주사위 횟수
    static int[] map = new int[101];
    static int[] dist = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // map[i] = i로 초기화 (이동 없는 기본 상태)
        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }

        // 사다리 입력 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from] = to;
        }

        // 뱀 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from] = to;
        }

        // BFS 탐색 시작
        bfs();

        // 100번 칸까지 가기 위해 최소 몇 번 주사위를 굴렸는지 출력
        System.out.println(dist[100]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        dist[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int dice = 1; dice <= 6; dice++) {
                int next = now + dice;
                if (next > 100) continue; // 100번 초과는 이동 불가

                // 사다리/뱀 존재 시 map[next]로 즉시 이동
                int target = map[next];

                // 처음엔 visited를 안 썼다가 같은 칸이 큐에 여러 번 들어가서 비효율 발생
                // visited[target] 체크로 이미 방문한 노드는 재방문하지 않음
                // dist가 최소가 된다는 뜻은 어떤 경로 든지 먼저 도착하는 경로가 가장 최소기 때문에
                // 가장 먼저 입력이 된것이 최소
                if (!visited[target]) {
                    visited[target] = true;
                    dist[target] = dist[now] + 1;
                    q.offer(target);
                }
            }
        }
    }
}

