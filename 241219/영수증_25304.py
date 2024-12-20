# 총 금액과 물건 갯수 입력받기
total_amount = int(input())
total_num = int(input())
result = 0

# 갯수 만큼 순회하면서 result 값에 계산해서 합치기
for i in range(total_num):
    amount, num = map(int, input().split())
    result += amount * num

# 총금액과 계산한 값 result가 같다면 Yes 아니면 No 반환
print("Yes" if total_amount == result else "No")
