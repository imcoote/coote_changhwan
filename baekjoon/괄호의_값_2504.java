/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N)
 * 메모리: 14372 kb
 * 시간: 108 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 괄호의_값_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracketString = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (char bracket : bracketString.toCharArray()) {
            if (bracket == '(') {
                stack.push(-2); 
            } else if (bracket == '[') {
                stack.push(-3);
            }

            else if (bracket == ')' || bracket == ']') {
                int target = (bracket == ')') ? -2 : -3;
                int base = Math.abs(target);
                int multi = 0;

                while (!stack.isEmpty()) {
                    int top = stack.pop();

                    if (top > 0) {
                        multi += top;  
                    } else if (top == target) {
                        int result = (multi == 0) ? base : base * multi;
                        stack.push(result);
                        break;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }

                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
            }

            else {
                System.out.println(0);
                return;
            }
        }

        int result = 0;
        for (int val : stack) {
            if (val < 0) {
                System.out.println(0);
                return;
            }
            result += val;
        }

        System.out.println(result);
    }
}
