# E-Commerce Backend - Spring Boot REST API

This E-Commerce Backend is a scalable **Spring Boot REST API** designed to manage core functionalities of an online shopping platform, including **product CRUD operations**, **image uploads**, and **keyword-based product search**. The backend supports seamless integration with a frontend or mobile application.

---

## Features

- **Product CRUD Operations** (Create, Read, Update, Delete)
- **Multipart Image Uploads** for product images
- **Single-Keyword Product Search** using Spring Data JPA
- **Cross-Origin Support** for frontend integration

---

## Setup Instructions

### 1. Clone the Backend Repository

Clone the E-Commerce Backend repository to your local machine:

```bash
git clone https://github.com/Nih-0/E_Commerce_Backend.git
2. Clone the Frontend Repository
You can integrate the frontend by cloning Navin Reddy's E-Commerce Frontend repository as well:

bash
Copy code
git clone https://github.com/navinreddy20/ecom-frontend-5.git

3. Configure the Database
Set up MySQL with your preferred username and password.

Modify the database configuration in the application.properties file located in src/main/resources to match your database credentials.

Example:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=root
