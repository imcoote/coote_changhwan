/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(S)
 *      -> 입력 받은 숫자(S)만큼 한번씩만 처리
 * 메모리: 17588 kb
 * 시간: 176 ms
 *******************************************************************************/

// 전체적인 아이디어는 0 -> 1, 1 -> 0 으로 바뀌는 지점을 기준으로
// 연속된 1의 그룹, 연속된 0의 그룹을 분리하여 갯수를 세는 것!!
// 둘 중 적은 그룹의 수가 이번에 구하려는 최소 횟수

import java.util.*;

public class 뒤집기_1439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();

        // 그룹 갯수 세는 변수 설정
        int one = 0;
        int zero = 0;

        // 0번째 인덱스는 이전 인덱스와 비교할 수 없으므로 따로 처리
        if (S.charAt(0) == '0') zero++;
        else one++;

        // 1번째 인덱스 부터 순회하면서
        // 현재와 이전 값이 달라진 경우
        // 0으로 시작하면 0그룹 갯수 +1 아니면 1그룹 갯수 + 1
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i-1)) {
                if (S.charAt(i) == '0') zero += 1;
                else one += 1;
            }
        }

        // 0과 1중 적은 그룹 수가 이번에 구하려는 최소횟수
        System.out.println(Math.min(zero, one));
    }
}
