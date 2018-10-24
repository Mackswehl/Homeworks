#Maxwell Vale
#AI period 9
#AI HW 3

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

test = Pqueue()
test.push(12)
test.push(3)
test.push(20)
test.push(1)
test.push(8)
print (test.peek())
print (test.pop())
test.push(0)
test.push(0)
test.push(3)
print (test.peek())
print (test.toList())
print (test.pop())
# Leo = Pqueue()
# Leo.push(5)
# Leo.push(10)
# Leo.push(3)
# Leo.push(4)
# Leo.push(15)
# Leo.push(7)
# Leo.push(4)
# print(Leo.container)
# print (Leo.pop())
# print(Leo.container)
# Leo.push(100)
# Leo.push(9)
# Leo.push(16)
# Leo.push(20)
# Leo.push(25)
# Leo.push(21)
# Leo.push(6)
# Leo.push(1)
# print(Leo.container)
# print (Leo.pop())
# print (Leo.pop())
# print (Leo.pop())
# print(Leo.container)
#
# print (Leo.toList())
# print (Leo.pop())
