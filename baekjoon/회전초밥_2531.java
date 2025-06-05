/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N)
 * 메모리: 18332 kb
 * 시간: 160 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 회전초밥_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken());  
        int k = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken());  

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int kind = 0;

        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) kind++;
            count[belt[i]]++;
        }

        int max = (count[c] == 0) ? kind + 1 : kind;

        for (int i = 1; i < N; i++) {
            int remove = belt[(i - 1) % N];
            int add = belt[(i + k - 1) % N];

            count[remove]--;
            if (count[remove] == 0) kind--;

            if (count[add] == 0) kind++;
            count[add]++;

            int total = (count[c] == 0) ? kind + 1 : kind;
            max = Math.max(max, total);
        }

        System.out.println(max);
    }
}