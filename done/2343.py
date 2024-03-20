import queue;
import sys;
n, m = map(int, sys.stdin.readline().split())
array = list(map(int, input().split()))

start=max(array) #최소 블루레이 크기
end=sum(array) #최대 블루레이 크기
while start<=end:
    mid = (start+end)//2
    s=0
    lay = 1 #mid로 블루레이 개수 구하기;
    for t in array:
        if s+t > mid:
            lay+=1
            s=0
        s += t
    if lay<=m : 
        ans = mid # 블루레이 수가 지정된 수보다 작거나 같을때
        end = mid-1 #왜 같아야하는지 잘 모르겠음.. 
    else:
        start = mid+1
print(ans)
       


    