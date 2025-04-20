/*******************************************************************************
 * 소요시간: 1시간 45분
 * 시간복잡도: O(n)
 * 메모리: 83816 kb
 * 시간: 1132 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;


public class 트리의_부모_찾기_11725 {
    // 연결된 번호 저장하고 부모 노드 저장할 수 있는 노드 클래스 생성
    static class Node {
        List<Integer> neighbors = new ArrayList<>();
        int parent = 0;
    }

    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1번부터 n번까지 노드를 만들기 위한 배열 초기화
        nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        // 다음 줄부터 n-1개의 간선 정보 입력
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // a와 b는 서로 연결되어 있으므로 양쪽에 추가
            nodes[a].neighbors.add(b);
            nodes[b].neighbors.add(a);
        }

        // 루트 노드는 1번, 부모는 0
        findParent(1, 0);

        // 2번 노드부터 N번 노드까지 각 노드의 부모 출력
        for (int i = 2; i <= n; i++) {
            System.out.println(nodes[i].parent);
        }
    }

    // DFS를 사용해서 현재 노드에서 연결된 이웃을 따라가며 부모 설정
    static void findParent(int current, int parent) {
        nodes[current].parent = parent;

        // 현재 노드에 연결된 이웃 노드들을 순회하기
        for (int next : nodes[current].neighbors) {
            // 이미 방문한 부모 노드는 다시 방문하지 않도록 하기
            if (next != parent) {
                // 자식 노드로 이동
                findParent(next, current);
            }
        }
    }
}
