#! /usr/bin/python3
import sys
print(sys.argv)
f = open(sys.argv[1], 'r')
g = open(sys.argv[2], 'w')
sc = f.read().split('\n')
for line in sc:
    lSum = 0
    x = line.split(',')
    for element in x:
        stripped = element.strip()
        if stripped.isdigit():
            if stripped >= 0:
                lSum += int(stripped)
    if lSum > 0:
        g.write(str(lSum))
    g.write('\n')
