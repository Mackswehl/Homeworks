#! /usr/bin/python3

import sys

# Opening the read and write files
boardFile = open(sys.argv[1],'r')
inputLines = boardFile.read().split('\n')
solvedOutput = open(sys.argv[2],'w')
boardName = sys.argv[3]

# Counter to check how many backtracks are necesary to solve the puzzle
# AKA to see how bad the naive solver method is
backTrackerer = 0

stack = []

# List of "cliques" for every row, column, and cell
Cliques = [
# Rows
[0,1,2,3,4,5,6,7,8],
[9,10,11,12,13,14,15,16,17],
[18,19,20,21,22,23,24,25,26],
[27,28,29,30,31,32,33,34,35],
[36,37,38,39,40,41,42,43,44],
[45,46,47,48,49,50,51,52,53],
[54,55,56,57,58,59,60,61,62],
[63,64,65,66,67,68,69,70,71],
[72,73,74,75,76,77,78,79,80],
# Columns
[0,9,18,27,36,45,54,63,72],
[1,10,19,28,37,46,55,64,73],
[2,11,20,29,38,47,56,65,74],
[3,12,21,30,39,48,57,66,75],
[4,13,22,31,40,49,58,67,76],
[5,14,23,32,41,50,59,68,77],
[6,15,24,33,42,51,60,69,78],
[7,16,25,34,43,52,61,70,79],
[8,17,26,35,44,53,62,71,80],
# Cells
[0,1,2,9,10,11,18,19,20],
[3,4,5,12,13,14,21,22,23],
[6,7,8,15,16,17,24,25,26],
[27,28,29,36,37,38,45,46,47],
[30,31,32,39,40,41,48,49,50],
[33,34,35,42,43,44,51,52,53],
[54,55,56,63,64,65,72,73,74],
[57,58,59,66,67,68,75,76,77],
[60,61,62,69,70,71,78,79,80]]

# Creating a dictionary of the "neighbors" of each position in the board
neighborDict = {}
for pos in range(81):
    neighborList = []
    for clique in Cliques:
        if pos in clique:
            for i in clique:
                # Puts every UNIQUE clique neighbor into the list (no duplicates allowed)
                if i != pos and i not in neighborList:
                    neighborList.append(i)
    neighborDict[pos] = neighborList

# Finding the puzzle in the input file and putting into a list
puzzleStr = ""
index = 0
while inputLines[index] != boardName:
    index += 1
# When the name of the puzzle is found:
for i in range(index + 1,index + 10):
    # Take the next 9 lines in the file and concatenate into one string
    puzzleStr += inputLines[i]
    # Adding a comma when at the end of the line (except for the 9th line)
    if (i - index) != 10:
        puzzleStr += ','
# Once all of the lines are in a string, make a list of each pos by splitting on commas
puzzleList = puzzleStr.split(',')
stack.append([[],list(puzzleList)])

# Function: neighborValues(pos)
# Parameters:
#   pos - Position on the sudoku board
# Returns the values (from 1 to 9) already used by the neighbors of pos at certain state
# Returns as a set to remove duplicates and speed up time to check for presence of value
def neighborValues(pos):
    valueList = []
    positions = neighborDict[pos]
    for neighbor in positions:
        valueList.append(puzzleList[neighbor])
    valueSet = set(valueList)
    if '_' in valueSet:
        valueSet.remove('_')     # Remove the '_' because it's not a numerical value of one of the neighbors
    return valueSet

# Prints the puzzleList as a 9x9 box for visualization purposes
def printPuzzle():
    global puzzleList
    for i in range(9):
        print (puzzleList[i*9:i*9+9])
        print ('\n')

def forceSearch():
    global puzzleList

    index = 0
    while index < 81:
        if puzzleList[index] == '_':
            neighVal = neighborValues(index)
            if len(neighVal) == 8:
                for i in range(1,10):
                    stri = str(i)
                    if stri not in neighVal:
                        puzzleList[index] = stri
                        break
                index = 0
            else:
                index += 1
        else:
            index += 1

def nextGuessIndex():
    nextGuessIndex = 0
    neighborLen = 0
    i = 0
    while i < 81:
        if puzzleList[i] == '_':
            if len(neighborValues(i)) > neighborLen:
                nextGuessIndex = i
                neighborLen = len(neighborValues(i))
        i += 1

    #print (nextGuessIndex)
    #print (neighborValues(nextGuessIndex))
    return nextGuessIndex

def makeGuess(guessIndex):
    global puzzleList
    global backTrackerer
    global stack

    neighVals = neighborValues(guessIndex)
    if len(neighVals) + len(stack[len(stack) - 1][0]) < 9:
        for i in range(1,10):
            stri = str(i)
            if stri not in neighVals and stri not in stack[len(stack) - 1][0]:
                stack[len(stack) - 1][0].append(stri)
                puzzleList[guessIndex] = stri
                stack.append([[],list(puzzleList)])
                break
    else:
        stack.pop()
        backTrackerer += 1
        puzzleList = stack[len(stack) - 1][1]
        #print ("\n\n\n\n\n\n BACKTRACK \n\n\n\n\n\n")

    #print (stack)




def lvl1Solver():
    while '_' in puzzleList:
        #print ("Current Puzzle State: " + '\n')
        #printPuzzle()
        forceSearch()
        #print ("After forcing: " + '\n')
        #printPuzzle()
        ngi = nextGuessIndex()
        makeGuess(ngi)
    print backTrackerer

    nameList = boardName.split(',')
    nameList[2] = "solved"
    solvedOutput.write(','.join(nameList) + '\n')
    # Writing out the solution as a 9x9 box instead of one long line
    for i in range(9):
        solvedOutput.write(','.join(puzzleList[i*9:i*9+9]) + '\n')

lvl1Solver()
