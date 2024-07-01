'''
N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다
“좋다(GOOD)”고 한다.
수의 위치가 다르면 값이 같아도 다른 수이다.
1 2 3 4 5 6 7 8 9 10

3,4,5,6,7,8,9,10

A 안에 속해야하는듯? dict
2,000 * 2,000 = 10^6
'''
import sys
import bisect

n = int(input())
origin= list(map(int, sys.stdin.readline().split()))
good = 0
# origin.sort()
ans = set()

for i in range(n):
    for j in range(i+1, n):
            ans.add(origin[i]+origin[j])

ans = list(ans)
ans.sort()
# ans = ans[bisect.bisect_right(ans, origin[0]):bisect.bisect_left(ans, origin[-1])+1]
# print(len(ans))
print(ans)
print(bisect.bisect_right(ans, max(origin))-bisect.bisect_left(ans, min(origin)) )