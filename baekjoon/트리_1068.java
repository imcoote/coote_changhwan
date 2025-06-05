/*******************************************************************************
 * 소요시간: 50분
 * 시간복잡도: O(N)
 * 메모리: 14256kb
 * 시간: 108ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 트리_1068 {
    static class Node {
        List<Integer> children = new ArrayList<>();
        int parent = -1;
    }

    static int count = 0;              
    static int deleteNodeNum;        
    static Node[] nodes;             

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parentNum = Integer.parseInt(st.nextToken());

            // 각 노드의 기본 parent는 -1로 설정
            // 루트노드는 설정이 불필요하므로 넘어감
            if (parentNum != -1) {
                nodes[i].parent = parentNum;
                nodes[parentNum].children.add(i);
            }
        }

        // 삭제할 노드 번호 입력
        deleteNodeNum = Integer.parseInt(br.readLine());

        // 부모가 1인 노드가 루트 노드임
        int root = -1;
        for (int i = 0; i < N; i++) {
            if (nodes[i].parent == -1) {
                root = i;
                break;
            }
        }

        // 루트 노드가 삭제 대상이 아닌 경우에만 탐색 시작
        if (root != deleteNodeNum) {
            countLeafNode(root);
        }

        System.out.println(count);
    }

    // 리프 노드 개수 세는 재귀 함수
    private static void countLeafNode(int current) {
        if (current == deleteNodeNum) return;

        List<Integer> children = nodes[current].children;

        // 자식이 없거나 삭제한 노드만 자식으로 있는 경우, 리프 노드로 간주
        if (children.isEmpty() || 
            (children.size() == 1 && children.get(0) == deleteNodeNum)) {
            count++;
            return;
        }

        // 그 외에는 리프노트 찾으러 가기
        for (int child : children) {
            if (child != deleteNodeNum) {
                countLeafNode(child);
            }
        }
    }
}
