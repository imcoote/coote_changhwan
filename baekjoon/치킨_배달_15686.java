/*******************************************************************************
 * 소요시간: 1시간 10분
 * 시간복잡도: O(C(13, M) × H × M)
 * 메모리: 19800 kb
 * 시간: 196 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 치킨_배달_15686{
    static int N, M;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int chickenDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int place = Integer.parseInt(st.nextToken());
                if (place == 1) house.add(new int[]{i, j});
                else if (place == 2) chicken.add(new int[]{i, j});
            }
        }

        combination(new ArrayList<>(), 0);

        System.out.println(chickenDist);
    }

    // 치킨집 조합 구하기
    static void combination(List<int[]> selected, int start) {
        // 모든 조합 중 가장 작은 도시 치킨 거리 구하기
        if (selected.size() == M) {
            chickenDist = Math.min(chickenDist, getChickenDist(selected));
            return;
        }

        // 조합 구하기 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            selected.add(chicken.get(i));
            combination(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    // 선택된 치킨집 조합에서 각 집마다 도시 치킨 거리 계산
    static int getChickenDist(List<int[]> selectedChickens) {
        int total = 0;
        for (int[] h : house) {
            int minDist = Integer.MAX_VALUE;
            for (int[] c : selectedChickens) {
                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                minDist = Math.min(minDist, dist);
            }
            total += minDist;
        }
        return total;
    }
}