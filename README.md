# SD_JavaCRUD
A terminal-based class project for performing CRUD operations on a mock Employee database with a focus on common Software Development processes (SOLID, Testing, etc.)

## Authors

Abir Chowdhury
Amara Irobi
Cristin Khor
Kayla Thornton
Kenny Pham


## Overview

The goal is to deliver a minimal working UX (via terminal) to facilitate an employee management system allowing for basic CRUD operations. Features include, but are not limited to:

- Create new employee
- Read/search for an employee using name, SSN, or employeeID
- Update an employee's data
- Delete an employee from the table
- Increase an employee's salary for a particular percentage; filtering said employees based on a salary amount range

Throughout this project, we will be following Software Development standards which include:

- SOLID principles
- Testing
- Documentation

## File Structure
```
SD_JavaCrud/                        # Root project directory
├── README.md
├── database/
│   └── schema.sql                  # SQL script for Employee table
├── src/
│   ├── Employee.java               # Employee entity class
│   ├── EmployeeService.java        # Employee business logic methods + validation
│   ├── EmployeeDAO.java            # Employee data access methods
│   ├── ReportGenerator.java 
│   ├── Main.java                   # Terminal UI + user input validation
│   └── DBUtil.java                 # Database connection
├── test/
│   ├── EmployeeTest.java           # Unit testing for Employee methods
│   ├── SalaryUpdateTest.java       # Unit testing for salary range updating methods
│   └── SearchTest.java             # Unit testing for search functionality
└── lib
    └── mysql-connector-j-9.4.0.jar    # JDBC driver for communicating with MySQL db
```

This file structure isn't final -- we may separate certain classes even further if deemed necessary, but this should include everything minimally required for the project.

schema.sql isn't necessary since we'll be connected to a shared database server, but good practice in our case. It will contain the SQL script that creates our database table and fills it with mock employee data. 

## Prerequisites

- [Java 24+](https://www.java.com/en/download/manual.jsp)
- [MySQL 8.0+](https://dev.mysql.com/downloads/installer/)