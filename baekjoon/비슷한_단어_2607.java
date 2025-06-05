/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(N * L)
 * 메모리: 14140 kb
 * 시간: 100 ms
 *******************************************************************************/

import java.io.*;

public class 비슷한_단어_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String baseWord = br.readLine();
        int[] baseWordCount = getAlphabetCount(baseWord);

        int result = 0;

        for (int i = 1; i < N; i++) {
            String restWord = br.readLine();
            int[] restWordCount = getAlphabetCount(restWord);

            int diff = 0;

            for (int j = 0; j < 26; j++) {
                diff += Math.abs(baseWordCount[j] - restWordCount[j]);
            }


            // 0 이면 완전히 같음
            // 1 이면 한글자 추가 or 삭제
            // 2 면 한글자 바꾸기
            if (diff == 0) {
                result++;
            } else if (diff == 1) {
                result++;
            } else if (diff == 2 && baseWord.length() == restWord.length()) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static int[] getAlphabetCount(String s) {
        // A~Z까지 각각의 빈도 구하기
        int[] count = new int[26]; 
        char[] alphabet = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z'
        };

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 알파벳 배열과 하나씩 비교
            for (int j = 0; j < 26; j++) {
                if (c == alphabet[j]) {
                    count[j]++;
                    break;
                }
            }
        }

        return count;
    }
}
