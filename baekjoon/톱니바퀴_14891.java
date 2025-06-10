/*******************************************************************************
 * 소요시간: 1시간 15분
 * 시간복잡도: O(1)
 * 메모리: 14236 kb
 * 시간: 104 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 톱니바퀴_14891 {
    static int[][] gear = new int[4][8]; // 톱니바퀴 상태
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 입력
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = line.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());

        // 회전 명령 입력
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            int[] dir = new int[4]; // 회전 방향
            dir[n] = d;

            // 왼쪽
            for (int i = n - 1; i >= 0; i--) {
                if (gear[i][2] != gear[i + 1][6]) {
                    dir[i] = -dir[i + 1];
                } else {
                    break;
                }
            }

            // 오른쪽
            for (int i = n + 1; i < 4; i++) {
                if (gear[i - 1][2] != gear[i][6]) {
                    dir[i] = -dir[i - 1];
                } else {
                    break;
                }
            }

            // 회전 적용
            for (int i = 0; i < 4; i++) {
                if (dir[i] == 1) rotateRight(i);
                else if (dir[i] == -1) rotateLeft(i);
            }
        }

        // 점수 계산
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) sum += (1 << i);
        }

        System.out.println(sum);
    }

    static void rotateRight(int idx) {
        int temp = gear[idx][7];
        for (int i = 7; i > 0; i--) {
            gear[idx][i] = gear[idx][i - 1];
        }
        gear[idx][0] = temp;
    }

    static void rotateLeft(int idx) {
        int temp = gear[idx][0];
        for (int i = 0; i < 7; i++) {
            gear[idx][i] = gear[idx][i + 1];
        }
        gear[idx][7] = temp;
    }
}
