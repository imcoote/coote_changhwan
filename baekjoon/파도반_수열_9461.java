/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(N × log(maxRequest))
 * 메모리: 15180 kb
 * 시간: 140 ms
 *******************************************************************************/

import java.io.*;

public class 파도반_수열_9461 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 수열 저장 배열 (P[1] ~ P[100])
        long[] P = new long[101]; // 64bit 정수 사용

        // 초기값 설정하기
        P[1] = P[2] = P[3] = 1;
        P[4] = P[5] = 2;

        // 점화식에 따라 계산
        for (int i = 6; i <= 100; i++) {
            P[i] = P[i - 1] + P[i - 5];
        }

        // 테스트케이스 실행
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(P[N]).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}
