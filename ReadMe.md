###PayCore Graduation Project

In this project, I tried to design a system which looks at Customer's money and credit point and with these data, it decides how much money the customer can get. The rules are given here:
*If the credit score is below 500, the user is rejected. (Credit result: Red)
*If the credit score is between 500 points and 1000 points and if the monthly income is below 5000 TL
the user's loan application is approved and a 10,000 TL limit is assigned to the user. (Credit Result:
Approval)
*If the credit score is between 500 points and 1000 points and if the monthly income is above 5000 TL, the user's loan application is approved and a 20,000 TL limit is assigned to the user. (Credit Result:
Approval)
*If the credit score is equal to or above 1000 points, the user is assigned a limit equal to MONTHLY INCOME INFORMATION * CREDIT
LIMIT MULTIPLIER. (Credit Result: Confirmation)



In this project we have one entity which is customer, one controller for customer, one Dto and one Mapper for customer entity. We used Dto because we need to get our datas from Dto instead of entity. We have specific features for customers which are, "name,surname,age,address,ic,citizenno,creditpoint,salary,profession,e-mail. In mapper I mapped both the Dto and entity.


In controller, we have 5 apis. Fof seeing all the customers, I wrote gettallCustomers method. To get one specific customer, I used getCustomer method. And the other methods are doing what they are called by their names.


In data.sql file we have customer table. I injected 8 customers and the features of the customers. I used PostgreSQL for the database of project. And for ORM, I used hibernate. I used swagger for documentation.


I couldn't write all the unit tests. I could write test for addCustomer, getAllCustomers methods. 


For business logic of this project in CustomerServiceImpl class I tried to write a function which gets our customer with id and see the customer's salary and credit point. And returns the max value of money the customer can get.


This project is written with Java(SpringBoot).