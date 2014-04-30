<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3">
	<div class="width1000">
		<div style="text-align: center;">
			<span class="titleAbout">Connexion</span>
			<form action="connexion" method="post">
					<label for="login">Pseudo :</label><br />
					<div>
						<input type="text" value="<c:out value="${param.login}"/>"
							name="login" id="login" style="line-height: 40px;height: 30px;" placeholder="Identifiant" />
					</div>
					<span class="erreur">${erreurs['login']}</span> <label
						for="password">Mot de passe :</label><br />
					<div>
						<input type="password" name="password" id="password" style="line-height: 40px;height: 30px;" placeholder="Mot de passe" />
					</div>
					 <span class="erreur">${erreurs['password']}</span> <input
						type="hidden" name="connexion" value="1" />
					<div style="margin: auto;">
						<input class="submit" style="background-color: #ea3c3d;border: 1px solid white;color: white;padding-left: 15px;padding-right: 15px;height: 35px;line-height: 40px;" type="submit" value="Login !" id="submit" />
					</div>
					<p style="${empty erreurs ? 'color: green;' : 'color: red;'}">${resultat}</p>
			</form>
		</div>
	</div>
</section>

<jsp:include page="footer.jsp" />