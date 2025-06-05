/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N³) -> N이 50이라서 가능할듯
 * 메모리: 16216 kb
 * 시간: 132 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;


// 알고리즘 분류에 폴라이드-워셜이라고 적혀있어 관련 자료 찾고 적용하였음
public class 회장뽑기_2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N + 1][N + 1];


        // 친구가 아닌 경우를 구별하기 위해
        // 처음엔 모든 사람 간 거리를 최대한 큰값으로 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 1000);
            // 자기 자신과의 거리는 0
            dist[i][i] = 0;
        }

        // 친구 관계는 양방향이다.
        // A가 B의 친구면 B도 A의 친구
        // 각 거리를 초반에 1로 초기화 한다
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        // 플로이드 워셜 알고리즘으로 모든 사람 간 최단 거리 계산
        // 중간 경유지(k)를 통해 i → j로 가는 최소 거리 갱신하기
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 각 사람의 점수는 가장 멀리 떨어진 사람까지의 거리
        // 최단 거리들 중에서 최댓값을 구해야함
        // 이중 반복문 돌면서 minScore도 갱신
        int[] score = new int[N + 1];
        int minScore = 1000;

        for (int i = 1; i <= N; i++) {
            int maxDist = 0;

            for (int j = 1; j <= N; j++) {
                if (dist[i][j] != 1000) {
                    maxDist = Math.max(maxDist, dist[i][j]);
                }
            }

            // 점수가 가장 낮은 사람이 회장 후보
            score[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }

        // 점수가 가장 낮은 사람들을 모두 출력해야 한다
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (score[i] == minScore) {
                count++;
                sb.append(i).append(" ");
            }
        }

        System.out.println(minScore + " " + count);
        System.out.println(sb.toString().trim());
    }
}

