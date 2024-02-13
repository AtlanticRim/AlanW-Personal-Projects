# SQL Queries for Funeral Home
# J. Alan Wallace & Shakira Eaddy

# Query for Problem 1
# Returns total of services for Shelton Reynolds
SELECT SUM(serviceCost) AS SumOfServices
FROM BusinessServices
WHERE ServiceNo IN (
	SELECT ServiceNo
	FROM BillServices
	WHERE billNo = (
		SELECT billNo
		FROM Bill
		WHERE callNumber = (
			SELECT callNumber
			FROM Service
			WHERE decSSN = (
				SELECT SSN
				FROM Deceased
				WHERE firstName = "Shelton" AND lastName = "Reynolds"
				)
			)
		)
	);

# Query for Problem 2
# Returns total of items for Shelton Reynolds
SELECT SUM(itemCost) AS SumOfItems
FROM Item
WHERE itemNo IN (
	SELECT itemNo
	FROM BillItems
	WHERE billNo = (
		SELECT billNo
		FROM Bill
		WHERE callNumber = (
			SELECT callNumber
			FROM Service
			WHERE decSSN = (
				SELECT SSN
				FROM Deceased
				WHERE firstName = "Shelton" AND lastName = "Reynolds"
				)
			)
		)
	);
    
# Query for Problem 3
# Selects the total of florist charges for services from March 10 2023 to March 31 2023
SELECT SUM(floristCharge) AS totalFloristCharges
FROM bill
WHERE callNumber IN (
SELECT callNumber
FROM Service
WHERE dateOfService > '2023-03-10' AND dateOfService < '2023-03-31'
);

# Query for Problem 4
# Selects the names of all deceased who were college graduates, sorted by age and grouped by sex
SELECT title, firstName, lastName, college
FROM Deceased
WHERE college IS NOT NULL
GROUP BY title, firstName, lastName, college, age, sex
ORDER BY age;

# Query for Problem 5
# Selects the names of all relatives of Shelton Reynolds
SELECT relFirstName, relMiddleName, relMaidenName, relLastName
FROM Relative
WHERE relationshipToDecedent = "Child" AND decSSN = (
SELECT SSN
FROM Deceased
WHERE firstName = "Shelton" AND lastName = "Reynolds"
);

# Query for Problem 6
# Selects the number of male deceased who were veterans and between 30 and 50 years of age
SELECT COUNT(SSN) as countOfVeterans
FROM Deceased
WHERE inArmedForces = TRUE AND sex = 'M' AND age > 30 AND age < 50;

# Query for Problem 7
# Selects the percentage of open casket services
SELECT ((
SELECT COUNT(callNumber)
FROM Service
WHERE closedCasket = FALSE)
/ COUNT(callNumber)) AS percentageOfOpenCaskets
FROM Service; 
