REST APIs for a Simple Banking Application using SpringBoot, Spring Data JPA(Hibernate) and MySQL Database.
Spring-3.4.0 ,
Java-17 ,
apache-maven-3.9.8-bin

#Functionalities:-
Creating a Bank Account,
Fetching Account Details,
Making a deposit/Withdrawl,
Removing the Bank Account

#Endpoints:-

#CreateAccount 
POST :- http://localhost:8080/api/accounts
        Body:-
				{
				"accountHolderName":"Rani",
				"balance":100000
				}

#GetAccountDetailsById
GET:- http://localhost:8080/api/accounts/1

#Deposit
PUT:- http://localhost:8080/api/accounts/1/deposit
     Body:-
     	{
		"amount":10000
		}
		
#Withdraw
PUT:- http://localhost:8080/api/accounts/1/withdraw
		Body:-
     	{
		"amount":5000
		}

#GetAllAccountDetails
GET:- http://localhost:8080/api/accounts

#DeleteAccountById
DELETE:- http://localhost:8080/api/accounts/2
