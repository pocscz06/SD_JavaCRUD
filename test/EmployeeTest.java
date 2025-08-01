package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    
public class EmployeeTest {
    
    @Test
    public void generalEmployeeUpdateTest() {
        FullEmployee emp = new FullEmployee("Karen", "Smith", 127362829, 72000, "Engineer", "IT", "Full-Time");
    

        assertEquals("Employee First Name: Karen", emp.getFirstName());
        assertEquals("Employee Last Name: Smith", emp.getLastName());
        assertEquals("Job: Engineer", emp.getJobTitle());
        assertEquals("Employee division: IT", emp.getDivision());
        assertEquals("Employee status: Full-Time", emp.getStatus());
        assertEquals("Employee salary: 72000.0", emp.getSalary());
    

        emp.firstName = "Ashley";
        emp.lastName = "Smith";
        emp.jobTitle = "Network Administrator";
        emp.division = "IT";
        emp.status = "Full-Time";
        emp.salary = 75000.0;
    
        assertEquals("Employee First Name: Ashley", emp.getFirstName());
        assertEquals("Employee Last Name: Smith", emp.getLastName());
        assertEquals("Job: Network Administrator", emp.getJobTitle());
        assertEquals("Employee division: IT", emp.getDivision());
        assertEquals("Employee status: Full-Time", emp.getStatus());
        assertEquals("Employee salary: 75000.0", emp.getSalary());
        }
    }