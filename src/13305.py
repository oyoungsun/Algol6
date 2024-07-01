'''
가장 최소 금액으로 주유하기
1. 처음에는 무조건 다음으로 가는 것 이상 넣어야한다.

일직선이라면.. node별 dp가 가능할것같은데?
10^6
현재 주유소에서는
1. 다음칸 갈 만큼만 넣는다.(다음노드-현재노드 위치)
2. 다음칸보다 더 많이 넣는다.(전체 남은 거리)
dp[위치n] = 현재 vs 주유소ai에서 위치n까지 가는 비용

'''
import sys
n = int(sys.stdin.readline())
dist=[]
dist.append(0)
dist.extend(list(map(int, sys.stdin.readline())))
cost = list(map(int, sys.stdin.readline()))
dp=[0 for _ in range(1_000_000_000)]
