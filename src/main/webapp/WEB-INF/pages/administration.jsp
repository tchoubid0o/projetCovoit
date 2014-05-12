<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section style="padding: 20px;">
	<c:if test="${listAnnonceRech == null}">
		<div class="width1000" style="margin: auto;text-align: center;">
			<span >
				Vous n'êtes pas administrateur
			</span>
		</div>
	</c:if>
	<c:if test="${listAnnonceRech != null}">
		<div class="width1000" style="margin: auto;text-align: center;">
			<span class="downTitle titleAbout" style="font-weight: bold;font-size: 36px;">
				Liste des utilisateurs du site web (<span class="nbS">${listUsers.size()}</span>)
			</span>					
			<img class="down" src="img/downarrow.png" alt="" />
						
			<div class="wrapProfil" style="display: none;">					
				<table  class="lastCars" style="text-align: center;">
					<tbody>	
						<tr style="color: black;">
							<td colspan="2">login</td>
							<td colspan="2">email</td>
							<td colspan="2">NOM</td>
							<td colspan="2">Prenom</td>
							<td colspan="2">Telephone</td>
							<td colspan="2">Date d'inscription</td>
						</tr>
						<c:forEach var="user" step="1" items="${listUsers}">
							<tr style="color: #666E74">
								<td colspan="2">${user.login}</td>
								<td colspan="2">${user.email}</td>
								<td colspan="2">${user.nom}</td>
								<td colspan="2">${user.prenom}</td>
								<td colspan="2">${user.telephone}</td>
								<td colspan="2">${user.registered}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>				
		</div>
		
		<div class="width1000" style="margin: auto;text-align: center;">
			<span class="downTitle titleAbout" style="font-weight: bold;font-size: 36px;">
				Liste des propositions d'annonce de covoiturage (<span class="nbS">${listAnnonceProp.size()}</span>)
			</span>					
			<img class="down" src="img/downarrow.png" alt="" />
						
			<div class="wrapProfil" style="display: none;">
				<table class="lastCars" style="text-align: center;">
					<tbody>
							<c:forEach var="annonceProp" step="1" items="${listAnnonceProp}">
								<tr>
									<td>${annonceProp.villeDepart}</td>
									<td><img src="img/rightarrow.png" alt=""></td>
									<td>${annonceProp.villeArrivee}</td>
									<td>${annonceProp.prix}€</td>
									<td>Nombre de places: ${annonceProp.nbPlace}</td>
									<td>${annonceProp.dateEtHeureTrajet} à
										${annonceProp.heure}h${annonceProp.minute}min</td>
									<td><img class="seeMore" data-type="offers" data-id="${annonceProp.idAnnonceProposition}" data-login="${annonceProp.login}" src="img/downarrow2.png" alt="" /></td>
									<td style="width: 25px;"><img class="deleteAds"
										src="img/delete.png" data-idP="${annonceProp.idAnnonceProposition}" data-type="proposition" style="cursor: pointer;"
										alt="Supprimer l'annonce" title="Supprimer l'annonce"/></td>
								</tr>
								<tr style="display: none;">
									<td colspan="1"></td>
									<td colspan="2">Commentaire: ${annonceProp.commentaire}</td>
									<td colspan="7" class="tdEtapes">Etapes: ${annonceProp.villeDepart}&nbsp;&nbsp;<img src="img/rightarrow.png" alt="">&nbsp;&nbsp;<span class="etapesMore${annonceProp.idAnnonceProposition}"></span>${annonceProp.villeArrivee}</td>	
								</tr>
								<tr style="display: none;">
									<td colspan="1"></td>
									<td colspan="2" class="userAddMore${annonceProp.idAnnonceProposition}"></td>
									<td colspan="7"></td>
								</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>			
		</div>
		
		<div class="width1000" style="margin: auto;text-align: center;">
			<span class="downTitle titleAbout" style="font-weight: bold;font-size: 36px;">
				Liste des recherches de covoiturage (<span class="nbS">${listAnnonceRech.size()}</span>)
			</span>					
			<img class="down" src="img/downarrow.png" alt="" />
						
			<div class="wrapProfil" style="display: none;">
				<table class="lastCars" style="text-align: center;">
					<tbody>
							<c:forEach var="annonceRech" step="1" items="${listAnnonceRech}">
								<tr>
									<td>${annonceRech.villeDepartRecherche}</td>
									<td><img src="img/rightarrow.png" alt=""></td>
									<td>${annonceRech.villeArriveeRecherche}</td>
									<td>${annonceRech.dateEtHeureRecherche} à
										${annonceRech.heure}h${annonceRech.minute}min</td>
									<td><img class="seeMore" data-type="searchCovoit" data-id="${annonceRech.idAnnonceRecherche}" data-login="${annonceRech.login}" src="img/downarrow2.png" alt="" /></td>
									<td style="width: 25px;"><img class="deleteAds"
										style="cursor: pointer;" data-idP="${annonceRech.idAnnonceRecherche}" data-type="recherche" src="img/delete.png"
										alt="Supprimer la recherche" title="Supprimer la recherche"/></td>
								</tr>									
								<tr style="display: none;">
									<td colspan="1"></td>
									<td colspan="2">Annonce déposée par: <span class="userAddMore${annonceRech.idAnnonceRecherche}"></span></td>
									<td colspan="6">Commentaire: ${annonceRech.commentaireRecherche}</td>	
								</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>			
		</div>
	</c:if>
