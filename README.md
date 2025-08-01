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
├── DBVars.env
├── database/
│   └── schema.sql                  # SQL script for Employee table
├── src/
│   ├── IEmployee.java              # Employee interface
│   ├── EmployeeService.java        # Employee business logic methods + validation
│   ├── EmployeeDAO.java            # Employee data access methods
│   ├── PartEmployee.java           # Part-time Employee class
│   ├── FullEmployee.java           # Full-time Employee class
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

## How to Run

We will each run our own instance of a local MySQL database server. The schema.sql file will ensure all of our databases have the same "starting point," so we're roughly on the same page. DBUtil.java handles the database connection, but if you notice, the connection parameters are gathered via a System.getenv method call. It's best practice to keep the login credentials for your database server encrypted or off of a public GitHub repository. That being said, you will have to create a .env file with the information needed for your system to fetch before running the program.


1. Initialize our SQL Schema

Redirect back to the project's root directory -- i.e., type "cd ../" in the PowerShell if you're currently in the src/ directory.

Locate where your MySQL Server 8.0 folder is within your system and run the following command (replace the file path with your MySQL Server 8.0's path if it's different):
```
Get-Content database\schema.sql | & "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -u user -p
```

It will ask for you to enter your database's password; upon doing so, it will execute the script into your MySQL database server -- creating the Employee table and filling it with 30 rows of data.

2. Create a DBVars.env file in the root project directory. It should be formatted as such:

```
DB_URL=jdbc:mysql://localhost:3306/Group6ProjectB
DB_USER=yourdbusername
DB_PASS=yourdbpassword
```

3. Run these commands in PowerShell sequentially:

```
.\load-env.ps1 # This will load the environment variables from your DBVars.env file for the current PowerShell instance. After the current PowerShell instance is terminated, your system does not persist storage of these variables, so you'd have to run these commands again.

cd src # Changes directory to the src/ folder

javac Main.java # Compiles Main into a class file for execution

java -cp ".;..\lib\mysql-connector-j-9.4.0.jar" Main # Runs the Main class using the MySQL JDBC connector jar stored in our project
```

> [!NOTE]
> Run the above commands in a new PowerShell instance everytime you want to test changes to the program. If you were to run the program natively through the IDE, it will not connect to your configured database server. 