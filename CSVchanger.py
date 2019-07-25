import csv

x = 0
guidList = []
fNameList = []
sNameList = []

with open('patients.csv') as csv_file:
    csvReader = csv.reader(csv_file)

    #next(csvReader) # skips the header of the csv

    for row in csvReader:
        guidList.append(row[0])
        fNameList.append(row[1])
        sNameList.append(row[2])
        x = x + 1

print(x)
print(guidList)
print(fNameList)
print(sNameList)

with open('new.csv', 'w') as newCsv:
    csvWriter = csv.writer(newCsv)



