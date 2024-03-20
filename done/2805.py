n, m = map(int, input().split())
array = list(map(int, input().split()))
# 머리만 가져갈수있음
end=max(array) #아무것도 못자름
start = 1 #모든 나무 다 자름

while(start<=end):
    mid = (start+end)//2
    #mid로 나무 다 잘라보기
    total=0
    for i in array:
        if i-mid>0:
            total+= i-mid
        
    if total>=m : #종료조건 필요
        start=mid+1
    else :
        end=mid-1
print(end)