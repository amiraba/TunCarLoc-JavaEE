<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 20:53:45
    Author     : Hela Chikhaoui
--%>
<jsp:include page="testCnx.jsp" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <title> <spring:message code="reservationMenu.title" /> </title>

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
        <div class="header">
            <h1><spring:message code="reservationMenu.subtitle" /> </h1>
        </div>
        <div class="main" style="width: 70%; margin: 0 auto;">
                <div  class="mail-form" ">
                    <form:form method="POST" action="/AuthentifTest/reserveVoiture.htm" modelAttribute="reservation">
                        <table style="width: 40%;">
                            <tr><h7 style="color: red">${resFail} </h7></tr>
                            <tr >
                                <td ><form:label path="matricule"><spring:message code="reservationMenu.matricule"/></form:label></td>
                                <td><form:input path="matricule" /> 
                                    <form:errors path="matricule" cssClass="error"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="date"><spring:message code="reservationMenu.dateReserv" /></form:label></td>
                                <td><form:input type="date" path="date" />
                                    <form:errors path="date"  cssClass="error"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="dater"><spring:message code="reservationMenu.dateRemise" /></form:label></td>
                                <td><form:input type="date" path="dater" /> 
                                    <form:errors path="dater" cssClass="error"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <spring:message code="reservationMenu.submit" var="submit" />
                                    <input  type="submit" value="${submit}"/>
                                </td>
                            </tr>
                            <tr>
                                <td></td><td></td>
                                <td>
                                    <c:if test="${empty sessionScope.login}">
                                        <a style="color: #1b6d85;" href="/AuthentifTest/authentif.htm"><spring:message code="reservationMenu.seConnecter" /></a><br>
                                    </c:if>
                                </td>
                            </tr>
                        </table>
                    </form:form>    
                </div>
            </div>
        
    </body>
</html>

