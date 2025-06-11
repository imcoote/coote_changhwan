/*******************************************************************************
 * 소요시간: 1시간 45분
 * 시간복잡도: O(M * N * H)
 * 메모리: 129888 kb
 * 시간: 684 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 토마토_7569 {
    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class Tomato {
        int x, y, z, day;

        Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        Queue<Tomato> queue = new LinkedList<>();

        // 입력 받기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.offer(new Tomato(m, n, h, 0));
                        visited[h][n][m] = true;
                    }
                }
            }
        }

        int maxDay = 0;

        // BFS
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            maxDay = Math.max(maxDay, t.day);

            for (int d = 0; d < 6; d++) {
                int nx = t.x + dx[d];
                int ny = t.y + dy[d];
                int nz = t.z + dz[d];

                if (nx >= 0 && ny >= 0 && nz >= 0 &&
                        nx < M && ny < N && nz < H &&
                        !visited[nz][ny][nx] && box[nz][ny][nx] == 0) {

                    visited[nz][ny][nx] = true;
                    queue.offer(new Tomato(nx, ny, nz, t.day + 1));
                }
            }
        }

        // 안 익은 토마토 있는지 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0 && !visited[h][n][m]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(maxDay);
    }
}