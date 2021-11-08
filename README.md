# Objective

The following two questions are designed to get a feel for your understanding of the Java programming language, basic object-oriented design, good programming practices, and ability to learn new material. 

The code should compile and run under JDK 1.8.  Upload your code to your personal git repository and provide the link.

### [Navigate to Answer for Question 1](docs/Answer1.md)
The Sieve of Eratosthenes is the earliest means of finding prime numbers.  A description can be found at https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.  Write a Spring boot application that implements this.  The application should provide a front-end (preferably React) that takes a maximum integer value as an input, and displays the list of prime numbers between 0 and that number.  Provide unit tests.



### [Navigate to Answer for Question 2](docs/Answer2.md)
You are modifying a human resources application. The current Employee class looks like this:
 
|Employee|
|:--------------------------|
|--------------------------|
|- managerFlag: Boolean|
|- name : String|
|- dateHired: Date|
|- id : int|
|--------------------------|
|+ getName(): String|
|+ getID(): int|
|+ getDateHire(): Date|
|+ isManager(): boolean|

Currently everyone is an Employee and some of those are Managers, which is determined by calling the isManager() method. The company has now started hiring part-time employees, so the system must be modified to keep track of them.
 
Create a new implementation of the Employee class which provides the flexibility required to support the new part-time employee notion. You are free to refactor this class as required and add additional classes if needed. 






