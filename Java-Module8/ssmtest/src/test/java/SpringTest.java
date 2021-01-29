import com.lagou.domain.Department;
import com.lagou.domain.Employee;
import com.lagou.service.DepartmentService;
import com.lagou.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class SpringTest {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void findAll() {
        List<Department> allDepartment = departmentService.findAllDepartment();
        for (Department department : allDepartment) {
            System.out.println(department);
        }
    }

    @Test
    public void findAllEmp() {
        for (Employee employee : employeeService.findAllEmployee()) {
            System.out.println(employee);
        }
    }


}
