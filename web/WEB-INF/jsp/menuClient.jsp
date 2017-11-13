<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 18:51:52
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
        <title><spring:message code="menuClient.title" /> </title>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

        <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="css/all.css" rel="stylesheet" type="text/css" media="all"/>

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

        <!-- for success intégré -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    </head>
    <body>
        <c:if test="${!empty sessionScope.reservation}">
            <div class="container">
                <div class="alert alert-info fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong><spring:message code="${msg}" /></strong>
                </div>
            </div>
        </c:if>
        
        <div class="header">
            <h1><spring:message code="menuClient.subtitle" /></h1><br/><br/>
        </div>
        <div class="main">
            <div class="menuR" style="padding-right: 250px">
                <ul>
                    <li> <a href="${pageContext.request.contextPath}/affichage.htm"><spring:message code="menuClient.aAffichage"/></a></li> <br/> <br/><br/><br/> 
                    <li> <a href="${pageContext.request.contextPath}/rech.htm"><spring:message code="menuClient.aRech" /></a> </li><br/><br/><br/><br/>
                    <li> <a  href="MyReservations.htm"><spring:message code="menuClient.aMyReservations" /></a> </li><br/><br/><br/><br/> 
                </ul>
            </div>

        </div>
        <div class="footer">
        </div>

    </body>
</html>
