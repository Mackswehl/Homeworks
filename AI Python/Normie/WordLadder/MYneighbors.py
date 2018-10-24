#! /usr/bin/python3

import sys

fin = open("dictall.txt", "r")
allWords = fin.read().split("\n")

f = open(sys.argv[1], "r")
rungs = f.read().split("\n")
j = open(sys.argv[2], "w")

dict = {}
for word in rungs:
    neighborList = []

    for entry in allWords:
        if len(entry) == len(word) and entry != word:
            for x in range(len(word)):
                if word[0:x] + word[x+1:] == entry[0:x] + entry[x+1:]:
                    neighborList.append(entry)
                    break

    dict[word] = neighborList
    j.write(word)
    j.write(",")
    j.write(str(len(dict[word])))
    j.write("\n")
