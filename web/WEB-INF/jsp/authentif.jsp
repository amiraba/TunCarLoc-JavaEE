<%-- 
    Document   : authentif
    Created on : 14 févr. 2016, 13:27:42
    Author     : Hela Chikhaoui
--%>
<jsp:include page="testCnx.jsp" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>


<!DOCTYPE HTML>
<html>
    <head>
        <title> <spring:message code="authentif.title" /> </title>

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
            <h1><spring:message code="authentif.msg" /></h1>
        </div>
        <div class="main">
            <div class="mail-section">
                <div class="close"> </div>
                <div class="mail-image">
                    <img src="images/message.png" alt="" class="imageLittleCar"/>
                </div>
                <div class="mail-form">
                    <form:form id="auth" method="POST" action="/AuthentifTest/authentifDone.htm" modelAttribute="authentif">
                        <span style="color: red"> ${AuthError} </span> <br/><br/>

                        <form:label class="label" path="login"><spring:message code="authentif.login" /> </form:label>
                        <form:input id="login" class="input" path="login" />
                        <form:errors path="login" class="error"/>

                        <br/>
                        <br/>

                        <form:label class="label" path="password"><spring:message code="authentif.password" /> </form:label>
                        <form:password id="password" class="input" path="password" />
                        <form:errors path="password" class="error"/>
                        <br/>
                        <br/>
                        <spring:message code="authentif.submit" var="authentifSubmit" />
                        <input class="submit" type="submit" value="${authentifSubmit}"/><br/>
                        <a href="${pageContext.request.contextPath}/inscrip.htm"><spring:message code="authentif.aInscriptionSuggesion1" /><br/><spring:message code="authentif.aInscriptionSuggesion2" /></a>
                    </form:form>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="footer">
        </div>

    </body>
</html>
