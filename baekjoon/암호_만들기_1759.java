/*******************************************************************************
 * 소요시간: 1시간 10분
 * 시간복잡도: O(C choose L)
 * 메모리: 14128 kb
 * 시간: 112 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

// 문제의 조건
// 1. 서로 다른 L개의 알파벳 소문자
// 2. 최소 한 개의 모음과 최소 두 개의 자음으로 구성
// 3. 알파벳 순으로 증가하는 순서로 배열
public class 암호_만들기_1759 {
    static int L, C;
    static char[] letters;
    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 입력 받은 문자 줄을 공백제거하고 toCharArray 로 배열 만들기
        // 사전 순으로 조합 만들기 위해 정렬
        letters = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(letters);

        // 조합 생성 시작
        result = new char[L];
        dfs(0, 0, 0, 0);
    }

    // 앞에 있었던걸 사용하지 못하게끔 시작위치 startIndex 선정
    static void dfs(int startIndex, int currentLength, int mo, int ja) {
        // 목표한 길이에 도달했으면 모음, 자음 숫자 파악하고 return
        if (currentLength == L) {
            if (mo >= 1 && ja >= 2) {
                // char 배열을 문자열로 바꾸기 위해서는 String 클래스 생성자 사용
                System.out.println(new String(result));
            }
            return;
        }

        // 다시 dfs 들어가기전에 길이가 안되는 케이스에서는 미리 멈춰야함
        // 남은 문자를 다 넣어도 L이 안되면 중단
        if (C - startIndex + currentLength < L) return;

        // startIndex로 설정된 위치부터 순회하기
        for (int i = startIndex; i < C; i++) {
            result[currentLength] = letters[i];

            if (isMo(letters[i])) {
                dfs(i + 1, currentLength + 1, mo + 1, ja);
            } else {
                dfs(i + 1, currentLength + 1, mo, ja + 1);
            }
        }
    }

    // 주어진 문자가 모음인지 확인하는 함수
    static boolean isMo(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}