<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<mytags:header />
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			<a class="brand" href="${pageContext.request.contextPath}/">My Very Sign</a>
		</div>
	</div>
</div>

<div class="container">

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

<div class="container">
	<div class="form-signin">
		<h1 class="form-signin-heading">Connexion</h1>
		<form method='post' name="f" action="<c:url value='/j_spring_security_check' />" class="form-horizontal">
			<input type="hidden" name="url" value="" />
			<div class="control-group">
				<label class="control-label" for="j_username">Pseudo :</label>
				<div class="controls">
					<input type="text" id="j_username" name="j_username" >
   				</div>
  			</div>
  			<div class="control-group">
	    		<label class="control-label" for="j_password">Mot de passe :</label>
	    		<div class="controls">
	      			<input type="password" id="j_password" name="j_password">
	    		</div>
	  		</div>
	  		<div class="control-group">
	       		<div class="control-group well">
	    			<div class="controls">
	       				<button class="btn btn-primary" type="submit">Soumettre</button>
	       				<button class="btn" type="reset">Annuler</button>
	    			</div>
	  			</div>
	  		</div>
		</form>
	</div>
</div> <!-- /container -->

	<mytags:footer/>
</body>
</html>