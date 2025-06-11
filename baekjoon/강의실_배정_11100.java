/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(N log N)
 * 메모리: 92316 kb
 * 시간: 724 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 강의실_배정_11100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> timeMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 각 시간마다 강의실 생성 또는 소멸 카운트
            // start시간때 강의실 새로 생성하기 때문에 +1
            // end시간때 강의 끝나면 -1
            timeMap.put(start, timeMap.getOrDefault(start, 0) + 1); 
            timeMap.put(end, timeMap.getOrDefault(end, 0) - 1);     
        }

        int current = 0;
        int max = 0;

        for (int time : timeMap.keySet()) {
            current += timeMap.get(time); 
            max = Math.max(max, current); 
        }

        System.out.println(max);
    }
}