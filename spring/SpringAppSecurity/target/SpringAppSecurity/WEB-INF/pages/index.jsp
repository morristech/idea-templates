<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<!doctype>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <div>
            <h1>Home</h1>
            <sec:authorize access="isAnonymous()">
                <p>
                    <a href="/login">Sign In</a>
                </p>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <p>Hello, ${userDetails.username}! <form action="<%=request.getContextPath()%>/logout" method="POST"><input type="submit" value="Sign Out!"/><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></form> </p>
            </sec:authorize>

            <sec:authorize access="hasAuthority('admin')">
                <p>
                    <a href="/admin">Admin page</a>
                </p>
            </sec:authorize>
        </div>
    </body>
</html>