public class ReportGenerator {
    // placeholders, will replace with SQL queries
    public void getSalary(int ID, double salary){
        System.out.println("Salary for " + ID + " : " + salary);
    }

    public void getPayByJob(int ID, String job, double salary){
        System.out.println("Salary for " + job + " : " + salary);
    }

    public void getPayByDivision(int ID, String div, double salary){
        System.out.println("Salary for " + div + " : " + salary);
    }
}
