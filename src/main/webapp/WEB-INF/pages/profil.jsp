<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />
${villes}
<section class="wrapper3" id="wrapperInsc" style="padding: 20px;">
	<div class="width1000">
		<div style="text-align: center;">
			<div id="myOffer" style="margin-top: 10px;">
				<span class="downTitle titleAbout">Mes offres de Covoiturage <c:if
						test="${propositions_size > 0 }">
						(<span class="nbS">${propositions_size}</span>)
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
									<td>${proposition.dateEtHeureTrajet} à
										${proposition.heure}h${proposition.minute}min</td>
									<td><img class="seeMore" data-type="offers" data-id="${proposition.idAnnonceProposition}" data-login="${proposition.login}" src="img/downarrow2.png" alt="" /></td>
									<td style="width: 25px;"><img class="editAds"
										src="img/edit.png" data-size="${propositions_size}"
										data-type="proposition"
										data-idP="${proposition.idAnnonceProposition}"
										data-villeD="${proposition.villeDepart}"
										data-villeA="${proposition.villeArrivee}"
										data-date="${proposition.dateEtHeureTrajet}"
										data-heure="${proposition.heure}"
										data-min="${proposition.minute}"
										data-commentaire="${proposition.commentaire}"
										data-prix="${proposition.prix}"
										data-nbPlace="${proposition.nbPlace}" style="cursor: pointer;"
										alt="Editer votre recherche" /></td>
									<td style="width: 25px;"><img class="deleteAds"
										src="img/delete.png" data-idP="${proposition.idAnnonceProposition}" data-type="proposition" style="cursor: pointer;"
										alt="Supprimer votre recherche" /></td>
								</tr>
								<tr style="display: none;">
									<td colspan="1"></td>
									<td colspan="2">Commentaire: ${proposition.commentaire}</td>
									<td colspan="7" class="tdEtapes">Etapes: ${proposition.villeDepart}&nbsp;&nbsp;<img src="img/rightarrow.png" alt="">&nbsp;&nbsp;<span class="etapesMore${proposition.idAnnonceProposition}"></span>${proposition.villeArrivee}</td>	
								</tr>
								<tr style="display: none;">
									<td colspan="1"></td>
									<td colspan="2" class="userAddMore${proposition.idAnnonceProposition}"></td>
									<td colspan="7"></td>
								</tr>	
								
								<c:if test='${proposition.listePersonneAccepteeDansCovoit != null }'>	
									<c:forEach var="accepteDansCovoit" items="${proposition.listePersonneAccepteeDansCovoit}">
										<tr style="display: none;" class="souhaiteEtreOuAccepteDansCovoit${proposition.idAnnonceProposition}">
											<td colspan="4"></td>
											<td colspan="2" >${accepteDansCovoit.prenom} ${accepteDansCovoit.nom.substring(0,1)}.</td>
											<td colspan="1"></td>
											<td style="width: 25px;"><img class="personneDansCovoit"
												style="cursor: pointer;" data-loginDesirEtreDansCovoit="${accepteDansCovoit.login}" data-idAP="${proposition.idAnnonceProposition}" data-typeDemande="voirDetail" src="img/lookAt.png"
												alt="Voir les details de la personne" title="Regarder les details de ${accepteDansCovoit.prenom} ${accepteDansCovoit.nom.substring(0,1)}." /></td>												
										</tr>
									</c:forEach>
								</c:if>
								
								<c:if test='${proposition.listePersonneSouhaitantParticiperCovoit != null }'>	
									<c:forEach var="demandePourEtreDansCovoit" items="${proposition.listePersonneSouhaitantParticiperCovoit}">
										<tr style="display: none;" class="souhaiteEtreOuAccepteDansCovoit${proposition.idAnnonceProposition}">
											<td colspan="4"></td>
											<td colspan="2" >${demandePourEtreDansCovoit.prenom} ${demandePourEtreDansCovoit.nom.substring(0,1)}.</td>
											<td colspan="1"></td>
											<td style="width: 25px;"><img class="personneDansCovoit"
												style="cursor: pointer;" data-loginDesirEtreDansCovoit="${demandePourEtreDansCovoit.login}" data-idAP="${proposition.idAnnonceProposition}" data-typeDemande="voirDetail" src="img/lookAt.png"
												alt="Voir les details de la personne" title="Regarder les details de ${demandePourEtreDansCovoit.prenom} ${demandePourEtreDansCovoit.nom.substring(0,1)}." /></td>
											<td style="width: 25px;"><img class="personneDansCovoit"
												style="cursor: pointer;" data-loginDesirEtreDansCovoit="${demandePourEtreDansCovoit.login}" data-idAP="${proposition.idAnnonceProposition}" data-typeDemande="accepterDansCovoit" src="img/check.png"
												alt="Ajouter cette personne au covoiturage" title="Ajouter ${demandePourEtreDansCovoit.prenom} ${demandePourEtreDansCovoit.nom.substring(0,1)}. au covoiturage" /></td>
											<td style="width: 25px;"><img class="personneDansCovoit"
												style="cursor: pointer;" data-loginDesirEtreDansCovoit="${demandePourEtreDansCovoit.login}" data-idAP="${proposition.idAnnonceProposition}" data-typeDemande="refusePourCovoit" src="img/delete.png"
												alt="Refuser cette personne pour le covoiturage" title="Refuser ${demandePourEtreDansCovoit.prenom} ${demandePourEtreDansCovoit.nom.substring(0,1)}. pour le covoiturage" /></td>												
										</tr>
									</c:forEach>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
					<div id="messageAjax"></div>
				</div>
				<c:if test="${propositions_size == 0 }">
					<div class="lastCars center">Vous n'avez encore poster aucune
						offre</div>
				</c:if>
			</div>
			<script>				
				$(".seeMore").click(function(event){

					var type= $(this).attr("data-type");
					var id = $(this).attr("data-id");
					var login = $(this).attr("data-login");
					
					if($(this).parent().parent().next("tr").css('display') != 'none'){
						$(this).parent().parent().next("tr").hide();
						$(this).parent().parent().next("tr").next("tr").hide();
						$(this).parent().parent().next("tr").next("tr").next("tr").hide();
						$(this).parent().parent().nextAll(".souhaiteEtreOuAccepteDansCovoit"+id).hide();
						$(this).attr("src", "img/downarrow2.png");
					}
					else{
						$(this).parent().parent().next("tr").show();
						$(this).parent().parent().next("tr").next("tr").show();
						$(this).parent().parent().next("tr").next("tr").next("tr").show();
						$(this).parent().parent().nextAll(".souhaiteEtreOuAccepteDansCovoit"+id).show();
						$(this).attr("src", "img/uparrow2.png");
					}
					
					
					event.preventDefault();
					$.ajax({ dataType: "json",url:"etapes", type:"POST", 
        				data: "type="+type+"&seeMoreInfos=1&id="+id
        			}).done(function(data){
        				var etapesTemp = "";
        				for (var i = 0; i < data.length; ++i) {
        					etapesTemp += ""+data[i].nomVille+"&nbsp;&nbsp;<img src='img/rightarrow.png' alt=''>&nbsp;&nbsp;";
        				}
        				$(".etapesMore"+id).html(etapesTemp);
        			});
					
					$.ajax({ dataType: "json",url:"getuser", type:"POST", 
        				data: "login="+login+"&seeMoreInfos=1"
        			}).done(function(data){
        				$(".userAddMore"+id).html("- "+data.prenom+" "+data.nom[0]+". -");
        			});
				});
			</script>
			<script>				
				$(".personneDansCovoit").click(function(event){

					var typeDemande= $(this).attr("data-typeDemande");
					var idAP = $(this).attr("data-idAP");
					var loginDesirEtreDansCovoit = $(this).attr("data-loginDesirEtreDansCovoit");	
					var nbPlaceSuffisant = false;
					
					event.preventDefault();
					
					$.post("ajaxreserver",{ 
						typeDemande : typeDemande,
						loginDesirEtreDansCovoit : loginDesirEtreDansCovoit,
						idAP : idAP
        			}, 'json').done(function(data){
        				
        				if(data[0]){
        					nbPlaceSuffisant = true;
        				}
        			});
					
					if(typeDemande == "accepterDansCovoit" && nbPlaceSuffisant){

        				$(this).parent().next("td").remove();
        				$(this).parent().remove();     
    				}     
					else if(typeDemande == "refusePourCovoit"){
						
						$(this).parent().parent().remove();
					}
				});
			</script>

			<div id="mySearch" style="margin-top: 10px;">
				<span class="downTitle titleAbout">Mes recherches <c:if
						test="${recherches_size > 0 }">
						(<span class="nbS">${recherches_size}</span>)
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
									<td>${recherche.dateEtHeureRecherche} à
										${recherche.heure}h${recherche.minute}min</td>
									<td style="width: 25px;"><img class="editAds"
										data-size="${recherches_size}" data-type="recherche"
										data-idR="${recherche.idAnnonceRecherche}"
										data-villeD="${recherche.villeDepartRecherche}"
										data-villeA="${recherche.villeArriveeRecherche}"
										data-date="${recherche.dateEtHeureRecherche}"
										data-heure="${recherche.heure}" data-min="${recherche.minute}"
										data-commentaire="${recherche.commentaireRecherche}"
										style="cursor: pointer;" src="img/edit.png"
										alt="Editer votre recherche" /></td>
									<td style="width: 25px;"><img class="deleteAds"
										style="cursor: pointer;" data-idP="${recherche.idAnnonceRecherche}" data-type="recherche" src="img/delete.png"
										alt="Supprimer votre recherche" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="messageAjax"></div>
				</div>
				<c:if test="${recherches_size == 0 }">
					<div class="lastCars center">Vous n'avez encore poster aucune
						recherche</div>
				</c:if>

			</div>
		</div>
	</div>
