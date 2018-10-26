#! /usr/bin/python3

import sys, heapq

wordList = open("dictall.txt", "r").read().split("\n")

inputWords = open(sys.argv[1], 'r').read().strip().split('\n')
output = open(sys.argv[2], 'w')
wLen = len(inputWords[0].split(',')[0]) # Gets the length of the first word of the word ladder

sameLenWords = set([x for x in wordList if len(x) == wLen]) # Makes a set of all words of the same length as the first word in the world ladder

dict = {}
# Create a dictionary of all words of the same length
# Every word is a key in the dictionary
# The value of each key is a list of the word's "neighbors"
for word in sameLenWords:
    NBD = []
    for pos in range(wLen):
        for letter in "abcdefghijklmnopqrstuvwxyz":
            if letter != word[pos]:
                if word[:pos] + letter + word[pos+1:] in sameLenWords:
                    NBD.append(word[:pos] + letter + word[pos+1:])

    dict[word] = NBD

class Node():

    def __init__(self,AValue,word,pathTo):
        self.AValue = AValue
        self.word = word
        self.pathTo = pathTo

    def toTuple(self):
        return (self.AValue,self.word,self.pathTo)

class ASearch():

    def __init__(self,first,last):
        self.ux = set()
        self.fr = []
        self.x = set()
        self.firstWord = first
        self.lastWord = last
        firstNode = Node(self.estimate(self.firstWord),self.firstWord,[])
        heapq.heappush(self.fr,firstNode.toTuple())

    def populateUx(self):
        for word in sameLenWords:
            self.ux.add(word)

    def estimate(self,curWord):
        guess = 0
        for pos in range(len(self.firstWord)):
            if curWord[pos] != self.lastWord[pos]:
                guess += 1
        return guess

    def popBest(self):
        bestPath = heapq.heappop(self.fr)
        self.x.add(bestPath[1])

        newPath = list(bestPath[2])
        newPath.append(bestPath[1])

        neighborList = dict[bestPath[1]]
        for neighbor in neighborList:
            if neighbor not in self.x:
                if neighbor in self.ux:
                    self.ux.remove(neighbor)
                newNode = Node(bestPath[0] - self.estimate(bestPath[1]) + 1 + self.estimate(neighbor), neighbor, newPath)
                heapq.heappush(self.fr,newNode.toTuple())
        return bestPath

for input in inputWords:

    pair = input.split(',')
    search = ASearch(pair[0],pair[1])
    search.populateUx()
    while pair[1] not in search.x:
        if len(search.fr) == 0:
            shortestPath = list(pair)
            break
        target = search.popBest()
        shortestPath = list(target[2])
        shortestPath.append(target[1])

    output.write(','.join(shortestPath))
    output.write('\n')
