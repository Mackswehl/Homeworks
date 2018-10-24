#! /usr/bin/python3

import sys

wordList = open("dictall.txt", "r").read().split("\n")

inputWords = open(sys.argv[1], 'r').read().strip().split('\n')
output = open(sys.argv[2], 'w')
wLen = len(inputWords[0])

sameLenWords = set([x for x in wordList if len(x) == wLen])

dict = {}
for word in sameLenWords:
    NBD = []
    for pos in range(wLen):
        for letter in "abcdefghijklmnopqrstuvwxyz":
            if letter != word[pos]:
                if word[:pos] + letter + word[pos+1:] in sameLenWords:
                    NBD.append(word[:pos] + letter + word[pos+1:])

    dict[word] = NBD

for input in inputWords:
    output.write(input + ',' + str(len(dict[input])) + '\n')
