# ConstruWare - Management System for a Construction Materials Store

This article describes a management system that will work based on the records of the respective employees, customers, suppliers and products, according to customer demand, the order will be generated and completing the sales process with payment confirmation.

## 1. ER model - Database
**Figure 1**: Graphically represents the entities and their relationships with other entities in the database.

<img src="https://github.com/arthur-pereira-silva/ConstruWare/assets/95577389/44f21409-eb65-480a-96db-755dbc3ec39d" width="900px" alt="ER model" title="click to view larger">
  <p align="center">
  </p>
</img>

## 2. Use Case Diagram
**Figure 2**: Represents the use case diagram and describes how each “author” will operate the system.

<img src="https://github.com/arthur-pereira-silva/ConstruWare/assets/95577389/d5ddc195-f81e-4e69-9aa1-9433a7fa3758" width="900px" alt="Use Case Diagram" title="click to view larger">
  <p align="center">
  </p>
</img>

## 3. Class Diagram
**Figure 3**: describes the structure of the system, modeling its describing classes, their attributes and the relationships between objects.

<img src="https://github.com/arthur-pereira-silva/ConstruWare/assets/95577389/5827b0da-ce1e-4516-8f88-4f6f0a8c8146" width="800px" alt="Class Diagram" title="click to view larger">
  <p align="center">
  </p>
</img>

 ## 4. Technologies Used

 **Java** - Programming language.
 
 **Swing** - Java graphical interface for creating screens.
 
 **Microsoft SQL Server** - Database
 
 ## 5. System Interface
This topic will show the main screens of the system and its functionalities.

 ### 5.1. Login
Initially, the system starts at the login screen where the employee will enter their authentication data.

<img src=""
alt="Login Screen" title="click to view larger">
  <p align="center">
  </p>
</img>


### 5.2 Home
System home screen, which redirects to all other screens

<img src=""
 alt="home" title="click to view larger">
  <p align="center">
  </p>
</img>


 ### 5.3 Customer Registration
We can perform operations, search, add, save, edit and delete. There is also a module for customer consultation, which searches the database and filters the information

<img src="" alt="Customer Registration" title="click to view larger">
  <p align="center">
  </p>
</img>


### 5.4 Employee Registration
We can perform operations, search, add, save, edit and delete. There is also a module for employee consultation, which searches the database and filters the information

<img src="" alt="Employee Registration" title="click to view larger">
  <p align="center">
  </p>
</img>


### 5.5 Product Registration
We can perform operations, search, add, save, edit and delete. There is also a module for product consultation, which searches the database and filters the information

<img src="" alt="Product Registration" title="click to view larger">
  <p align="center">
  </p>
</img>



### 5.6 Inventory 
The “search” button is for querying purposes based on the name, it checks whether a product is in stock and can add or remove it.

<img src="" alt="Inventory" title="click to view larger">
  <p align="center">
  </p>
</img>


### 5.7 Sales
This screen is responsible for selling products. The Employee chooses a customer already registered by CPF in the system, the corresponding product by code or by clicking on the table, and the quantity in cubic meters, and can add it to the cart. If the product code is wrong, there is a clear button, which clears the fields and enables the product choice again.

<img src="" alt="Sales" title="click to view larger">
  <p align="center">
  </p>
</img>


### 5.8  Payment
It shows the payment methods, and as soon as the payment is entered, it is confirmed to complete the sale.

<img src="" alt="payment" title="click to view larger">
  <p align="center">
  </p>
</img>
