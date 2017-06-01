
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER (internalCustomerId VARCHAR(20),firstName VARCHAR(20), lastName VARCHAR(20),
    userName VARCHAR(20), email VARCHAR(20),phoneNumber VARCHAR(20), address  VARCHAR(20), 
    createdDateTime TIMESTAMP, additionalProperties VARCHAR(20));

INSERT INTO CUSTOMER (internalCustomerId, firstName, lastName, userName, email, phoneNumber, address, createdDateTime, additionalProperties)
VALUES ('1','firstNameTest', 'lastnameTest', 'userName', 'email','1234567890','address',CURTIME(),'additionalProperties');

-------------------------------------------------------------------


CREATE TABLE CUSTOMER (internalCustomerId VARCHAR(20),firstName VARCHAR(20), lastName VARCHAR(20),
    userName VARCHAR(20), email VARCHAR(20),phoneNumber VARCHAR(20));
    
INSERT INTO CUSTOMER (internalCustomerId, firstName, lastName, userName, email, phoneNumber)
VALUES ('1','firstNameTest', 'lastnameTest', 'userName', 'email','1234567890');
	

select * from CUSTOMER;
------------------------------------------------------------------------------

CREATE TABLE PRODUCT (internalProductId VARCHAR(20), productName VARCHAR(20), region VARCHAR(20),
    autoRenew VARCHAR(20), price VARCHAR(20),curreny VARCHAR(20));

INSERT INTO PRODUCT (internalProductId, productName, region, autoRenew, price, curreny)
VALUES  ('1','productName', 'region', 'autoRenew', 'price','123');

select * from PRODUCT;

----------------------------------------------------------------------------------


CREATE TABLE VEHICLE (internalVehicleId VARCHAR(20), vin VARCHAR(20), region VARCHAR(20));


INSERT INTO VEHICLE (internalVehicleId, vin, region)
VALUES  ('1','vin', 'region');



