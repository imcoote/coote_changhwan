import java.util.*;

/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(K)
 *      -> 입력 받은 숫자(K)만큼 한번씩만 처리
 * 메모리: 113348 kb
 * 시간: 700 ms
 *******************************************************************************/

public class 제로_10773 {
    public static void main(String[] args) {
        // 자바는 Scanner 로 입력을 받는다
        Scanner scanner = new Scanner(System.in);

        // 숫자를 입력 받을려면 nextInt() 메서드 사용
        int K = scanner.nextInt();

        // 스택 형식으로 구현하기 위해 java 의 Stack 클래스사용
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = scanner.nextInt();
            // 문제 조건에서
            // "정수가 '0'일 경우에 지울 수 있는 수가 있음을 보장할 수 있다."
            // 라고 적혀 있어서 stack 이 비어있는 조건은 넣지 않았다!!
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int sum = 0;
        // stack 은 배열이 아니라서 get 메서드를 사용해서 인덱스로 접근할 수 있다
        // stack.size() 메서드로 stack 크기만큼 순회하면서 전체 숫자 합치기
        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }

        System.out.println(sum);
    }
}
