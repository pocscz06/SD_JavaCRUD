public class FullEmployee implements IEmployee {
    public String firstName;
    public String lastName;
    private int socialSecurity;
    public double salary;
    public String jobTitle;
    public String division;
    public String status;

    public FullEmployee(String fname, String lname, int ssn, double sal, String title, 
    String div, String stat){
        firstName = fname;
        lastName = lname;
        socialSecurity = ssn;
        salary = sal;
        jobTitle = title;
        division = div;
        status = stat;
    }

    // Getters and setters
    @Override
    public String getFirstName(){
        return "Employee First Name: " + firstName;
    }

    @Override
    public String getLastName(){
        return "Employee Last Name: " + lastName;
    }

    @Override
    public String getSalary(){
        return "Employee salary: " + salary;
    }

    @Override
    public String getJobTitle(){
        return "Job: " + jobTitle;
    }

    @Override
    public String getDivision(){
        return "Employee division: " + division;
    }

    @Override
    public String getStatus(){
        return "Employee status: " + status;
    }

    @Override
    public void getFullInfo(){
        System.out.println("Displaying employee: " + firstName + " " + lastName);
        System.out.println("SSN: ********* ");
        System.out.println("Employee Status " + status);
        System.out.println("Salary: " + salary);
        System.out.println("Title: " + jobTitle);
        System.out.println("Division: " + division);
        System.out.println(" ------------------------- ");
    }
}