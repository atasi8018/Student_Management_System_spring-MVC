
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>

<h2>
    <c:choose>
        <c:when test="${student.id != null}">
            Update Student
        </c:when>
        <c:otherwise>
            Register Student
        </c:otherwise>
    </c:choose>
</h2>

<form:form modelAttribute="student"
           method="post"
           action="${pageContext.request.contextPath}/student/${student.id != null ? 'update' : 'save'}">

    <form:hidden path="id"/>

    <label>Full Name:</label>
    <form:input path="fullName"/>
    <form:errors path="fullName" cssStyle="color:red"/>
    <br><br>

    <label>Email:</label>
    <form:input path="email"/>
    <form:errors path="email" cssStyle="color:red"/>
    <br><br>

    <label>Mobile:</label>
    <form:input path="mobile"/>
    <form:errors path="mobile" cssStyle="color:red"/>
    <br><br>

    <label>Age:</label>
    <form:input path="age" type="number"/>
    <form:errors path="age" cssStyle="color:red"/>
    <br><br>

    <label>Course:</label>
    <form:input path="course"/>
    <form:errors path="course" cssStyle="color:red"/>
    <br><br>

    <button type="submit">Submit</button>

</form:form>

<br>

<a href="${pageContext.request.contextPath}/student/list">
    Back to Student List
</a>

</body>
</html>