</section>

<!-- DIV CACHEE -->

<section class="wrapper6 divModif" style="display: none;">
	<div class="width1000">

		<div id="ancreModifyProp"
			style="margin-bottom: 5px; font-size: 32px; color: #7b7b7b; font-family: 'gill'; text-align: center; padding-top: 25px;">Modifier
			le trajet</div>
		<form action="profil" method="post">
			<div class="width500" style="float: left;">
				<div style="padding: 0px 100px 0px 100px;">
					<input type="hidden" name="idProp" id="idProp" /> <label
						for="villeDepart" class="columnheader2">Ville de départ :</label>
					<div>
						<input type="text" class="input_contact villeInput" name="villeDepartPropM"
							id="villeDepartPropM" style="line-height: 40px; height: 30px;"
							placeholder="Ville de Départ" />
					</div>

					<label for="villeArriveePropM" class="columnheader2">Ville
						d'arrivée :</label><br />
					<div>
						<input type="text" class="input_contact villeInput" name="villeArriveePropM"
							id="villeArriveePropM" style="line-height: 40px; height: 30px;"
							placeholder="ville d'Arrivée" />
					</div>
					<label for="date" class="columnheader2">Date :</label><br /> <input
						type="text" class="datepicker input_contact" name="datePropM"
						id="datePropM" required /><br /> <label class="columnheader2">Heure
						de départ :</label><br />
					<div>
						<select id="heurePropM" class="input_contact" style="width: auto;"
							name="heurePropM">
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
						</select> <span class="columnheader2"> h</span> <select id="minutePropM"
							class="input_contact" style="width: auto;" name="minutePropM">
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
					<label for="etapes" class="columnheader2">Etapes
						éventuelles :</label><br />

					<div id="inputEtape"></div>
					<input type="button" id="addEtapeProp" class="submitContactForm"
						value="Ajouter une autre étape"> <label for="prix"
						class="columnheader2">Prix par passager :</label><br />
					<div>
						<input type="text" class="input_contact" name="prixPropM"
							id="prixPropM" style="line-height: 40px; height: 30px;"
							placeholder="prix" />
					</div>
					<label for="nbPlace" class="columnheader2">Nombre de places
						:</label><br />
					<div>
						<input type="text" class="input_contact" name="nbPlacePropM"
							id="nbPlacePropM" style="line-height: 40px; height: 30px;"
							placeholder="Nb places" />
					</div>
				</div>
			</div>

			<div style="padding: 0px 100px 0px 100px;">
				<textarea placeholder="Commentaire" id="commentPropM"
					class="input_contact" name="commentPropM"></textarea>
			</div>
			<div style="margin: auto; text-align: center; padding-bottom: 50px;">
				<input class="submit submitContactForm" style="width: 250px;"
					type="submit" value="Modifier" id="submit" />
			</div>
			<input type="hidden" name="modifierProp" value="1" />
		</form>

	</div>
