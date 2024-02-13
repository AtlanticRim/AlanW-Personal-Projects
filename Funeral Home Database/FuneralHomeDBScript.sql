# SQL Script for Funeral Home
# J. Alan Wallace & Shakira Eaddy

# 13 Tables Defined

CREATE TABLE Deceased (
SSN DECIMAL(9,0) PRIMARY KEY,
title VARCHAR(10),
firstName VARCHAR(20) NOT NULL,
middleName VARCHAR(20),
lastName VARCHAR(40) NOT NULL,
maidenName VARCHAR(40),
suffix VARCHAR(10),
decStreetAddress VARCHAR(100) NOT NULL,
decApartmentNo VARCHAR(4),
decCity VARCHAR(40),
decCounty VARCHAR(40),
decState CHAR(2),
decZIP CHAR(5),
inCityLimits BOOLEAN,
age SMALLINT NOT NULL,
sex CHAR(1) NOT NULL CHECK (sex IN ('M','F')),
race VARCHAR(20),
maritalStatus VARCHAR(13) NOT NULL, CHECK (maritalStatus IN ("Married", "Divorced", "Never Married", "Widowed")),
dateOfBirth DATE NOT NULL,
birthplace VARCHAR(100),
inArmedForces BOOLEAN,
AFBranch VARCHAR(20),
occupation VARCHAR(40),
typeOfBusiness VARCHAR(40),
elementarySchool VARCHAR(100),
highSchool VARCHAR(100),
college VARCHAR(100),
typeOfDegree VARCHAR(40),
church VARCHAR(100),
methodOfDisposition VARCHAR(100) NOT NULL,
placeOfDisposition VARCHAR(100) NOT NULL
);

CREATE TABLE Relative (
decSSN DECIMAL (9,0) NOT NULL,
FOREIGN KEY (decSSN) REFERENCES Deceased(SSN),
relFirstName VARCHAR(40) NOT NULL,
relMiddleName VARCHAR(40),
relLastName VARCHAR(40) NOT NULL,
relMaidenName VARCHAR(40),
townOfResidence VARCHAR(100),
relationshipToDecedent VARCHAR(40) NOT NULL,
CHECK (relationshipToDecedent IN ("Mother", "Father", "Brother", "Sister", "Spouse", "Cousin", "Child",
"Neice", "Nephew", "Aunt", "Uncle", "Friend", "Stepfather", "Stepmother", "Grandfather", "Grandmother")),
PRIMARY KEY (decSSN, relFirstName, relLastName, relationshipToDecedent)
);

CREATE TABLE Informant (
decSSN DECIMAL(9,0) PRIMARY KEY,
FOREIGN KEY (decSSN) REFERENCES Deceased(SSN),
phoneNumber DECIMAL(10,0) NOT NULL,
infFirstName VARCHAR(40) NOT NULL,
infLastName VARCHAR(40) NOT NULL,
infStreetAddress VARCHAR(100) NOT NULL,
infCity VARCHAR(40) NOT NULL,
infState CHAR(2) NOT NULL,
infZIP CHAR(5) NOT NULL
);

CREATE TABLE Item (
itemNo INT PRIMARY KEY,
itemName VARCHAR(40) NOT NULL,
itemCost DECIMAL(7,2), CHECK (itemCost >= 0.00)
);

CREATE TABLE BusinessServices (
serviceNo INT PRIMARY KEY,
serviceName VARCHAR(60) NOT NULL,
serviceCost DECIMAL(7,2), CHECK (serviceCost >= 0.00)
);

CREATE TABLE Service (
callNumber VARCHAR(8) PRIMARY KEY,
decSSN DECIMAL(9,0) NOT NULL,
FOREIGN KEY (decSSN) REFERENCES Deceased(SSN),
numDeathCertsOrdered INT,
dateDeathCertsOrdered DATE,
placeOfService VARCHAR(40),
dateOfService DATE,
timeOfService TIME,
placeInChurch VARCHAR(40),
closedCasket BOOLEAN,
casketItemNo INT,
FOREIGN KEY (casketItemNo) REFERENCES Item(itemNo),
dateCasketOrdered DATE,
vaultItemNo INT,
FOREIGN KEY (vaultItemNo) REFERENCES Item(itemNo),
dateVaultOrdered DATE,
jewelry BOOLEAN,
removeJewelry BOOLEAN,
pins BOOLEAN,
removePins BOOLEAN,
glasses BOOLEAN,
removeGlasses BOOLEAN,
notes VARCHAR(500)
);

