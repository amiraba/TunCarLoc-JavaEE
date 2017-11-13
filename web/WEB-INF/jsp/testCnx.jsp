<%-- 
    Document   : testCnx
    Created on : 31 janv. 2016, 08:10:36
    Author     : Hela Chikhaoui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="${pageContext.request.contextPath}/css/all.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="${pageContext.request.contextPath}/css/testCnx.css" rel="stylesheet" type="text/css" media="all"/>
    </head>
    <body>
        
        <header>

             <a href="/AuthentifTest/welcome.htm" ><img src="${pageContext.request.contextPath}/images/home.png" alt="Home" style="width: 4%"/></a><br/>
             <c:if test="${!empty sessionScope.login}">
                <span class="welcomeText">    
                Bienvenue  <c:out  value="${sessionScope.login}"/> 
                
                </span> <br/>           
            </c:if>
             <a href="?lang=en">en</a> | <a href="?lang=fr">fr</a> <br/>
             <c:if test="${!empty sessionScope.login}">
                <span class="welcomeText">    
                <span> <a id="deco" href="/AuthentifTest/logOut.htm" ><spring:message code="testCnx.logOut" /></a> </span>
            </c:if>
            <table>    
            <tr>
                <td rowspan="10">
                   <div class="divLogo">
                    <img src="${pageContext.request.contextPath}/images/logo.png" alt="TunCarLoc"/>
                   </div>
               </td>
           </tr>   
            </table>
         </header>       
         <footer class="fooooter">
             <spring:message code="copyrights"/><br/>
             Dors comme un chat et code comme une fourmi
         </footer>
    </body>
        
</html>
