
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<title>Error</title>
</head>
<body>

<h2>Something Went Wrong!</h2>

<p>
<c:out value="${errorMessage}"

           default="An unexpected error occurred."/>
</p>

<a href="${pageContext.request.contextPath}/student/list">

    Back to Student List
</a>

</body>
</html>

