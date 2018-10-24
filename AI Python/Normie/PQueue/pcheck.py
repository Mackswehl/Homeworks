#! /usr/bin/python3

import sys

def my_cmp(a,b):
    if len(a) < len(b): return -1
    if len(a) == len(b): return 0
    return 1

def OrdinaryComparison(a,b):
    if a < b: return -1
    if a == b: return 0
    return 1

class Pqueue:

    def __init__(self, comparator = OrdinaryComparison):
        self.cmpfunc = comparator
        self.container = [None]

    def swap(self,a,b):
        temp = self.container[a]
        self.container[a] = self.container[b]
        self.container[b] = temp

    def push(self, data):
        self.container.append(data)
        curIndex = len(self.container) - 1
        while curIndex > 1 and self.cmpfunc(data,self.container[curIndex // 2]) == -1:
            self.swap(curIndex,curIndex // 2)
            curIndex = curIndex // 2

    def pop(self):
        if len(self.container) == 1:
            return None
        retVal = self.container[1]
        curIndex = 1
        self.swap(1,-1)
        self.container.pop(-1)
        while self.smallerChild(curIndex) != -1 and self.cmpfunc(self.container[curIndex],self.container[self.smallerChild(curIndex)]) == 1:
            tempIndex = self.smallerChild(curIndex)
            self.swap(curIndex,self.smallerChild(curIndex))
            curIndex = tempIndex
        return retVal

    def smallerChild(self,index):
        if 2 * index >= len(self.container):
            return -1
        elif 2 * index + 1 >= len(self.container):
            return 2 * index
        else:
            if self.cmpfunc(self.container[2*index],self.container[2*index+1]) == -1:
                return 2*index
            return 2*index + 1

    def peek(self):
        if len(self.container) == 1:
            return None
        return self.container[1]

    def toList(self):
        retList = []
        while len(self.container) > 1:
            retList.append(self.pop())
        return retList

f = open(sys.argv[1],'r')
sc = f.read().split('\n')
j = open(sys.argv[2],'w')
print (sc)
test = Pqueue()

for line in sc:
    command = line.split(',')
    print (command)
    if command[0] == 'push':
        for x in range(len(command) - 1):
            test.push(int(command[x+1]))
    elif command[0] == 'peek':
        j.write(str(test.peek()))
        j.write('\n')
    elif command[0] == 'pop':
        j.write(str(test.pop()))
        j.write('\n')
    elif command[0] == 'tolist':
        j.write(str(test.toList()))
        j.write('\n')
        
