"""
 * 소요시간: 10 분
 * 시간복잡도: O(n) 	
 * 메모리: 32412 kb	
 * 시간: 60 ms
"""

# <문제 해결 아이디어>
# 서로 다른 자연수들을 더해서 자연수 S가 나오도록 해야함
# 근데 여기서 서로 다른 자연수의 갯수가 최대가 되도록 해야함..
# 그러면 자연수S에서 작은 자연수 부터 빼면 최댓값을 구할 수 있지 않을까..?

# 자연수 S를 입력받는다
sum_num = int(input())

# 갯수 카운트
count = 0

# 빼줄 값을 1부터 설정
subtract_num = 1

# 무한 반복문을 돌면서..
while True:
    # 1.빼야할 숫자가 자연수 S보다 큰 경우
    # 2.모두 알맞게 빼서 자연수 S가 0된 경우
    # 더 이상 뺄 수 없기 때문에 반복문 종료
    if (subtract_num > sum_num) or (sum_num == 0):
        break
    # 그 외의 상황에서는 카운트와 뺄 자연수 숫자를 1씩 늘려간다
    else:
        sum_num -= subtract_num
        count += 1
        subtract_num += 1

print(count)
