/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(1)
 * 메모리: 14128 kb
 * 시간: 104 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 빙고_2578 {
    static int[][] board = new int[5][5];
    static Map<Integer, int[]> numberMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                numberMap.put(num, new int[]{i, j});
            }
        }

        // 사회자가 부른 수 입력 및 처리
        int count = 0; 

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int called = Integer.parseInt(st.nextToken());
                count++;

                int[] pos = numberMap.get(called);

                // 숫자를 0으로 바꿔서 체크 표시
                board[pos[0]][pos[1]] = 0;

                if (checkBingo() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    // 빙고 3줄 이상인지 확인
    public static int checkBingo() {
        int bingo = 0;

        // 가로 빙고 확인
        for (int i = 0; i < 5; i++) {
            boolean row = true;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != 0) row = false;
            }
            if (row) bingo++;
        }

        // 세로 빙고 확인
        for (int j = 0; j < 5; j++) {
            boolean col = true;
            for (int i = 0; i < 5; i++) {
                if (board[i][j] != 0) col = false;
            }
            if (col) bingo++;
        }

        // 오른쪽으로 낮아지는 대각선 빙고 확인
        boolean daeR = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != 0) daeR = false;
        }
        if (daeR) bingo++;

        // 왼쪽으로 낮아지는 대각선 빙고 확인
        boolean daeL = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != 0) daeL = false;
        }
        if (daeL) bingo++;

        return bingo;
    }
}