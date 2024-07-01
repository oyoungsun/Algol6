'''
길이가 N인 수열에서
 수열에서 연속한 1개 이상의 수
 같은 수가 여러 번 등장하지 않는 경우의 수

12345
-> 다른 위치 같은 조합도 같은 경우의 수로 간주한다.
-> 투포인터 * O(n)
-> O(n^2)
'''

n = int(input())
array = list(map(int, input().split()))


cnt=0
l, r =0, 0
visit=[False]*100001
while(l<=r and r <n) :
    if not visit[array[r]] :
        visit[array[r]] = True
        r+=1
        cnt += r-l
    else :
        while visit[array[r]] :
            visit[array[l]]=False
            l+=1

print(cnt)


