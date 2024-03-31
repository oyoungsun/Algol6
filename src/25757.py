'''
임스가 미니게임을 같이할 사람을 찾고 있습니다.
y,f,o : 2,3,4
임스는 한 번 같이 플레이한 사람과는 다시 플레이하지 않습니다.
'''
import sys
# y, f, o = 2, 3, 4
n, type = sys.stdin.readline().split()
n = int(n)
names = set()
if type=="Y":
    type = 1 # 임스 포함 2명
elif type=="F":
    type = 2
elif type=="O":
    type = 3
for i in range(n):
    names.add(sys.stdin.readline().rstrip())
print(len(names)//type)


