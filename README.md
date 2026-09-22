# Employee Task & Performance Management System

> ⚠️ **PROJECT STATUS: UNDER WORK — NOT READY TO USE**
>
> This project is currently under development. Some features may be incomplete, unstable, or not implemented yet. **This project is not ready for production or regular use.**

## 📌 Project Description

The **Employee Task & Performance Management System** is a web-based application designed to help organizations manage employees, departments, tasks, and employee performance.

The system provides different access levels for **Admin, Manager, and Employee**.

### Main Features

* 🔐 Role-based login and authentication
* 👨‍💼 Admin manages employees and departments
* 📋 Managers create and assign tasks
* 👨‍💻 Employees view and update assigned tasks
* 🔄 Task status management
* 📊 Employee performance statistics
* 🔎 Search and filtering
* 📈 Dashboard with task completion information
* 🔗 REST APIs
* 🗄️ MySQL database
* 🔒 Role-based authorization

## 👥 User Roles

### Admin

* Manage employees
* Manage departments
* View system information
* Monitor tasks and statistics

### Manager

* View employees
* Create and assign tasks
* Monitor task progress
* View employee performance

### Employee

* View assigned tasks
* Update task status
* Add task remarks
* View personal performance

## 🛠️ Technologies Used

### Frontend

* HTML5
* CSS3
* JavaScript
* Bootstrap

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* REST API

### Database

* MySQL

### Tools

* IntelliJ IDEA / Eclipse
* MySQL Workbench
* Postman
* Git
* GitHub
* Maven

## 🏗️ Project Architecture

The project follows a basic layered architecture:

```text
Frontend
   ↓
REST API
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL Database
```

## 📂 Planned Project Structure

```text
employee-task-management/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/employeemanagement/
│       │       ├── controller/
│       │       ├── service/
│       │       ├── repository/
│       │       ├── entity/
│       │       ├── dto/
│       │       ├── security/
│       │       └── exception/
│       │
│       └── resources/
│           ├── static/
│           └── application.properties
│
├── pom.xml
├── README.md
└── .gitignore
```

## 🚧 Current Development Status

**Status: 🟡 Under Work / Work in Progress**

The project is currently being developed and tested.

### Planned Development

* [ ] Project setup
* [ ] MySQL database configuration
* [ ] User and role management
* [ ] Authentication
* [ ] Admin module
* [ ] Manager module
* [ ] Employee module
* [ ] Department management
* [ ] Task management
* [ ] Task status tracking
* [ ] Performance calculation
* [ ] Dashboard
* [ ] Search and filtering
* [ ] REST API testing
* [ ] Security testing
* [ ] Final UI improvements
* [ ] Documentation

## ⚠️ Important Notice

**This project is NOT READY TO USE.**

It is currently being developed as a learning and portfolio project. The functionality, security, database structure, and user interface may change during development.

Do not use this project for real employee data or production environments at this stage.

## 💻 Planned Setup

Once the project is completed, the expected setup will be:

### 1. Clone the repository

```bash
git clone <repository-url>
cd employee-task-management
```

### 2. Create MySQL Database

```sql
CREATE DATABASE employee_management;
```

### 3. Configure Database

Update the database configuration in:

```text
src/main/resources/application.properties
```

### 4. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application from IntelliJ IDEA/Eclipse.

> **Note:** Setup instructions may change while the project is under development.

## 🧪 Testing

API testing will be performed using **Postman**.

Planned testing includes:

* Login authentication
* Employee CRUD operations
* Department CRUD operations
* Task creation
* Task assignment
* Task status updates
* Role-based authorization
* Invalid input handling
* API error handling

## 🔮 Future Enhancements

Possible future improvements:

* Email notifications
* Task reminders
* Advanced performance reports
* Charts and analytics
* Profile management
* File attachments for tasks
* Password reset
* Activity logs
* Deployment to cloud
* Mobile application

## 📚 Learning Objectives

This project is being developed to gain practical experience in:

* Java
* Object-Oriented Programming
* Spring Boot
* REST API development
* Spring Security
* MySQL and SQL
* JPA/Hibernate
* CRUD operations
* Authentication and authorization
* Git and GitHub
* Software development practices

## 👨‍💻 Author

**Harsh Patil**

Computer Engineering Student

## 📄 License

This project is currently under development and is intended primarily for **educational and portfolio purposes**.

---

> 🚧 **WORK IN PROGRESS**
>
> **This project is under development and is NOT READY TO USE.**
>
> Features, APIs, database structure, and UI may change as development continues.
