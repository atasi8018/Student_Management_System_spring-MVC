<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<title>Student List</title>
</head>
<body>

<h2>Student Management System</h2>

<a href="${pageContext.request.contextPath}/student/add">
    Add New Student
</a>

<br><br>

<table border="1" cellpadding="10">

    <thead>
<tr>
<th>ID</th>
<th>Full Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Age</th>
<th>Course</th>
<th>Actions</th>
</tr>
</thead>

    <tbody>

        <c:forEach var="student" items="${students}">

            <tr>
<td>${student.id}</td>
<td><c:out value="${student.fullName}"/></td>
<td><c:out value="${student.email}"/></td>
<td><c:out value="${student.mobile}"/></td>
<td>${student.age}</td>
<td><c:out value="${student.course}"/></td>

                <td>

                    <a href="${pageContext.request.contextPath}/student/view/${student.id}">
                        View
</a>

                    |

                    <a href="${pageContext.request.contextPath}/student/edit/${student.id}">
                        Edit
</a>

                    |

                    <form method="post"
                          action="${pageContext.request.contextPath}/student/delete/${student.id}"
                          style="display:inline"
                          onsubmit="return confirm('Delete this student?')">

                        <button type="submit">Delete</button>

                    </form>

                </td>
</tr>

        </c:forEach>

        <c:if test="${empty students}">
<tr>
<td colspan="7">No students found.</td>
</tr>
</c:if>

    </tbody>

</table>

</body>
</html>