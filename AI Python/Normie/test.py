s = "iajsdhjaidhguiaf,adgiuadfgisdhfg,adfgadfgsd,adfgadfgdfa,g,,adfb,gb,fgh,fg,hfsg,h"
split = s.split(',')
print (split)
print (','.join(split))
strip = "                                        hi eric                    "
print (strip.strip())
number = "1"
notNumber = 'not1'
print (number.isdigit())
print (notNumber.isdigit())
#split.sort()
print (sorted(split))
print (sorted(split, reverse = True))
print (split)
split.sort()
print (split)

newDict = {}
newDict["eric"] = "muy inteligente"
newDict['AI'] = "hard af"
print (newDict)
print (newDict.get("eric"))
for x in newDict:
    print (x)

for x in newDict:
    print (newDict[x])

print ("Maxwell" in newDict)
print ("eric" in newDict)

order = [1,1,1,1,1,1,12,2,2,2,2,2,3,3,4,5,5,6,6,7,7,7,8,8,9,90,0,0]
print (set(order))
s = set(order)
s.add(100)
print (s)
s.pop()
print (s)
s.pop()
print (s)

print ('7.5'.isdigit())
