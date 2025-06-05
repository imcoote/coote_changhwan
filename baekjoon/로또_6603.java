/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(K C 6)
 * 메모리: 20608 kb
 * 시간: 272 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 로또_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {  
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            if (K == 0) break;

            int[] S = new int[K];  

            for (int i = 0; i < K; i++) {  
                S[i] = Integer.parseInt(st.nextToken());
            }
            
            dfs(K, S, 0, new ArrayList<>());  
            System.out.println();
        }    
    }

    private static void dfs(int len, int[] numArr, int start, List<Integer> result) {
        if (result.size() == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(result.get(i) + " ");  
            }
            System.out.println();
            return;
        }

        for (int i = start; i < len; i++) {  
            result.add(numArr[i]);
            dfs(len, numArr, i + 1, result);  
            result.remove(result.size() - 1); 
        }
    }
}