</section>

<section class="wrapper6 divModifRech" style="display: none;">
	<div class="width1000">

		<div id="ancreModifyRech"
			style="margin-bottom: 5px; font-size: 32px; color: #7b7b7b; font-family: 'gill'; text-align: center; padding-top: 25px;">Modifier
			la recherche</div>
		<form action="profil" method="post">
			<div class="width500" style="float: left;">
				<div style="padding: 0px 100px 0px 100px;">
					<input type="hidden" name="idRech" id="idRech" /> <label
						for="villeDepart" class="columnheader2">Ville de départ :</label>
					<div>
						<input type="text" class="input_contact villeInput" name="villeDepartRechM"
							id="villeDepartRechM" style="line-height: 40px; height: 30px;"
							placeholder="Ville de Départ" />
					</div>

					<label for="villeArriveeRechM" class="columnheader2">Ville
						d'arrivée :</label><br />
					<div>
						<input type="text" class="input_contact villeInput" name="villeArriveeRechM"
							id="villeArriveeRechM" style="line-height: 40px; height: 30px;"
							placeholder="ville d'Arrivée" />
					</div>
				</div>
			</div>
			<div class="width500" style="margin-left: 500px;">
				<div style="padding: 0px 100px 0px 100px;">
					<label for="date" class="columnheader2">Date :</label><br /> <input
						type="text" class="datepicker input_contact" name="dateRechM"
						id="dateRechM" required /><br /> <label class="columnheader2">Heure
						de départ :</label><br />
					<div>
						<select id="heureRechM" class="input_contact" style="width: auto;"
							name="heureRechM">
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
						</select> <span class="columnheader2"> h</span> <select id="minuteRechM"
							class="input_contact" style="width: auto;" name="minuteRechM">
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

			<div style="padding: 0px 100px 0px 100px;">
				<textarea placeholder="Commentaire" id="commentRechM"
					class="input_contact" name="commentRechM"></textarea>
			</div>
			<div style="margin: auto; text-align: center; padding-bottom: 50px;">
				<input class="submit submitContactForm" style="width: 250px;"
					type="submit" value="Modifier" id="submit" />
			</div>
			<input type="hidden" name="modifierRech" value="1" />
		</form>

	</div>
