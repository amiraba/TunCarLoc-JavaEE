<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 19:16:33
    Author     : Hela Chikhaoui
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="testCnx.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <title><spring:message code="updateMenu.title" /></title>

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
        </div>
        <div class="main">
            <div class="mail-section">
                <div class="close"> </div>
                <div class="mail-image">
                    <img src="${pageContext.request.contextPath}/images/message.png" alt="" />

                </div>
                <div class="mail-form">

                    <form:form method="POST" action="/AuthentifTest/updateVoiture.htm" modelAttribute="voitureAdd">

                        <form:label path="matricule"><spring:message code="updateMenu.matricule" /> </form:label>
                        <form:input path="matricule" /> 
                        <form:errors path="matricule" cssClass="error"/>
                        <br/><br/>
                        <form:label path="age"><spring:message code="updateMenu.age"/> </form:label>
                        <form:input  path="age" />
                        <form:errors path="age"  cssClass="error"/>
                        <br/><br/>

                        <form:label path="disponibilite"><spring:message code="updateMenu.disponibilite" /></form:label>
                        <form:input path="disponibilite" /> 
                        <form:errors path="disponibilite" cssClass="error"/>
                        <br/><br/>

                        <spring:message code="rech.submit" var="rechSubmit" />
                        <input  type="submit" value="${rechSubmit}"/>

                    </form:form>  
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="footer">
        </div>

    </body>
</html>
