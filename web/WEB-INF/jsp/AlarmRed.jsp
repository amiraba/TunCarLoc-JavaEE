<%-- 
    Document   : AlarmGreen
    Created on : 18 févr. 2016, 20:12:02
    Author     : Hela Chikhaoui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <c:forEach var="liste" items="${reservListe}" >

        <tr>

        ${liste.matricule}   ${liste.login} ${liste.date}${liste.dater}<br/>      

        <spring:url value="/reserve/${liste.matricule}/deleteRes.htm" var="reserve" />
        <td> <button class="btn btn-primary"  onclick="location.href = '${reserve}'"><spring:message code="MyReservations.annuler" /></button> </td>
    </tr>   

</c:forEach>
</body>
</html>
