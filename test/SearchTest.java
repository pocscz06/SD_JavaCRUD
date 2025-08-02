package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    @Test
    public void searchByNameTest() throws Exception {
        IEmployee emp1 = EmployeeDAO.searchByName("Chester", "Wester");
        assertNotNull(emp1);
        assertEquals("Chester", emp1.getFirstName());
        assertEquals("Wester", emp1.getLastName());
    }

    @Test
    public void searchBySSNTest() throws Exception {
        IEmployee emp2 = EmployeeDAO.searchBySSN("433675049");
        assertNotNull(emp2);
        assertEquals("Anna", emp2.getFirstName());
        assertEquals("Wise", emp2.getLastName());
    }

    @Test
    public void searchByNameNotFoundTest() throws Exception {
        IEmployee emp3 = EmployeeDAO.searchByName("Johnny", "Chad");
        assertNull(emp3);
    }
}
