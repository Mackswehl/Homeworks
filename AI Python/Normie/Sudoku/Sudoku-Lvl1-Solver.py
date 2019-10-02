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

# Stack to keep track of the latest verion of the current sudoku puzzle
# Allows for backtracking in case a guess was incorrect (just pop the most recent version and revert to the previous one)
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
# Add the original version of the puzzle to the stack
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

# Looks for empty spaces in the puzzle in which a value can be FORCED
# A value can be forced at an empty when 8 out of 9 of the possible numbers have been used by the empty spot's neighbors (row, column, cell)
def forceSearch():
    global puzzleList

    index = 0
    while index < 81:
        if puzzleList[index] == '_':
            neighVal = neighborValues(index)
            if len(neighVal) == 8: # 8 out of 9 numbers were used by neighbors
                for i in range(1,10):
                    stri = str(i)
                    if stri not in neighVal: # Find the number that wasn't used by neighbors
                        puzzleList[index] = stri
                        break
                # Restart the search for forces because one force might lead other spaces to force into a single number
                index = 0
            else:
                index += 1
        else:
            index += 1

# Finds the index of the next best place to guess
# In this solver, "Next Best" guess would be the empty with the least possibilities for numbers in that position
# To find that, nextGuessIndex() looks for empty spaces with the longest neighVal list
# Longer neighVal list signifies more numbers used by neighbors, thus leaving less possibilities for the empty space
def nextGuessIndex():
    nextGuessIndex = 0 # Keep track of index of where next guess should happen
    neighborLen = 0 # Keep track of len of neighbor list to compare to other empty indices
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

# Make a guess at guessIndex retrieved from nextGuessIndex()
def makeGuess(guessIndex):
    global puzzleList
    global backTrackerer
    global stack

    neighVals = neighborValues(guessIndex)
    if len(neighVals) + len(stack[len(stack) - 1][0]) < 9: # There are still numbers that can be guessed
        for i in range(1,10):
            stri = str(i)
            if stri not in neighVals and stri not in stack[len(stack) - 1][0]: # If number hasn't been used by a neighbor and hasn't been guessed yet
                stack[len(stack) - 1][0].append(stri) # Update guesses at that state
                puzzleList[guessIndex] = stri # Fill in the empty with the guessed numnber
                stack.append([[],list(puzzleList)]) # Add new state to the top of the stack
                break
    else: # This means a contradiction was reached -> Neighbors use all 9 numbers or all possible numbers were guessed and failed
        stack.pop() # Pop the latest state off the top of the stack
        backTrackerer += 1 # Increment the backtrack counter
        puzzleList = stack[len(stack) - 1][1] # Set puzzleList to the state now at the top of the stack
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
        printPuzzle()
        print('\n\n')
    print backTrackerer

    nameList = boardName.split(',')
    nameList[2] = "solved"
    solvedOutput.write(','.join(nameList) + '\n')
    # Writing out the solution as a 9x9 box instead of one long line
    for i in range(9):
        solvedOutput.write(','.join(puzzleList[i*9:i*9+9]) + '\n')

lvl1Solver()
