'''
두 단어의 비슷한 정도는 두 단어의 접두사의 길이로 측정한다.
즉, 두 단어의 앞에서부터 M개의 글자들이 같으면서 M이 최대인 경우를 구하는 것이다.
"AH EHHEH", "AH AHEH"의 접두사는 "AH"가 되고, "AB", "CD"의 접두사는 ""(길이가 0)이 된다.

접두사의 길이가 최대인 경우가 여러 개일 때에는 입력되는 순서대로 제일 앞쪽에 있는 단어를 답으로 한다.
N(2 ≤ N ≤ 20,000)
len < 100

9
noon
is
lunch
for
most
noone
waits
until
two

정렬 nlogn
i, i+1의 접두사 비교 n * 100
-> 10^6
'''
import sys

input = sys.stdin.readline

n = int(input())
array = []
for i in range(n):
    array.append((input().rstrip().lstrip(), i)) # input, idx
array.sort(key=lambda x : (x[0], x[1]))


maxLen=0
result = dict()
for i in range(n-1):

    for k in range(i+1, n):
        count=0
        for j in range(len(array[i][0])):
            if len(array[k][0])-1 < j : break
            if array[k][0][j] != array[i][0][j] : break
            count+=1
        if maxLen <= count :
            maxLen=count
            if count not in result:
                result[count]=[]
            result[count].append(((array[i], array[k], min(array[i][1], array[k][1]))))

result[maxLen].sort(key=lambda x: x[2])
# print(result)
#for r in result[maxLen][0]:
result = [result[maxLen][0][0], result[maxLen][0][1]]
result.sort(key=lambda x:x[1])

print(result[0][0])
print(result[1][0])

# # print(maxLen)