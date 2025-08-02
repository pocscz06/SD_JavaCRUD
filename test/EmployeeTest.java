package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    
public class EmployeeTest {
    
    @Test
    public void generalEmployeeUpdateTest() {
        FullEmployee emp = new FullEmployee( "Jones", "Boro", "234567890", 180000.00, "Software Architect", "Engineering");
    

        assertEquals("Jones", emp.getFirstName());
        assertEquals("Boro", emp.getLastName());
        assertEquals("Software Architect", emp.getJobTitle());
        assertEquals("Engineering", emp.getDivision());
        assertEquals(180000.0, emp.getSalary());
    

        emp.setFirstName("James");
        emp.setLastName("Boro");
        emp.setJobTitle("Software Engineer");
        emp.setDivision("Engineering");
        emp.setSalary(190000.0);
    
        assertEquals("James", emp.getFirstName());
        assertEquals("Boro", emp.getLastName());
        assertEquals("Software Engineer", emp.getJobTitle());
        assertEquals("Engineering", emp.getDivision());
        assertEquals(190000.0, emp.getSalary());
        }
    }


