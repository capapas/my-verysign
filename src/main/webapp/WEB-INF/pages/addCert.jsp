<%@ page import="org.esgi.model.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="org.esgi.model.Person" %>
<html>
<head>
    <mytags:header/>
</head>
<body><mytags:menu/>

<div class="page-header">
    <h1>Create Certificate</h1>
</div>

<div class="well">
    <p>Veuillez remplir les champs suivants afin de generer votre certificat.</p>
</div>

<% Person person = (Person) request.getAttribute("userConnected"); %>
<%--action="<c:url value='/add-cert.htm' />"--%>
<form class="form-horizontal" method="post" commandName="add-cert">

    <%--NOM DU CERTIFICAT--%>
    <div class="control-group">
        <label class="control-label" for="certname">Le nom de votre certificat (ne pas reutiliser un nom deja renseigne)
            *</label>

        <div class="controls">
            <input type="text" id="certname" name="certname" value="certificat_1" required="true">
        </div>
    </div>

    <%--PAYS--%>
    <div class="control-group">
        <label class="control-label" for="country">Code Pays * (2 lettres maximum)</label>

        <div class="controls">
            <input type="text" id="country" name="country" value="Exemple : FR" required="true" maxlength="2">
        </div>
    </div>

    <%--ETAT OU PROVINCE--%>
    <div class="control-group">
        <label class="control-label" for="state">Votre Etat ou province *</label>

        <div class="controls">
            <input type="text" id="state" name="state" value="Exemple : Monaco" required="true">
        </div>
    </div>

    <%--VILLE--%>
    <div class="control-group">
        <label class="control-label" for="city">Votre ville *</label>

        <div class="controls">
            <input type="text" id="city" name="city" value="Exemple : Paris" required="true">
        </div>
    </div>

    <%--COMPAGNIE--%>
    <div class="control-group">
        <label class="control-label" for="compagny">Votre entreprise / societe (vide si il n'y en a pas)</label>

        <div class="controls">
            <input type="text" id="compagny" name="compagny" value="Exemple : Natysphere">
        </div>
    </div>

    <%--SECTION--%>
    <div class="control-group">
        <label class="control-label" for="section">Section de votre compagnie (vide si il n'y en a pas)</label>

        <div class="controls">
            <input type="text" id="section" name="section" value="Exemple : Entertainment">
        </div>
    </div>

    <%--NOM--%>
    <div class="control-group">
        <label class="control-label" for="commonName">Votre nom *</label>

        <div class="controls">
            <input type="text" id="commonName" name="commonName" value="<%=person.getLastname()%>">
        </div>
    </div>

    <%--EMAIL--%>
    <div class="control-group">
        <label class="control-label" for="email">Votre Email *</label>

        <div class="controls">
            <input type="text" id="email" name="email" placeholder="Email" value="<%=person.getMail()%>">
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-primary">Generer le certificat</button>
        </div>
    </div>
</form>
<mytags:footer/>
</body>
</html>