CREATE TABLE Memorials (
callNumber VARCHAR(8) NOT NULL,
FOREIGN KEY (callNumber) REFERENCES Service(callNumber),
toOrganization VARCHAR(40) NOT NULL,
amount DECIMAL(7,2) NOT NULL, CHECK (amount >= 0.00),
PRIMARY KEY (callNumber, toOrganization)
);

CREATE TABLE Staff (
staffPhoneNo DECIMAL (10,0) PRIMARY KEY,
position VARCHAR(20) NOT NULL,
staffTitle VARCHAR(10),
staffFirstName VARCHAR(20) NOT NULL,
staffLastName VARCHAR(40) NOT NULL
);

CREATE TABLE ServiceStaff (
callNumber VARCHAR(8) NOT NULL,
FOREIGN KEY (callNumber) REFERENCES Service(callNumber),
staffPhoneNo DECIMAL(10,0) NOT NULL,
FOREIGN KEY (staffPhoneNo) REFERENCES Staff(staffPhoneNo),
PRIMARY KEY (callNumber, staffPhoneNo)
);

CREATE TABLE NewspaperObits (
callNumber VARCHAR(8) NOT NULL,
FOREIGN KEY (callNumber) REFERENCES Service(callNumber),
newspaper VARCHAR(40) NOT NULL,
amount DECIMAL(7,2), CHECK (amount >= 0.00),
PRIMARY KEY (callNumber, newspaper)
);

CREATE TABLE Bill (
billNo INT PRIMARY KEY,
callNumber VARCHAR(8),
FOREIGN KEY (callNumber) REFERENCES Service(callNumber),
floristCharge DECIMAL(6,2), CHECK (floristCharge >= 0.00),
certOfDeathCharge DECIMAL(6,2), CHECK (certOfDeathCharge >= 0.00) 
);

CREATE TABLE BillItems (
billNo INT NOT NULL,
FOREIGN KEY (billNo) REFERENCES Bill(billNo),
itemNo INT NOT NULL,
FOREIGN KEY (itemNo) REFERENCES Item(itemNo),
PRIMARY KEY (billNo, itemNo)
);

CREATE TABLE BillServices (
billNo INT NOT NULL,
FOREIGN KEY (billNo) REFERENCES Bill(billNo),
serviceNo INT,
FOREIGN KEY (serviceNo) REFERENCES BusinessServices(serviceNo),
PRIMARY KEY (billNo, serviceNo)
);

CREATE TABLE Inventory (
itemNo INT PRIMARY KEY,
FOREIGN KEY (itemNo) REFERENCES Item(itemNo),
amountInInv INT
);

