public class ReportGenerator {
    // placeholders, will replace with SQL queries
    public void getSalary(int ID, double salary){
        // return SELECT salary FROM employees WHERE employeeID = id;
    }

    // get total pay for everyone with provided job title
    public void getPayByJob(String job){
        // return SELECT jobTitle, SUM(salary) FROM employees GROUP BY jobTitle;
        // return SELECT SUM(salary) FROM employees WHERE jobTitle=job;
    }
    
    // get total pay for everyone with provided division
    public void getPayByDivision(String div){
        // return SELECT division, SUM(salary) FROM employees GROUP BY division;
        // return SELECT SUM(salary) FROM employees WHERE division=div;
    }
}
