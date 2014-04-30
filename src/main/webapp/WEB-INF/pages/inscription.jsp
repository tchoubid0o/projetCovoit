<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc">
	<div class="width1000">
		<div style="text-align: center;">
			<span class="titleAbout">Inscription</span>
			<form action="inscription" method="post">
				<label for="login">Identifiant :</label><br />
				<div>
					<input type="text" value="<c:out value="${param.login}"/>"
						name="login" id="login" style="line-height: 40px; height: 30px;"
						placeholder="Identifiant" />
				</div>
				<span class="erreur">${erreurs['login']}</span> <label for="email">E-mail
					:</label><br />
				<div>
					<input type="email" value="<c:out value="${param.email}"/>"
						name="email" id="email" style="line-height: 40px; height: 30px;"
						placeholder="E-mail" />
				</div>
				<span class="erreur">${erreurs['email']}</span> <label
					for="password">Mot de passe :</label><br />
				<div>
					<input type="password" name="password" id="password"
						style="line-height: 40px; height: 30px;"
						placeholder="Mot de passe" />
				</div>
				<span class="erreur">${erreurs['password']}</span> <label
					for="password_verif">Confirmez votre mot de passe</label><br /> <input
					type="password" placeholder="Mot de passe" name="password_verif"
					id="password_verif" required /><br /> <label for="nom">Nom
					:</label><br />
				<div>
					<input type="text" value="<c:out value="${param.nom}"/>" name="nom"
						id="nom" style="line-height: 40px; height: 30px;"
						placeholder="Nom" />
				</div>
				<span class="erreur">${erreurs['nom']}</span> <label for="prenom">Prenom
					:</label><br />
				<div>
					<input type="text" value="<c:out value="${param.prenom}"/>"
						name="prenom" id="prenom" style="line-height: 40px; height: 30px;"
						placeholder="Prenom" />
				</div>
				<span class="erreur">${erreurs['prenom']}</span> <label
					for="telephone">Téléphone :</label><br /> <i>ex: 0625431475</i><br />
				<div>
					<input type="text" value="<c:out value="${param.telephone}"/>"
						name="telephone" id="telephone"
						style="line-height: 40px; height: 30px;"
						placeholder="N° de téléphone" />
				</div>
				<span class="erreur">${erreurs['telephone']}</span> <input
					type="hidden" name="connexion" value="1" />
				<div style="margin: auto;">
					<input class="submit"
						style="background-color: #ea3c3d; border: 1px solid white; color: white; padding-left: 15px; padding-right: 15px; height: 35px; line-height: 40px;"
						type="submit" value="S'inscrire" id="submit" />
				</div>
				
			</form>
		</div>
	</div>
</section>

<section class="wrapper3">
	<div class="width1000">
		<div style="text-align: center;">
			<div style="${empty erreurs ? 'color: green;' : 'color: red;'}">${resultat}</div>
		</div>
	</div>
</section>

<jsp:include page="footer.jsp" />