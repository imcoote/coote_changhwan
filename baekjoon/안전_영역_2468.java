/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(N² × H)
 * 메모리: 55628 kb
 * 시간: 280 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 안전_영역_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxHeight = 0;

        // 지도 입력 및 최대 높이 찾기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int maxZone = 0;

        // 비 높이를 0부터 최대 높이까지 시뮬레이션
        // 영역 넓이 찾기니까 bfs 하나 끝내고 count + 1 하기
        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > h) {
                        bfs(i, j, h);
                        count++;
                    }
                }
            }

            // 현재 높이에서 카운트 된 값과 비교해서 높은 값으로 갱신
            maxZone = Math.max(maxZone, count);
        }

        System.out.println(maxZone);
    }

    static void bfs(int x, int y, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] > height) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
