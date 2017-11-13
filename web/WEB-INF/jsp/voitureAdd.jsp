<%-- 
    Document   : newjsp
    Created on : 14 févr. 2016, 14:18:33
    Author     : Hela Chikhaoui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="testCnx.jsp" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="voitureAdd.title" /></title>

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
            <h1><spring:message code="voitureAdd.subtitle" /></h1>
        </div>
        
         <nav id="sidebar" class="menu">
            <ul>
                <c:if test="${sessionScope.login}!=\"admina\"}" >
                     <li> <a  href="${pageContext.request.contextPath}/redirection.htm"><spring:message code="menuClient.mySpace" /></a> </li><br/> 
                </c:if>
            </ul>
        </nav>
        
        <div class="main">
            <div class="mail-section">
                <div class="close"> </div>

                <div class="mail-form">
                    <form:form method="POST" action="/AuthentifTest/VoitureAddDone.htm" modelAttribute="voitureAdd" enctype="multipart/form-data">

                        <form:label path="matricule"><spring:message code="affichage.matricule" /></form:label>
                        <form:input path="matricule" /> <form:errors path="matricule" cssClass="error"/>
                        <br/><br/>
                        <form:label path="marque"><spring:message code="affichage.marque" /></form:label>
                        <form:input path="marque" /><form:errors path="marque" cssClass="error"/>

                        <br/><br/>

                        <form:label path="couleur"><spring:message code="affichage.couleur" /></form:label>
                        <form:input path="couleur" /><form:errors path="couleur" cssClass="error"/>
                        <br/><br/>


                        <form:label path="age"><spring:message code="voitureAdd.age" /></form:label>
                        <form:input path="age" /><form:errors path="age" cssClass="error"/>
                        <br/><br/>

                        <form:label path="moteur"><spring:message code="voitureAdd.moteur" /></form:label>
                        <form:input path="moteur" /><form:errors path="moteur" cssClass="error"/>
                        <br/><br/>

                        <form:label path="puissance"><spring:message code="voitureAdd.puissance" /></form:label>
                        <form:input path="puissance" /><form:errors path="puissance" cssClass="error"/>
                        <br/><br/>

                        <form:label path="prix"><spring:message code="affichage.prix" /></form:label>
                        <form:input path="prix" /><form:errors path="prix" cssClass="error"/>

                        <br/><br/>

                        <form:label path="info"><spring:message code="voitureAdd.info" /></form:label>
                        <form:input path="info" /><form:errors path="info" cssClass="error"/>
                        <br/><br/>

                        <form:label path="disponibilite"><spring:message code="affichage.disponibilite" /></form:label>
                        <form:input path="disponibilite" /><form:errors path="disponibilite" cssClass="error"/>
                        <br/><br/>

                        <form:label path="image" >Image</form:label>
                        <form:input path="image" type="file" /><form:errors path="image" cssClass="error"/>
                        <br/><br/>
                        
                        <spring:message code="authentif.submit" var="authentifSubmit" />
                        <input class="submit" type="submit" value="${authentifSubmit}"/>

                    </form:form>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="footer">
        </div>

    </body>
</html>
