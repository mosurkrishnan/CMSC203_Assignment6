# CMSC203_Assignment6
Bradley Beverage Shop
Bradley Beverage Shop

Bradley shop is a family-owned store that sells beverages.  The store offers 3 types of beverages: Coffee, Alcohol, and Smoothie. The store is open from 8 in the morning to 11 pm in the afternoon.  The owner of the shop likes to automate the order transactions and reports, and purchases software for testing order activities for one month. You are asked to implement this software based on the following requirements.




BevShop (The Data Manager Class)

The BevShop offers 3 types of beverages: Coffee, Alcoholic and Smoothie. Beverages can be ordered in 3 different sizes: Small, medium, and large. All the beverage types have a base price. In addition, there are additional charges depending on the size and specific add-ons for each type of beverage.

The BevShop has the following functionality:

•	Create and process orders of different types of beverages.
•	Provide information on all the orders. 
•	Total amount on a specific order
•	Monthly total number of orders
•	Monthly sale report



•	Aggregation
•	Searching an ArrayList
•	Selection sort
•	Enumeration
•	Inheritance
•	Interface
•	Polymorphism
•	Abstract classes
•	Overriding methods






OrderInterface 
This interface is provided for you and is implemented by the Order class.

BevShopInterface
This interface is provided for you and is implemented by the BevShop class.






Enumerated Type – Day
Create an enumerated type called Day.  The valid values will be MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY. Create this as a separate class file, rather than an internal class.
Enumerated Type – Size
Create an enumerated type called Size.  The valid values will be SMALL, MEDIUM, LARGE. Create this as a separate class file, rather than an internal class.
Enumerated Type – Type
Create an enumerated type called Type.  The valid values will be COFFEE, SMOOTHIE, ALCOHOL. Create this as a separate class file, rather than an internal class.

Data Element - Beverage
Create an abstract class called Beverage with:
•	Instance variables for beverage name, beverage type, size, and constant attributes for the base price ($2.0) and size price (additional $0.5 to go a size up).
•	An addSizePrice()method:
Calculates a new price by adding the size price to the base price. There is no additional cost for small size, for medium and large beverages the additional cost of size price is added to base price for example if the base price is 2 and SIZE_PRICE is .5 then the cost of small beverage is 2, the medium beverage is 2.5 and the large beverage is 3.
•	A parametrized constructor to create a Beverage object given its name, type and size
•	An abstract method called calcPrice calculates and returns the beverage price. 
•	A toString method: String representation for Beverage including the name and size.
•	The Overridden equals method: checks equality based on name, type, size of the beverage.
•	getters and setters and any other methods that are needed for your design.  
 
Data Element – subclasses of Beverage
Create the following subclasses of Beverage for the 3 types of beverages: 

Coffee
•	Contains additional instance variables of type boolean to indicate if it contains extra shot of coffee (additional cost of 50 cents) and extra syrup (additional cost of 50 cents).   
•	A parametrized constructor  
•	A toString method: String representation of Coffee beverage, including the name, size ,  whether it contains extra shot, extra syrup and the price of the coffee
•	An Overridden calcPrice method.
•	An Overridden equals method: checks equality based on the Beverage class equals method and additional instance variables for this class.
•	getters and setters and any other methods that are needed for your design.
•	Use finals to represent constants.
Smoothie
•	Contains additional instance variables for number of fruits and boolean variable to indicate if protein powder is added to the beverage. The cost of adding protein is $1.50 and each additional fruit costs 50 cents.
•	A parametrized constructor.  
•	An Overridden toString method: String representation of a Smoothie drink including the name, size, whether or not protein is added, number of fruits and the price.
•	An Overridden equals method: checks equality based on the Beverage class equals method and additional instance variables for this class.
•	An Overridden calcPrice method.
•	getters and setters and any other methods that are needed for your design.
•	Use finals to represent constants.
Alcohol
•	Contains additional instance variable for weather or not it is offered in the weekend.  The additional cost for drinks offered in the weekend is 60 cents. 
•	A parametrized constructor  
•	An Overridden toString method: String representation of a alcohol drink including the name, size, whether or not beverage is offered in the weekend and the price.
•	An Overridden equals method: checks equality based on the Beverage class equals method and additional instance variables for this class.
•	An Overridden calcPrice method.
•	getters and setters and any other methods that are needed for your design.
•	Use finals to represent constants.

Data Element – Customer
Create a class to represent a customer.
•	Instance variables for name and age
•	A parametrized constructor 
•	A Copy constructor  
•	An Overridden toString method: String representation for Customer including the name and age
•	getters and setters and any other methods that are needed for your design.  
Data Element – Order 
Create a class to represent an order. This class implements two interfaces: OrderInterface and Comparable.  
•	Instance variables for order number, order time, order day and customer and a list of beverages within this order
•	A method to generate a random number within the range of 10000 and 90000
•	A parametrized constructor 
•	A method called addNewBeverage that adds a beverage to the order.  This is an overloaded method to add different beverages to the order.  Refer to the interface OrderInterface provided for you,
•	An Overridden toString method: Includes order number, time, day, customer name, customer age and the list of beverages (with information of the beverage).
•	Override the compareTo method to compare this order with another order based on the order number. Returns 0 if this order number is same as another order's order number, 1 if it is greater than another order's order number, -1 if it smaller than another order's order number.
•	getters and setters and any other methods that are needed for your design.   Note: The getter method for the customer returns a Deep copy of the customer.
•	Refer to provided OrderInterface interface for additional methods.
Data Manager – BevShop
Create a class to represent a beverage shop. This class implements BevShopInterface provided to you. 
•	Instance variable for the number of Alcohol drinks ordered for the current order. The current order in process can have at most 3 alcoholic beverages.
•	An instance list to keep track of orders.
•	The minimum age to order alcohol drink is 21.
•	  time, order day and customer and a list of beverages Order within this order
•	 An Overridden toString method: The string representation of all the orders and the total monthly sale.  
•	Refer to provided BevShopInterface interface for additional methods.

