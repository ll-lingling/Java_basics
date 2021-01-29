import com.lagou.domain.Department;
import com.lagou.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class DeptTest {


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
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        for (Department department : mapper.findAll()) {
            System.out.println(department);
        }
    }


    @Test
    public void test2() throws IOException {
        System.out.println("test2 run");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Department dept = mapper.findById(2);
        System.out.println(dept);

    }




}
