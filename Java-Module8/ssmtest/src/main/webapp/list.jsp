<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>账户列表</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
  <div class="row">
      <h3 style="text-align: center">员工信息列表</h3>
      <div class="col-lg-2"></div>
      <div class="col-lg-8">

          <form action="${pageContext.request.contextPath}/employee/delete" method="post" id="deleteForm">
          <table border="1" class="table table-bordered table-hover">
              <tr class="success">
                  <th>
                      <input type="checkbox" id="checkAll">
                      <%--实现全选全不选效果--%>
                      <script>
                          $('#checkAll').click(function () {
                                $('input[name="ids"]').prop('checked',$(this).prop('checked'));
                          })
                      </script>

                  </th>
                  <th>编号</th>
                  <th>姓名</th>
                  <th>部分</th>
                  <th>职位</th>
                  <th>入职时间</th>
                  <th>电话</th>
              </tr>

              <c:forEach items="${employeeList}" var="employee">
                  <td>
                      <input type="checkbox" name="ids" value="${employee.id}">
                  </td>
                  <td>${employee.id}</td>
                  <td>${employee.empName}</td>
                  <td>${employee.deptId}</td>
                  <td>${employee.jobName}</td>
                    <%--格式化显示日期--%>
                  <td><fmt:formatDate value="${employee.joinDate}" pattern="yyyy-MM-dd"/></td>
                  <td>${employee.telephone}</td>
              </tr>
              </c:forEach>


              <tr>
                  <td colspan="9" align="center">
                      <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加新员工</a>
<%--                      <input class="btn btn-primary" type="button" value="删除选中" id="deleteBtn">--%>
                  </td>
              </tr>
          </table>
          </form>
      </div>
      <div class="col-lg-2"></div>
  </div>
</div>

</body>

<script>
        /*给删除选中按钮绑定点击事件*/
        $('#deleteBtn').click(function () {
        if(confirm('您确定要删除吗')){
        if($('input[name=ids]:checked').length > 0){
        /*提交表单*/
        $('#deleteForm').submit();
    }
    }else {
        alert('想啥呢，没事瞎操作啥')
    }
    })
</script>

</html>

