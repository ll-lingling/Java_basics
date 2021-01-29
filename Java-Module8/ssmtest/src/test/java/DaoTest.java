import com.lagou.dao.DepartmentDao;
import com.lagou.dao.EmployeeDao;
import com.lagou.domain.Department;
import com.lagou.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DaoTest {


    @Test
    public void test1() throws IOException {
        System.out.println("test1 run");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();

      /*  List<Department> depts = sqlSession.selectList("dept.findAll");

        for (Department dept : depts) {
            System.out.println(dept);
        }*/
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        for (Department department : mapper.findAllDepartment()) {
            System.out.println(department);
        }
    }


    @Test
    public void test2() throws IOException {
        System.out.println("test2 run");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();

        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department dept = mapper.findDepartmentById(2);
        System.out.println(dept);

    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();

        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        for (Employee employee : mapper.findAllEmployee()) {
            System.out.println(employee);
        }
    }
}
