<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper1">
	<div class="width1000">
		<div style="text-align: center;">
			<h2 class="h2_right_content">Connexion</h2>
			<form action="connexion" method="post">
				<fieldset>
					<label for="user_pseudo">Pseudo :</label><br />
					<div>
						<input type="text" value="<c:out value="${param.user_pseudo}"/>"
							name="user_pseudo" id="user_pseudo" placeholder="Pseudonyme" />
					</div>
					<br /> <span class="erreur">${erreurs['user_pseudo']}</span> <label
						for="user_password">Mot de passe :</label><br />
					<div>
						<input type="password" name="user_password" id="user_password"
							placeholder="Password..." />
					</div>
					<br />
					<br /> <span class="erreur">${erreurs['user_password']}</span> <input
						type="hidden" name="connexion" value="1" />
					<div style="margin: auto;">
						<input class="submit" type="submit" value="Login !" id="submit" />
					</div>
					<p style="${empty erreurs ? 'color: green;' : 'color: red;'}">${resultat}</p>
				</fieldset>
			</form>
		</div>
	</div>
	<div style="clear: both"></div>
</section>

<!-- Footer -->
<jsp:include page="footer.jsp" />