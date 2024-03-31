import sys

n, k = map(int, sys.stdin.readline().split())
array = set(map(int, sys.stdin.readline().split()))
origin = array.copy()
for i in range(2, k+1):
    #level k
    temp = set()
    for s in array:
        for j in origin:
            temp.add(s+j)
    array = temp

array = sorted(list(array))
for i in array:
    print(i, end=" ")