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
				<span class="titleAbout">Mes offres de Covoiturage <c:if
						test="${propositions_size > 0 }">
						(${propositions_size})
					</c:if> <c:if test="${propositions_size == 0}"> 
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
									<td style="width: 25px;"><form method="post" action="edit">
											<input type="hidden" name="idProposition"
												value="${recherche.idAnnonceProposition}" /><input
												type="hidden" name="editProposition" /><input type="submit"
												style="background: url('img/edit.png'); height: 20px; width: 20px; border: none; font-size: 0.1px; cursor: pointer;" />
										</form></td>
									<td style="width: 25px;"><form method="post"
											action="delete">
											<input type="hidden" name="idProposition"
												value="${recherche.idAnnonceProposition}" /><input
												type="hidden" name="deleteProposition" /><input
												type="submit"
												style="background: url('img/delete.png'); height: 20px; width: 20px; border: none; font-size: 0.1px; cursor: pointer;" />
										</form></td>
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
				<span class="titleAbout">Mes recherches <c:if
						test="${recherches_size > 0 }">
						(${recherches_size})
					</c:if> <c:if test="${recherches_size == 0}"> 
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
									<td>${recherche.dateEtHeureRecherche}à
										${recherche.heure}h${recherche.minute}min</td>
									<td style="width: 25px;"><form method="post" action="edit">
											<input type="hidden" name="idRecherche"
												value="${recherche.idAnnonceRecherche}" /><input
												type="hidden" name="editRecherche" /><input type="submit"
												style="background: url('img/edit.png'); height: 20px; width: 20px; border: none; font-size: 0.1px; cursor: pointer;" />
										</form></td>
									<td style="width: 25px;"><form method="post"
											action="delete">
											<input type="hidden" name="idRecherche"
												value="${recherche.idAnnonceRecherche}" /><input
												type="hidden" name="deleteRecherche" /><input type="submit"
												style="background: url('img/delete.png'); height: 20px; width: 20px; border: none; font-size: 0.1px; cursor: pointer;" />
										</form></td>
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

<section class="wrapper6">
	<div class="width1000">
		
			<span class="titleAbout">Modifier le trajet</span>
			<form action="proposer" method="post">
			<div class="width500" style="float: left;">
				<div style="padding: 0px 100px 0px 100px;">
				<label for="villeDepart" class="columnheader2">Ville de départ :</label>
				<div>
					<input type="text" class="input_contact" name="villeDepart" id="villeDepart"
						style="line-height: 40px; height: 30px;"
						placeholder="Ville de Départ" />
				</div>

				<label for="villeArrivee" class="columnheader2">Ville d'arrivée :</label><br />
				<div>
					<input type="text" class="input_contact" name="villeArrivee" id="villeArrivee"
						style="line-height: 40px; height: 30px;"
						placeholder="ville d'Arrivée" />
				</div>
				<label for="date" class="columnheader2">Date :</label><br /> <input type="text"
					class="datepicker input_contact" name="date" id="date" required /><br /> <label class="columnheader2">Heure
					de départ :</label><br />
				<div>
					<select id="heure" class="input_contact" style="width: auto;" name="heure">
						<option value="00">00</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<c:forEach var="j" begin="10" end="23">
							<option value="<c:out value="${j}"/>"><c:out
									value="${j}" /></option>
						</c:forEach>
					</select> <span class="columnheader2"> h</span> <select id="minute" class="input_contact" style="width: auto;" name="minute">
						<option value="00">00</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<c:forEach var="i" begin="10" end="59">
							<option value="<c:out value="${i}"/>"><c:out
									value="${i}" /></option>
						</c:forEach>
					</select> <span class="columnheader2"> min</span>
				</div>
				</div>
			</div>
			<div class="width500" style="margin-left: 500px;">
				<div style="padding: 0px 100px 0px 100px;">
				<label for="etapes" class="columnheader2">Etapes éventuelles :</label><br />
				
					<div id="dynamicInput" class="columnheader2">
						Etape 1<br>
						<input type="text" class="input_contact" name="etapes">
					</div>
					<input type="button" class="submitContactForm" value="Ajouter une autre étape"
						
						onClick="addInput('dynamicInput');">
					<script>
						var counter = 1;
						var limit = 15;
						function addInput(divName) {
							if (counter == limit) {
								alert("Vous avez atteint la limite des "
										+ counter + " étapes possibles.");
							} else {
								var newdiv = document.createElement('div');
								newdiv.innerHTML = "Etape "
										+ (counter + 1)
										+ " <br><input type='text' name='etapes'>";
								document.getElementById(divName).appendChild(
										newdiv);
								counter++;
							}
						}
					</script>
					<label for="prix" class="columnheader2">Prix par passager :</label><br />
				<div>
					<input type="text" class="input_contact" name="prix" id="prix"
						style="line-height: 40px; height: 30px;" placeholder="prix" />
				</div>
				<label for="nbPlace" class="columnheader2">Nombre de places :</label><br />
				<div>
					<input type="text" class="input_contact" name="nbPlace" id="nbPlace"
						style="line-height: 40px; height: 30px;" placeholder="Nb places" />
				</div>
				</div>
			</div>
				
				<div style="padding: 0px 100px 0px 100px;">
					<textarea placeholder="Commentaire" class="input_contact" name="comment"></textarea>
				</div>
				<div style="margin: auto;text-align: center; padding-bottom: 50px;">
					<input class="submit submitContactForm" style="width: 250px;" type="submit" value="Modifier" id="submit" />
				</div>

			</form>

	</div>
</section>

<jsp:include page="footer.jsp" />