# Scripts to insert Items & Inventory
INSERT INTO Item VALUES (001, "Basic Burial Container", 1630.00);
INSERT INTO Inventory VALUES (001, 20);
INSERT INTO Item VALUES (002, "Midgrade Burial Container", 1740.00);
INSERT INTO Inventory VALUES (002, 15);
INSERT INTO Item VALUES (003, "Decorative Burial Container", 1905.00);
INSERT INTO Inventory VALUES (003,10);
INSERT INTO Item VALUES (004, "Stainless Steel Burial Container", 2510.00);
INSERT INTO Inventory VALUES (004, 10);
INSERT INTO Item VALUES (005, "Copper Burial Container", 3395.00);
INSERT INTO Inventory VALUES (005, 7);
INSERT INTO Item VALUES (006, "Bronze Burial Container", 3780.00);
INSERT INTO Inventory VALUES (006, 5);
INSERT INTO Item VALUES (007, "Unlined Seal Burial Container", 1525.00);
INSERT INTO Inventory VALUES (007, 25);
INSERT INTO Item VALUES (008, "Concrete Box Burial Container", 1195.00);
INSERT INTO Inventory VALUES (008, 30);
INSERT INTO Item VALUES (009, "Buckley Casket", 1330.00);
INSERT INTO Inventory VALUES (009, 30);
INSERT INTO Item VALUES (010, "Ashley Casket", 1975.00);
INSERT INTO Inventory VALUES (010, 25);
INSERT INTO Item VALUES (011, "Benjamin Casket", 2190.00);
INSERT INTO Inventory VALUES (011, 15);
INSERT INTO Item VALUES (012, "Variety Casket", 2515.00);
INSERT INTO Inventory VALUES (012, 15);
INSERT INTO Item VALUES (013, "New Silver Casket", 2585.00);
INSERT INTO Inventory VALUES (013, 25);
INSERT INTO Item VALUES (014, "Neoblue Casket", 2680.00);
INSERT INTO Inventory VALUES (014, 30);
INSERT INTO Item VALUES (015, "Silverland Casket", 2775.00);
INSERT INTO Inventory VALUES (015, 10);
INSERT INTO Item VALUES (016, "Morning Mist Casket", 2790.00);
INSERT INTO Inventory VALUES (016, 10);
INSERT INTO Item VALUES (017, "Silver Edge Casket", 2850.00);
INSERT INTO Inventory VALUES (017, 10);
INSERT INTO Item VALUES (018, "Kristen Casket", 2970.00);
INSERT INTO Inventory VALUES (018, 10);
INSERT INTO Item VALUES (019, "Ebony Casket", 3190.00);
INSERT INTO Inventory VALUES (019, 10);
INSERT INTO Item VALUES (020, "Indigo Blue Casket", 3230.00);
INSERT INTO Inventory VALUES (020, 10);
INSERT INTO Item VALUES (021, "Pacific Beige Casket", 3290.00);
INSERT INTO Inventory VALUES (021, 10);
INSERT INTO Item VALUES (022, "Veteran Casket", 3375.00);
INSERT INTO Inventory VALUES (022, 10);
INSERT INTO Item VALUES (023, "Floral Casket", 3475.00);
INSERT INTO Inventory VALUES (023, 10);
INSERT INTO Item VALUES (024, "Taupe Brushed Casket", 3790.00);
INSERT INTO Inventory VALUES (024, 10);
INSERT INTO Item VALUES (025, "Langley Pine Casket", 3980.00);
INSERT INTO Inventory VALUES (025, 10);
INSERT INTO Item VALUES (026, "Weatherwood Casket", 4685.00);
INSERT INTO Inventory VALUES (026, 10);
INSERT INTO Item VALUES (027, "Cremation Rental Casket", 895.00);
INSERT INTO Inventory VALUES (027, 25);
INSERT INTO Item VALUES (028, "Alternative Container Casket", 75.00);
INSERT INTO Inventory VALUES (028, 50);

# Script to insert Services
INSERT INTO BusinessServices VALUES (001, "Basic Services", 1895.00);
INSERT INTO BusinessServices VALUES (002, "Embalming", 825.00);
INSERT INTO BusinessServices VALUES (003, "Other Preparation", 240.00);
INSERT INTO BusinessServices VALUES (004, "Viewing At Funeral Home", 390.00);
INSERT INTO BusinessServices VALUES (005, "Funeral Ceremony at Funeral Home", 795.00);
INSERT INTO BusinessServices VALUES (006, "Funeral Ceremony at Another Facility", 795.00);
INSERT INTO BusinessServices VALUES (007, "Memorial Service at Funeral Home", 715.00);
INSERT INTO BusinessServices VALUES (008, "Memorial Service at Another Facility", 715.00);
INSERT INTO BusinessServices VALUES (009, "Graveside Service", 685.00);
INSERT INTO BusinessServices VALUES (010, "Graveside Memorial Service", 625.00);
INSERT INTO BusinessServices VALUES (011, "Use of Tents", 180.00);
INSERT INTO BusinessServices VALUES (012, "Transfer of Remains to Funeral Home", 355.00);
INSERT INTO BusinessServices VALUES (013, "Hearse Service", 360.00);
INSERT INTO BusinessServices VALUES (014, "Limousine Service", 295.00);
INSERT INTO BusinessServices VALUES (015, "Family Car", 220.00);
INSERT INTO BusinessServices VALUES (016, "Service/Utility Van", 190.00);
INSERT INTO BusinessServices VALUES (017, "Use of Equipment Carried to Home", 45.00);
INSERT INTO BusinessServices VALUES (018, "Open/Close Grave", 775.00);
INSERT INTO BusinessServices VALUES (019, "Use of Cemetary Equipment", 680.00);
INSERT INTO BusinessServices VALUES (020, "Acknowledgement Cards", 10.00);
INSERT INTO BusinessServices VALUES (021, "Food Register", 5.00);
INSERT INTO BusinessServices VALUES (022, "Grave Marker", 45.00);
INSERT INTO BusinessServices VALUES (023, "Clothing", 140.00);
INSERT INTO BusinessServices VALUES (024, "Fowarding Remains to Another Funeral Home", 2290.00);
INSERT INTO BusinessServices VALUES (025, "Recieveing Remains from Another Funeral Home", 1780.00);
INSERT INTO BusinessServices VALUES (026, "Direct Cremation with Provided Or Rented Casket", 2535.00);
INSERT INTO BusinessServices VALUES (027, "Direct Cremation with Fiberboard Container", 2595.00);
INSERT INTO BusinessServices VALUES (028, "Immediate Burial with Provided Casket", 2710.00);
INSERT INTO BusinessServices VALUES (029, "Immediate Burial with Cloth Covered Wood Casket", 3705.00);