</section>

<script>
$(".editAds").click(function() {
	//Si l'on est pas connecté
	if ($(this).attr("data-type") == "proposition") {
			$(".divModifRech").slideUp("slow");
			$("#inputEtape").html("");
			$.ajax({url : "etapes",
					type : "POST",
					data : {id : $(this).attr("data-idP")}
			}).done(function(response) {
					var currentEtape = response.length;
					for (var i = 0; i < response.length; i++) {
						$("#inputEtape").append('<div id="dynamicInputPropM'+(i+1)+'" class="columnheader2">Etape <span class="idCurrentEtape">'	+ (i + 1)+ '</span><br><input type="text" class="input_contact villeInput" name="etapesPropM" id="villeEtape'+ (i+1) +'" value="'+response[i].nomVille+'">');
					}
					for(var a = response.length; a <15; a++){
						$("#inputEtape").append('<div id="dynamicInputPropM'+(a+1)+'" class="columnheader2" style="display: none;">Etape <span class="idCurrentEtape">'	+ (a + 1)+ '</span><br><input type="text" class="input_contact villeInput" name="etapesPropM" id="villeEtape'+ (a+1) +'" >');
					}

					$("#addEtapeProp").click(function() {
						$("#inputEtape").children("#dynamicInputPropM"+(currentEtape+1)).show();
						currentEtape++;
					});
			});

			//On met les valeurs de l'image � modifier dans les div
			$("#idProp").attr("value", $(this).attr("data-idP"));
			$("#villeDepartPropM").attr("value",$(this).attr("data-villeD"));
			$("#villeArriveePropM").attr("value",$(this).attr("data-villeA"));
			$("#datePropM").attr("value",$(this).attr("data-date"));

			$("#heurePropM option[value='"+ $(this).attr("data-heure") + "']").attr("selected", "selected");
			$("#minutePropM option[value='"+ $(this).attr("data-min") + "']").attr("selected", "selected");

			$("#commentPropM").text($(this).attr("data-commentaire"));
			$("#prixPropM").attr("value",$(this).attr("data-prix"));
			$("#nbPlacePropM").attr("value",$(this).attr("data-nbPlace"));

			$(".divModif").slideDown("slow");
			$('html, body').animate({
				scrollTop : $(".wrapper6").offset().top
			}, 2000);
	}
	if ($(this).attr("data-type") == "recherche") {
		$(".divModif").slideUp("slow");
		//On met les valeurs de l'image � modifier dans les div
		$("#idRech").attr("value", $(this).attr("data-idR"));
		$("#villeDepartRechM").attr("value",$(this).attr("data-villeD"));
		$("#villeArriveeRechM").attr("value",$(this).attr("data-villeA"));
		$("#dateRechM").attr("value",$(this).attr("data-date"));

		$("#heureRechM option[value='"+ $(this).attr("data-heure") + "']").attr("selected", "selected");
		$("#minuteRechM option[value='"+ $(this).attr("data-min") + "']").attr("selected", "selected");

		$("#commentRechM").text($(this).attr("data-commentaire"));

		$(".divModifRech").slideDown("slow");
		$('html, body').animate({
			scrollTop : $(".wrapper6 divModifRech").offset().top
		}, 2000);
	}

});

