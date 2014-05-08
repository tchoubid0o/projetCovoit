<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp" />

<section class="wrapper3" id="wrapperInsc">
	<div class="width1000">
		
		<!-- Trouver un conducteur -->
	
		<div style="text-align: center;">
			<span class="titleAbout">Trouver un trajet</span>
		</div>

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
							<td>${proposition.dateEtHeureTrajet.substring(8, 10)}/${proposition.dateEtHeureTrajet.substring(5, 7)}/${proposition.dateEtHeureTrajet.substring(0, 4)} à ${proposition.heure}h${proposition.minute}min</td>
							<td><img class="seeMore" data-type="offers" data-id="${proposition.idAnnonceProposition}" data-login="${proposition.login}" src="img/downarrow2.png" alt="" /></td>
							<td>
								<form method="post" action="reserver" class="reservation_form">
									<input type="hidden" name="idAnnonceProposition" value="${proposition.idAnnonceProposition}" />
									<input type="hidden" name="reserverForm" value="1" />
									<input type="submit" value="Réserver" class="submitContactForm" style="margin-bottom: 10px; height: auto; border: none; width: 100px;" />
								</form>
								<div class="resultReserv" style="display: none;"></div>
							</td>
						</tr>
						<tr style="display: none;">
							<td colspan="1"></td>
							<td colspan="2">Commentaire: ${proposition.commentaire}</td>
							<td colspan="6" class="tdEtapes">Etapes: ${proposition.villeDepart}&nbsp;&nbsp;<img src="img/rightarrow.png" alt="">&nbsp;&nbsp;<span class="etapesMore${proposition.idAnnonceProposition}"></span>${proposition.villeArrivee}</td>	
						</tr>
						<tr style="display: none;">
							<td colspan="1"></td>
							<td colspan="2" class="userAddMore${proposition.idAnnonceProposition}"></td>
							<td colspan="6"></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<script>			            	
					$(".reservation_form").submit(function (event){
						event.preventDefault();
						$(this).css("display", "none");
						$(this).parent().children(".resultReserv").html("<div style='color: #ea3c3d;'>L'annonce a été réservée.</div>");
						$(this).parent().children(".resultReserv").slideDown();
						$.ajax({ url:"ajaxreserver", type:"POST", 
							data: $(this).serialize()
						});
					});
				</script>
				<script>				
				$(".seeMore").click(function(event){

					var type= $(this).attr("data-type");
					var id = $(this).attr("data-id");
					var login = $(this).attr("data-login");
					
					
					
					
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
        				$(".userAddMore"+id).html(""+data.prenom+" "+data.nom[0]+".");
        			});
					
					if($(this).parent().parent().next("tr").css('display') != 'none'){
						$(this).parent().parent().next("tr").hide();
						$(this).parent().parent().next("tr").next("tr").hide();
						$(this).attr("src", "img/downarrow2.png");
					}
					else{
						$(this).parent().parent().next("tr").show();
						$(this).parent().parent().next("tr").next("tr").slideDown();
						$(this).attr("src", "img/uparrow2.png");
					}
				});
			</script>
			
		<c:if test="${propositions_size == 0 }">
			<div class="lastCars center">Aucun résultat</div>
		</c:if>

		<!-- Trouver un passager -->
		
		<div style="text-align: center;">
			<span class="titleAbout">Trouver un passager</span>
		</div>

				<table class="lastCars" style="text-align: center;">
					<tbody>
						<c:forEach var="propositionp" begin="0" end="${propositionsp_size}"
				step="1" items="${propositionsp}">
						<tr>
							<td><img src="img/passenger.png" alt="" /></td>
							<td>${propositionp.villeDepartRecherche}</td>
							<td><img src="img/rightarrow.png" alt=""></td>
							<td>${propositionp.villeArriveeRecherche}</td>
							<td>${propositionp.dateEtHeureRecherche.substring(8, 10)}/${propositionp.dateEtHeureRecherche.substring(5, 7)}/${propositionp.dateEtHeureRecherche.substring(0, 4)} à ${propositionp.heure}h${propositionp.minute}min</td>
							<td><form method="post" action="reserver" class="proposition_form"><input type="hidden" name="idAnnonceProposition" value="${propositionp.idAnnonceRecherche}" /><input type="submit" value="Proposer" class="submitContactForm" style="margin-bottom: 10px; height: auto; border: none;" /><input type="hidden" name="proposerForm" value="1" /></form></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			
		<c:if test="${propositionsp_size == 0 }">
			<div class="lastCars center">Aucune annonce de passager.</div>
		</c:if>
		
	</div>
</section>


<jsp:include page="footer.jsp" />