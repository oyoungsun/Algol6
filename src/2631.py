'''
KOI 어린이집에는 N명의 아이들이 있다. 오늘은 소풍을 가는 날이다.
선생님은 1번부터 N번까지 번호가 적혀있는 번호표를 아이들의 가슴에 붙여주었다.

위치를 옮기는 아이들의 수를 최소로 하려고 한다.
3 7 5 2 6 1 '4'
3 '7' 4 5 2 6 1
3 4 5 2 6 '1' 7
1 3 4 5 '2' 6 7
1 2 3 4 5 6 7
-> 여기서는 '나'가 나+1의 앞에 위치하도록 이동했다.
-> buble sort?
N은 2 이상 200 이하의 정수이다.
정렬 or dfs
max depth= 200*200..
'''

n = int(input())
array = []
for i in range(n):
    array.append(int(input()))

dp = [0 for _ in range(n)]
for k in range(n):
    dp[k]=1 #본인
    for j in range(k) :
        if array[j] < array[k] : #증가하는 배열에 만족
            dp[k] = max(dp[k], dp[j]+1) # 본인 vs j기준 +1

print(n - max(dp))