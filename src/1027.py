'''
탑보기 22866과 비슷하지만 n숫자가 작아 기울기를 사용해도 무방함
-> 애초에 stack은 일직선높이만 가정하고 있기 때문에 반드시 기울기를 사용해서 풀어야함

'''
from collections import deque
import sys

input = sys.stdin.readline
INT_MAX = sys.maxsize

n = int(input())
buildings = list(map(int, input().split()))

count_r = [0] * n
count_l = [0] * n
stack = deque()
stack.append(buildings[0])

for i in range(1, len(buildings)):
    count_r[i]=len(stack)
    while stack and stack[-1] <= buildings[i] :
        stack.pop()
    stack.append(buildings[i])

stack = deque()
stack.append(buildings[-1])

for i in range(len(buildings)-2, -1, -1):
    count_l[i]=len(stack)
    while stack and stack[-1] <= buildings[i] :
        stack.pop()
    stack.append(buildings[i])

print(count_r)
print(count_l)
sum=[]
for i in range(n):
    sum.append(count_l[i]+count_r[i])

print(sum)