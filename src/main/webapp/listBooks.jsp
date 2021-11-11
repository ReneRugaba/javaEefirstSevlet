<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="org.libraryshoponline.library.dto.Book"%>
<%@page import="org.libraryshoponline.library.dto.Library"%>

        <ul>
        <%
            List<Book> books=(List<Book>)session.getAttribute("books");
            for( int i=0;i<books.size();i++ ){
        %>
            <li><%=books.get(i).getTitle()%> <a href="detailsbook?index=<%=i%>">details</a></li>
         <%
            }
         %>
        </ul>
