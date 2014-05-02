<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc" style="padding: 20px;">
	<div class="width1000">
		<div style="text-align: center;">
			<span class="titleAbout">Profil</span>
			<form action="inscription" method="post">
				<label for="login">Identifiant :</label><br />
				<div>
					<input type="text" value="<c:out value="${user.login}"/>"
						name="login" id="login" style="line-height: 40px; height: 30px;"
						disabled />
				</div>
				<label for="email">E-mail:</label><br />
				<div>
					<input type="email" value="<c:out value="${user.email}"/>"
						name="email" id="email" style="line-height: 40px; height: 30px;"
						disabled />
				</div>
				<label for="password">Mot de passe :</label><br />
				<div>
					<input type="password" name="password" id="password"
						style="line-height: 40px; height: 30px;"
						placeholder="Mot de passe" />
				</div>
				<label for="password_verif">Confirmez votre mot de passe</label><br />
				<input type="password" placeholder="Mot de passe"
					name="password_verif" id="password_verif" required /><br /> <label
					for="nom">Nom:</label><br />
				<div>
					<input type="text" value="<c:out value="${user.nom}"/>" name="nom"
						id="nom" style="line-height: 40px; height: 30px;" disabled />
				</div>
				<label for="prenom">Prenom :</label><br />
				<div>
					<input type="text" value="<c:out value="${user.prenom}"/>"
						name="prenom" id="prenom" style="line-height: 40px; height: 30px;"
						disabled />
				</div>
				<label for="telephone">Téléphone :</label><br /> <i>ex:
					0625431475</i><br />
				<div>
					<input type="text" value="<c:out value="${user.telephone}"/>"
						name="telephone" id="telephone"
						style="line-height: 40px; height: 30px;" disabled />
				</div>
				<input type="hidden" name="connexion" value="1" />
				<div style="margin: auto;">
					<!--  
					<input class="submit"
						style="background-color: #ea3c3d; border: 1px solid white; color: white; padding-left: 15px; padding-right: 15px; height: 35px; line-height: 40px;"
						type="submit" value="S'inscrire" id="submit" />-->
				</div>

			</form>

			<div id="myOffer" style="margin-top: 10px;">
				<span class="titleAbout">Mes offres de Covoiturage
					<c:if test="${propositions_size > 0 }">
						(${propositions_size})
					</c:if>
					<c:if test="${propositions_size == 0}"> 
						(0)
					</c:if>
				</span>
				<c:if test="${propositions_size > 0 }">
				<img class="down" src="img/downarrow.png" alt="" />
				</c:if>
				<div class="wrapProfil" style="display: none;">
					<table class="lastCars" style="text-align: center;">
						<tbody>
							<c:forEach var="proposition" begin="0" end="${propositions_size}"
								step="1" items="${propositions}">
								<tr>
									<td><img src="img/car.png" alt="" /></td>
									<td>${proposition.villeDepart}</td>
									<td><img src="img/rightarrow.png" alt=""></td>
									<td>${proposition.villeArrivee}</td>
									<td>${proposition.prix}€</td>
									<td>Nombre de places: ${proposition.nbPlace}</td>
									<td>${proposition.dateEtHeureTrajet}à
										${proposition.heure}h${proposition.minute}min</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
					<c:if test="${propositions_size == 0 }">
						<div class="lastCars center">Vous n'avez encore poster aucune
							offre</div>
					</c:if>
			</div>
			
			<div id="mySearch" style="margin-top: 10px;">
				<span class="titleAbout">Mes recherches
					<c:if test="${recherches_size > 0 }">
						(${recherches_size})
					</c:if>
					<c:if test="${recherches_size == 0}"> 
						(0)
					</c:if>
				</span>
				<c:if test="${recherches_size > 0 }">
				<img class="down" src="img/downarrow.png" alt="" />
				</c:if>
				<div class="wrapProfil" style="display: none;">
					<table class="lastCars" style="text-align: center;">
						<tbody>
							<c:forEach var="recherche" begin="0" end="${recherches_size}"
								step="1" items="${recherches}">
								<tr>
									<td><img src="img/passenger.png" alt="" /></td>
									<td>${recherche.villeDepartRecherche}</td>
									<td><img src="img/rightarrow.png" alt=""></td>
									<td>${recherche.villeArriveeRecherche}</td>
									<td>${recherche.dateEtHeureRecherche} à ${recherche.heure}h${recherche.minute}min</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
					<c:if test="${recherches_size == 0 }">
						<div class="lastCars center">Vous n'avez encore poster aucune
							recherche</div>
					</c:if>
					
				
			</div>
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