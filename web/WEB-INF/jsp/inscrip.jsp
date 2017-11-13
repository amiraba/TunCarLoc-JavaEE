<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 13:38:34
    Author     : Hela Chikhaoui
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="testCnx.jsp" />

<html>
    <head>
        <title> <spring:message code="inscrip.title" /> </title>

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
            <h1><spring:message code="inscrip.subtitle" /></h1>
        </div>
        <div class="main">
            <div class="mail-section">
                <div class="close"> </div>
                <div class="mail-form">

                    <form:form method="POST" action="/AuthentifTest/inscripDone.htm" modelAttribute="inscrip">
                        <form:label  path="name"><spring:message code="inscrip.nom" /></form:label>
                        <form:input  path="name" />
                        <form:errors path="name" class="error"/>

                        <br/><br/>
                        <form:label  path="surname"><spring:message code="inscrip.prenom" /></form:label>
                        <form:input  path="surname" />
                        <form:errors path="surname" class="error"/>

                        <br/><br/>
                        <form:label  path="email"><spring:message code="inscrip.email" /></form:label>
                        <form:input path="email" />
                        <form:errors path="email" class="error"/>
                        <br/><br/>
                        <form:label  path="login"><spring:message code="inscrip.login" /></form:label>
                        <form:input  path="login" />
                        <form:errors path="login" class="error"/>
                        <br/><br/>
                        <form:label  path="password"><spring:message code="inscrip.password" /></form:label>
                        <form:password class="input" path="password" />
                        <form:errors path="password" class="error"/>
                        <br/> <br/>
                        <form:label  path="password2"><spring:message code="inscrip.password2" /></form:label>
                        <form:password class="input" path="password2" />
                        <form:errors path="password2" class="error"/>
                        <br/>  <br/>
                        <spring:message code="inscrip.submit" var="inscripSubmit"/>
                        <input class="submit" type="submit" value="${inscripSubmit}"/>

                    </form:form>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="footer">
        </div>

    </body>
</html>
