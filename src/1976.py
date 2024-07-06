'''
동혁이는 친구들과 함께 여행을 가려고 한다.
도시 N개
임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다.
중간에 다른 도시를 경유해서 여행을 할 수도 있다.
예를 들어 도시가 5개 있고, A-B, B-C, A-D, B-D, E-A의 길이 있고,
동혁이의 여행 계획이 E C B C D 라면 E-A-B-C-B-C-B-D라는 여행경로를 통해 목적을 달성할 수 있다.
같은 도시를 여러 번 방문하는 것도 가능하다.
N은 200이하이다.
M은 1000이하이다.
i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다.
1이면 연결된 것이고 0이면 연결이 되지 않은 것이다.
A와 B가 연결되었으면 B와 A도 연결되어 있다. 마지막 줄에는 여행 계획이 주어진다. 도시의 번호는 1부터 N까지 차례대로 매겨져 있다.
'''
import sys
input = sys.stdin.readline

def find(x):
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]

def merge(parents, a, b):
    ap = findP(parents, a)
    bp = findP(parents, b)

    if a > b :
        parents[a]=b
    else :
        parents[b]=a

def connect(parents, load):
    pre = findP(load, load[0])
    for l in load[1:]:
        cur = findP(parents, l)
        if pre != cur:
            return "NO"
        pre = cur
    return "YES"
def main():
    n = int(input())
    m = int(input())
    maps = [list(map(int, input().rstrip().split())) for _ in range(n)]
    cities = list(map(lambda x: int(x)-1, input().rstrip().split()))

    parent = [i for i in range(n)]

    for i in range(n):
        for j in range(n):
            if maps[i][j]==1: # 연결됨 -> 부모 합치기
                merge(parent, i, j)
    print(connect(parent, cities))

main()

