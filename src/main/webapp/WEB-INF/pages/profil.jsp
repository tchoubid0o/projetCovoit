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
									<td style="width: 25px;"><img class="editAds" src="img/edit.png" data-size="${propositions_size}" data-type="proposition" data-idP="${proposition.idAnnonceProposition}" data-villeD="${proposition.villeDepart}" data-villeA="${proposition.villeArrivee}" data-date="${proposition.dateEtHeureTrajet}" data-heure="${proposition.heure}" data-min="${proposition.minute}" data-commentaire="${proposition.commentaire}" data-prix="${proposition.prix}" data-nbPlace="${proposition.nbPlace}" style="cursor: pointer;" alt="Editer votre recherche" /></td>
									<td style="width: 25px;"><img class="deleteAds" src="img/delete.png" style="cursor: pointer;" alt="Supprimer votre recherche" /></td>
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
									<td style="width: 25px;"><img class="editAds" data-type="recherche" style="cursor: pointer;" src="img/edit.png" alt="Editer votre recherche" /></td>
									<td style="width: 25px;"><img class="deleteAds" style="cursor: pointer;" src="img/delete.png" alt="Supprimer votre recherche" /></td>
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

<section class="wrapper6" style="display:none;">
	<div class="width1000">
			<script>
			
			
			$(".editAds").click(function(){
				//Si l'on est pas connecté
				if($(this).attr("data-type") == "proposition"){
					$("#inputEtape").html("");
						$.ajax({ url:"etapes", type:"POST", 
							data:{id:$(this).attr("data-idP")}
						}).done(function (response){
							for(var i=0; i<response.length;i++){
								$("#inputEtape").append('<div id="dynamicInputPropM" class="columnheader2">Etape <span class="idCurrentEtape">'+(i+1)+'</span><br><input type="text" class="input_contact" name="etapesPropM" value="'+response[i].nomVille+'">');
							}
							
							$("#addEtapeProp").click(function(){
								var currentEtape = $(this).parent().children("#inputEtape").children("#dynamicInputPropM").last().children(".idCurrentEtape").text();
								$("#inputEtape").append('<div id="dynamicInputPropM" class="columnheader2">Etape <span class="idCurrentEtape">'+(parseInt(currentEtape)+1)+'</span><br><input type="text" class="input_contact" name="etapesPropM">');
							});
						});
					
						//On met les valeurs de l'image � modifier dans les div
						$("#idProp").attr("value", $(this).attr("data-idP"));
						$("#villeDepartPropM").attr("value", $(this).attr("data-villeD"));
						$("#villeArriveePropM").attr("value", $(this).attr("data-villeA"));
	
						$("#datePropM").attr("value", $(this).attr("data-date"));
						
						$("#heurePropM option[value='" +$(this).attr("data-heure") + "']").attr("selected", "selected");
						$("#minutePropM option[value='" +$(this).attr("data-min") + "']").attr("selected", "selected");
						
						$("#commentPropM").text($(this).attr("data-commentaire"));
						$("#prixPropM").attr("value", $(this).attr("data-prix"));
						$("#nbPlacePropM").attr("value", $(this).attr("data-nbPlace"));
						
						$(".wrapper6").slideDown("slow");
						$('html, body').animate({
		                    scrollTop: $(".wrapper6").offset().top
		                }, 2000);
					}
					else{
						//On delete l'image en ajax 
						
					}
				
				
			});
			
			</script>
			<div id="ancreModifyProp" style="margin-bottom: 5px;font-size: 32px;color: #7b7b7b;font-family: 'gill'; text-align: center; padding-top: 25px;">Modifier le trajet</div>
			<form action="profil" method="post">
			<div class="width500" style="float: left;">
				<div style="padding: 0px 100px 0px 100px;">
				<input type="hidden" name="idProp" id="idProp"/>
				<label for="villeDepart" class="columnheader2">Ville de départ :</label>
				<div>
					<input type="text" class="input_contact" name="villeDepartPropM" id="villeDepartPropM"
						style="line-height: 40px; height: 30px;"
						placeholder="Ville de Départ" />
				</div>

				<label for="villeArriveePropM" class="columnheader2">Ville d'arrivée :</label><br />
				<div>
					<input type="text" class="input_contact" name="villeArriveePropM" id="villeArriveePropM"
						style="line-height: 40px; height: 30px;"
						placeholder="ville d'Arrivée" />
				</div>
				<label for="date" class="columnheader2">Date :</label><br /> <input type="text"
					class="datepicker input_contact" name="datePropM" id="datePropM" required /><br /> <label class="columnheader2">Heure
					de départ :</label><br />
				<div>
					<select id="heurePropM" class="input_contact" style="width: auto;" name="heurePropM">
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
					</select> <span class="columnheader2"> h</span> <select id="minutePropM" class="input_contact" style="width: auto;" name="minutePropM">
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
				
					<div id="inputEtape">
					
					</div>
					<input type="button" id="addEtapeProp" class="submitContactForm" value="Ajouter une autre étape">
					
					<label for="prix" class="columnheader2">Prix par passager :</label><br />
				<div>
					<input type="text" class="input_contact" name="prixPropM" id="prixPropM"
						style="line-height: 40px; height: 30px;" placeholder="prix" />
				</div>
				<label for="nbPlace" class="columnheader2">Nombre de places :</label><br />
				<div>
					<input type="text" class="input_contact" name="nbPlacePropM" id="nbPlacePropM"
						style="line-height: 40px; height: 30px;" placeholder="Nb places" />
				</div>
				</div>
			</div>
				
				<div style="padding: 0px 100px 0px 100px;">
					<textarea placeholder="Commentaire" id="commentPropM" class="input_contact" name="commentPropM"></textarea>
				</div>
				<div style="margin: auto;text-align: center; padding-bottom: 50px;">
					<input class="submit submitContactForm" style="width: 250px;" type="submit" value="Modifier" id="submit" />
				</div>
				<input type="hidden" name="modifierProp" value="1" />
			</form>

	</div>
</section>

<jsp:include page="footer.jsp" />