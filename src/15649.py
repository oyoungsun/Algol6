# n, m = 0,0
# def dfs(depth, visit, array):
#     if depth==m:
#         print(" ".join(array))
#         return;
#     else:
#         for i in range(1, n+1):
#             if visit[i] :
#                 continue
#             else :
#                 visit[i]=True
#                 array[depth] = str(i)
#                 dfs(depth+1, visit, array)
#                 visit[i]=False
#
#
# n, m = map(int, input().split())
# visit = [False for _ in range(n+1)]
# array = ["" for _ in range(m)]
# dfs(0, visit, array)
# n, m = 0,0
# def dfs(depth, start, visit, array):
#     if depth==m:
#         print(" ".join(array))
#         return
#     else :
#         for i in range(start, n+1):
#             if visit[i] : continue
#             else :
#                 visit[i] = True
#                 array[depth] = str(i)
#                 dfs(depth+1, i+1, visit, array)
#                 visit[i] = False
#
#
# n, m = map(int, input().split())
# visit = [False for _ in range(n+1)]
# array = ["" for _ in range(m)]
# dfs(0, 1, visit, array)

#
# n, m = 0,0
# def dfs(depth, array):
#     if depth==m:
#         print(" ".join(array))
#         return
#     else :
#         for i in range(1, n+1):
#             array[depth] = str(i)
#             dfs(depth+1, array)
#
#
#
# n, m = map(int, input().split())
# array = ["" for _ in range(m)]
# dfs(0, array)


# n, m = 0,0
# def dfs(depth, start, array):
#     if depth==m:
#         print(" ".join(array))
#         return
#     else :
#         for i in range(start, n+1):
#             array[depth] = str(i)
#             dfs(depth+1, i, array)
#
#
# n, m = map(int, input().split())
# array = ["" for _ in range(m)]
# dfs(0, 1, array)


# n, m = 0,0
# def dfs(depth, start, array, maps, visit):
#     if depth==m:
#         strs = ""
#         for i in range(m):
#             strs += str(maps[array[i]]) + " "
#         print(strs)
#         return
#     else :
#         for i in range(0, n):
#             if visit[i] : continue
#             else :
#                 visit[i] = True
#                 array[depth] = i
#                 dfs(depth+1, i+1, array, maps, visit)
#                 visit[i] = False
#
# n, m = map(int, input().split())
# maps = list(map(int, input().split()))
# maps.sort()
# visit = [False for _ in range(n)]
# array = ["" for _ in range(m)]
# dfs(0, 0, array, maps, visit)


# n, m = 0,0
# def dfs(depth, start, array, maps, visit):
#     if depth==m:
#         strs = ""
#         for i in range(m):
#             strs += str(maps[array[i]]) + " "
#         print(strs)
#         return
#     else :
#         for i in range(start, n):
#             if visit[i] : continue
#             else :
#                 visit[i] = True
#                 array[depth] = i
#                 dfs(depth+1, i+1, array, maps, visit)
#                 visit[i] = False
#
# n, m = map(int, input().split())
# maps = list(map(int, input().split()))
# maps.sort()
# visit = [False for _ in range(n)]
# array = ["" for _ in range(m)]
# dfs(0, 0, array, maps, visit)

n, m = 0,0
def dfs(depth, start, array, maps, visit):
    if depth==m:
        strs = ""
        for i in range(m):
            strs += str(maps[array[i]]) + " "
        print(strs)
        return
    else :
        for i in range(0, n):
            array[depth] = i
            dfs(depth+1, i+1, array, maps, visit)

n, m = map(int, input().split())
maps = list(map(int, input().split()))
maps.sort()
visit = [False for _ in range(n)]
array = ["" for _ in range(m)]
dfs(0, 0, array, maps, visit)