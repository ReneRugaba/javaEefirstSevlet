<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="org.libraryshoponline.library.dto.Book"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
    <body>

        <%
            Book book=(Book)session.getAttribute("bookDetails");
        %>
        <h1><%=book.getTitle()%></h1>
        <p>
            <%=book.getDescription()%>
        </p>

        </ul>
    </body>
</html>