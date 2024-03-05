<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Application</title>
</head>
<body>
    <div align="center">
   <form action="insert" method="post">
        <table border="1" cellpadding="5">
            
          <c:if test="${department != null}">
           <input type="hidden" name="id" value="<c:out value='${department.id}' />" />
          </c:if>            
            <tr>
                <th>Name: </th>
                <td>
                 <input type="text" name="deptName" size="45"
                   value="<c:out value='${department.name}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>deptNo: </th>
                <td>
                 <input type="text" name="deptNo" size="45"
                   value="<c:out value='${department."deptNo"}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>location: </th>
                <td>
                 <input type="text" name="location" size="15"
                   value="<c:out value='${department.location}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>