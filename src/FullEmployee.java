public class FullEmployee implements IEmployee {
    private int employeeID;
    public String firstName;
    public String lastName;
    private String socialSecurity;
    public double salary;
    public String jobTitle;
    public String division;
    public String status;

    // Constructor used when creating a new Employee
    public FullEmployee(String fname, String lname, String ssn, double sal, String title, String division) {
        firstName = fname;
        lastName = lname;
        socialSecurity = ssn;
        salary = sal;
        jobTitle = title;
        this.division = division;
        status = "FT";
    }

    // Constructor used when loading an Employee from the database (has ID)
    public FullEmployee(int id, String fname, String lname, String ssn, double sal, String title, 
    String div){
        employeeID = id;
        firstName = fname;
        lastName = lname;
        socialSecurity = ssn;
        salary = sal;
        jobTitle = title;
        division = div;
        status = "FT";
    }

    // Getters and setters
    @Override
    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public String getFirstName(){
        return firstName;
    }

    @Override
    public String getLastName(){
        return lastName;
    }

    @Override
    public String getSSN() {
        return socialSecurity;
    }

    @Override
    public double getSalary(){
        return salary;
    }

    @Override
    public String getJobTitle(){
        return jobTitle;
    }

    @Override
    public String getDivision(){
        return division;
    }

    @Override
    public String getStatus(){
        return status;
    }

    @Override
    public void getFullInfo(){
        System.out.println("Displaying employee: " + firstName + " " + lastName);
        System.out.println("ID: " + employeeID);
        System.out.println("SSN: ********* ");
        System.out.println("Employee Status: " + status);
        System.out.println("Salary: " + salary);
        System.out.println("Title: " + jobTitle);
        System.out.println("Division: " + division);
        System.out.println(" ------------------------- ");
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public void setEmployeeID(int id) {
        employeeID = id;
    }
}