/*******************************************************************************
 * 소요시간: 분
 * 시간복잡도: O()
 * 메모리:  kb
 * 시간:  ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 가장_긴_짝수_연속한_부분_수열_22862{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        int[] numArr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int even = 0;
        int odd = 0;
        int max = 0;

        for (int right = 0; right < N; right++) {
            if (numArr[right] % 2 == 0) {
                even++;
            } else {
                odd++;
            }

            while (odd > K) {
                if (numArr[left] % 2 == 0) {
                    even--;
                } else {
                    odd--;
                }
                left++;
            }

            max = Math.max(max, even);
        }

        System.out.println(max);
    }
}