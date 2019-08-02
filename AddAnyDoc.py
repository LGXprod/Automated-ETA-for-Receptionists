import csv
import random

x = 0
csvList = []
randDr1 = "1"
randDr2 = "2"
randDr3 = "3"
randDr4 = "4"
randDr5 = "5"
randDr6 = "6" # Any doctor
randDr7 = "7" # Any female doctor
randDr8 = "8" # Any male doctor

with open('patientList.csv') as csv_file:
    csvReader = csv.reader(csv_file)

    #next(csvReader) # skips the header of the csv

    for row in csvReader:
        csvList.append(row)
        x = x + 1

csv_file.close()

csvList[0].append("doctor")

randDocName = ""

for y in range(1, x):

    randomDoc = random.randint(1,6)

    if randomDoc == 1:
        randDocName = randDr1
    elif randomDoc == 2:
        randDocName = randDr2
    # elif randomDoc == 3:
    #     randDocName = randDr3
    # elif randomDoc == 4:
    #     randDocName = randDr4
    elif randomDoc == 3:
        randDocName = randDr5
    # elif randomDoc == 6:
    #     randDocName = randDr8
    # elif randomDoc == 7:
    #     randDocName = randDr7
    elif randomDoc >= 4:
        randDocName = randDr6

    csvList[y].append(randDocName)

print(csvList)

with open('patientList2.csv', 'w') as newCsv:
    csvWriter = csv.writer(newCsv)
    csvWriter.writerows(csvList)
