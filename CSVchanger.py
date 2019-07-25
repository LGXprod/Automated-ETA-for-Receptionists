import csv
import random

x = 0
csvList = []

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

for y in range(1, x):
    randomHour = random.randint(1, 13)
    randomMin = random.randint(1, 60)
    csvList[y].append(randomHour)
    csvList[y].append(randomMin)

print(csvList)

#for y in range(0, x):


with open('new.csv', 'w') as newCsv:
    csvWriter = csv.writer(newCsv)
    csvWriter.writerows(csvList)



