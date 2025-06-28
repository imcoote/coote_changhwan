/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(N × log(maxLength))
 * 메모리: 115384 kb
 * 시간: 528 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 과자_나눠주기_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snacks = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = Arrays.stream(snacks).max().getAsInt();;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int piece = 0;
            for (int i = 0; i < N; i++) {
                piece += snacks[i] / mid;
            }

            // 조각이 많이 생긴다는 거는 구하고자하는 값보다 
            // 나눈 값이 작다는 거
            if (piece >= M) {
                result = mid;      
                left = mid + 1;     
            } else {
                right = mid - 1;   
            }
        }

        System.out.println(result);
    }
}