# 1 View Defined
CREATE VIEW CertOfDeathWorksheet AS
SELECT d.title, d.firstName, d.middleName, d.lastName, d.suffix, d.sex, d.SSN, d.age, d.dateOfBirth, 
d.birthplace, d.decCounty, d.decCity, d.decStreetAddress, d. decApartmentNo, d.decZip, d.inCityLimits,
d.inArmedForces, d.maritalStatus, r.relFirstName, r.relMiddleName, r.relLastName, r.relMaidenName,
i.*,  d.methodOfDisposition, d.placeOfDisposition, d.typeOfDegree, d.race, d.occupation, d.typeOfBusiness
FROM Deceased d, Informant i, Relative r
WHERE (r.relationshipToDecedent IN ("Father", "Mother", "Spouse"));

# Load in test data for Deceased
INSERT INTO Deceased VALUES (879509604, "Mr.", "Shelton", "Bay", "Reynolds", NULL, "IV", 
"527 Green Ln.", NULL, "Florence", "Florence", "SC", "29501", TRUE, 79, 'M', "White", "Married", 
'1957-09-03', "Greenville, SC", FALSE, NULL, "Cobbler", "Shoemaker", 
"Florence Elementary", "West Florence High School", "Francis Marion University", "BS of Mathematics", "Florence Baptist", "Cremation", "Florence Crematorium");
INSERT INTO Deceased VALUES (623686182, "Mr.", "Hakim", "Bo", "Branscomb", NULL, NULL, 
"870 Reike Place", NULL, "Cheraw", "Chesterfield", "SC", "29520", TRUE, 69, 'M', "Indian", "Never Married", 
'1970-10-30', "Gary, Indiana", FALSE, NULL, "Software Engineer", "Computer Development", 
"Gary Elementary", "Gary High", "Gary Community College", "Associates of Science", NULL, "Burial", "Gary Cemetary");
INSERT INTO Deceased VALUES (558404452, "Ms.", "Maren", "Cinda", "Kilpin", NULL, NULL, 
"4498 Melvin Crossing", "5B", "Chesterfield", "Chesterfield", "SC", "29520", FALSE, 58, 'F', "White", "Divorced", 
'1960-11-09', "Marlin, Louisiana", TRUE, "Army", "Data Analyst", "Military", 
"Marlin Primary School", "Marlin High", "Louisiana State Univerisity", "BS of Computer Science", "Chesterfield Church of God", "Burial", "Chesterfield Church of God Cemetary");
INSERT INTO Deceased VALUES (368151563, "Mrs.", "Gerty", "Marlee", "Dallender", "Asson", NULL, 
"56 Hansons Point", NULL, "Florence", "Florence", "SC", "29501", TRUE, 98, 'F', "African-American", "Married", 
'1980-02-21', "Florence", FALSE, NULL, "Teacher", "Education", 
"Florence Elementary", "East Florence High School", NULL, "High School", NULL, "Burial", "Oak Ridge Cemetary");
INSERT INTO Deceased VALUES (650441943, "Mr.", "Alard", "Vincent", "Cottle-Newell", NULL, "Junior", 
"36 Cherokee Drive", "10C", "New York City", "New York", "NY", "54321", TRUE, 85, 'M', "Hispanic", "Married", 
'1954-08-09', "Charlotte, NC", TRUE, "Air Force", "Waiter", "Resturaunt", 
"Charlotte Elementary", "Central High", "University of North Carolina Charlotte", "High School", "Raliegh Cathedral", "Cremation", "Ashes Scattered");

