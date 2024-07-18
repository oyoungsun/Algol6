
args = list(map(int, input().split()))
k = list()
for i in range(args[3]):
    k.append(list(map(int, input().split())))

l = args[2]
k = sorted(k, key = lambda x : (x[0], x[1]))

minC=args[3] # 전부떨어짐
for star in k :
    for star2 in k :
        x, nx, y, ny = star[0], star[0]+l, star2[1], star2[1]+l
        count=0
        for star3 in k :
            if x <= star3[0] <= nx and y <= star3[1] <= ny :
                count+=1
        minC= min(minC, args[3]-count)

print(minC)