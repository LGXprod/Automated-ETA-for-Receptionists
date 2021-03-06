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
csvList[0].append("newPatient")

randomHour = startHour
randomMin = startMin
randDocName = ""
newPatient = False

for y in range(1, x):

    if y <= 40:
        minuteAdd = random.randint(4, 8) # minuteAdd = round(random.uniform(0, 1.75), 2)
        #8am-12pm 40 patients, 1 patient per 6 min, variance of 2 mins
    elif y <= 210:
        minuteAdd = random.randint(0, 3)
        #12am-4pm 170 patients, 1 patient per 1.4 (rounded to 1) min, variance of 2 mins
    else:
        minuteAdd = random.randint(3, 7)
        #12am-4pm 170 patients, 1 patient per 5 min, variance of 2 mins

    randomDoc = random.randint(1,5)
    newPatientOdds = random.randint(1,6)

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

    if newPatientOdds < 6:
        newPatient = False
    else:
        newPatient = True

    csvList[y].append(randomHour)
    csvList[y].append(randomMin)
    csvList[y].append(randDocName)
    csvList[y].append(newPatient)

print(csvList)



with open('new.csv', 'w') as newCsv:
    csvWriter = csv.writer(newCsv)
    csvWriter.writerows(csvList)



