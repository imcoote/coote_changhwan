/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(N)
 * 메모리: 14276 kb
 * 시간: 104 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 패션왕_신해빈_9375 {
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> typeCount = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); 
                String type = st.nextToken(); 

                typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : typeCount.values()) {
                result *= (count + 1); 
            }

            System.out.println(result - 1); 
        }
    }
}