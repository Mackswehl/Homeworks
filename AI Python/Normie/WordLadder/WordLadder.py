#! /usr/bin/python3

import sys
import heapq

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

# Node class holds the current word, the path to that word, and the predicted cost of using that word (AValue)
class Node():

    def __init__(self,AValue,word,pathTo):
        self.AValue = AValue
        self.word = word
        self.pathTo = pathTo

    # Since tuples are used to push into the heap, Node should have a method that returns data in a tuple
    def toTuple(self):
        return (self.AValue,self.word,self.pathTo)

# ASearch class contains the methods needed to execute A*Search properly
class ASearch():

    def __init__(self,first,last):
        self.ux = set() # Unexplored words (a set)
        self.fr = [] # Words on the frontier of exploration (a heap)
        self.x = set() # Explored words (a set)
        self.firstWord = first # Beginning of word ladder
        self.lastWord = last # End of word ladder
        # Initialize with the first word of the word ladder push into the frontier
        firstNode = Node(self.estimate(self.firstWord),self.firstWord,[])
        heapq.heappush(self.fr,firstNode.toTuple())

    # Will fill set Ux with all of the words of the same length as the first
    def populateUx(self):
        for word in sameLenWords:
            self.ux.add(word)

    # Estimate of how many steps away curWord is from the target word
    # Just compares the letters at each position of the words
    def estimate(self,curWord):
        guess = 0
        for pos in range(len(self.firstWord)):
            if curWord[pos] != self.lastWord[pos]:
                guess += 1
        return guess

    # Pops the best Tuple off of the heap
    # Adds available neighbors of the word to the frontier with updated cost and pathTo
    def popBest(self):
        # Best path is popped off of the heap and added to the explored set
        bestPath = heapq.heappop(self.fr)
        self.x.add(bestPath[1])

        # Create a copy of the pathTo that word
        # Adds the curWord to the path (for its neighbors)
        newPath = list(bestPath[2])
        newPath.append(bestPath[1])

        # Acquires the neighborList of the word popped off of the heap
        neighborList = dict[bestPath[1]]
        # If the neighbor hasn't been added to explored yet, then create a new node for that neighbor
        for neighbor in neighborList:
            # If this is the first time the neighbor is being added to frontier, then remove from unexplored
            if neighbor not in self.x:
                if neighbor in self.ux:
                    self.ux.remove(neighbor)

                # Need to take away the estimate (heuristic) from the previous node, incremented by 1, and add the estimate of the neighbor
                newNode = Node(bestPath[0] - self.estimate(bestPath[1]) + 1 + self.estimate(neighbor), neighbor, newPath)
                heapq.heappush(self.fr,newNode.toTuple())
        return bestPath

for input in inputWords:

    pair = input.split(',')
    search = ASearch(pair[0],pair[1])
    search.populateUx()
    while pair[1] not in search.x:
        if len(search.fr) == 0: # Means that all possible paths were searched already -> No path exists
            shortestPath = list(pair)
            break
        target = search.popBest()
        shortestPath = list(target[2])
        shortestPath.append(target[1])

    output.write(','.join(shortestPath))
    output.write('\n')
