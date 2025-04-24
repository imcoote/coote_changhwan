/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(K)
 * 메모리: 20600 kb
 * 시간: 264 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int commandCnt = Integer.parseInt(br.readLine());

        // 명령어 처리
        for (int i = 0; i < commandCnt; i++) {
            String command = br.readLine();

            if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else {
                String[] pushCommand = command.split(" ");
                int pushNum = Integer.parseInt(pushCommand[1]);
                stack.push(pushNum);
            }
        }
    }
}
