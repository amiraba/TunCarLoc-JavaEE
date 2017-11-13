<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 13:48:25
    Author     : Hela Chikhaoui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="testCnx.jsp" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="rech.title" /></title>

        <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
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
            <h1><spring:message code="rech.subtitle" /></h1>
        </div>
        <nav id="sidebar" class="menu">
                <ul>
                <c:if test="${!empty sessionScope.login}">
                    <li> <a  href="${pageContext.request.contextPath}/redirection.htm"><spring:message code="menuClient.mySpace" /></a> </li><br/> 
                </c:if>
                </ul>
            </nav>
        <div class="main">
            <div class="mail-section">
                <div class="close"> </div>
                <div class="mail-form">
                    <form:form method="POST" action="/AuthentifTest/rechDone.htm" modelAttribute="rech">
                        <form:label class="label" path="MotCle" ><spring:message code="rech.motCle" /></form:label>
                        <form:input class="input" path="motCle" />
                        <form:errors path="MotCle" cssClass="error"/>
                        <br/><br/>
                        <spring:message code="rech.submit" var="rechSubmit" />
                        <input class="submit" type="submit" value="${rechSubmit}"/>
                    </form:form>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="footer">
        </div>
    </body>
</html>
