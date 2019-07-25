import csv
import random

x = 0
csvList = []
startHour = 8
startMin = 0
randDr1 = "Doctor A"
randDr2 = "Doctor B"
randDr3 = "Doctor C"
randDr4 = "Doctor D"
randDr5 = "Doctor E"

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
csvList[0].append("doctor")

randomHour = startHour
randomMin = startMin
randDocName = ""

for y in range(1, x):
    minuteAdd = random.randint(0, 6)
    randomDoc = random.randint(1,5)

    randomMin = randomMin + minuteAdd

    if randomMin >= 60:
        randomMin = 0
        randomHour = randomHour + 1

    if randomDoc == 1:
        randDocName = randDr1
    elif randomDoc == 2:
        randDocName = randDr2
    elif randomDoc == 3:
        randDocName = randDr3
    elif randomDoc == 4:
        randDocName = randDr4
    else:
        randDocName = randDr5

    csvList[y].append(randomHour)
    csvList[y].append(randomMin)
    csvList[y].append(randDocName)

print(csvList)



with open('new.csv', 'w') as newCsv:
    csvWriter = csv.writer(newCsv)
    csvWriter.writerows(csvList)



