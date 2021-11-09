### [Navigate to Home](../README.md)

To Answer this question we need to refactor this class as:

|Employee|
|:--------------------------|
|--------------------------|
|- managerFlag: Boolean|
|- name : String|
|- dateHired: Date|
|- id : int|
|**- minMandatoryWorkingHoursPerWeek: int**|
|--------------------------|
|+ getName(): String|
|+ getID(): int|
|+ getDateHire(): Date|
|+ isManager(): boolean|
|**+ isPartTime(): Boolean**|

Where the isPartTime() method would be implemented as followed:

```
const FullTimeHoursPerWeekCompanyPolicy = 40;

boolean isPartTime() {

	return minMandatoryWorkingHoursPerWeek < FullTimeHoursPerWeekCompanyPolicy

}
```

Assuming that every employee that works less than 40 h/week (this depends on the company’s policy) is considered part-time:

Also, is possible to (if the previous implementation allows it) to inherit from Employee to define a new type (class) that includes the minimum mandatory hours per week information and knowing if  an Employee instance is part-time is needed to verify if is instance of PartTimeEmployee

```
Employee

   ∆
   |

PartTimeEmployee
```

|**PartTimeEmployee extends Employee**|
|:--------------------------|
|--------------------------------------------------|
|- managerFlag: Boolean|
|- name : String|
|- dateHired: Date|
|- id : int|
|**- minMandatoryWorkingHoursPerWeek: int**|
|--------------------------------------------------|
|+ getName(): String|
|+ getID(): int|
|+ getDateHire(): Date|
|+ isManager(): boolean|

Off course, this might bring (in case Employee is a database entity) some extra database modification, for relational databases (in particular) is possible to create a new table (relation) that match employees with minimum mandatory hours per week. This table would hold only part-time employees

|id : int|
|:-------|
|minMandatoryWorkingHoursPerWeek: int|


### [Navigate to Answer to Question 1](Answer1.md)
