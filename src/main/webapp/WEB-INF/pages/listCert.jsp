<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="org.esgi.model.Person" %>
<%@page import="org.esgi.model.Certificat" %>
<%@page import="java.util.List" %>
<html>
<head>
    <mytags:header/>
</head>
<body><mytags:menu/>

<%
    Person userConnected = null;
    List<Certificat> listCertificates = null;

    userConnected = (Person) request.getAttribute("userConnected");
    listCertificates = userConnected.getCertificats();
%>

<div class="page-header">
    <h1>List Certificate</h1>

    <%
        for (Certificat certificat : listCertificates) {
    %>
    <ul>
        <li><%=certificat.getCertName()%> - <%=certificat.getStartValidity()%>
        </li>

    </ul>
    <% } %>
</div>
<mytags:footer/>
</body>
</html>