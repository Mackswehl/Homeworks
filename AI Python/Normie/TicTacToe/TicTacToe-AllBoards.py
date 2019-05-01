#! usr/bin/python3

import sys

# Counting the total number of possible games and resulting game boards in the Tic-Tac-Toe solution set

# Layout positions:
# 0 1 2
# 3 4 5
# 6 7 8

# Counter for the total number of possible games of Tic-Tac-Toe
# Games end when one side wins or when the board is filled (after 9 moves)
numOfGames = 0

numOfXWins = 0
numOfOWins = 0
numOfDraws = 0

# Set containing distinct boards produced by the games
# Different game paths can result in the same exact
boardConfigs = set()

# Dictionary containing all of the possible board layouts
# Key - Each distinct board layout
# Value - Corresponding boardNode
AllBoards = {}

# Stack to contain the last state of the board and the moves already explored
stack = []
stack.append([[],curBoard])

# Indices that must be the same symbol in order to win the game
solutions = [[0,1,2],[3,4,5],[6,7,8], #rows
            [0,3,6],[1,4,7],[2,5,8], #columns
            [0,4,8],[2,4,6]] #diagonals

# Method isSovled(board)
# Parameters:
#   board - current state of the Tic-Tac-Toe board as a string
# Returns true if either side wins with the current board (three x's or three o'x in a row)
def isSolved(board):
        for clique in solutions:
            pos0 = clique[0]
            pos1 = clique[1]
            pos2 = clique[2]
            if curBoard[pos0] != '_' and curBoard[pos0] == curBoard[pos1] == curBoard[pos2]:
                return True
        return False

def winner(board):
    if isSolved(board):
        for clique in solutions:
            pos0 = clique[0]
            pos1 = clique[1]
            pos2 = clique[2]
            if curBoard[pos0] != '_' and curBoard[pos0] == curBoard[pos1] == curBoard[pos2]:
                return curBoard[pos0]
    else:
        return None

def gameOver(board):
    full = True
    for element in curBoard:
        if element == '_':
            full = False
    if full or isSolved(board):
        return True
    return False

def makeNextMove():
    global numOfGames
    global boardConfigs
    global numOfDraws
    global numOfXWins
    global numOfOWins

    if curBoard.count('_') % 2 == 0:
        nextMove = 'o'
    else:
        nextMove = 'x'

    if gameOver(curBoard) or curBoard.count('_') == len(stack[len(stack) - 1][0]):
        if gameOver(curBoard):
            numOfGames += 1
            if isSolved(curBoard):
                if winner(curBoard) == 'x':
                    numOfXWins += 1
                elif winner(curBoard) == 'o':
                    numOfOWins += 1
            else:
                numOfDraws += 1
        boardConfigs.add(curBoard)
        stack.pop()
        # print ("\n\n\n POP \n\n\n")
        if len(stack) > 0:
            curBoard = stack[len(stack) - 1][1]
    else:
        index = 0
        while index < 9:
            if curBoard[index] == '_' and index not in stack[len(stack) - 1][0]:
                newBoard = curBoard[0:index] + nextMove + curBoard[index + 1:]
                stack[len(stack) - 1][0].append(index)
                stack.append([[],newBoard])
                curBoard = newBoard
                break
            else:
                index += 1
    # print (curBoard)
    # print (stack)
    # print ('\n')

class BoardNode:
    def __init__(self,layout):
        self.layout = layout
        self.endState = None # if this is a terminal board, endState == 'x' or 'o' for wins, of 'd' for draw, else None
        self.parents = [] # all layouts that can lead to this one, by one move
        self.children = [] # all layouts that can be reached with a single move

    def print_me(self):
        print ('layout:',self.layout, 'endState:',self.endState)
        print ('parents:',self.parents)
        print ('children:',self.children)

def CreateAllBoards(layout,parent):
    # recursive function to manufacture all BoardNode nodes and place them into the AllBoards dictionary
    if layout not in AllBoards:
        AllBoards[layout] = newNode(layout)
    if parent not in AllBoards[layout].parents:
        AllBoards[layout].parents.append(parent)

    if curBoard.count('_') % 2 == 0:
        nextMove = 'o'
    else:
        nextMove = 'x'
