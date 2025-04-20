/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(K)
 * 메모리: 20872 kb
 * 시간: 272 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 큐_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queue = new ArrayDeque<>();
        int commandCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCnt; i++) {
            String command = br.readLine();

            if (command.equals("pop")) {
                System.out.println(queue.isEmpty() ? -1 : queue.pollFirst());
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (command.equals("front")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());
            } else if (command.equals("back")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
            } else {
                String[] pushCommand = command.split(" ");
                int pushNum = Integer.parseInt(pushCommand[1]);
                queue.addLast(pushNum);
            }
        }
    }
}
