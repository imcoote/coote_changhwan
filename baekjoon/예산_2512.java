/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N × log(maxRequest))
 * 메모리: 15180 kb
 * 시간: 140 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 예산_2512 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 예산 요청 수 N
        int N = Integer.parseInt(br.readLine());

        // 예산 요청 배열
        int[] requests = new int[N];
        int max = 0; // 요청 중 최대값 저장용

        // 예산 요청값들 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, requests[i]);
        }

        // 총 예산 M 입력
        int M = Integer.parseInt(br.readLine());

        // 상한액을 1부터 max까지 다 시도해볼까
        // 시간초과 발생 위험이 있다

        // 이진 탐색으로 조건을 만족하는 최대 상한값을 찾자
        // 가장 큰 상한값을 찾는 이진 탐색 구조

        int left = 0;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 현재 시도해보는 상한액

            // mid를 상한액으로 잡았을 때 총 예산이 M 이하면 가능한 배정
            // 더 큰 상한액이 가능한지 시도
            if (isValid(requests, M, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 정답 출력
        System.out.println(result);
    }

    // 총 요청 합이 상한 cap을 넘지 않는지 검사하는 함수
    private static boolean isValid(int[] arr, int limit, int cap) {
        long sum = 0;

        // 각 요청은 cap보다 크면 cap으로 자르고, 작으면 그대로 더함
        for (int req : arr) {
            sum += Math.min(req, cap);
        }

        // 총합이 limit 이하이면 cap은 유효한 상한액
        return sum <= limit;
    }
}