$(".deleteAds").click(function(){
	$(this).parent().parent().hide();
	var nbS = parseInt($(this).parent().parent().parent().parent().parent().parent().children(".titleAbout").children(".nbS").text());
	var nbSafter = nbS - 1;
	$(this).parent().parent().parent().parent().parent().parent().children(".titleAbout").children(".nbS").html(nbSafter);
	$(this).parent().parent().parent().parent().parent().children("#messageAjax").html('<span class="red">L\'annonce a correctement été supprimée.</span>');
	$.ajax({url : "profil",
		type : "POST",
		data : {deleteAds : 1, type : $(this).attr("data-type"), id : $(this).attr("data-idP")}
	});
});

</script>

<section class="wrapper6" style="border-top: 1px solid #7b7b7b;">
	
	<div class="width1000" style="text-align: center;">
		<img src="img/settings.png" style="margin-right: 8px;" alt=""/><span class="downTitleSettings" style="margin-bottom: 5px;font-size: 32px;color: #7b7b7b;font-family: 'gill';text-align: center;padding-top: 25px;">Réglages </span><img id="downSettings" src="img/downarrow2.png" alt="" />
			<script>
				$("#downSettings").click(function(){
					if($("#wrap_settings").css('display') != 'none'){
						$("#wrap_settings").slideUp();
						$(this).attr("src", "img/downarrow2.png");
					}
					else{
						$("#wrap_settings").slideDown();
						$(this).attr("src", "img/uparrow2.png");
					}
				});
				
				$(".downTitleSettings").click(function(){
					if($("#wrap_settings").css('display') != 'none'){
						$("#wrap_settings").slideUp();
						$(this).next().attr("src", "img/downarrow2.png");
					}
					else{
						$("#wrap_settings").slideDown();
						$(this).next().attr("src", "img/uparrow2.png");
					}
				});
			</script>
			<div id="wrap_settings" style="display: none;padding-top: 15px; border-top: 1px dashed #7b7b7b;">
				<form action="inscription" method="post" style="width: 400px; margin: auto;">
					<label for="login" class="columnheader2">Identifiant :</label><br />
					<div>
						<input type="text" value="<c:out value="${user.login}"/>" name="login" id="login" class="input_contact" style="line-height: 40px; height: 30px; background-color: #121212;" disabled />
					</div>
					<label for="email" class="columnheader2">E-mail:</label><br />
					<div>
						<input type="email" value="<c:out value="${user.email}"/>" name="email" id="email"  class="input_contact" style="line-height: 40px; height: 30px;background-color: #121212;"	disabled />
					</div>
					<label for="password" class="columnheader2">Mot de passe :</label><br />
					<div>
						<input type="password" name="password" id="password" style="line-height: 40px; height: 30px;" class="input_contact" placeholder="Mot de passe" />
					</div>
					<label for="password_verif" class="columnheader2">Confirmez votre mot de passe</label><br />
					<input type="password" placeholder="Mot de passe" name="password_verif" class="input_contact" id="password_verif" required /><br /> 
					
					<label for="nom" class="columnheader2">Nom:</label><br />
					<div>
						<input type="text" value="<c:out value="${user.nom}"/>" name="nom" id="nom" style="line-height: 40px; height: 30px;background-color: #121212;" class="input_contact" disabled />
					</div>
					<label for="prenom" class="columnheader2">Prenom :</label><br />
					<div>
						<input type="text" value="<c:out value="${user.prenom}"/>" name="prenom" id="prenom" style="line-height: 40px; height: 30px;background-color: #121212;" class="input_contact"	disabled />
					</div>
					<label for="telephone" class="columnheader2">Téléphone :</label><br /> <i class="columnheader2">ex:
						0625431475</i><br />
					<div>
						<input type="text" value="<c:out value="${user.telephone}"/>" name="telephone" id="telephone" style="line-height: 40px; height: 30px;background-color: #121212;" class="input_contact" disabled />
					</div>
					<input type="hidden" name="connexion" value="1" />
					<div style="margin: auto;">
						<!--  
						<input class="submit"
							style="background-color: #ea3c3d; border: 1px solid white; color: white; padding-left: 15px; padding-right: 15px; height: 35px; line-height: 40px;"
							type="submit" value="S'inscrire" id="submit" />-->
				</div>
	
			</form>
		</div>
	</div>
</section>

<jsp:include page="footer.jsp" />