# Load in test data for Relatives
#INSERT INTO Relative VALUES (SSN, "FName", "MName", "LName", "Maiden", "Town", "relationship");
INSERT INTO Relative VALUES (879509604, "Lucina", "Marth", "Reynolds", "Roy", "Florence", "Spouse");
INSERT INTO Relative VALUES (879509604, "Marky", "Mark", "Reynolds", NULL, "Chesterfield", "Child");
INSERT INTO Relative VALUES (879509604, "Deborah", "Ann", "Ryder", "Reynolds", "Greenville", "Child");
INSERT INTO Relative VALUES (879509604, "Roy", "Ike", "Byleth", NULL, "Charleston", "Friend");
INSERT INTO Relative VALUES (623686182, "Laurel", "Hildebrand", "Branscomb", NULL, "Florence", "Child");
INSERT INTO Relative VALUES (623686182, "Herold", NULL, "Joe", NULL, "Raleigh", "Friend");
INSERT INTO Relative VALUES (368151563, "Beatrice", "Lavender", "Marlowe", "Asson", "Cheraw", "Mother");
INSERT INTO Relative VALUES (650441943, "Siebold", "Matthew", "Cooper", NULL, "Florence", "Father");

# Load in test data for Informants
INSERT INTO Informant VALUES (879509604, 8432878877, "Lucina", "Reynolds", "708 Rayben Street", "Florence", "SC", "29825");
INSERT INTO Informant VALUES (623686182, 8431814784, "Laurel", "Branscomb", "1337 South Street", "Florence", "SC", "29825");
INSERT INTO Informant VALUES (558404452, 8435215328, "Frank", "Armstrong", "44 Time Avenue", "Rockingham", "NC", "38745");
INSERT INTO Informant VALUES (368151563, 8439586741, "Taylor", "Grohl", "789 Church Circle", "Atlanta", "GA", "48520");
INSERT INTO Informant VALUES (650441943, 8439213805, "Siebold", "Cooper", "640 South Irby St.", "Florence", "SC", "29825");

# Load in test data for Service
INSERT INTO Service VALUES ("2023-01", 879509604, 5, '2023-03-04'	, "Hopewell Baptist Church", '2023-03-24'	, '7:17', "Sanctuary",
TRUE, 014, '2023-03-05', 006, '2023-03-28', FALSE, FALSE, TRUE, FALSE, FALSE, FALSE, "Do not bring daisies, the family is allergic.");
INSERT INTO Service VALUES ("2023-03", 623686182, 7, '2023-03-19', "Funeral Home", '2023-03-02', '13:29', NULL,
FALSE, 013, '2023-03-30', 005, '2023-03-19', TRUE, TRUE, FALSE, FALSE, TRUE, FALSE, NULL);
INSERT INTO Service VALUES ("2023-05", 558404452, 2, '2023-03-07'	, "Funeral Home", '2023-03-21', '6:35', NULL,
TRUE, 010, '2023-03-05', 004, '2023-03-28', FALSE, FALSE, TRUE, TRUE, FALSE, FALSE, "Family preferes roses.");
INSERT INTO Service VALUES ("2023-07", 368151563, 3, '2023-03-13'	, "Freewill Methodist Church", '2023-03-12', '8:57', "Rear Hall",
FALSE, 015, '2023-03-28', 004, '2023-03-24', TRUE, FALSE, TRUE, FALSE, FALSE, FALSE, "Family members require handicap-accessibility.");
INSERT INTO Service VALUES ("2023-13", 650441943, 5, '2023-03-23'	, "Florence Synagogue", '2023-03-23', '8:11', "Sanctuary",
TRUE, 013, '2023-04-10', 006, '2023-04-10', FALSE, FALSE, FALSE, FALSE, TRUE, TRUE, NULL);

