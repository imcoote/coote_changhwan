/*******************************************************************************
 * 소요시간: 1시간 20분
 * 시간복잡도: O(N^2)
 * 메모리: 14572 kb
 * 시간: 108 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 뱀_3190 {
    static int N, K, L;
    static int[][] board;
    static Map<Integer, Character> turnInfo = new HashMap<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];

        // 사과 위치 입력 받기
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }

        // 방향 전환 정보 입력
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            turnInfo.put(time, dir);
        }

        System.out.println(calculateTime());
    }

    private static int calculateTime() {
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1});
        board[1][1] = 2; 

        int time = 0;
        int dir = 0; 

        int x = 1, y = 1;

        while (true) {
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || ny < 1 || nx > N || ny > N || board[nx][ny] == 2) {
                break;
            }

            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
            } else {
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0;
            }

            if (turnInfo.containsKey(time)) {
                char c = turnInfo.get(time);
                if (c == 'L') dir = (dir + 3) % 4; 
                else dir = (dir + 1) % 4;          
            }

            x = nx;
            y = ny;
        }

        return time;
    }
}