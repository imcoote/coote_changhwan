"""
 * 소요시간: 3 분
 * 시간복잡도: O(n * m) 	
 * 메모리: 32412 kb	
 * 시간: 32 ms
"""

# 테스트 케이스 갯수 입력 받기
total_test_case = int(input())

# 테스트 케이스 갯수 만큼 순회하면서
for i in range(total_test_case):
    # 각 케이스의 문자열과 반복횟수 입력받기
    repeat_num, str = input().split()

    # 문자열의 각 문자를 반복횟수만큼 곱하여 result에 저장 후 출력
    result = ""
    for j in range(len(str)):
        result += str[j] * int(repeat_num)

    print(result)