</section>

<script>				
				$(".seeMore").click(function(event){

					var type= $(this).attr("data-type");
					var id = $(this).attr("data-id");
					var login = $(this).attr("data-login");					
					
					event.preventDefault();
					if(type == "offers"){
						$.ajax({ dataType: "json",url:"etapes", type:"POST", 
	        				data: "type="+type+"&seeMoreInfos=1&id="+id
	        			}).done(function(data){
	        				var etapesTemp = "";
	        				for (var i = 0; i < data.length; ++i) {
	        					etapesTemp += ""+data[i].nomVille+"&nbsp;&nbsp;<img src='img/rightarrow.png' alt=''>&nbsp;&nbsp;";
	        				}
	        				$(".etapesMore"+id).html(etapesTemp);
	        			});
					}
					
					$.ajax({ dataType: "json",url:"getuser", type:"POST", 
        				data: "login="+login+"&seeMoreInfos=1"
        			}).done(function(data){
        				$(".userAddMore"+id).html(""+data.prenom+" "+data.nom[0]+".");
        			});
					
					if($(this).parent().parent().next("tr").css('display') != 'none'){
						$(this).parent().parent().next("tr").hide();
						if(type == "offers"){
							$(this).parent().parent().next("tr").next("tr").hide();
						}
						$(this).attr("src", "img/downarrow2.png");
					}
					else{
						$(this).parent().parent().next("tr").show();
						if(type == "offers"){
							$(this).parent().parent().next("tr").next("tr").slideDown();
						}
						$(this).attr("src", "img/uparrow2.png");
					}
				});
</script>
<script>
	$(".deleteAds").click(function(){
		$(this).parent().parent().hide();
		$(this).parent().parent().next().hide();
		
		if($(this).attr("data-type") == "proposition"){
			$(this).parent().parent().next().next().hide();
		}
		
		var nbS = parseInt($(this).parent().parent().parent().parent().parent().parent().children(".titleAbout").children(".nbS").text());
		var nbSafter = nbS - 1;
		$(this).parent().parent().parent().parent().parent().parent().children(".titleAbout").children(".nbS").html(nbSafter);
		$.ajax({url : "profil",
			type : "POST",
			data : {deleteAds : 1, type : $(this).attr("data-type"), id : $(this).attr("data-idP")}
		});
	});
</script>

<jsp:include page="footer.jsp" />
