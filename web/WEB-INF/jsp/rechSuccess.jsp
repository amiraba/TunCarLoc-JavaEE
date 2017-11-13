<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 21:05:08
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
        <title>Home</title>
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
        <div class="header">
            <title> <spring:message code="rechSuccess.title" /> </title><br/>
        </div>

        <div class="main">
            <div class="mail-section" style="width: 45%;padding: 3em 30em 3em 1em; left: 60px;">
                <div class="close"> </div>
                <table class="rwd-table">        
                    <tr>
                        <th> <spring:message code="affichage.marque" /></th><th>  <spring:message code="affichage.prix" /> </th> <th><spring:message code="affichage.disponibilite" /> </th><th>Image</th> <th><spring:message code="affichage.location" /> </th>
                    </tr>
                    ${Vide}
                    <c:forEach var="list" items="${list}" >
                        <tr>        
                            <td> ${list.marque} </td> <td>  ${list.prix}</td> <td>  ${list.disponibilite}</td>    <td>  <img  src="data:image/jpeg;base64,${list.imageShown}" /></td>

                            <spring:url value="/reserve/${list.matricule}/locate.htm" var="reserve" />
                            <td><button class="btn btn-primary"  onclick="location.href = '${reserve}'"><spring:message code="affichage.reserve" /></button> </td>
                            <c:if test="${sessionScope.login=='admina'}">
                                <spring:url value="/${list.matricule}/voitureDelete.htm" var="reserve" />
                                <spring:url value="/${list.matricule}/voitureUpdate.htm" var="update" />
                                <td><button class="btn btn-primary"  onclick="location.href = '${reserve}'"><spring:message code="affichage.delete" /></button> </td>
                                <td><button class="btn btn-primary"  onclick="location.href = '${update}'"><spring:message code="affichage.update" /></button> </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="footer">
        </div>
    </body>
</html>
