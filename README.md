# Product Inventory Management System

This project is a product inventory management system built using **Java 17**, **Spring Boot 3**, and **MySQL**. It allows managing products, GTINs, and batches, with endpoints for various CRUD operations and queries.

## Table of Contents

- [Endpoints](#endpoints)
  - [Product Endpoints]
  - [GTIN Endpoints]
  - [Batch Endpoints]
- [How to Run](#how-to-run)
- [Database](#database)
- [Technologies Used](#technologies-used)

---

### How to run
1. Clone this repository
  * git clone https://github.com/TwinLeavesAssignment.git
  * cd TwinLeavesAssignment
2. Configure MySQL Database
  * Create a database named twin_leaves.
  * Update the application.properties file with your MySQL credentials.
3. Build and Run the Application:
  * ./mvnw spring-boot:run
4. The application will be available at http://localhost:8081.


### Database
##### Tables
* Product: Stores product details.
* GTIN: Stores GTINs associated with products.
* Batch: Stores batch details linked to GTINs or products.

#### Schema
* The MySQL schema will be automatically generated when the application starts.

### Technologies Used
* Java 17
* Spring Boot 3
* MySQL (Database)
* Lombok (For reducing boilerplate code)
* Jakarta Persistence (JPA) (For ORM)
* JSON Validation (For validating request bodies)

### Made with ❤️ using Spring Boot and MySQL. ###
