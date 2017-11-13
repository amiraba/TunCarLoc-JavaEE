<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 17:02:18
    Author     : Hela Chikhaoui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="testCnx.jsp" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> <spring:message code="menuAdmin.title" /> </title>
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
        <script>$(document).ready(function (c) {
                $('.closeAlert').on('click', function (c) {
                    $('.warning').fadeOut('slow', function (c) {
                        $('.warning').remove();
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="header">
            <h1><spring:message code="menuAdmin.subtitle" /></h1><br/>
        </div>

        <div class="main">
            <div class="menu">
                <ul>
                    <li> <a href="${pageContext.request.contextPath}/affichage.htm"><spring:message code="menuClient.aAffichage" /></a></li> <br/> <br/><br/><br/> 
                    <li>  <a href="${pageContext.request.contextPath}/voitureAdd.htm"><spring:message code="menuAdmin.aAddVoiture" /></a> <br/><br/></li><br/><br/>
                     <li>  <a href="${pageContext.request.contextPath}/pieChart.htm"><spring:message code="menuAdmin.apieChart" /></a> <br/><br/></li><br/><br/>
                </ul>
            </div>
            <div class="menuM">
                <ul>
                    <li>  <a href="${pageContext.request.contextPath}/rech.htm"><spring:message code="menuAdmin.aRech" /></a> </li><br/><br/><br/><br/>
                    <li>  <a href="${pageContext.request.contextPath}/reservationsAdmin.htm"><spring:message code="menuAdmin.aReservations" /></a> <br/><br/></li><br/><br/>
                    <li>  <a href="${pageContext.request.contextPath}/clientsList.htm"><spring:message code="Users.title" /></a> <br/><br/></li><br/><br/>

                </ul>
            </div>
        </div>
        <c:forEach var="liste" items="${Liste}" >
            <div class="warning">          
                <div class="closeAlert"> </div>
                <spring:message code="menuAdmin.LaVoit" /> <span class="attribute"> ${liste.matricule}</span> <spring:message code="menuAdmin.ResPar" /> <span class="attribute"> ${liste.login}</span> <spring:message code="menuAdmin.RenderDate" /> <span class="attribute">${liste.dater}</span>     
                <span class="attribute"> <input TYPE="button"  VALUE=" Mail" onClick="parent.location = 'mailto:votreadresse@domaine.com?subject=Objet du courrier'" /></span>
                <span> <button class="btn btn-primary"  onclick="location.href = '${user}'"><spring:message code="UsersList.Ban" /></button> </span>
            </div>
        </c:forEach>

    </body>
</html>
