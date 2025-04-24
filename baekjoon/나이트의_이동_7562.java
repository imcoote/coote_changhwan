/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(T * I^2)
 * 메모리: 77972 kb
 * 시간: 348 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 나이트의_이동_7562 {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스 갯수 입력 받기
        int T =  Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());

            // 현재 위치 입력 받기
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st1.nextToken());
            int nowY = Integer.parseInt(st1.nextToken());

            // 목표 위치 입력 받기
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st2.nextToken());
            int targetY = Integer.parseInt(st2.nextToken());

            // 방문 했다는거 입력 안받으면 같은 곳을 계속 맴도는 경우가 있다
            // visited 안 넣으니까 메모리 초과 떴음;;
            // x,y 좌표값 뿐만 아니라 이동횟수까지 넣었음
            boolean[][] visited = new boolean[I][I];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {nowX, nowY, 0});
            visited[nowX][nowY] = true;

            //bfs 시작
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int moveCnt = current[2];

                // 타겟에 도착하면 이동횟수 프린트하고 반복문 탈출
                if (x == targetX && y == targetY) {
                    System.out.println(moveCnt);
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // 체스판 구역안에서 움직이고 방문하지 아닌 곳일때만
                    if (nx >= 0 && ny >= 0 && nx < I && ny < I && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, moveCnt + 1});
                    }
                }
            }
        }
    }
}