Driver Class - BevShopDriverApp
Create a class with a main method to demonstrate all classes (you created) that use BevShop and Customer objects. Example of a Program output: 
The current order in process can have at most 3 alcoholic beverages.
The minimum age to order alcohol drink is 21
Start please a new order:
Your Total Order for now is 0.0
Would you please enter your name John
Would you please enter your age 23
Your age is above 20 and you are eligible to order alcohol
Would you please add an alcohol drink
The current order of drinks is 1
The Total price on the Order is 2.0
Your current alcohol drink order is less than 4
Would you please add a second alcohol drink
The current order of drinks is 2
The Total Price on the Order: 6.0
Your current alcohol drink order is less than 4
Add third alcohol drink
The current order of drinks is 3
The Total Price on the Order: 8.0
You have a maximum alcohol drinks for this order
Would you please add a COFFEE to your order: 
Total items on your order is 4
The Total Price on the Order: 11.0
#------------------------------------#
Would you please start a new order
Would you please enter your name: Ray
Would you please enter your age: 18
The Total Price on the Order: 0.0
Would you please add a SMOOTHIE to order
The Total Price on the Order: 6.5
Would you please add a SMOOTHIE to order
Would you please add a COFFEE to order
The Total Price on the Order: 9.5
Would you please add a drink 
Your Age is not appropriate for alcohol drink!!
The current order of drinks is 4
The Total price on the Order: 9.5
 The total number of fruits is 5
You reached a Maximum number of fruits

Total price on the second Order: 16.0
Total amount for all Orders: 27.0
Data Structure
•	You will be using an Arraylist within your Order to hold beverages of the order and BevShop class to hold orders.
External Documentation
•	Provide a UML diagram with all classes and their relationships.

•	JUnit Test
•	A GFA test file, OrderTestGFA, has been provided. GFA (Good Faith Attempt) is the minimum set of requirements for the project. Run each provided JUnit test file and ensure that all tests succeed. Do not modify any of these JUnit tests files since the instructor will be using the original file(s).
•	For each assignment class that you create, you must create a JUnit test file. Name your test file as the following format: [classname]TestStudent; for example, CoffeeTestStudent.
•	Make sure your test files cover as many as possible test cases. Ensure your test cases all succeed. Since the instructors will be using their own JUnit test files that thoroughly covers each public method. If you have not tested every single method, your chance of failing a test case would be high.
•	Make sure to test each constructor. 




Deliverables / Submissions and Deliverable format: 
•	The Java application must compile and run correctly, otherwise the project grade will be zero.
•	The detailed grading rubric is provided in the assignment rubric excel file.
•	Your source code should contain proper indentation and documentation.
•	Documentation within a source code should include: 
•	additional Comments to clarify a code, if needed
•	class description comments at the top of each program containing the course name, the project number, your name, the date, and platform/compiler that you used to develop the project, for example:
/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: MM/DD/YYYY
 * Platform/compiler:
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __________
*/



•	Design 
•	Turn in a UML class diagram for all classes in a Word document (or .uml file if you use UmlScluptor). 

•	Implementation
•	Note: Only submit the files that are created/modified by per requirement. DO NOT submit the files that are already provided for you.  

The deliverables will be packaged as follows. Two compressed files in the following formats:
•	FirstInitialLastName_Assignment6_Complete.zip, a compressed file in the zip format, with the following:
•	src folder:
1.	Alcohol.java
2.	Beverage.java
3.	BevShop.java
4.	BevShopDriverApp
5.	Coffee.java
6.	Customer.java
7.	Smoothie.java
8.	Order.java
9.	Day.java
10.	Size.java
11.	Type.java

JUnit Tests:
1.	AlcoholTestStudent.java
2.	BevShopTestStudent.java
3.	CoffeeTestStudent.java
4.	CustomerTestStudent.java
5.	SmoothieTestStudent.java
6.	OrderTestStudent.java

•	Word document that includes (use provided template):
1.	UML Class Diagram for all classes
2.	Screenshots:
a.	Screenshots of the BevShopDriverApp (like screenshots in Assignment Description).
b.	Screenshots of all Junit Tests
c.	Screenshot of src folder files in your GitHub repository.
3.	If you have added any public methods in addition to the ones listed in the provided Javadoc, you must submit an updated version of your Javadoc. 
4.	Lessons Learned: Write about your Learning Experience, highlighting your lessons learned and learning experience from working on this project. 
Provide answers to the questions listed below:
a.	What have you learned? 
b.	What did you struggle with? 
c.	What would you do differently on your next project? 
d.	What parts of this assignment were you successful with, and what parts (if any) were you not successful with?
e.	Provide any additional resources/links/videos you used to while working on this assignment/project. 



	FirstInitialLastName_Assignment6_JavaFiles.zip, a compressed file containing one or more Java files (This folder SHOULD NOT contain any folders and it SHOULD contain Java source file only that are created/modified by you per requirement.)
•	Alcohol.java
•	Beverage.java
•	BevShop.java
•	Coffee.java
•	Customer.java
•	Smoothie.java
•	Order.java
•	Day.java
•	Size.java
•	Type.java
