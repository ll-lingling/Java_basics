import com.itheima.service.UserService;
import com.itheima.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 1.编码设置
         * 2.接收参数用户名
         * 3.创建service,并代用service的查询方法 ==> int count (1/0)
         * 4.直接将返回的count写到回调函数的data中
         */
        try {
            //1.编码设置
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            //2.接收参数用户名
            String username = request.getParameter("username");
            //3.创建service,并代用service的查询方法 ==> int count (1/0)
            UserService service = new UserServiceImpl();
            long count = service.findUserByName(username);
            //4.直接将返回的count写到回调函数的data中
            response.getWriter().print(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
