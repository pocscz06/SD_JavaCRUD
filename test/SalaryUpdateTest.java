package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryUpdateTest {

    @Test
    public void updateSalaryInRangeTest() {
        FullEmployee emp1 = new FullEmployee("Andrea", "Bose", "114504220", 68000.0, "Marketing Specialist", "Marketing");
        double minSalary = 58000.0;
        double maxSalary = 105000.0;
        double percentIncrease = 3.2;
        if(emp1.salary >= minSalary && emp1.salary < maxSalary) {
            emp1.salary = emp1.salary * (1 + percentIncrease / 100);
        }
        double expectedSalary = 68000.0 * (1 + 3.2 / 100);
        assertEquals(expectedSalary, emp1.getSalary());
    }

    @Test
    public void nonUpdateBelowMinTest() {
        FullEmployee emp2 = new FullEmployee("Red", "Tyson", "944312399", 22000.0, "Customer Support Associate", "Support");
        double minSalary = 58000.0;
        double maxSalary = 105000.0;
        double percentIncrease = 3.2;
        if(emp2.salary >= minSalary && emp2.salary < maxSalary) {
            emp2.salary = emp2.salary * (1 + percentIncrease / 100);
        }
        assertEquals(22000.0, emp2.getSalary());
    }
    @Test
    public void nonUpdateAboveMaxTest() {
        FullEmployee emp = new FullEmployee("Ronald", "McDonald", "488181030", 112000.0, "Frontend Engineer", "Engineering");

        double minSalary = 58000.0;
        double maxSalary = 105000.0;
        double percentIncrease = 3.2;
        if(emp.salary >= minSalary && emp.salary < maxSalary) {
            emp.salary = emp.salary * (1 + percentIncrease / 100);
        }
        assertEquals(112000.0, emp.getSalary());
    }
}
