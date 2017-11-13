<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 16:15:03
    Author     : Hela Chikhaoui
--%>
<jsp:include page="testCnx.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="affichage.title"/></title>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="${pageContext.request.contextPath}/css/all.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="${pageContext.request.contextPath}/css/affichage.css" rel="stylesheet" type="text/css" media="all"/>
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
    
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>

           <script type="text/javascript"
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
    <script>


function saveRating(rate)
{
    jQuery('.rating').attr('onmouseout','setRating(\''+"number"+'\')');
    $('#result').html(rate);        
}
</script>

    </head>
    <body>
        
        <div class="header">
            <h1> <spring:message code="affichage.subtitle" />  </h1><br/>
        </div>
       
        <nav id="sidebar" class="menu">
            <ul>
                <c:if test="${empty sessionScope.login}">     
                    <li> <a href="${pageContext.request.contextPath}/inscrip.htm"><spring:message code="affichage.aInscriptionClient" /></a> </li> <br/><br/><br/><br/>
                    <li><a href="${pageContext.request.contextPath}/authentif.htm"><spring:message code="affichage.aSeConnecter" /></a></li><br/><br/><br/><br/>
                    </c:if>
                <li><a href="${pageContext.request.contextPath}/rech.htm"><spring:message code="affichage.aRech" /></a></li><br/><br/><br/><br/>
                    <c:if test="${!empty sessionScope.login}">
                        <c:if test="${sessionScope.login != 'admina'}" >
                            <li> <a href="MyReservations.htm"><spring:message code="menuClient.aMyReservations" /></a> </li><br/><br/><br/><br/> 
                        </c:if>
                        <li> <a  href="${pageContext.request.contextPath}/redirection.htm"><spring:message code="menuClient.mySpace" /></a> </li><br/> 
                         <div class="rating"><!--
                            --><a href="#5" onclick="saveRating('<spring:message code="rate" />');" title="Donner 5 étoiles">☆</a><!--
                            --><a href="#4" onclick="saveRating('<spring:message code="rate" />');" title="Donner 4 étoiles">☆</a><!--
                            --><a href="#3" onclick="saveRating('<spring:message code="rate" />');" title="Donner 3 étoiles">☆</a><!--
                            --><a href="#2" onclick="saveRating('<spring:message code="rate" />');" title="Donner 2 étoiles">☆</a>
                            <div id="result" style="color: #005555"></div>
                        </div>
                    </c:if>
            </ul>
        </nav>
        <div class="main">
            <h2><spring:message code="affichage.subtitle2" /></h2><br/>
            <div class="mail-section" style="width: 45%;padding: 3em 30em 3em 1em; left: 120px;">
                <div class="close"> </div>
                <div class="mail-image">

                </div>

                <table class="rwd-table">        
                    <h3 style="color: #005555"> <spring:message code="index.credo" /> </h3>
                    <tr>
                        <th> <spring:message code="affichage.marque" /></th><th>  <spring:message code="affichage.prix" /> </th> <th><spring:message code="affichage.disponibilite" /> </th> <th>Image </th>
                    </tr>
                    <tr>  <h7 style="color: red">${DelError} </h7></tr>  <br/><br/>
                        <c:forEach var="liste" items="${liste}" >

                        <tr>        
                            <td> ${liste.marque} </td><td>  ${liste.prix}</td> <td>  ${liste.disponibilite}</td> 
                            <td> <img  src="data:image/jpeg;base64,${liste.imageShown}" /></td>
                                <spring:url value="/reserve/${liste.matricule}/locate.htm" var="reserve" />
                                <c:if test="${sessionScope.login != 'admina'}" >
                                    <td><button class="btn btn-primary"  onclick="location.href = '${reserve}'"><spring:message code="affichage.reserve" /></button> </td>
                                </c:if>
                                <c:if test="${sessionScope.login=='admina'}">
                                <spring:url value="/${liste.matricule}/voitureDelete.htm" var="delete" />
                                <spring:url value="/${liste.matricule}/voitureUpdate.htm" var="update" />
                                <td><button class="btn btn-primary"  onclick="location.href = '${delete}'"><spring:message code="affichage.delete" /></button> </td>
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
