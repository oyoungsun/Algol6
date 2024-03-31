'''
심장의 위치와 팔, 다리, 허리
'''
import sys

def ifHeart(i,j):
    global array
    global dir, n
    for d in dir :
        nx = i+d[0]
        ny = j+d[1]
        if nx >= n or nx < 0 or ny >= n or ny < 0 : continue
        if array[nx][ny] != "*":
            return False
    return True
def isBoundary(nx,ny):
    global n, array
    if nx >= n or nx < 0 or ny >= n or ny < 0 :
        return False
    if  array[nx][ny] !="*" :
        return False
    return True
def findLhand(x,y):
    global array
    cnt=0
    for i in range(y,-1,-1):
        if array[x][i]=="_":
            return cnt
        cnt+=1
    return cnt

def findRhand(x,y):
    global array,n
    cnt=0
    for i in range(y,n,1):
        if array[x][i]=="_":
            return cnt
        cnt+=1
    return cnt

def findRoll(x,y):
    global array,n
    cnt=0
    for i in range(x,n,1):
        if array[i][y]=="_":
            return i-1, y, cnt
        cnt+=1
    return n-1, y, cnt

def foot(x,y):
    global array,n
    cnt=0
    for i in range(x,n,1):
        if array[i][y]=="_":
            return cnt
        cnt+=1
    return cnt

n = int(sys.stdin.readline())
array = []
dir = [[0,-1],[0, 1], [1,0], [-1,0]]
body = [0 for _ in range(5)]
for i in range(n):
    array.append(sys.stdin.readline().rstrip())
hx,hy=0,0 #심장
for i in range(n):
    for j in range(n):
        if array[i][j]=="*" and ifHeart(i,j):
            hx,hy = i,j
            body[0] = findLhand(hx, hy-1)
            body[1] = findRhand(hx, hy+1)
            rx, ry, body[2] = findRoll(hx+1, hy)
            body[3] = foot(rx+1, ry-1)
            body[4] = foot(rx+1, ry+1)
            break
print(hx+1,hy+1)
print(" ".join(map(str, body)))