/*******************************************************************************
 * 소요시간: 2시간 45분
 * 시간복잡도: O(N × M)
 * 메모리: 31096 kb
 * 시간: 324 ms
 *******************************************************************************/

import java.util.*;

public class 유기농_배추_1012 {
    public static void main(String[] args) {
        // Scanner 정의 후 바로 테스트케이스 갯수 입력받아 정의하기
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        // 테스트케이스 갯수만큼 반복하기
        for (int t = 0; t < testCase; t++) {
            // 가로길이, 세로길이, 배추위치 갯수 입력받기
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            // 배추위치를 나타낸 이차원배열, 방문여부를 나타낸 이차원배열 정의
            // <<이차원배열 정의할 때 X축, Y축은 [Y][X] 이런식으로 정의한다!!>>
            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                map[y][x] = 1;
            }

            // 전체 그룹 갯수 정의
            int group = 0;

            // 이차원 배열을 돌면서 탐색시작
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    // 배추가 있고 방문하지 않은 배추부터 상하좌우 모두 방문하면서 visited = true로 변경하고
                    // 모두 탐색하면 group + 1 하기!!
                    if (map[y][x] == 1 && !visited[y][x]) {
                        // BFS 탐색 시작
                        // java의 LinkedList로 큐 정의
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{x, y});
                        visited[y][x] = true;

                        // 만약 큐가 비어있을 때 까지 반복하기
                        while (!queue.isEmpty()) {
                            // 큐의 맨 앞에서 꺼내어 현재 좌표로 설정
                            int[] current = queue.poll();
                            int cX = current[0];
                            int cY = current[1];

                            // 왼쪽 확인, 있다면 큐에 넣기
                            if (cX > 0 && map[cY][cX - 1] == 1 && !visited[cY][cX - 1]) {
                                queue.add(new int[]{cX - 1, cY});
                                visited[cY][cX - 1] = true;
                            }

                            // 오른쪽 확인, 있다면 큐에 넣기
                            if (cX < M - 1 && map[cY][cX + 1] == 1 && !visited[cY][cX + 1]) {
                                queue.add(new int[]{cX + 1, cY});
                                visited[cY][cX + 1] = true;
                            }

                            // 아래 확인, 있다면 큐에 넣기
                            if (cY > 0 && map[cY - 1][cX] == 1 && !visited[cY - 1][cX]) {
                                queue.add(new int[]{cX, cY - 1});
                                visited[cY - 1][cX] = true;
                            }

                            // 위 확인, 있다면 큐에 넣기
                            if (cY < N - 1 && map[cY + 1][cX] == 1 && !visited[cY + 1][cX]) {
                                queue.add(new int[]{cX, cY + 1});
                                visited[cY + 1][cX] = true;
                            }
                        }

                        // 탐색이 끝났으면 group + 1 하기
                        group++;
                    }
                }
            }
            System.out.println(group);
        }
    }
}
