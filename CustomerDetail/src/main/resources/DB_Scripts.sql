
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
VALUES  ('3','productName', 'region', 'autoRenew', 'price','123');

select * from PRODUCT;

----------------------------------------------------------------------------------


CREATE TABLE VEHICLE (internalVehicleId VARCHAR(20), vin VARCHAR(20), region VARCHAR(20));


INSERT INTO VEHICLE (internalVehicleId, vin, region)
VALUES  ('1','vin', 'region');

Select * from VEHICLE;

---------------------------------------------------------------------------------------------


CREATE TABLE SUBSCRIPTION (subscriptionId VARCHAR(20), vin VARCHAR(20), customerId VARCHAR(20), productId VARCHAR(20) );

INSERT INTO SUBSCRIPTION (subscriptionId, vin, customerId, productId) values ('1','123','1','3');

select * from subscription;
------------------------------------------------------------------------------------------------

Select internalCustomerId, firstName, lastName, userName, email, phoneNumber from CUSTOMER;

Select PD.internalProductId, PD.productName, PD.region, PD.autoRenew, PD.pricE  from SUBSCRIPTION SUB 
LEFT JOIN PRODUCT PD ON SUB.productId = PD.internalProductId
WHERE SUB.subscriptionId = '1';

Select *
from SUBSCRIPTION SUB 
LEFT JOIN PRODUCT PD ON SUB.productId = PD.internalProductId
WHERE SUB.subscriptionId = '1';

Select internalCustomerId, firstName, lastName, userName, email, phoneNumber from CUSTOMER where internalCustomerId = 1;

Select internalVehicleId, vin, region from VEHICLE where vin = 32;

