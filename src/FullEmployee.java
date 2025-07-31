public class FullEmployee implements IEmployee {
    public String fullName;
    private int socialSecurity;
    public double salary;
    public String jobTitle;
    public String division;
    public String status;

    public FullEmployee(String name, int ssn, double sal, String title, 
    String div, String stat){
        fullName = name;
        socialSecurity = ssn;
        salary = sal;
        jobTitle = title;
        division = div;
        status = stat;
    }

    // Getters and setters
    @Override
    public void getName(){
        System.out.println("Employee: " + fullName);
    }

    @Override
    public void getFullInfo(){
        System.out.println("Displaying employee: " + fullName);
        System.out.println("SSN: ********* ");
        System.out.println("Employee Status " + status);
        System.out.println("Salary: " + salary);
        System.out.println("Title: " + jobTitle);
        System.out.println("Division: " + division);
        System.out.println(" ------------------------- ");
    }
}