# Load in test data for Memorials
INSERT INTO Memorials VALUES ("2023-01", "ASPCA", 200.00);
INSERT INTO Memorials VALUES ("2023-01", "Audobon Society", 500.00);
INSERT INTO Memorials VALUES ("2023-01", "National Parks", 550.00);
INSERT INTO Memorials VALUES ("2023-03", "Boys & Girls Club", 300.00);
INSERT INTO Memorials VALUES ("2023-13", "Boy Scouts of America", 200.00);
INSERT INTO Memorials VALUES ("2023-13", "Girl Scouts of America", 200.00);
INSERT INTO Memorials VALUES ("2023-05", "Samaritan's Purse", 900.00);

# Load in test data for Staff
INSERT INTO Staff VALUES (2296523934, "Organist", NULL, "Augistine", "Casbolt");
INSERT INTO Staff VALUES (1706740972, "Pall Bearer", NULL, "Jessica", "Kearton");
INSERT INTO Staff VALUES (4363782794, "Pall Bearer", NULL, "Merralee", "Butcher");
INSERT INTO Staff VALUES (7902302563, "Soloist", NULL, "Mord", "Van Dijk");
INSERT INTO Staff VALUES (6966698734, "Pastor", "Reverend", "Mordy", "Ludford");
INSERT INTO Staff VALUES (7349905576, "Pall Bearer", "Dr.", "Almeda", "Lowman");
INSERT INTO Staff VALUES (1559023288, "Painist", NULL, "Courtney", "MacCracken");

# Load in test data for ServiceStaff
INSERT INTO ServiceStaff VALUES ("2023-01", 2296523934);
INSERT INTO ServiceStaff VALUES ("2023-01", 1706740972);
INSERT INTO ServiceStaff VALUES ("2023-01", 6966698734);
INSERT INTO ServiceStaff VALUES ("2023-03", 2296523934);
INSERT INTO ServiceStaff VALUES ("2023-03", 1706740972);
INSERT INTO ServiceStaff VALUES ("2023-03", 4363782794);
INSERT INTO ServiceStaff VALUES ("2023-05", 1706740972);
INSERT INTO ServiceStaff VALUES ("2023-07", 1706740972);
INSERT INTO ServiceStaff VALUES ("2023-07", 1559023288);
INSERT INTO ServiceStaff VALUES ("2023-07", 4363782794);

# Load in test data for NewspaperObits
INSERT INTO NewspaperObits VALUES ("2023-01", "Morning News", 80.00);
INSERT INTO NewspaperObits VALUES ("2023-01", "The State", 100.00);
INSERT INTO NewspaperObits VALUES ("2023-03", "News & Courier", 75.00);
INSERT INTO NewspaperObits VALUES ("2023-03", "Morning News", 80.00);
INSERT INTO NewspaperObits VALUES ("2023-07", "Florence Herald", 150.00);
INSERT INTO NewspaperObits VALUES ("2023-07", "News & Courier", 75.00);
INSERT INTO NewspaperObits VALUES ("2023-07", "The State", 100.00);

# Load in test data for Bill
INSERT INTO Bill VALUES (001, "2023-01", 75.00, 100.00);
INSERT INTO Bill VALUES (002, "2023-03", 85.00, 280.00);
INSERT INTO Bill VALUES (003, "2023-05", 103.00, 175.00);
INSERT INTO Bill VALUES (004, "2023-07", 110.00, 200.00);
INSERT INTO Bill VALUES (005, "2023-13", 50.00, 150.00);

# Load in test data for BillItems
INSERT INTO BillItems VALUES (001, 001);
INSERT INTO BillItems VALUES (001, 017);
INSERT INTO BillItems VALUES (002, 004);
INSERT INTO BillItems VALUES (002, 001);
INSERT INTO BillItems VALUES (003, 026);
INSERT INTO BillItems VALUES (003, 003);
INSERT INTO BillItems VALUES (004, 027);
INSERT INTO BillItems VALUES (005, 018);
INSERT INTO BillItems VALUES (005, 003);

# Load in test data for BillServices
INSERT INTO BillServices VALUES (001,001);
INSERT INTO BillServices VALUES (001,012);
INSERT INTO BillServices VALUES (001,013);
INSERT INTO BillServices VALUES (001,018);
INSERT INTO BillServices VALUES (002,019);
INSERT INTO BillServices VALUES (002,024);
INSERT INTO BillServices VALUES (003,001);
INSERT INTO BillServices VALUES (004,027);
INSERT INTO BillServices VALUES (005,004);
INSERT INTO BillServices VALUES (005,021);
INSERT INTO BillServices VALUES (005,023);
