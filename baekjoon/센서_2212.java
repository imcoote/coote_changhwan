/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(K)
 * 메모리: 16212 kb
 * 시간: 160 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 센서_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 센서랑 집중국 개수 입력받기
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 센서 위치 정렬
        Arrays.sort(sensors);

        // 센서 사이 거리 구해서 그룹 나누기
        int[] distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 오름차순으로 정렬하고 제일 큰 거리 기준으로 그룹 나누기
        Arrays.sort(distances);

        int total = 0;
        for (int i = 0; i < N - K; i++) {
            total += distances[i];
        }

        System.out.println(total);
    }
}
