'''
단어 반복횟수>
단어의 길이>
알파벳 사전순
길이 M이상인 단어들만 외운다고
'''
import sys

n, m = map(int, sys.stdin.readline().split())
cnts = dict()
for i in range(n):
    voca = sys.stdin.readline().strip()
    if len(voca) < m : continue
    if voca in cnts :
        cnts[voca]= (cnts[voca][0]+1, len(voca), voca)
    else :
        cnts[voca] = (1, len(voca), voca)

ans = sorted(cnts.items(), key= lambda x : (-x[1][0], -x[1][1], x[1][2]))

for i in ans:
    print(i[0])