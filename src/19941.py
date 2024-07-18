'''
k 거리 이하의 햄버거 먹기
k=1...2

n : 2*10^4
k=10
'''

import sys

input = sys.stdin.readline
n, k = map(int, input().split())
table = list(input().rstrip())

leng = max(10, n)
maxC=0

copys = table.copy()
count=0
for i in range(len(table)):
    if copys[i]!="P" : continue
    start = max(0, i-k)
    end = min(n-1, i+k)
    flag=False
    for j in range(start, i):
        if copys[j]=="H" :
            copys[j]="0"
            count+=1
            flag=True
            break
    if(flag) : continue
    for j in range(i+1, end+1):
        if copys[j]=="H" :
            copys[j]="0"
            count+=1
            break
print(count)
print(copys)

