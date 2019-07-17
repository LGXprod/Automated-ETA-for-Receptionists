import csv

with open('patients.csv') as csv_file:
    csvReader = csv.DictReader(csv_file)

    #next(csvReader) # skips the header of the csv

    for line in csvReader:
        print(line['doctor'])

