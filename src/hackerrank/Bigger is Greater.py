#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'biggerIsGreater' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING w as parameter.


def biggerIsGreater(w):
    array = list(w)
    i = len(array)-2
    while i>=0 and array[i] >= array[i+1] :
        i-=1

    if i==-1 :
        return "no answer"# impossible

    j = len(array)-1
    while array[j] <= array[i]:
        j-=1

    array[i], array[j] = array[j], array[i]
    array[i+1:] = reversed(array[i+1:])
    return "".join(array)

if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')

    T = int(input().strip())

    for T_itr in range(T):
        w = input()
        result = biggerIsGreater(w)
        print(result)