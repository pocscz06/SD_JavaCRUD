CREATE DATABASE IF NOT EXISTS Group6ProjectB;
USE Group6ProjectB;

CREATE TABLE IF NOT EXISTS employees (
    employeeID INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(15) NOT NULL,
    lastName VARCHAR(15) NOT NULL,
    socialSecurity CHAR(9) NOT NULL UNIQUE,
    salary DOUBLE NOT NULL,
    jobTitle VARCHAR(30) NOT NULL,
    division VARCHAR(20) NOT NULL
);

INSERT INTO employees (firstName, lastName, socialSecurity, salary, jobTitle, division) VALUES
('Kenny', 'Pham', '123456789', 5000000.00, 'Software Engineer', 'Engineering'),
('James', 'Stoney', '453214950', 85000.00, 'Product Manager', 'Product'),
('Jones', 'Boro', '234567890', 180000.00, 'Software Architect', 'Engineering'),
('Tony', 'Bologna', '987654321', 65000.00, 'QA Tester', 'Quality Assurance'),
('Anna', 'Wise', '433675049', 70000.00, 'HR Specialist', 'Human Resources'),
('Max', 'Gerald', '230214950', 120000.00, 'UI/UX Designer', 'UI/UX'),
('Milo', 'Ha', '600459403', 125000.00, 'Frontend Engineer', 'Engineering'),
('Red', 'Tyson', '944312399', 22000.00, 'Customer Support Associate', 'Support'),
('Andrea', 'Bose', '114504220', 68000.00, 'Marketing Specialist', 'Marketing'),
('Nina', 'Sanchez', '045424305', 98000.00, 'Software Engineer', 'Engineering'),
('Tyson', 'Ngo', '595492490', 105000.00, 'DevOps Engineer', 'Engineering'),
('Tyra', 'Jones', '503344900', 95000.00, 'DevOps Engineer', 'Engineering'),
('Sunny', 'Sa', '806501203', 62000.00, 'Research Associate', 'R&D'),
('Chester', 'Wester', '983423300', 100000.00, 'Lead Designer', 'UI/UX'),
('Michael', 'Shinoda', '022505040', 90000.00, 'Business Analyst', 'Operations'),
('James', 'Trill', '225346072', 88000.00, 'DevOps Engineer', 'Engineering'),
('Ronald', 'McDonald', '488181030', 112000.00, 'Frontend Engineer', 'Engineering'),
('Nicholas', 'Ball', '900892910', 78000.00, 'HR Specialist', 'Human Resources'),
('Eugene', 'An', '593205959', 75000.00, 'Technical Writer', 'Documentation'),
('Samuel', 'Kim', '995501024', 72000.00, 'HR Specialist', 'Human Resources'),
('Gerardo', 'Mendoza', '240494219', 92000.00, 'Software Engineer', 'Engineering'),
('Dmitry', 'Ivanov', '126228930', 77000.00, 'Technical Writer', 'Documentation'),
('Meek', 'Chappell', '007565042', 130000.00, 'Backend Engineer', 'Engineering'),
('Mary', 'Hanes', '429331200', 105000.00, 'UI/UX Designer', 'UI/UX'),
('Shane', 'Wilson', '110850320', 70000.00, 'Recruiter', 'Human Resources'),
('Umar', 'Walker', '909091111', 80000.00, 'Business Analyst', 'Operations'),
('Zach', 'Carter', '565656565', 78000.00, 'Security Analyst', 'IT'),
('Brandon', 'Edwards', '787878787', 85000.00, 'Solutions Architect', 'Engineering'),
('Abigail', 'Diaz', '777889999', 54000.00, 'Customer Support', 'Support'),
('Julia', 'Marks', '888990000', 58000.00, 'Technical Writer', 'Documentation'),
('Fiona', 'Taylor', '444556666', 99000.00, 'Software Engineer', 'Engineering');