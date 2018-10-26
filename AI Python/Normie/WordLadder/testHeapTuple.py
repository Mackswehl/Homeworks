import heapq

heap = []
heapq.heappush(heap, (5,"dead",['read','nead']))
heapq.heappush(heap, (3,"head",['lead']))
heapq.heappush(heap, (2,"bead",['sear','rear','bear']))
heapq.heappush(heap, (7,"bean",[]))
heapq.heappush(heap, (6,"sean",['ream','reak','leak','lean']))
print (heap)
print (heapq.heappop(heap))
print (heapq.heappop(heap))
print (heapq.heappop(heap))
print (heapq.heappop(heap))
