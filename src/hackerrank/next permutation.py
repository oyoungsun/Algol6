array = [2,4,3,1]

def next_permutation(array):
    i = len(array)-2
    while i>=0 and array[i] >= array[i+1] :
        i-=1

    if i==-1 :
        return [-1] # impossible

    j = len(array)-1
    while array[j] <= array[i]:
        j-=1

    array[i], array[j] = array[j], array[i]
    array[i+1:] = reversed(array[i+1:])

next_permutation(array)
print(array)

