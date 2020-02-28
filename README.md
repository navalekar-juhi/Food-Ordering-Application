# Food-Ordering-Application

Summary of Technologies Used:
Web application is developed using spring mvc. Maven is used for managing the repository. 
Hibernate is used to map an object-oriented domain model to a relational database tables. 
HQL is used for performing the queries. To restrict result of HQL are used. 
Itextpdf dependency is used to download and view pdf report of the order. 
For email notification, Common.mail extension is used.
Database : MySQL

Summary:
Online food ordering is a process of ordering food from a local restaurant through an application. With the increase in the number of local restaurants. Fooze delivers the food at your doorstep through the e-commerce web application, where a user can order his choice of food from variety of restaurants and cuisines. The user needs to register to use the application. The user can select multiple items from the menu of the restaurants. The user can add or delete the items from cart as well. After confirmation, the user can place order where upon he can view his confirmed order with details.

Summary Of functionality:
The admin can add and manage restaurants. The admin adds restaurant details such as name and location. The admin can add items in the menu of the restaurants.
User will register to system by email confirmation which he will receive after entering desired details. After Registration, User will log in to the application.
The user can then view and select restaurant of his/her choice. The user can then select menu items based on his/her preference. He can edit the items in the shopping cart before proceeding for checkout.
Upon successful checkout, the user can view and download his order summary in pdf.

Roles Of System :
ADMIN- The admin will register himself and add restaurants and menu items in the restaurants.
USER- The user can register in the application. Post registration, he can select restaurants and place order. The user can view order details and download the pdf of order details. The user receives email upon registration.
