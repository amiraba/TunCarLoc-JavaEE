<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 14:40:45
    Author     : Hela Chikhaoui
--%>
<jsp:include page="testCnx.jsp" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="Users.title" /></title>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="${pageContext.request.contextPath}/css/all.css" rel="stylesheet" type="text/css" media="all"/>

        <!-- Custom Theme files -->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <meta name="keywords" content="Login On Webapp Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <!--web-fonts-->
        <link href='//fonts.googleapis.com/css?family=Nunito:400,700,300' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <!--web-fonts-->
        <script src="js/jquery.min.js"></script>

        

    </head>
    <body>
        <c:if test="${!empty sessionScope.msg}">
            <div class="container">
                <div class="alert alert-info fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong><spring:message code="${msg}" /></strong>
                </div>
            </div>
        </c:if>
        <div class="header">
            <h1> <spring:message code="Users.tableTitle" /> </h1><br/>
        </div>
        <div class="main">
            <nav id="sidebar" class="menu">
                <ul>
                    <li>  <a  href="${pageContext.request.contextPath}/redirection.htm"><spring:message code="menuClient.mySpace" /></a> </li><br/> 
                </ul>
            </nav>

            <div class="mail-section" style="width: 40%;padding: 3em 30em 3em 1em; left: 60px;">

                <table class="rwd-table" style="width: 80%"> 
                    <tr><h7 style="color: red">${SuccessDelUser} </h7></tr>
                <th><spring:message code="user.login" /> </th> <th> <spring:message code="user.name" /> </th>  <th> <spring:message code="user.surname" /> </th> <th><spring:message code="user.email" />  </th><th> <spring:message code="user.ban" /></th>
                        <c:forEach var="liste" items="${liste}" >
                        <tr>

                            <td> ${liste.login}  </td>  <td> ${liste.name} </td> <td>${liste.surname}</td> <br/>
                        <td><input TYPE="button"  VALUE=" Mail" onClick="parent.location = 'mailto:${liste.email}?subject=Objet du courrier'" /></td>
                            <spring:url value="/${liste.login}/deleteUser.htm" var="user" />
                        <td> <button class="btn btn-primary"  onclick="location.href = '${user}'"><spring:message code="UsersList.Ban" /></button> </td>

                        </tr>
                    </c:forEach>
                </table>
                <div class="clear"> </div>
            </div>
        </div>

    </body>
</html>
