n, k, d = map(int, input().split())

stud = []

for i in range(n):
    m, skill = map(int, input().split())
    algo = list(map(int, input().split()))
    stud.append((m, skill, algo)) # 알고리즘 수, 실력, 알고리즘 정보

stud.sort(key = lambda x:(x[1]))

start=end=0
algo = [0 for _ in range(k+1)]
inter, union = 0,0 # 합, 교
E=0
while end<n:
    totald = stud[end][1] - stud[start][1]
    if totald > d : #start 증가, 교집 그대로 합집 감소할수있음.
        for a in stud[start][2] :
            algo[a]-=1
            if algo[a]==0:
                inter -=1
        start +=1
    else : #end 증가, 교집 검사 and 합집 검사
        union = 0
        for a in stud[end][2]:
            algo[a]+=1
            if algo[a]==1:
                inter+=1
        for i in range(k+1):
            if algo[i] == end-start+1:
                union+=1
        # E 계산하기
        E = max(E, (inter-union)*(end-start+1))
        end+=1

print(E)
