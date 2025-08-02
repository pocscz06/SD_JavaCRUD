interface IEmployee{
    public int getEmployeeID();
    public String getFirstName();
    public String getLastName();
    public String getSSN();
    public double getSalary();
    public String getJobTitle();
    public String getDivision();
    public String getStatus();
    public void getFullInfo();

    public void setFirstName(String firstName);
    public void setLastName(String lastName);
    // Assume SSN will never change, so no need for an SSN mutator
    public void setSalary(double salary);
    public void setJobTitle(String jobTitle);
    public void setDivision(String division);
    public void setEmployeeID(int id); 
    // EmployeeID won't ever actually be changed since it's the primary key
    // This is just for instances of Employee that are created in the program; they won't have an employee ID
}