import csv
import random

x = 0
csvList = []
startHour = 8
startMin = 0

with open('patients.csv') as csv_file:
    csvReader = csv.reader(csv_file)

    #next(csvReader) # skips the header of the csv

    for row in csvReader:
        csvList.append(row)
        x = x + 1

csv_file.close()

print(x)

csvList[0].append("hour")
csvList[0].append("minutes")

randomHour = startHour
randomMin = startMin

for y in range(1, x):
    minuteAdd = random.randint(0, 6)
    randomMin = randomMin + minuteAdd

    if randomMin > 60:
        randomMin = 0
        randomHour = randomHour + 1

    csvList[y].append(randomHour)
    csvList[y].append(randomMin)

print(csvList)

#for y in range(0, x):


with open('new.csv', 'w') as newCsv:
    csvWriter = csv.writer(newCsv)
    csvWriter.writerows(csvList)



