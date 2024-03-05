<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css&quot" rel="stylesheet">
   
</head>
<body>
   <section class="container mt-5">
       <h1>THÔNG TIN PHÒNG BAN</h1>
       
       <p style="color: red;">${errorString}</p>
       <p> ${sql}</p>
       <table class="table table-bordered">
           <thead style="background: #f1f1f1">
               <tr>
                   <th>Id</th>
                   <th>Name</th>
                   <th>Dept No</th>
                   <th>Location</th>
                   <th>Edit</th>
                   <th>Delete</th>
               </tr>
           </thead>
           <tbody>
               <c:forEach items="${listDepartment}" var="department">
                   <tr>
                       <td>${department.getDeptId()}</td>
                       <td>${department.getDeptName()}</td>
                       <td>${department.getDeptNo()}</td>
                       <td>${department.getLocation()}</td>
                   </tr>
               </c:forEach>
           </tbody>
       </table>

   </section>

</body>
</html>